package com.epam.client;

import com.epam.utils.MyScanner;

public class RichClient extends AbstractClient implements Client {

	public RichClient() {
		setCash();
	}

	@Override
	public void setCash() {
		System.out.print("Set cash: ");
		while (MyScanner.getInstance().hasNext()) {
			if (MyScanner.getInstance().hasNextInt()) {
				cash = MyScanner.getInstance().nextInt();
				if (cash < 250) {
					System.out.print("Too poor for Rich Client.\n\nSet Cash: ");
					MyScanner.getInstance().next();
				}
				break;
			} else {
				System.out.print("Invalid input\n\nSet Cash: ");
				MyScanner.getInstance().next();
			}
		}
	}

	@Override
	public void walk() {

	}

	@Override
	public void speak() {

	}

	@Override
	public void move() {

	}

	@Override
	public void sleep() {

	}
}
