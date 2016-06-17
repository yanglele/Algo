package leetcode;

import java.util.Arrays;

public class LC242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		if (s.length() == 0)
			return true;
		else {
			char[] arrays1 = s.toCharArray();
			char[] arrays2 = t.toCharArray();
			Arrays.sort(arrays1);
			Arrays.sort(arrays2);
			if (Arrays.equals(arrays1, arrays2))
				return true;
		}
		return false;
	}

}
