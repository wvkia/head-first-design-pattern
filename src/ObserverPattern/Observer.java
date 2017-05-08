package ObserverPattern;

/**
 * 所有观察者必须实现Observer接口
 * 
 * @author wk
 *
 */
public interface Observer {
	/**
	 * 当值更改时，主题会把这些状态值当作方法的参数，传递给观察者
	 * 
	 * @param tempe
	 * @param pressure
	 */
	void update(float tempe, float pressure);
}
