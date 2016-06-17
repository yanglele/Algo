package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

public class LC202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int a=0;
		while((a=Integer.parseInt(scanner.nextLine())) != 0){
			System.out.println("  "+isHappy(a));
		}
		int n=1;
	}
	
	 public static boolean isHappy(int n) {
		 ArrayList<Integer> list=new ArrayList<Integer>();
		 while(n != 1){
			 if(list.contains(n)){
				 return false;
			 }
			 list.add(n);
			 int tem=0;
			 while(n>0){
				 tem+=(n%10)*(n%10);
				 n/=10;
			 }
			 n=tem;
		 }
	        return true;
	    }
//	 public static boolean isHappy(int n) {
//		 ArrayList<Integer> list=new ArrayList<Integer>();
//		 while(n != 1){
//			 long i=10;
//			 if(list.contains(n)){
//				 return false;
//			 }
//			 list.add(n);
//			 int tem=(int) Math.pow(n%10, 2);
//			 while(n/i>0){
//				 tem=tem+(int) Math.pow((n%(i*10)-n%i)/i, 2);
//				 i=i*10;
//			 }
//			 n=tem;
//		 }
//	        return true;
//	    }
}
