package ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 接口
 */
interface SubjectJDK {
    void method();
}

/**
 * 实际委托类
 */
class RealSubjectJDK implements SubjectJDK {
    @Override
    public void method() {
        System.out.println("实际方法...");
    }
}

/**
 * 代理类的调用处理器
 */
class ProxyHandler implements InvocationHandler {
    private SubjectJDK Subject;

    public ProxyHandler(SubjectJDK Subject) {
        this.Subject = Subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==代理前处理==");
        Object result = method.invoke(Subject, args);
        System.out.println("==代理后置处理==");

        //返回执行结果
        return result;
    }

}

public class JDKProxy {
    public static void main(String[] args) {
        RealSubjectJDK realSubjectJDK = new RealSubjectJDK();   //实际委托对象
        ProxyHandler handler = new ProxyHandler(realSubjectJDK);//创建调用处理器对象
        SubjectJDK proxy = (SubjectJDK) Proxy.newProxyInstance(realSubjectJDK.getClass().getClassLoader(),
                realSubjectJDK.getClass().getInterfaces(), handler);//动态生成代理对象
        proxy.method(); //通过代理对象调用方法

    }
}
