import java.util.Scanner;
import java.lang.Integer;

public class ratMaze{

	static int nRows, nCols;
	//total number of ways in which a maze can be traversed
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rows :");
		nRows=sc.nextInt();
		System.out.println("Enter the number of cols :");
		nCols=sc.nextInt();
		System.out.println("Enter the maze (0 means blocked, 1 means open):");
		int i,j;
		int arr[][]=new int[nRows][nCols];
		for(i=0;i<nRows;i++){
			for(j=0;j<nCols;j++){
				arr[i][j]=Integer.parseInt(sc.next());
			}
		}
		arr[0][0]=7;
		ratMaze rm=new ratMaze();
		System.out.println("Solutions (Trail of 7 indicates path):");
		System.out.println("Maze can be solved in "+rm.solve(arr,0,0)+" ways.");
	}

	public void displayPath(int arr[][]){
		int i,j;
		System.out.println("-------------------");
		for(i=0;i<nRows;i++){
			for(j=0;j<nCols;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("-------------------");
	}

	public int solve(int arr[][], int cRow, int cCol){
		int nPaths=0;
		if(cRow==(nRows-1) && cCol==(nCols-1)){
			displayPath(arr);
			return 1;
		}
		else{
			if(cRow<nRows && cCol<nCols){
				if((cCol+1)<nCols && arr[cRow][cCol+1]==1){
					arr[cRow][cCol+1]=7;
					nPaths = nPaths+solve(arr,cRow,cCol+1);
					arr[cRow][cCol+1]=1;
				}
				if((cRow+1)<nRows && arr[cRow+1][cCol]==1){
					arr[cRow+1][cCol]=7;
					nPaths = nPaths+solve(arr,cRow+1,cCol);
					arr[cRow+1][cCol]=1;
				}
			}
		}
		return nPaths;
	}

}