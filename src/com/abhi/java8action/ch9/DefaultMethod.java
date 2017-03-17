package com.abhi.java8action.ch9;

/**
 * Created by Abhishek on 2/11/2017.
 */
public interface DefaultMethod {

	void doMarriage();

	default void doFamilyPlanning() {
		System.out.println("DefaultMethod doFamilyPlanning");
	}

}

interface DefaultMethod1 {

	void doMarriage();

	default void doFamilyPlanning() {
		System.out.println("DefaultMethod1 doFamilyPlanning");
	}

}



class DefaultMethodImplementation implements DefaultMethod, DefaultMethod1 {

	@Override
	public void doMarriage() {
		System.out.println("Do marriage");
	}

	public void doFamilyPlanning() {
		DefaultMethod1.super.doFamilyPlanning();

	}

	public static void main(String[] args) {
		DefaultMethod d = new DefaultMethodImplementation();
		d.doFamilyPlanning();
	}

}
