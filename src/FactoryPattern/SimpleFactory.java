package FactoryPattern;

/**
 * 简单工厂模式
 */

abstract class Base {

}

class A extends Base {

}

class B extends Base {

}
public class SimpleFactory {
    public static Base create(String type) {

        if (type.equals("A")) {
            return new A();
        }
        if (type.equals("B")) {
            return new B();
        }
        return null;
    }
}

