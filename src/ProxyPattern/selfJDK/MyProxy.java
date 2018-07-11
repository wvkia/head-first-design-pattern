package ProxyPattern.selfJDK;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyProxy {
    private static final String ENTER = "\r\n";
    public static final String proxyClassName = "$Proxy0";

    /**
     * 根据接口构造代理类class
     *
     * @param interfaces
     * @return
     */
    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package ");
        for (Class<?> aClass : interfaces) {
            sb.append(aClass.getPackage().getName())
                    .append(";")
                    .append(ENTER);
        }
        sb.append("import java.lang.reflect.Method;")
                .append(ENTER)
                .append("public class ")
                .append(proxyClassName)
                .append(" implements ");
        for (Class<?> aClass : interfaces) {
            sb.append(aClass.getName())
                    .append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(" {")
                .append(ENTER)
                .append(MyInvocationHandler.class.getName())
                .append(" h;")
                .append(ENTER)
                .append(" public ")
                .append(proxyClassName)
                .append("(")
                .append(MyInvocationHandler.class.getName())
                .append(" h){")
                .append(ENTER)
                .append("this.h=h;\n }")
                .append(ENTER);
        for (Class<?> aClass : interfaces) {
            for (Method method : aClass.getMethods()) {
                sb.append("public ")
                        .append(method.getReturnType().getName())
                        .append(" ")
                        .append(method.getName())
                        .append("(){")
                        .append(ENTER);
                sb.append("try { ")
                        .append(ENTER)
                        .append("Method m= ")
                        .append(aClass.getName())
                        .append(".class.getMethod(\"")
                        .append(method.getName())
                        .append("\",new Class[]{});")
                        .append(ENTER);
                sb.append("this.h.invoke(this,m,null);")
                        .append(ENTER)
                        .append("} catch(Throwable t) { ")
                        .append(ENTER)
                        .append("t.getMessage();")
                        .append(ENTER)
                        .append("}")
                        .append(ENTER)
                        .append("}");
            }
        }
        sb.append("}");
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(generateSrc(new Class[]{MyInvocationHandler.class}));
    }

    private static void writeFile(String proxyclassString, File file) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(proxyclassString);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void compile(File proxyFile) {
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardJavaFileManager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable javaFileObjects = standardJavaFileManager.getJavaFileObjects(proxyFile);
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardJavaFileManager, null, null, null, javaFileObjects);
        task.call();
        try {
            standardJavaFileManager.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object newInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler h) throws Exception {
        if (h == null) {
            throw new NullPointerException();
        }
        String srcClass = generateSrc(interfaces);
        String fileapth = MyProxy.class.getResource("").getPath() + proxyClassName+".java";
        File file = new File(fileapth);
        writeFile(srcClass, file);
        compile(file);

        //加载编译生成的class文件
        Class<?> proxyClass = classLoader.findClass(proxyClassName+".java");
        Constructor<?> constructor = proxyClass.getConstructor(MyInvocationHandler.class);
        return constructor.newInstance(h);
    }
}
