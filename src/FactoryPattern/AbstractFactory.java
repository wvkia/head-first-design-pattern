package FactoryPattern;

interface IProduct1 {
     void show();
}
interface IProduct2 {
     void show();
}

class Product1 implements IProduct1 {
    public void show() {
        System.out.println("这是1型产品");
    }
}
class Product2 implements IProduct2 {
    public void show() {
        System.out.println("这是2型产品");
    }
}

interface IFactory {
     IProduct1 createProduct1();
     IProduct2 createProduct2();
}
class Factory_1 implements IFactory{
    public IProduct1 createProduct1() {
        return new Product1();
    }
    public IProduct2 createProduct2() {
        return new Product2();
    }
}

public class AbstractFactory {
    public static void main(String[] args){
        IFactory factory = new Factory_1();
        factory.createProduct1().show();
        factory.createProduct2().show();
    }
}
