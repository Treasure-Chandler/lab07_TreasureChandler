/*
 * Treasure Chandler
 * CS 16000-01 02/03, Fall Semester 2024
 * Lab 7
 * 
 */

package colors;

import java.awt.Color;      // Needed for the color class
import java.util.Random;    // Needed for the Random class
import javax.swing.*;       // NEeded for the JOptionPane class


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
            case 13:
                color = Color.BLACK;
                chosenColor = "black";
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
        frame.setSize(400,350);
        frame.setLocation(200,203);

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
        // Variables declaration
        String title, message, user_Input;
        int randomColor, yesNo = 0, totalTries = 0,
            correctTries = 0, incorrectTries = 0;
        double triesPercentage = 0.0;
        Random rand = new Random();

        // Figure 1:
        title = "ESP Game";
        message = "Enter the ESP Game?";
        yesNo = JOptionPane.showConfirmDialog(null, message, title,
                                                JOptionPane.YES_NO_OPTION);
        
        while (true) {
            if (yesNo == JOptionPane.NO_OPTION) {
                /*
                 * If the user answers "No", the program will end with a new
                 * dialog window and a console message notifying the player
                 * of such
                 */
                System.out.println("No game was played.");
                
                title = "Your ESP Test Result:";
                message = "No game was played.";
                JOptionPane.showMessageDialog(null, message, title,
                                                JOptionPane.INFORMATION_MESSAGE);

                System.exit(0);

                break;
            } else {
                /*
                 * Increments the amount of total tries (which will be the number
                 * of correct and incorrect tries total)
                 */
                totalTries++;
                /*
                 * If the user clicks "Yes", the method will randomly select
                 * an integer between 1 and 13, calls chooseColor() with the
                 * random number as a parameter, then calls showColor() with
                 * the color value returned by chooseColor() as a parameter
                 */
                randomColor = rand.nextInt(13) + 1;

                /*
                 * The "internalChosenColor" variable is initialized to chooseColor()
                 * in order to keep track of the chosen color later on. It also
                 * gives showColor() a parameter to be called with
                 */
                Color internalChosenColor = chooseColor(randomColor);

                showColor(internalChosenColor);

                // Figure 3b:
                title = "Choose any color name here:";
                message = "\nbrown\nred\ngreen\nblue\nmagenta\ncyan\nblack"
                            + "\norange\nyellow\nbeige\nlight gray\ngray"
                            + "\ndark gray\npink\nwhite";
                String[] colorArray = {"beige", "black", "blue", "brown", "cyan",
                                        "dark gray", "gray", "green", "light gray",
                                        "magenta", "orange", "pink", "red", "white",
                                        "yellow"};
                user_Input = (String) JOptionPane.showInputDialog(null, message, title,
                                                                    JOptionPane.QUESTION_MESSAGE,
                                                                    null, colorArray, colorArray[11]);

                /*
                 * After the user enters a choice, the method compares the selection
                 * from the window with the value of "chosenColor", and notifies the user
                 * upon if they guessed correctly or incorrectly. 
                 */
                if (user_Input.equals(chosenColor)) {
                    // Figure 4:
                    title = "Your guess is...";
                    message = "You guessed correctly!";
                    JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
                    // Increments the amount of correct guesses
                    correctTries++;
                } else {
                    // Figure 5:
                    title = "Your guess is...";
                    message = "You guessed incorrectly...";
                    JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
                    // Increments the amount of incorrect guesses
                    incorrectTries++;
                }

                // Compute the percentage of the correct games
                triesPercentage = (correctTries / totalTries) * 100;

                /*
                 * Since this game will go on forever due to the loop, I have added a limit to how
                 * many games can be played. I added a game limit of 10, for reference.
                 */
                if (totalTries = 10) {
                    /*
                     * Display the results in the console, and in a seperate JOptionPane
                     * window
                     */
                    System.out.printf("Out of %d game(s), you have guessed %d correctly." +
                                        "\nThe percentage for your correct guesses is %.2f%%.",
                                        totalTries, correctTries, triesPercentage);

                    break;
                }
            }
        } // End of while loop
    } // End of guessColor()
} // End of ESPGame