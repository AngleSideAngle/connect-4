package src;

import java.util.Scanner;

public class Game {
    private static Scanner sc = new Scanner(System.in);
    private static Board board;
    private static Player human;
    private static Player computer;
    
    public static void main(String[] args) {
        human = new Human(sc);
        computer = new Computer();
        // main game loop
        do {
            board = new Board(10, 20);
            char winner = ' ';
            while(winner == ' ')
                winner = turn();
            System.out.println(winner + " wins!");
        } while (ask("Would you like to continue?"));
    }

    public static char turn() {
        human.move(board);
        char c1 = board.checkWin(human.getLastRow(), human.getLastCol());
        computer.move(board);
        char c2 = board.checkWin(computer.getLastRow(), computer.getLastCol());
        if (c1 != ' ')
            return c1;
        return c2;
    }

    public static boolean ask(String prompt) {
        System.out.print(prompt + " [y/N]: ");
        String next = sc.next();
        return next.toLowerCase().contains("y");
    }
}
