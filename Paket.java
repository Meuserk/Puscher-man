import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paket here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paket extends Actor
{
    public Paket(int x, int y){
        GreenfootImage image = getImage();   // Holt das aktuelle Bild des Objekts
        image.scale(x, y);               // Skalieren des Bildes auf 100x100 Pixel
        setImage(image);                     // Setzt das skalierte Bild zurück auf das Objekt
    }
    /**
     * Act - do whatever the Paket wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
