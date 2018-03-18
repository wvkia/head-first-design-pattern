package DecratorPattern;

/**
 * 被装饰对象
 */
public class HouseBlend extends Beverage {
	public HouseBlend() {
		this.description = "HouseBlend";
	}

	@Override
	public double cost() {
		return 2;
	}

}
