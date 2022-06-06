//import the packages used in this class
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;


/**
 * GameTile class object
 */
public class GameTile {
    //Fields for the GameTile class objects are tile colour and size.
    private static Color tileColour = Color.LIGHT_GRAY;
    private static Dimension tileSize;


    /**
     * GameTile default constructor method with parameters for width, height, and colour.
     * @param width
     * @param height
     * @param colour
     */
    public GameTile(int width, int height, Color colour){
        //Values received for width and height are used as the values in the Dimension.
        //Set that the parameters received will be the object own rather than the default ones.
        this.tileSize = new Dimension(width, height);
        this.tileColour = colour;
    }


    /**
     * Method "playSound" takes a string as a parameter which is the expected sound file name.
     * @param soundName
     */
    public void playSound(String soundName){
        AudioInputStream audioInputStream = null;
        Clip clip = null;
        //program looks for the file using the identification provided as a parameter.
        //if it is found, it is assigned to be the variable "clip".
        //Otherwise, if the file name is incorrect, not found, or is the wrong format, throw an IO exception and print what the error.
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        try {
            //assign clip to be the found audio file.
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            //make sure clip has been assigned something before the method proceeds.
            assert clip != null;
            clip.open(audioInputStream);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        //Play the audio.
        clip.start();
    }

    /**
     * Constructor method "makeTile" is a basic GameTile constructor method that makes a new blank tile, the other methods are based off of this one.
     * @return
     */
    JButton makeTile(){
        //create a new instance of the GameTile object.
        JButton newTile = new JButton();
        //Set the preferred size to the set Dimension "tileSize".
        //Set the button colour to the set Color "tileColour".
        newTile.setPreferredSize(tileSize);
        newTile.setBackground(tileColour);
        //return the GameTile object
        return newTile;
    }


    /**
     * Constructor method "makeRandColTile" created a new GameTile object that responds to user input by changing to a random colour each time it is clicked.
     * @return
     */

    JButton makeRandColTile(){
        //initialize new class object and assign default tile size and colour.
        JButton newTile = new JButton();
        newTile.setPreferredSize(tileSize);
        newTile.setBackground(tileColour);

        //add an ActionListener property to the button so that whenever the said action is performed, it runs the "actionPerformed" method.
        newTile.addActionListener(new ActionListener() {
            //override parent class method for "actionPerformed".
            @Override
            public void actionPerformed(ActionEvent e) {
                //choose a random value between 0 and 255 to represent RGB values.
                int R = (int) (Math.random() * 256);
                int G = (int) (Math.random() * 256);
                int B = (int) (Math.random() * 256);
                //set a new Color to be made of the respective RGB values.
                Color color = new Color(R, G, B);
                //set the random colour to be the tile colour.
                newTile.setBackground(color);
            }
        });
        //return the new tile.
        return newTile;
    }


    /**
     * Constructor method "makeImgRandSoundTile" creates a new tile that plays a sound changes colour and has a boolean dependant image.
     *     //method takes a boolean parameter to decide what image to display on the button.
     * @param q
     * @return
     */
    JButton makeImgRandSoundTile(boolean q){
        //Declare and initialize new JButton with preset default colour and size.
        JButton newTile = new JButton();
        newTile.setPreferredSize(tileSize);
        newTile.setBackground(tileColour);
        //depending on whether the boolean q is true or false, choose between two images.
        //if true, set the Image "img" to be "qmark.png".
        if(q){
            //Set image icon to "qmark.png".
        ImageIcon img = new ImageIcon("qmark.png");
        //Initialize a new Image object and set it to be the image from the ImageIcon "img".
        Image image = img.getImage();
        //initialize another Image called "scaledImage" and using the set size from the Main class, scale it to fit the button.
        Image scaledImage = image.getScaledInstance(Main.tileSize-20,Main.tileSize-20, Image.SCALE_SMOOTH);
        //set the new GameTile's imageIcon to be the new scaled "scaledImage".
        newTile.setIcon(new ImageIcon(scaledImage));
        //Follow the same procedure if boolean "q" is false with the exception that ImageIcon "img" is set to be the file "MarioBox.png" instead.
        }else if(!q){
            ImageIcon img = new ImageIcon("MarioBox.png");
            Image image = img.getImage();
            Image scaledImage = image.getScaledInstance(Main.tileSize-10,Main.tileSize-10, Image.SCALE_SMOOTH);
            newTile.setIcon(new ImageIcon(scaledImage));
        }

        //Add an actionListener property to the new GameTile.
        newTile.addActionListener(new ActionListener() {
            //Override parent class method "actionPerformed".
            @Override
            //Same random colour generator as the "makeRandColTile" constructor method.
            public void actionPerformed(ActionEvent e) {
                int R = (int) (Math.random() * 256);
                int G = (int) (Math.random() * 256);
                int B = (int) (Math.random() * 256);
                Color color = new Color(R, G, B);
                newTile.setBackground(color);

                //call the "playSound" method to play the sound file. Pass the file name "popp.wav" as a parameter so the method knows which file to play.
                playSound("popp.wav");
            }
        });
        //Return the new GameTile object.
        return newTile;
    }
}
