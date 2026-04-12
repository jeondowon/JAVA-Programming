import java.util.Scanner;

public class Rep02Replace1 {
    public static void main(String[] args){
        Rep02Replace1 a2 = new Rep02Replace1();
        a2.level1();
    }
    void level1(){
        String line;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a line of text.");
        line = sc.nextLine();

        System.out.println("You entered: " + line);
    }
}
