import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
            Jogador jog1 = new Jogador("Mikael", 'x');

            Jogador jog2 = new Jogador("Aaaaa", 'o');

            Tabuleiro tab1 = new Tabuleiro();

            tab1.startGame(jog1, jog2);



        }
    }
