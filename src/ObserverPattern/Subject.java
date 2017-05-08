package ObserverPattern;
/**
 * 主题接口，用来管理观察者
 * @author wk
 *
 */
public interface Subject {

	/**
	 * 注册为观察者
	 * @param o
	 */
	void registObserver(Observer o);
	/**
	 * 删除观察者
	 * @param o
	 */
	void removeObserver(Observer o);
	/**
	 * 当主题状态改变，调用方法通知所有观察者
	 */
	void notifyObservers();

}
