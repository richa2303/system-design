package com.example.practice.system_design.design_patterns.behavioral_pattern;

abstract class HouseTemplate{

    public final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
    }

    private void buildWindows(){
        System.out.println("Glass Windows");
    }

    public abstract void buildWalls();

    public abstract void buildPillars();

    private void buildFoundation(){
        System.out.println("House Foundation made of Cement, Iron rods, sand and Concrete");
    }
}
class GlassHouse extends HouseTemplate{

    @Override
    public void buildWalls() {
        System.out.println("Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Glass Coated Pillars");
    }
}
class WoodenHouse extends HouseTemplate{

    @Override
    public void buildWalls() {
        System.out.println("Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Wooden Coated Pillars");
    }
}
public class TemplateDesignPatternDemo {

    public static void main(String args[]){
       HouseTemplate glass = new GlassHouse();
       glass.buildHouse();

       HouseTemplate wood = new WoodenHouse();
       wood.buildHouse();
    }
}
