package leetcode;

public class LC191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//System.out.println(hammingWeight(4294967295));
		int a=-1;
		
	}
    public static int hammingWeight(int n) {
        int count=0;
        while(n>0){
        	count+=n&1;
        	n=n>>1;
        }
        return count;
    }
    
    public int hammingWeight2(int n) {
        int count = 0;
    for(int i = 0; i < 32; i++) {
        if(((1 << i) & n) != 0) {
            count++;
        }
    }
    return count;
    }
    
}
