import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label_Level extends Actor
{
    public Label_Level (String text)  {
        this.text = text;
        fontSize = 120;
        textColor = Color.RED;
        bkColor = new Color(0,0,0,130); //Transparent
        updateImage();
    }
    /**
     * Act - do whatever the Label wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Color textColor;
    private Color bkColor;
    private int fontSize;
    private String text;
    
    public void act()
    {

    }
    
    // Methode, um den Text des Labels zu aktualisieren
    public void setText(String text) {
        this.text = text;
        updateImage();  // Bild neu generieren mit aktualisiertem Text
    }
    private void updateImage()  {
        this.text = text;
        GreenfootImage img = new GreenfootImage (text, fontSize, textColor, bkColor);
        setImage (img);
    }
    
}
