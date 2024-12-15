import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Polizei_L3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Polizei_L3 extends Polizei{
    /**
     * Act - do whatever the Polizei_L3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootSound sirene = new GreenfootSound("sirene.mp3");
    private GreenfootSound theme1 = new GreenfootSound("level1_theme.mp3");
    private GreenfootSound theme2 = new GreenfootSound("level2_theme.mp3");
    private GreenfootSound theme3 = new GreenfootSound("level3_theme.mp3");
    private GreenfootSound theme4 = new GreenfootSound("level4_theme.mp3");
    public void act(){
        int x = getX();  // Gibt die X-Koordinate des Objekts zurück
        int y = getY();  // Gibt die Y-Koordinate des Objekts zurück
        
        if (canSee(Spieler.class)&& Spieler.getHatPaket()){
            stopAllSounds();
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
    private void stopAllSounds() {
        sirene.stop();
        theme1.stop();
        theme2.stop();
        theme3.stop();
        theme4.stop();
    }
}
