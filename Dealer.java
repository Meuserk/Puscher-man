import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dealer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dealer extends Actor
{
    /**
     * Act - do whatever the Dealer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void spawn(){
    if(Greenfoot.getRandomNumber(100) == 1) {
        int x = Greenfoot.getRandomNumber(400);
        int y = Greenfoot.getRandomNumber(300);
        getWorld().addObject(new Dealer(), x, y);
        //spawn();
        }
    }
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
