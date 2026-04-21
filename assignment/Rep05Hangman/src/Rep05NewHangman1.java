import java.util.Scanner;

public class Rep05NewHangman1 {
    public static void main(String[] args){
        NewHangman1 game = new NewHangman1();
        game.initialize("Happiness");
        System.out.println("Let's play a round of hangman.");
        game.playGame();
    }
}
class NewHangman1{
    private String secretWord;
    private String disguisedWord;

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
        }
        disguisedWord = strBuilder.toString();
    }

    String getDisguisedWord(){
        return disguisedWord;
    }

    String getSecretWord(){
        return secretWord;
    }

    void playGame(){
        Scanner sc = new Scanner(System.in);
        while(!(disguisedWord.equals(secretWord))){
            System.out.print("Current word: " + getDisguisedWord() + '\n');
            System.out.print("Enter your guess: ");
            char c = sc.nextLine().charAt(0);
            makeGuess(c);
        }
        System.out.println("Congratulations! The word was: " + getSecretWord());
    }
}