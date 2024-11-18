import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    public Dealer(int x, int y){
        GreenfootImage image = getImage();   // Holt das aktuelle Bild des Objekts
        image.scale(x, y);               // Skalieren des Bildes auf 100x100 Pixel
        setImage(image);                     // Setzt das skalierte Bild zurück auf das Objekt
    }
    /**
     * Act - do whatever the Dealer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // if (isTouching(Spieler.class) && Spieler.getHatPaket()==true) { //guckt ob Spieler Paket hat
        //     Spieler.setHatPaket(false);
        //     MyWorld world = (MyWorld) getWorld(); // genutzt, um die Methoden showPacketLabel(), updateScore(100) und hidePacketLabel() in MyWorld aufzurufen
        //     world.showPacketLabel();
        //     world.updateScore(100);
        //     spawn();
        //     ;
        // }
    }
}
