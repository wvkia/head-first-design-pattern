package DecratorPattern;

public class StarbuzzCoffee {
	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $ " + beverage.cost());
		Beverage be2 = new HouseBlend();
		be2 =  new MocaCondiment(be2);
		System.out.println(be2.getDescription() + " $ " + be2.cost());
		// double moca
		be2 =  new MocaCondiment(be2);
		System.out.println(be2.getDescription() + " $ " + be2.cost());
	}
}
