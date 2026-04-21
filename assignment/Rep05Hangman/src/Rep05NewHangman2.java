import java.util.Scanner;

public class Rep05NewHangman2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        String answer;
        do{
            NewHangman2 game = new NewHangman2();
            game.initialize("Happiness");
            System.out.println("Let's play a round of hangman.");
            game.playGame();
            System.out.print("Would you like to play another round? (yes/no): ");
            answer = sc.nextLine();
            if(answer.equals("no")){
                quit = true;
            }
        }while(!quit);
    }

}
class NewHangman2{
    private String secretWord;
    private String disguisedWord;
    private int wrongCount = 0;

    void initialize(String word){
        disguisedWord = "";
        StringBuilder strBuilder = new StringBuilder(disguisedWord);
        secretWord = word.toLowerCase();
        for(int i = 0; i < secretWord.length(); i++){
            if(Character.isAlphabetic(secretWord.charAt(i))){
                strBuilder.append("?");
            }
            else{
                strBuilder.append(secretWord.charAt(i));
            }
        }
        disguisedWord = strBuilder.toString();
    }

    void makeGuess(char c){
        c = Character.toLowerCase(c);
        StringBuilder strBuilder = new StringBuilder(disguisedWord);
        boolean found = false;
        for(int i = 0; i < secretWord.length(); i++){
            if(secretWord.charAt(i) == c && disguisedWord.charAt(i) == '?'){
                strBuilder.replace(i, i+1, String.valueOf(c));
                found = true;
            }
            else if(secretWord.charAt(i) == c){
                found = true;
            }
        }
        if(!found){
            wrongCount++;
            found = false;
        }
        disguisedWord = strBuilder.toString();
    }

    String getDisguisedWord(){return disguisedWord;}

    String getSecretWord(){
        return secretWord;
    }

    void playGame(){
        Scanner sc = new Scanner(System.in);
        while(!(disguisedWord.equals(secretWord))){
            System.out.print("Current word: " + getDisguisedWord() + '\n');
            System.out.println("Incorrect guesses: " + wrongCount);
            System.out.print("Enter your guess: ");
            char c = sc.nextLine().charAt(0);
            makeGuess(c);
        }
        System.out.println("Congratulations! The word was: " + getSecretWord());
    }
}