import java.util.Scanner;

public class Rep02Replace3 {
    public static void main(String[] args){
        Rep02Replace3 a2 = new Rep02Replace3();
        a2.level3();
    }
    void level3(){
        boolean run = true;
        String line;
        while (run){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a line of text.");
            line = sc.nextLine();

            if(line.compareTo("quit") == 0){      //사용자 입력 문자열이 "quit"일 경우 반복문 종료
                run = false;
            }

            String line_lc = line.toLowerCase();    //소문자로 변경 후
            int position = line_lc.indexOf("hate"); //hate 위치 확인
            if(position != -1){     //문자열 안에 hate가 있는 경우 실행
                line = line.substring(0, position)  //index 0 부터 hate index-1까지 자름
                        + "love"    //그 뒤에 love 추가
                        + line.substring(position + 4);     //love의 길이가 4이므로 hate의 index 보다 4만큼 뒤에 위치한 문자열을 더함
                System.out.println("I have rephrased that line to read:");      //위 코드가 실행된 경우에 rephrased 문자열 출력
                System.out.println(line);
            }   //조건문이 실행되지 않은 경우 아무것도 하지 않고 다시 반복문 상단으로 복귀
        }
    }
}
