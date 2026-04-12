import java.util.Scanner;

public class Rep02Replace2 {
    public static void main(String[] args){
        Rep02Replace2 a2 = new Rep02Replace2();
        a2.level2();
    }
    void level2(){
        String line;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of text.");
        line = sc.nextLine();

        //System.out.printf("You entered: %s\n", line);
        String line_lc = line.toLowerCase();

        int position = line_lc.indexOf("hate");
        System.out.println("First occurrence of \"hate\" is at index: " + position);
    }
}
