package src;

import java.util.Scanner;

public class Game {
    private static Scanner sc = new Scanner(System.in);
    private static Board board;
    
    public static void main(String[] args) {
        board = new Board(10, 20);
        System.out.println(board);
        // main game loop
        do {
            
        } while (ask("Would you like to continue?"));
    }

    public static void turn() {

    }

    public static char checkWin() {
        return ' ';
    }

    public static boolean ask(String prompt) {
        System.out.println(prompt + " [y/N]: ");
        String next = sc.next();
        return next.toLowerCase().contains("y");
    }
}
