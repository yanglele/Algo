package leetcode;

/*
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
 * */
public class LC258 {
	public int addDigits(int num) {
		while (num > 9) {
			int result = 0;
			long div = 10;
			long pdiv = 10;
			while (num / pdiv > 0) {
				if (div == 10) {
					result += num % 10;
					div *= div;
				} else {
					result += (num % div - num % pdiv) / pdiv;
					pdiv = div;
					div = div * 10;
				}
			}
			num = result;
		}
		return num;
	}
}

/*2
public int addDigits(int num) {
    return 1+(num-1)%9;
 }
*/

/*3
public int addDigits(int num) {
    if(num%9==0 && num!=0)
        return 9;
    else return num%9;
}
*/
