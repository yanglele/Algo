package com.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher matcher = pattern.matcher("32 ");
		boolean isMatcher = matcher.matches();
		System.out.println(isMatcher);
	}

}
