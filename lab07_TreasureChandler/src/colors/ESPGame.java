/*
 * Treasure Chandler
 * CS 16000-01 02/03, Fall Semester 2024
 * Lab 7
 * 
 */

package colors;

import java.awt.Color;  // Needed for the color class
import javax.swing.*;   // NEeded for the JOptionPane class

public class ESPGame {
    // Variables declaration
    private String chosenColor;

    /**
     * Runs a switch selection that chooses the color based
     * on the user's input
     * @param input     Controls what color will eventually be
     *                  displayed
     * @return          Returns the displayed color
     */
    public Color chooseColor(int input) {
        // Variables declaration
        Color color;

        // Aforementioned switch selection
        switch (input) {
            case 1:
                color = Color.BLUE;
                chosenColor = "blue";
                break;
            case 2:
                color = Color.YELLOW;
                chosenColor = "yellow";
                break;
            case 3:
                color = Color.RED;
                chosenColor = "red";
                break;
            case 4:
                color = Color.GREEN;
                chosenColor = "green";
                break;
            case 5:
                color = Color.ORANGE;
                chosenColor = "orange";
                break;
            case 6:
                color = Color.CYAN;
                chosenColor = "cyan";
                break;
            case 7:
                color = Color.darkGray;
                chosenColor = "dark gray";
                break;
            case 8:
                color = Color.GRAY;
                chosenColor = "gray";
                break;
            case 9:
                color = Color.PINK;
                chosenColor = "pink";
                break;
            case 10:
                color = Color.MAGENTA;
                chosenColor = "magenta";
                break;
            case 11:
                color = Color.WHITE;
                chosenColor = "white";
                break;
            case 12:
                color = Color.lightGray;
                chosenColor = "light gray";
                break;
            default:
                color = Color.BLACK;
                chosenColor = "black";
        }
        return color;
    } // End of chooseColor()

    /**
     * Creates a small window for displaying the "color"
     * parameter
     * @param color     Color to be displayed in the window
     */
    public void showColor(Color color) {
        JFrame frame = new JFrame("Guess this color!");
        frame.setSize(200,200);
        frame.setLocation(300,300);

        JPanel panel = new JPanel();
        panel.setBackground(color);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // End of showColor()

    /**
     * Runs a while loop to repeadedly offer the ESP game to the
     * user
     */
    public void guessColor() {
        String title, message;
        int yesNo = 0;

        // Figure 1:
        title = "ESP Game";
        message = "Enter the ESP Game?";
        JOptionPane.showConfirmDialog(null, message, title,
                                        JOptionPane.YES_NO_OPTION);
        
        while (yesNo == JOptionPane.YES_OPTION) {

        }
    } // End of guessColor()
} // End of ESPGame