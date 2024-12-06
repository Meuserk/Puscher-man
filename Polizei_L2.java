import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Polizei_L2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Polizei_L2 extends Polizei{

    public double speed = 10;
    
    public Polizei_L2(int x, int y){
        
        GreenfootImage image = getImage();   // Holt das aktuelle Bild des Objekts
        image.scale(x, y);               // Skalieren des Bildes auf 100x100 Pixel
        setImage(image);                     // Setzt das skalierte Bild zurück auf das Objekt
    }
    
    /**
     * Act - do whatever the Polizei_L2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        int x = getX();  // Gibt die X-Koordinate des Objekts zurück
        int y = getY();  // Gibt die Y-Koordinate des Objekts zurück
        
        if (canSee(Spieler.class)&& Spieler.getHatPaket()){
            Greenfoot.playSound("au.wav");
            Greenfoot.delay(15);
            super.eat(Spieler.class);
            greenfoot.Greenfoot.stop();
            //greenfoot.Greenfoot.setWorld(new GameOver());
        }
        
        //falls die Polizei von der Straße abkommt
        if(atWorldEdge()){
            setRotation(180);
            setLocation(1300,650);
        }
        
        anKreuzungWenden();
        move();
    }
}
