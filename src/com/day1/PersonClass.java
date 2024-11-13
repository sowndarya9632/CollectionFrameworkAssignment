package com.day1;

import java.util.Objects;

class PersonClass implements Comparable<PersonClass> {
	private String name;
	private int age;

	@Override
	public int compareTo(PersonClass o) {
		int nameComparison = this.name.compareTo(o.name);
        return nameComparison != 0 ? nameComparison : Integer.compare(this.age, o.age);
	}

	@Override
	public String toString() {
		return "PersonClass [name=" + name + ", age=" + age + "]";
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
		PersonClass other = (PersonClass) obj;
		return age == other.age && Objects.equals(name, other.name);
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

	public PersonClass(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

}
