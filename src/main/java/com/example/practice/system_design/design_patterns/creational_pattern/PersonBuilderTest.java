package com.example.practice.system_design.design_patterns.creational_pattern;

class Person{

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    Person(PersonBuilder builder){
        this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
        this.age = builder.getAge();
        this.phoneNumber = builder.getPhoneNumber();
    }

    public PersonBuilder getBuilder(){
        return new PersonBuilder();
    }

    static class PersonBuilder{

        private String firstName;
        private String lastName;
        private int age;
        private String phoneNumber;

        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PersonBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Person build() {
            return new person(this);
        }

    }


}
public class PersonBuilderTest {

    public static void main(String args[]){
        Person createPerson = new Person.PersonBuilder()
                .setFirstName("Deepank")
                .setLastName("Yadav")
                .setAge(25)
                .setPhoneNumber("1233131")
                .build();

    }
}
