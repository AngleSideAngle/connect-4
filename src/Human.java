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
        int col = 0;
        while (true) {
            System.out.print("Enter the column you want to place your disc: ");
            col = sc.nextInt();
            if (col < 0 || col >= board.getRow(0).size())
                System.out.println("Please enter a valid index");
            else
                break;
        }
        int row = board.add(getName(), col);
        setLastCol(col);
        setLastRow(row);
    }
    
}
