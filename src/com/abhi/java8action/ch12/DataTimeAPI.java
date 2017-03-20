package com.abhi.java8action.ch12;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Abhishek on 3/11/2017.
 */
public class DataTimeAPI {

	public static void main(String[] args) {
		System.out.println("Current :" + new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(new Date()));

		System.out.println("Current :" + new SimpleDateFormat("dd MM yyyy-HHmmss").format(new Date()));
	}
}
