package DecratorPattern;

public class MocaCondiment extends CondimentDecorator {
	Beverage beverage;

	public MocaCondiment(Beverage beverage) {
		this.beverage = beverage;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return beverage.getDescription() + " moca";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return .2 + beverage.cost();
	}

}
