package leetcode;

import java.util.ArrayList;
import java.util.List;

//[
//    [1],
//   [1,1],
//  [1,2,1],
// [1,3,3,1],
//[1,4,6,4,1]
//]
public class LC118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> generate(int numRows) {

		if(numRows == 0)
			return new ArrayList<>();
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		if(numRows == 1){
			List<Integer> list1=new ArrayList<>();
			list1.add(1);
			list.add(list1);
			return list;
		}
		
		List<Integer> list2=new ArrayList<>();
		list2.add(1);
		list.add(list2);
		
		List<Integer> list3=null;
		for(int i=2;i<=numRows;i++){
			list3=new ArrayList<>();
			for(int j=1;j<=i;j++){
				if(j==1)
					list3.add(1);
				else if(j==i)
					list3.add(1);
				else{
					List<Integer> lastList=list.get(i-2);
					list3.add(lastList.get(j-2)+lastList.get(j-1));
				}
			}
			list.add(list3);
		}
		return list;
	}
}
