package com.example.practice.system_design.design_patterns.creational_pattern;

class Person{

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    Person(PersonBuilder builder){
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phoneNumber = builder.phoneNumber;
    }

    public static PersonBuilder getBuilder() {
        return new PersonBuilder();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
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

        public Person build() {
            return new Person(this);
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

        System.out.println(" person :"+createPerson.toString());

    }
}
