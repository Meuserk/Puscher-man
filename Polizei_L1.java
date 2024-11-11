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
    public void act(){
        int x = getX();  // Gibt die X-Koordinate des Objekts zurück
        int y = getY();  // Gibt die Y-Koordinate des Objekts zurück
        
        if (canSee(Spieler.class)){
            Greenfoot.playSound("au.wav");
            Greenfoot.delay(15);
            super.eat(Spieler.class);
            greenfoot.Greenfoot.stop();
            //greenfoot.Greenfoot.setWorld(new GameOver());
        }
        
        //überflüssig, da ich jedes Ende implementiert habe, an das die Polizei
        //kommen sollte (hoffentlich)
        if(atWorldEdge()){
            turn(180);
        }
        
        //zähle, ob ich mich noch bei der Kreuzung befinden kann
        //checken, ob die letzte gesehene Kreuzung mit der aktuellen
        //Kreuzung übereinstimmt. Wenn ja, die Methode überspringen.
        
        
        move();
    }
    
    
}
