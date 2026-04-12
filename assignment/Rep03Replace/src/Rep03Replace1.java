import java.util.Scanner;
import javax.swing.JOptionPane;

public class Rep03Replace1 {
    public static void main(String[] args){
        Rep03Replace1 rep03 = new Rep03Replace1();
        rep03.level1();
    }
    void level1(){
        String gender;
        int weight, height, age;
        while(true){
            gender = JOptionPane.showInputDialog
                ("성별을 입력하세요(남자는 M,m, 여자는 W,w):");
            if(gender.equals("m") || gender.equals("w") || (gender.equals("M") || gender.equals("W"))){
                break;
            }
        }
        weight = Integer.parseInt(JOptionPane.showInputDialog("몸무게를 입력하세요:"));
        height = Integer.parseInt(JOptionPane.showInputDialog("키를 입력하세요:"));
        age = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요:"));
        JOptionPane.showMessageDialog(
                null, "성별: " + gender + '\n'
                        + "몸무게: " + weight + '\n'
                        + "키: " + height + '\n'
                        + "나이: " + age);
        System.exit(0);
    }
}
