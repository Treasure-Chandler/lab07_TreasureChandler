/*
 * Treasure Chandler
 * CS 16000-01 02/03, Fall Semester 2024
 * Lab 7
 * 
 * This class contains the main() method, which will
 * simply run the ESP game.
 */

package colors;

public class Applications {
    /**
     * 
     * @param args      Entered values
     */
    public static void main(String[] args) {
        ESPGame game = new ESPGame();
        game.guessColor();
    } // End of main()
} // End of Applications
