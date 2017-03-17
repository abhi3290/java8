package com.abhi.java8action.ch10;

import java.util.Optional;

/**
 * Created by WeConnect on 2/13/2017.
 */
public class OptionalStudy {

	public static void main(String[] args) {
		Person person = new Person();

		Insurance insurance = new Insurance();
		//insurance.setName("Insurance Name");
		Optional<Insurance> insuranceOptional = Optional.of(insurance);

		Car car = new Car();
		Optional<Car> carOptional = Optional.ofNullable(car);
		car.setInsurance(insuranceOptional);

		Optional<Person> personOptional = Optional.ofNullable(person);
		person.setCar(carOptional);

		String unknown = personOptional.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
		System.out.println("Person :"+unknown);

	}
}

class Person {

	private Optional<Car> car;

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}
}

class Car {
	private Optional<Insurance> insurance;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Optional<Insurance> insurance) {
		this.insurance = insurance;
	}
}

class Insurance {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}