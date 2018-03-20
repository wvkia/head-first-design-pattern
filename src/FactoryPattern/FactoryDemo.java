package FactoryPattern;

//
class Product{}
//具体产品
class AProduct extends Product {
}
class BProduct extends Product{}

//工厂类
interface ProductFactory{
    Product createProduct();
}
//具体工厂类
class AProductFactory implements ProductFactory{
    @Override
    public Product createProduct() {
        return new AProduct();
    }
}
//
class BProductFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new BProduct();
    }
}

public class FactoryDemo {
    Product a = new AProductFactory().createProduct();
    Product b = new BProductFactory().createProduct();
}

