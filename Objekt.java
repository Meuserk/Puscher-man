import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Objekt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Objekt extends SmoothOperator
{
    public Objekt(){
                   // Setzt das skalierte Bild zurück auf das Objekt
    }
    public Objekt(int x, int y){
        GreenfootImage image = getImage();   // Holt das aktuelle Bild des Objekts
        image.scale(x, y);               // Skalieren des Bildes auf 100x100 Pixel
        setImage(image);                     // Setzt das skalierte Bild zurück auf das Objekt
    }
    /**
     * Act - do whatever the Objekt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
