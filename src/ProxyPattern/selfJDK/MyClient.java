package ProxyPattern.selfJDK;

import java.lang.reflect.Method;

/**
 * 接口
 */
interface MyInterface {
    void method();
}

/**
 * 实际委托类
 */
class MyRealObject implements MyInterface {
    @Override
    public void method() {
        System.out.println("实际方法...");
    }
}

/**
 * 代理类的调用处理器
 */
class MyHandler implements MyInvocationHandler {
    MyRealObject object;

    public MyHandler(MyRealObject object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==代理前处理==");
        System.out.println(proxy.getClass());
        Object result = method.invoke(object, args);
        System.out.println("==代理后置处理==");

        //返回执行结果
        return result;
    }

}

public class MyClient {
    public static void main(String[] args) throws Exception {
        MyRealObject myRealObject = new MyRealObject();
        MyHandler myHandler = new MyHandler(myRealObject);
        MyInterface myInterface = (MyInterface) MyProxy.newInstance(new MyClassLoader(), new Class[]{MyInterface.class}, myHandler);
        myInterface.method();

    }
}
