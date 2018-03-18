package DecratorPattern;

/**
 * 继承装饰器超类，具体装饰器实现
 */
public class MocaCondiment extends CondimentDecorator {
	Beverage beverage;	//这个引用记录被装饰者

	public MocaCondiment(Beverage beverage) {	//通常使用构造器完成引用的传递
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + " moca";
	}

	//行为的获取通过组合对象行为
	@Override
	public double cost() {
		return .2 + beverage.cost();
	}

}
