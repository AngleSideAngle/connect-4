package src;

public class Computer extends Player {

    public Computer() {
        super('Y');
    }

    @Override
    public void move(Board board) {
        int col = (int) (Math.random() * board.getRow(0).size());
        int row = board.add(getName(), col);
        setLastCol(col);
        setLastRow(row);
    }
    
}
