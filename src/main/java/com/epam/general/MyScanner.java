package com.epam.general;

import java.util.Scanner;

public class MyScanner {

	private static Scanner instance = null;

	private MyScanner() {
	}

	public static synchronized Scanner getInstance() {
		if (instance == null)
			instance = new Scanner(System.in);
		return instance;
	}

}
