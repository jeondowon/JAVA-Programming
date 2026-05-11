import java.util.Scanner;

public class Palindrome2 {
    public static void main(String[] args) {
        Palindrome2 a2 = new Palindrome2();
        a2.main();
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
                if(palindrome(input)){
                    System.out.println("YES!! the phrase is a palindrome!.");
                    break;
                }
                else{
                    System.out.println("NO!! the phrase is NOT a palindrome!");
                }
            }
            System.out.println();
        }
        sc.close();
    }
    public static boolean palindrome(String text){
        String sentence = text.toLowerCase().replaceAll(" ", "").replaceAll("\\.", "");
        int len = sentence.length();
        for(int i = 0, j = len - 1; i < j; i++, j--) {
            if(sentence.charAt(i) != sentence.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

