import java.util.Scanner;
import javax.swing.JOptionPane;

public class Rep03Replace2 {
    public static void main(String[] args){
        Rep03Replace2 rep03 = new Rep03Replace2();
        rep03.level2();
    }
    void level2(){
        String gender;
        int weight, height, age;
        double cal = 0.0;
        int chocolate = 0;
        gender = JOptionPane.showInputDialog("성별을 입력하세요(남자는 M,m, 여자는 W,w):");
        weight = Integer.parseInt(JOptionPane.showInputDialog("몸무게를 입력하세요:"));
        height = Integer.parseInt(JOptionPane.showInputDialog("키를 입력하세요:"));
        age = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요:"));
        if(!((gender.equals("m") || gender.equals("w") || gender.equals("M") || gender.equals("W")))){
            JOptionPane.showMessageDialog(null, "성별이 잘못 입력되었습니다.");
            System.exit(0);
        }
        if(gender.equals("m") || gender.equals("M")){
            cal = ((10*weight) + (6.25 * height) - (5*age) + 5);
            chocolate = ((int)cal / 200);
        }
        if(gender.equals("w") || gender.equals("W")){
            cal = ((10*weight) + (6.25 * height) - (5*age) - 161);
            chocolate = ((int)cal / 200);
        }
        JOptionPane.showMessageDialog(
                null, "성별: " + gender + '\n'
                        + "몸무게: " + weight + '\n'
                        + "키: " + height + '\n'
                        + "나이: " + age);
        JOptionPane.showMessageDialog(null,
                "하루에 필요한 칼로리: " + String.format("%.1f", cal) + " kcal"
                        + "\n" + "하루에 필요한 초콜릿 수 : " + chocolate + "개");
        System.exit(0);
    }
}
