import java.util.Scanner;

public class Palindrome1 {
    public static void main(String[] args) {
        Palindrome1 a1 = new Palindrome1();
        a1.main();
    }

    void main(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("This program will test whatever text \n" +
                    "you enter to see if is a palindrome\n" +
                    "(reads the same backwards and forwards)\n\n" +
                    "Enter text (just letters and blanks, please):");
            String input = sc.nextLine();
            int len = input.length();
            if(input.charAt(len-1) != '.'){
                System.out.println("Your sentence does not end with a period.");
            }
            if(len > 80){
                System.out.println("Your sentence length is over 80.");
            }
            if((input.charAt(len-1) == '.')&&len<80){
                break;
            }
            System.out.println();
        }
        sc.close();
    }
}