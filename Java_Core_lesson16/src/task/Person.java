package task;

import java.util.Objects;

public class Person extends Human implements Comparable<Person>{
	
	private int id;
	private String firstName;
	private String secondName;
	private int age;
	private String sex;
	
	public Person() {
		
	}

	public Person(int id, String firstName) {
		super();
		this.id = id;
		this.firstName = firstName;
	}

	public Person(int id, String firstName, String secondName, int age, String sex) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.age = age;
		this.sex = sex;
	}

	public void myMethod(String a, int ... args) {
		System.out.println("Виклик методу myMethod з парматертрами String, int");
	}
	
	public void myMethod(String ... args) {
		System.out.println("Виклик методу myMethod з парматертром String");
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", age=" + age
				+ ", sex=" + sex + "]";
	}

	@Override
	public int compareTo(Person o) {
		return this.firstName.compareTo(o.getFirstName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, firstName, id, secondName, sex);
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
		return age == other.age && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(secondName, other.secondName) && Objects.equals(sex, other.sex);
	}
	
	
	
}
