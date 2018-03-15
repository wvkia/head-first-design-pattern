package ObserverPattern;

/**
 *
 * 观察者接口
 * @author wk
 *
 */
public interface Observer {
	/**
	 *
	 * 更新自身行为
	 * @param tempe
	 * @param pressure
	 */
	void update(float tempe, float pressure);
}
