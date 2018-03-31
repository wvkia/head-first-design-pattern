package AdapterPattern;
//火鸡实现类
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble");
    }

    @Override
    public void fly() {
        System.out.println("Fly a short distance");
    }
}
