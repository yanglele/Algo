package alogo;

public class MatchString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String reString="qwertyuiop";
		String deString="rtyui";
		System.out.println(mathTest(reString, deString));
		
	}

	public static boolean mathTest(String res,String des){
		int i=0,j=0;
		while(i<res.length()&&j<des.length()){
			if(des.charAt(j) == res.charAt(i)){
				i++;
				j++;
			}else{
				i=i-j+1;
				j=0;
			}
		}
		if(j == des.length())
			return true;
		else return false;
	}
}
