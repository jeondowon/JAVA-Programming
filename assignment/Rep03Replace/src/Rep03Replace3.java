import java.util.Scanner;
import javax.swing.JOptionPane;

public class Rep03Replace3 {
    public static void main(String[] args){
        Rep03Replace3 rep03 = new Rep03Replace3();
        rep03.level3();
    }

    boolean isValid(int n){
        boolean valid;
        if(n <= 0){
            valid = false;
        }
        else{
            valid = true;
        }
        return valid;
    }

    void level3() {
        String gender;
        int weight = 0, height = 0, age = 0;
        double cal = 0.0;
        int chocolate = 0;
        while (true) {
            gender = JOptionPane.showInputDialog
                    ("성별을 입력하세요(남자는 M,m, 여자는 W,w, 종료는 Q,q):");
            if (gender.equals("m") || gender.equals("w") || (gender.equals("M") || gender.equals("W"))) {
                do{
                    weight = Integer.parseInt(JOptionPane.showInputDialog("몸무게를 입력하세요:"));
                    if(weight <= 0){
                        JOptionPane.showMessageDialog(null,
                                "몸무게는 양수여야 합니다. 다시 입력해주세요.");
                        break;
                    }
                    height = Integer.parseInt(JOptionPane.showInputDialog("키를 입력하세요:"));
                    if(height <= 0){
                        JOptionPane.showMessageDialog(null,
                                "키는 양수여야 합니다. 다시 입력해주세요.");
                        break;
                    }
                } while((!isValid(weight)) || (!isValid(height)));
                if(isValid(weight) && isValid(height)){
                    age = Integer.parseInt(JOptionPane.showInputDialog("나이를 입력하세요:"));
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
                }
            }
            else if(gender.equals("q") || gender.equals("Q")){
                JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
                System.exit(0);
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "성별이 잘못 입력되었습니다. M, m 또는 W, w를 입력하세요.");
            }
        }
    }
}
