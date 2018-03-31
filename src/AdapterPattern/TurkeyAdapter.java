package AdapterPattern;

//火鸡冒充鸭子
//适配鸭子
public class TurkeyAdapter implements Duck {
    //维持一个适配引用，内部接口实现全部使用适配对象来实现
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();

    }

    @Override
    public void fly() {
        turkey.fly();

    }
}
