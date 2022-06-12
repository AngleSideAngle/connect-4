package src;

import java.util.Scanner;

public class Human extends Player {
    private Scanner sc;
    public Human(Scanner sc) {
        super('R');
        this.sc = sc;
    }

    @Override
    public void move(Board board) {
        System.out.println(board);
        System.out.print("Which column do you want to add to: ");
        int col = sc.nextInt();
        int row = board.add(getName(), col);
        setLastCol(col);
        setLastRow(row);
    }
    
}
