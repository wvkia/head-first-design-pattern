package StrategePattern.model;

import StrategePattern.FlyNoWay;
import StrategePattern.Quack;

public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("i am a model duck");
	}

}
