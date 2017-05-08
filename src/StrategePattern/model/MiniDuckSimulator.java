package StrategePattern.model;

import StrategePattern.FlyRocketPowered;

public class MiniDuckSimulator {
	public static void main(String[] args) {
		Duck mallard = new MallarDuck();
		mallard.display();
		mallard.performFly();
		mallard.performQuack();
		System.out.println("-------------------");
		Duck modeld = new ModelDuck();
		modeld.performFly();
		modeld.performQuack();
		System.out.println("-------------------");
		modeld.setFlyBehavior(new FlyRocketPowered());
		modeld.performFly();
		modeld.performQuack();
	}
}
