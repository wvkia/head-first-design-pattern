package AdapterPattern;

public class DuckTest {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();
        //包装适配
        Duck duck1 = new TurkeyAdapter(turkey);

    }
}
