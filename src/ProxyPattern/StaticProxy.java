package ProxyPattern;

/**
 * 静态代理
 */

/**
 * 委托对象和代理对象共同接口
 */
interface SubJect{
    void request();
}

/**
 * 实际委托对象
 */
class RealSubject implements SubJect {
    @Override
    public void request() {
        System.out.println("real request ... ");

    }
}

/**
 * 代理对象
 */
class Proxy implements SubJect {
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("proxy before..");
        realSubject.request();
        System.out.println("proxy after...");
    }
}

public class StaticProxy {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.request();

    }
}
