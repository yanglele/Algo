package leetcode;

public class LC009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(int x) {

		if (x < 0)
			return false;
		if (x == 0)
			return true;
		int copy = x;
		int tmp = 0;
		while (x / 10 > 0) {
			tmp = tmp + x % 10;
			x = x / 10;
			tmp = tmp * 10;
		}
		tmp = tmp + x;
		if (tmp == copy)
			return true;
		else
			return false;
	}
}
