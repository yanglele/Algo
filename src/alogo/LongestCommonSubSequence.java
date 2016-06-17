package alogo;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String arr = "iloveyoull";
		String arr1 = "istilldoloveyoutoo";
		System.out.println(longestCommonSubSequence(arr, arr1));
	}

	public static int longestCommonSubSequence(String arr1, String arr2) {
		if (arr1 == null || arr2 == null)
			return Integer.MIN_VALUE;
		String newString1 = null;// duan
		String newString2 = null;// chang
		List<String> list = new ArrayList<>();
		int result = Integer.MIN_VALUE;
		if (arr1.length() < arr2.length()) {
			newString1 = arr1;
			newString2 = arr2;
		} else {
			newString1 = arr2;
			newString2 = arr1;
		}
		list = getAllSubSequence(newString1);
		for (String tmpList : list) {
			if (ifContainTheString(newString2, tmpList)) {
				int tmpListLength = tmpList.length();
				if (tmpListLength > result)
					result = tmpListLength;
				// System.out.println("tmpListLength=" + tmpListLength);
			}
		}
		return result;
	}

	// s1包含s2
	public static boolean ifContainTheString(String s1, String s2) {
		// U.p("s1: " + s1 + " s2: " + s2);
		int location = 0;
		int count = 0;
		int length = s2.length();
		for (int i = 0; i < s2.length(); i++) {
			while (location < s1.length() && s1.charAt(location) != s2.charAt(i))
				location++;
			if (location < s1.length() && s1.charAt(location) == s2.charAt(i)) {
				location++;
				count++;
			}
		}
		if (count == length)
			return true;
		else
			return false;
	}

	public static List<String> getAllSubSequence(String arr) {
		List<String> result = new ArrayList<>();
		int arrLength = arr.length();
		int count = (int) Math.pow(2, arr.length());

		for (int i = 1; i < count; i++) {

			String binary = Integer.toBinaryString(i);
			// System.out.println("binary=" + binary);
			int binaryLength = binary.length();
			char[] charArr = new char[arrLength];
			for (int n = 0; n < charArr.length; n++)
				charArr[n] = '0';
			// System.out.println("---");
			// System.out.println(charArr[0]);
			int needZeroNum = arrLength - binaryLength;
			StringBuilder resultString = new StringBuilder(); // 补齐位数
			for (int j = 0; j < needZeroNum; j++) {
				charArr[j] = 0;
			}
			for (int k = 0; k < binaryLength; k++) {
				charArr[needZeroNum + k] = binary.charAt(k);
			}
			for (int m = 0; m < arrLength; m++) {
				if (charArr[m] == '1')
					resultString.append(arr.charAt(m));
			}
			result.add(resultString.toString());
			// System.out.println(resultString);
		}
		return result;
	}

}
