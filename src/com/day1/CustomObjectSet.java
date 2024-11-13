package com.day1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}  
}


public class CustomObjectSet {

	public static void main(String[] args) {
		Set<Person> personSet = new HashSet<>();
        Scanner s=new Scanner(System.in);
        System.out.println("enter the name");
        String name=s.next();
        System.out.println("enter the age");
        int age=s.nextInt();
        Person p1 = new Person(name, age);
        System.out.println("enter the name");
        String name1=s.next();
        System.out.println("enter the age");
        int age1=s.nextInt();
        Person p2 = new Person(name1, age1);
        System.out.println("enter the name");
        String name2=s.next();
        System.out.println("enter the age");
        int age2=s.nextInt();
        Person p3 = new Person(name2, age2);
         addPerson(personSet,p1);
         addPerson(personSet,p2);
         addPerson(personSet,p3);
        System.out.println("Persons in set: " + personSet);
        System.out.println(checkPerson(personSet,p1));
        
       
	}
    public static void addPerson(Set<Person> personSet, Person person) {
        personSet.add(person);
    }

    public static boolean checkPerson(Set<Person> personSet, Person person) {
        return personSet.contains(person);
    }
	

}
