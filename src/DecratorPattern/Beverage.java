package DecratorPattern;

/**
 *
 * 被装饰者和装饰器的超类，为了使二者具有相同的超类型
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
