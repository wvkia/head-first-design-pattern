package StrategePattern.model;

import StrategePattern.FlyBehavior;
import StrategePattern.QuackBehavior;

/**
 * Duck abstract class
 *
 */
public abstract class Duck {
	//fly Algorithm
	FlyBehavior flyBehavior;
	//quack Algorithm
	QuackBehavior quackBehavior;

	public Duck() {
	}

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public abstract void display();

	public void swim() {
		System.out.println("all duck float,even decoys");
	}


	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}


	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
}
