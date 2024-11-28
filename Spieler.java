import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Spieler extends Person{

    private static boolean hatPaket; //guckt ob Spieler ein Paket hat
    private double speed;
    //private MyWorld world = Greenfoot.MyWorld;
   
        
    public Spieler(double speeduebergabe){
        speed = speeduebergabe;
        hatPaket = false; //Spieler hat noch kein Paket aufgehoben
    }
        
    public boolean canSee(Class clss){
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }
    
    /**
    * Act - do whatever the Spieler wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */

    public void act() {
        if (isTouching(Paket.class) && !hatPaket) { //guckt ob Spieler Paket hat
            hatPaket = true;            
            removeTouching(Paket.class);//entfernt Paket nach Aufhebung
            MyWorld world = (MyWorld) getWorld();
            world.showPacketLabel();

        }
        if (isTouching(Dealer.class) && hatPaket)   {
            MyWorld world = (MyWorld) getWorld();
            world.updateScore(100);
            hatPaket = false; //Paketstatus zurücksetzen
            world.hidePacketLabel();
            //greenfoot.Greenfoot.playSound("cash.wav");
            sleepFor(10);
            removeTouching(Dealer.class);
            int Position = Greenfoot.getRandomNumber(10);

            switch (Position) {
                case 1-1:
                    world.addObject(new Dealer(100,100), 208, 129);
                    break;
                    //klappt
                        
                case 2-1:
                    world.addObject(new Dealer(100,100), 372, 409);
                    break;
                    //klappt

                case 3-1:
                    world.addObject(new Dealer(100,100), 687, 660);
                    break;
                    //klappt
                       
                case 4-1:
                    world.addObject(new Dealer(100,100), 1168, 960);                        
                    break;
                    //klappt

                case 5-1:
                    world.addObject(new Dealer(100,100), 1497, 123);
                    break;
                    //klappt
                        
                case 6-1:
                    world.addObject(new Dealer(100,100), 1572,416);
                    break;
                    //klappt

                    case 7-1:
                        world.addObject(new Dealer(100,100), 1569,888);
                        break;
                        //klappt
                        
                    case 8-1:
                        world.addObject(new Dealer(100,100), 1152,132);
                        break;
                        //klappt

                    case 9-1:
                        world.addObject(new Dealer(100,100), 1021,417);
                        break;
                        //klappt
                        
                    case 10-1:
                        world.addObject(new Dealer(100,100), 208,673);
                        break;
                        //klappt
                }
                world.addObject(new Paket(75,75), 826, 78);
            }

            checkKeyPress();
            
        }
        
        public void moveLeft() {
            setLocation(getX() - speed, getY());
        }
    
        public void moveRight() {
            setLocation(getX() + speed, getY());
        }
    
        public void moveUp() {
            setLocation(getX(), getY() - speed);
        }
    
        public void moveDown() {
            setLocation(getX(), getY() + speed);
        }
    
        public void checkKeyPress() {
            
            if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
                moveLeft();
                if (canSee(Objekt.class)) {
                    moveRight();
                }   
            }
    
            if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
                moveRight();
                if (canSee(Objekt.class)) {
                    moveLeft();
                }
            }
    
            if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
                moveUp();
                if (canSee(Objekt.class)) {
                    moveDown();
                }
            }
    
            if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
                moveDown();
                if (canSee(Objekt.class)) {
                    moveUp();
                }
            }
    
        }
        
        public static boolean getHatPaket() {
            return hatPaket;
        }
    
        public static void setHatPaket(boolean hatPaket) {
            Spieler.hatPaket = hatPaket;
    }

}
