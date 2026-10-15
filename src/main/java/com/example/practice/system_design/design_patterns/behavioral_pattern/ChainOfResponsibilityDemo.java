package com.example.practice.system_design.design_patterns.behavioral_pattern;

import java.util.Scanner;

class Currency{

    public int currency;
    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    Currency(int currency){
        this.currency = currency;
    }
}

interface DispenserChain{

    public void setNextChain(DispenserChain chain);
    public void dispense(Currency curr);
}

class Dispense50Dollar implements DispenserChain{

    DispenserChain chain;
    @Override
    public void setNextChain(DispenserChain chain) {
        this.chain = chain;
    }

    @Override
    public void dispense(Currency curr) {
       if(curr.getCurrency()>50){
           int count = curr.getCurrency()/50;
           int remainder = curr.getCurrency()%50;
           System.out.println("dispense "+count+" notes of 50 Dollars...");
           if(remainder != 0){
               chain.dispense(new Currency(remainder));
           }
       }else{
           this.chain.dispense(curr);
       }
    }
}

class Dispense20Dollar implements DispenserChain{

    DispenserChain chain;
    @Override
    public void setNextChain(DispenserChain chain) {
        this.chain = chain;
    }

    @Override
    public void dispense(Currency curr) {
        if(curr.getCurrency()>20){
            int count = curr.getCurrency()/20;
            int remainder = curr.getCurrency()%20;
            System.out.println("dispense "+count+" notes of 20 Dollars...");
            if(remainder != 0){
                chain.dispense(new Currency(remainder));
            }
        }else{
            this.chain.dispense(curr);
        }
    }
}
class Dispense10Dollar implements DispenserChain{

    DispenserChain chain;
    @Override
    public void setNextChain(DispenserChain chain) {
        this.chain = chain;
    }

    @Override
    public void dispense(Currency curr) {
        if(curr.getCurrency()>10){
            int count = curr.getCurrency()/10;
            int remainder = curr.getCurrency()%10;
            System.out.println("dispense "+count+" notes of 10 Dollars...");
        }else{
            this.chain.dispense(curr);
        }
    }
}

public class ChainOfResponsibilityDemo {

    DispenserChain chain ;

    public ChainOfResponsibilityDemo(){
        chain = new Dispense50Dollar();
        DispenserChain dispnse20  = new Dispense20Dollar();
        chain.setNextChain(dispnse20);
        DispenserChain dispnse10  = new Dispense20Dollar();
        dispnse20.setNextChain(dispnse10);
    }

    public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int n= sc.nextInt();
      if(n%10 != 0){
          System.out.println("Enter number divisible by 10...");
      }else{
          ChainOfResponsibilityDemo demo = new ChainOfResponsibilityDemo();
          demo.chain.dispense(new Currency(n));
      }
    }
}
