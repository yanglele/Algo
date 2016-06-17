package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		show(5);
	}
	
	public static void show(int n){
		List<Integer> list=getRow(n);
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
	}

	public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list=new ArrayList<>();
        if(rowIndex <= 0)
        	return list;
        list.add(1);
        
        for(int i=2;i<=rowIndex;i++){
        	for(int j=i-2;j>0;j--){
        		list.set(j, list.get(j)+list.get(j-1));
        	}
        	list.add(1);
        }
        return list;
    }
}
