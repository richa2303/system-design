package com.example.practice.system_design.design_patterns.behavioral_pattern;

import java.util.ArrayList;
import java.util.List;

interface Subject{

    public void register(Observer obs);
    public void unRegister(Observer obs);
    public void notifyObserver();
    public Object getUpdate(Observer obs);

}

interface Observer{

   public void update();
   public void setSubject(Subject sub);

}

class MyTopic implements Subject{

    private String message;
    private boolean changed;
    List<Observer> observerList;
    private final Object MUTEX = new Object();

    public MyTopic(){
        observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer obs) {
        if(obs == null){
            throw new NullPointerException("Object is null");
        }
        synchronized (MUTEX) {
            if (!observerList.contains(obs)) {
                observerList.add(obs);
            }
        }

    }

    @Override
    public void unRegister(Observer obs) {
        if(obs == null){
            throw new NullPointerException("Object is null");
        }
        synchronized (MUTEX) {
            if(observerList.contains(obs)){
                observerList.remove(obs);
            }
        }
    }

    @Override
    public void notifyObserver() {
        List<Observer> observerListLocal = null;
        synchronized (MUTEX){
            if(!changed)
                return ;

            observerListLocal = new ArrayList<>(observerList);
            for(Observer obs: observerListLocal){
                obs.update();
            }
        }
    }

    @Override
    public Object getUpdate(Observer obs) {
        return this.message;
    }

    public void postMessage(String message){
        System.out.println("Message is posted...");
        this.message = message;
        this.changed = true;
        notifyObserver();
    }
}

class MyTopicSubscriber implements Observer{

    private String name;
    private Subject topic;

    MyTopicSubscriber(String name){
        this.name = name;
    }

    @Override
    public void update() {
       String message  = (String)topic.getUpdate(this);
       if(message == null){
           System.out.println("No New Message");
       }
       else{
           System.out.println("Message "+message+" consumed...");
       }
    }

    @Override
    public void setSubject(Subject sub) {
       this.topic = sub;
    }
}

public class ObserverDesignPatternDemo {

    public static void main(String args[]){

        MyTopic topic = new MyTopic();
        MyTopicSubscriber subs = new MyTopicSubscriber("Sub 1");
        MyTopicSubscriber subs1 = new MyTopicSubscriber("Sub 2");
        MyTopicSubscriber subs2 = new MyTopicSubscriber("Sub 3");

        topic.register(subs);
        topic.register(subs1);
        topic.register(subs2);

        //attach observer to subject
        subs.setSubject(topic);
        subs1.setSubject(topic);
        subs2.setSubject(topic);

        subs.update();

        topic.postMessage("Hello Krati welcome in our company");
    }
}
