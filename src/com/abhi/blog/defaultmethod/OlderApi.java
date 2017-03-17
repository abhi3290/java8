package com.abhi.blog.defaultmethod;

/**
 * Created by Abhishek on 2/18/2017.
 */
public interface OlderApi {

	int data = 10;

	public void oldMethod();

	default public void newMethod(){
		System.out.println("Default Implementation of newMethod");
	}
}

class OlderApiImpl implements  OlderApi {

	@Override
	public void oldMethod() {
		System.out.println("Implementation of oldMethod");
	}
}