package DecratorPattern;

/**
 * 继承自Beverage，被装饰对象
 */
public class Espresso extends Beverage {
	 public Espresso() {
		// TODO Auto-generated constructor stub
		 this.description = "Espresso";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.9;
	}

}
