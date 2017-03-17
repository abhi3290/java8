package com.abhi.java8action.ch8;

/**
 * Created by Abhishek on 2/7/2017.
 */
public class RefactoringAnonymousToLambda {

	public static void main(String[] args) {
		doSomething((Task) () -> System.out.println("OK"));
	}

	public static void doSomething(Runnable r){
		r.run();
	}

	public static void doSomething(Task r){
		r.run();
	}
}

interface Task {
	public void run();
}
