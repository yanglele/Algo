package alogo;

public class PrintTwoArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] a=new int[5][8];
		get2Array(a);
		printArray(a);
	}

	public static void get2Array(int array[][]){
		int i=0,j=0,m=array.length-1,n=array[0].length-1;
		int k=0;
		while(i<=m && j<=n){
			for(int a=j;a<=n;a++){
				array[i][a]=k;
				k++;
			}
			
			for(int a=i+1;a<=m;a++){
				array[a][n]=k;
				k++;
			}
			
			for(int a=n-1;a>=j;a--){
				array[m][a]=k;
				k++;
			}
			
			for(int a=m-1;a>=i+1;a--){
				array[a][j]=k;
				k++;
			}
			
			i++;
			j++;
			m--;
			n--;
		}
	}
	
	public static void printArray(int[][] arry){
		int m=arry.length;
		int n=arry[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(arry[i][j]+"    ");
			}
			System.out.println();
		}
	}
}
