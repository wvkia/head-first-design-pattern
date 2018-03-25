package SingletonPattern;

/**
 * 为了避免多线程导致会创建两个对象，使用synchronized进行同步
 */
public class SyncSingleton {
    //静态变量保存唯一实例
    private static SyncSingleton singleton;
    private SyncSingleton() {
    }//私有构造器，只有类内才能调用
    public static  synchronized SyncSingleton createInstance() {
        //延迟实例化（lazy instaniaze）
        if (singleton == null) {
            singleton = new SyncSingleton();
        }
        return singleton;
    }
}
