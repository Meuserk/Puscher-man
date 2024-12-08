import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Polizei_L1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Polizei_L1 extends Polizei{
    /**
     * Act - do whatever the Polizei_L1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int counter = 0;
    private GreenfootSound sirene = new GreenfootSound("sirene.mp3");
    public Polizei_L1(int x, int y){
        GreenfootImage image = getImage();   // Holt das aktuelle Bild des Objekts
        image.scale(x, y);               // Skalieren des Bildes auf 100x100 Pixel
        setImage(image);                     // Setzt das skalierte Bild zurück auf das Objekt
    }
    public void act(){
        int x = getX();  // Gibt die X-Koordinate des Objekts zurück
        int y = getY();  // Gibt die Y-Koordinate des Objekts zurück
        if (!sirene.isPlaying()) {
            sirene.setVolume(30); 
            sirene.play(); // Sirene nur starten, wenn sie nicht läuft
        }
        
        if (canSee(Spieler.class) && Spieler.getHatPaket()){
            sirene.stop();
            //Greenfoot.playSound("au.wav");
            Greenfoot.delay(15);
            super.eat(Spieler.class);
            greenfoot.Greenfoot.stop();
            //greenfoot.Greenfoot.setWorld(new GameOver());
        }
        
        anKreuzungWenden();
        //falls die Polizei von der Straße abkommt
        if(atWorldEdge()){
            setRotation(180);
            setLocation(1300,650);
        }
        
        move();
    }
}
