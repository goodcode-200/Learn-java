import java.util.Scanner;

public class ReturnMatrix {
	public static int min(int x,int y) {
		return (x>y)?y:x;
	}
	public static void PrintMatrix(int n) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.printf("%3d",min(min(i+1,j+1),min(n-i,n-j)));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		PrintMatrix(n);
		input.close();
	}
}
