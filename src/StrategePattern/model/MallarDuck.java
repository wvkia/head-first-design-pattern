package StrategePattern.model;

import StrategePattern.FlyWithWings;
import StrategePattern.Quack;

public class MallarDuck extends Duck {

	public MallarDuck() {
		// TODO Auto-generated constructor stub
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("i am a mallarDuck");
	}

}
