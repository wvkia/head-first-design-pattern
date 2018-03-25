package SingletonPattern;

public class SimpleSingleton {
    //静态变量保存唯一实例
    private static SimpleSingleton simpleSingleton;
    private SimpleSingleton() {
    }//私有构造器，只有类内才能调用
    public static SimpleSingleton createInstance() {
        //延迟实例化（lazy instaniaze）
        if (simpleSingleton == null) {
            simpleSingleton = new SimpleSingleton();
        }
        return simpleSingleton;
    }

}
