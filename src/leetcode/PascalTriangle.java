package leetcode;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		show(10);
		
	}

	public static ArrayList<ArrayList<Integer>> getTheResult(int n){
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		if(n <= 0)
			return list;
		ArrayList<Integer> pre=new ArrayList<>();
		pre.add(1);
		list.add(pre);
		
		for(int i=2;i<=n;i++){
			ArrayList<Integer> cur=new ArrayList<>();
			cur.add(1);
			for(int j=1;j<pre.size();j++){
				cur.add(pre.get(j-1)+pre.get(j));
			}
			cur.add(1);
			list.add(cur);
			pre=cur;
		}
		return list;
	}
	
	public static void show(int n){
		ArrayList<ArrayList<Integer>> list=getTheResult(n);
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.get(i).size();j++){
				System.out.print(list.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}
}
