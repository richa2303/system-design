package com.example.practice.system_design.design_patterns.behavioral_pattern;

import org.springframework.core.annotation.Order;

interface OrderState{

    void nextState(OrderContext context);
    void cancelState(OrderContext context);

}

class OrderContext{

    OrderState state;

    OrderContext(){
        this.state = new PlacedOrder();
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void proceedToNextState(){
        state.nextState(this);
    }

    public void cancelNextState(){
        state.cancelState(this);
    }

}

class PlacedOrder implements OrderState{

    @Override
    public void nextState(OrderContext context) {
        System.out.println("Order has been placed...");
        context.setState(new ShippedOrder());
    }

    @Override
    public void cancelState(OrderContext context) {
        System.out.println("Order has been cancelled...");
        context.setState(new CanceledOrder());
    }
}
class ShippedOrder implements OrderState{

    @Override
    public void nextState(OrderContext context) {
        System.out.println("Order has been Shipped...");
        context.setState(new DeliveredOrder());
    }

    @Override
    public void cancelState(OrderContext context) {
        System.out.println("Order has been shipped Cannot be cancelled...");
    }
}
class DeliveredOrder implements OrderState{

    @Override
    public void nextState(OrderContext context) {
        System.out.println("Order has been Delivered...");
    }

    @Override
    public void cancelState(OrderContext context) {
        System.out.println("Order has been cancelled...");
        context.setState(new CanceledOrder());
    }
}
class CanceledOrder implements OrderState{

    @Override
    public void nextState(OrderContext context) {
        System.out.println("Order has been cancelled...");
    }

    @Override
    public void cancelState(OrderContext context) {
        System.out.println("Order has been cancelled...");
    }
}

public class StateDesignPatternDemo {

    public static void main(String args[]){

        OrderContext context = new OrderContext();
        context.proceedToNextState();
        context.proceedToNextState();
        context.proceedToNextState();
        context.cancelNextState();

        System.out.println("\nNew Order Workflow:");
        OrderContext newOrder = new OrderContext();
        newOrder.proceedToNextState();
        newOrder.cancelNextState();
    }
}
