//import the packages that the program needs to run.
import javax.swing.*;
import java.awt.*;


/**
 * Main class extending JPanel to inherit methods that are used in this program.
 */
public class Main extends JPanel{
    /**
     * Declare the number of rows, columns, size and separation of GameTile class objects.
     * Declare starting background colour.
     */
    public static int rows = 3, cols = 3, tileSize = 80, border = 2;
    public static Color bgColour = Color.GRAY;


    /**
     * Method "makeBoard" creates a new JFrame object and sets its size, title, and properties,
     * Including its layout manager.
     * GridBagLayout is used to facilitate the grid structure the GameTiles will assume when the program is run.
     * GridBagLayout is used since the number of rows and columns can be set independently.
     */
    public void makeBoard(){
        JFrame daFrame = new JFrame("Button Board");
        daFrame.setPreferredSize(new Dimension(500,500));
        daFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        daFrame.setLayout(new GridBagLayout());
        daFrame.setResizable(true);
        daFrame.setVisible(true);
        daFrame.add(this);
        daFrame.pack();
    }


/**
 * First test constructor creates the designated amount of basic GameTile
 * class objects using the "makeTile" constructor method of the GameTile class.
 * "testConstructor1" calls on the "makeBoard" method to create a
 * new JFrame in which to put the GameTiles.
 */
    public void testConstructor1(){
        //Define GridLayout with set number of rows, columns, and border width.
        setLayout(new GridLayout(rows,cols,border,border));
        //Declaration and initialization of new GameTile object with preset parameters.
        GameTile maker = new GameTile(tileSize,tileSize,Color.GRAY);
        setBackground(bgColour);
        //Call on makeBoard method to make new JFrame window.
        makeBoard();
        //Nested for loop to create multiple GameTiles using the "makeTile" constructor method from GameTile class.
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                //Add the new GameTile to the JFrame window.
                add(maker.makeTile());
            }
        }
    }


    /**
     * Second test constructor creates the designated amount of basic
     * GameTile class objects using the "makeTile" constructor method of the GameTile class.
     * Follows the exact same structure as first constructor but changes the "tileSize" variable.
     */
    public void testConstructor2(){
        setLayout(new GridLayout(rows,cols,border,border));
        //Change tileSize variable.
        this.tileSize = tileSize-20;
        //Declaration and initialization of new GameTile object with preset parameters.
        GameTile maker = new GameTile(tileSize,tileSize,Color.GRAY);
        setBackground(bgColour);
        //Call on makeBoard method to make JFrame.
        makeBoard();
        //Nested for loop to create multiple GameTiles using the "makeTile" constructor method from GameTile class.
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                add(maker.makeTile());
            }
        }
    }


    /**
     * Third test constructor creates the designated amount of Colourful
     * GameTile class objects using the "makeRandColTile" constructor of the GameTile class.
     * Again follows the same structure as both previous methods but calls a
     * different constructor method from the GameTile class.
     */
    public void testConstructor3(){
        setLayout(new GridLayout(rows,cols,border,border));
        GameTile maker = new GameTile(tileSize,tileSize,Color.GRAY);
        setBackground(bgColour);
        makeBoard();
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                add(maker.makeRandColTile());
            }
        }
    }


    /**
     * Fourth test constructor method again follows the exact same structure
     * but calls on yet another different constructor method.
     * This test method calls on the "makeImgRandSoundTile"
     * constructor method with the parameter q as true.
     */
    public void testConstructor4(){
        setLayout(new GridLayout(rows,cols,border,border));
        GameTile maker = new GameTile(tileSize,tileSize,Color.GRAY);
        setBackground(bgColour);
        makeBoard();
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                add(maker.makeImgRandSoundTile(true));
            }
        }
    }


    /**
     * Fifth test constructor is identical to the fourth with the exception that
     * it calls the "makeImgRandSoundTile" constructor method with the boolean q as false.
     */
    public void testConstructor5(){
        setLayout(new GridLayout(rows,cols,border,border));
        GameTile maker = new GameTile(tileSize,tileSize,Color.GRAY);
        setBackground(bgColour);
        makeBoard();
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                add(maker.makeImgRandSoundTile(false));
            }
        }
    }


    /**
     * Main method that is called to run the select methods above.
     * by changing the method that is called, a different version and arrangement of GameTiles can be achieved.
     * Currently set to run the 5th test method.
     */
    public Main(){
        testConstructor5();
    }


    /**
     *  "main" method creates a new instance of "Main" when it is run.
     */
    public static void main(String[] args) {
        new Main();
    }
}
