package DecratorPattern;

/**
 * 用于被包装的基础组建接口或者抽象类 为了保证被包装组件和装饰组件具有相同的类型
 * 
 * @author wk
 *
 */
public abstract class Beverage {
	String description = "unknown beverage";

	public String getDescription() {
		return this.description;
	}

	public abstract double cost();
}
