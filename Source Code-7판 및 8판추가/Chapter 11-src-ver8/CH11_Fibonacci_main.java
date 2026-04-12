import java.util.Scanner;
public class CH11_Fibonacci_main {
	public static void main(String[] args){
	int n = 0;
	int fn = 0;
	Scanner kb = new Scanner(System.in);
	do{
		System.out.println("Input n (-1 for exit): ");
		n = kb.nextInt();
		if (n < 0){System.out.println("GoodBye~!! "); break;}
		fn = getfibo(n);
		System.out.println("Fibonacci(" + n + ") is " + fn);
	}while(n >= 0);

	kb.close();
	}

	static public int getfibo(int n){
		int myfibo;
		if (n == 0)	myfibo = 0;
		else if (n==1)	myfibo = 1;
		else		myfibo = getfibo(n-2) + getfibo(n-1);

		return myfibo;
	}
}

