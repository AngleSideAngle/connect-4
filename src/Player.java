package src;

public interface Player {
    /*
     * Make a move
     * Returns an integer array of 2 values,
     * representing the x and y coordinate of a new location
     */
    int[] move(Board board);

}
