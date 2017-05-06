package StrategePattern.behaviorImpl;

import StrategePattern.behavior.QuackBehavior;

/**
 * ²»»á½Ð
 * 
 * @author wk
 *
 */
public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		// TODO Auto-generated method stub
		System.out.println("<Silence>");
	}

}
