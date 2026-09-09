package com.example.practice.system_design.design_patterns.structural_pattern;

interface Car{
   public void assemble();
}

class BasicCar implements Car{
    @Override
    public void assemble() {
        System.out.println("Basic Car");
    }
}

class LuxuryCar implements Car{

    Car car;

    public LuxuryCar(Car car){
        this.car = car;
    }

    @Override
    public void assemble() {
       this.car.assemble();
       System.out.println("Decorate Luxury Car....");
    }
}

class SportsCar implements Car{

    Car car;
    SportsCar(Car car){
        this.car = car;
    }
    @Override
    public void assemble() {
       car.assemble();
       System.out.println("Decorate sports Car...");
    }
}
public class DecoratorDesignPatternDemo {

    public static void main(String args[]){
        Car car1 = new LuxuryCar(new BasicCar());
        car1.assemble();
        Car car2 = new SportsCar(new BasicCar());
        car2.assemble();
    }
}
