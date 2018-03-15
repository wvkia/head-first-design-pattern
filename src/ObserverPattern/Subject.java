package ObserverPattern;
/**
 *主题接口
 * @author wk
 *
 */
public interface Subject {

	/**注册观察者
	 * @param o
	 */
	void registObserver(Observer o);
	/**
	 * 删除观察者
	 * @param o
	 */
	void removeObserver(Observer o);
	/**
	 * 通知观察者
	 */
	void notifyObservers();

}
