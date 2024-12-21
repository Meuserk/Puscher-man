import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Polizei_L2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Polizei_L2 extends Polizei{

    public double speed = 10;
    private GreenfootSound sirene = new GreenfootSound("sirene.mp3");

    private GreenfootSound theme1 = new GreenfootSound("level1_theme.mp3");
    private GreenfootSound theme2 = new GreenfootSound("level2_theme.mp3");
    private GreenfootSound theme3 = new GreenfootSound("level3_theme.mp3");
    private GreenfootSound theme4 = new GreenfootSound("level4_theme.mp3");
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
        if (!sirene.isPlaying()) {
            sirene.setVolume(30); 
            sirene.play(); // Sirene nur starten, wenn sie nicht läuft
        }
        int x = getX();  // Gibt die X-Koordinate des Objekts zurück
        int y = getY();  // Gibt die Y-Koordinate des Objekts zurück
        
        if (canSee(Spieler.class)&& Spieler.getHatPaket()){
            MyWorld world = (MyWorld) getWorld();
            //Greenfoot.playSound("au.wav");
            sirene.stop();
            Greenfoot.delay(15);
            stopAllSounds();
            super.eat(Spieler.class);
            world.setBackground("gameover-screen.png");
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
    private void stopAllSounds() {
        sirene.stop();
        theme1.stop();
        theme2.stop();
        theme3.stop();
        theme4.stop();
    }
}
