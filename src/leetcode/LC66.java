package leetcode;

public class LC66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] test = new int[] { 1, 0 };
		// plusOne(test);
	}

	public static int[] plusOne(int[] digits) {
		if(digits.length == 0)
			return null;
		int n=digits.length;
		int carry=1;
		for(int i=n-1;i>=0;i--){
			int sum=digits[i]+carry;
			digits[i]=sum%10;
			carry=sum/10;
			if(carry == 0)
				return digits;
		}
		int[] a=new int[n+1];
		//System.arraycopy(digits, 0, a, 1, n);
		a[0]=carry;
		for(int i=1;i<a.length;i++)
			a[i]=0;
		return a;
	}
	
//	public static int[] plusOne(int[] digits) {
//		  if (digits == null || digits.length == 0)
//		        return null;
//		    int n = digits.length;
//		    int carry = 1;
//		    for (int i = n - 1; i >= 0; i--) {
//		        int sum = digits[i] + carry;
//		        digits[i] = sum % 10;
//		        carry = sum / 10;
//		        if (carry == 0)
//		            return digits;
//		    }
//		    int[] a = new int[n + 1];
//		    System.arraycopy(digits, 0, a, 1, n);
//		    a[0] = carry;
//		    return a;
//	}


}
