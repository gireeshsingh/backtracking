import java.util.Scanner;

public class knightstour{

	static int n;
	static int move[][]={
					{2,1},
					{1,2},
					{-1,2},
					{-2,1},
					{-2,-1},
					{-1,-2},
					{1,-2},
					{2,-1}
				};

	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of rows: ");
		n=sc.nextInt();
		int i,j;
		int arr[][]=new int[n][n];
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				arr[i][j]=0;
			}
		}
		knightstour kt= new knightstour();
		arr[0][0]=1;
		
		if(!kt.findTourPath(arr,1,0,0)){
			System.out.println("Solution not found");
		}
	}

	public void displayBoard(int arr[][]){
		int i,j;
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

	public boolean findTourPath(int arr[][], int pos, int row, int col){
		if(pos==n*n){
			displayBoard(arr);
			return true;
		}
		else{
			int k;
			for(k=0;k<8;k++){
				if(validPos(arr,row+move[k][0],col+move[k][1])){
					arr[row+move[k][0]][col+move[k][1]]=pos+1;
					if(findTourPath(arr, pos+1, row+move[k][0], col+move[k][1])){
						return true;
					}
					else{
						arr[row+move[k][0]][col+move[k][1]]=0;
					}
				}
			}
		}
		return false;
	}

	public boolean validPos(int arr[][], int row, int col){
		return (row>=0 && row<n && col>=0 && col<n && arr[row][col]==0);
	}

}