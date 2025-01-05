import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Spieler extends Person{
    private static boolean hatPaket; //guckt ob Spieler ein Paket hat
    private double speed; //Geschwindigkeit des Spielers   
    private int packetCount;    
    private int level;
    private Dealer dealer;


    public Spieler(double speeduebergabe){
        speed = speeduebergabe;
        hatPaket = false; //Spieler hat noch kein Paket aufgehoben
        GreenfootImage image = new GreenfootImage("charVorne.png");
        image.scale(100, 100);
        level = 1; // Standard-Level festlegen
        dealer = new Dealer(100,100); 
        
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
       // Dealer dealer = new Dealer(100,100);
        MyWorld world = (MyWorld) getWorld();
        checkKeyPress();

        if (isTouching(Paket.class) && !hatPaket) { //guckt ob Spieler Paket hat
            hatPaket = true;            
            removeTouching(Paket.class);//entfernt Paket nach Aufhebung
            //MyWorld world = (MyWorld) getWorld();
            world.showPacketLabel();
        }

        if (isTouching(Dealer.class) && hatPaket){
            //MyWorld world = (MyWorld) getWorld();
            //removeTouching(Dealer.class);
            world.updateScore(100);
            hatPaket = false; //Paketstatus zurücksetzen
            world.hidePacketLabel();
            //greenfoot.Greenfoot.playSound("cash.wav");
            sleepFor(10);
            //removeTouching(Dealer.class);
            int Position = Greenfoot.getRandomNumber(10);
            level = world.getLevel(); // Synchronisiert den Level mit MyWorld
            switch (Position) {
                case 1-1:
                    dealer.setLocation(208, 129);
                    //world.addObject(new Dealer(100,100), 208, 129);
                    break;
                    //klappt
                        
                case 2-1:
                    dealer.setLocation(372, 409);
                    break;
                    //klappt

                case 3-1:
                    dealer.setLocation(687, 660);
                    break;
                    //klappt
                       
                case 4-1:
                    dealer.setLocation(1168, 960);                        
                    break;
                    //klappt

                case 5-1:
                    dealer.setLocation(1497, 123);
                    break;
                    //klappt
                        
                case 6-1:
                    dealer.setLocation(1572,416);
                    break;
                    //klappt

                case 7-1:
                    dealer.setLocation(1569,888);
                    break;
                    //klappt
                        
                case 8-1:
                    dealer.setLocation(1152,132);
                    break;
                    //klappt

                case 9-1:
                    dealer.setLocation(1021,417);
                    break;
                    //klappt
                        
                case 10-1:
                    dealer.setLocation(208,673);
                    break;
                    //klappt

            }

            world.addObject(new Paket(75,75), 826, 78);

        }

        if (world.getLevel() == 2){
            speed = 8;
        }
        if (world.getLevel() == 3){
            speed = 10;
        }
        if (world.getLevel() == 4){
            speed = 12;
        }

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
        MyWorld world = (MyWorld) getWorld();

        if (Greenfoot.isKeyDown("ENTER") && getX() == 0 && getY() == 0) {
            world.setBackground("PushermapFinalV1.png");
            world.World_Generation();
            setLocation(1116,867);
            world.addObject(dealer, 208, 129);
        }

        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            moveLeft();
            if (level == 1) {
                setImage("charLinks.png");
            }   
            else if (level == 2) {
                setImage("RollerCharSeiteZwei.png");                
            }
            else if (level == 3 || level == 4) {
                setImage("SpielerAutoLinks.png");
            }
            if (canSee(Objekt.class)) {
                moveRight();
            }   
        }
    
        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            moveRight();
            if (level == 1) {
                setImage("charRechts.png");
            }   
            else if (level == 2) {
                setImage("RollerCharSeiteEins.png");
            }
            else if (level == 3 || level == 4) {
                setImage("SpielerAutoRechts.png");
            }
            if (canSee(Objekt.class)) {
                moveLeft();
            }
        }
    
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            moveUp();
            if (level == 1) {
                setImage("charHinten.png");
            }   
            else if (level == 2) {
                setImage("RollerCharHinten.png");
            }
            else if (level == 3 || level == 4) {
                setImage("SpielerAutoOben.png");
            }
            if (canSee(Objekt.class)) {
                moveDown();
            }
        }
    
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
            moveDown();
            if (level == 1) {
                setImage("charVorne.png");
            }   
            else if (level == 2) {
                setImage("RollerCharVorne.png");
            }
            else if (level == 3 || level == 4) {
                setImage("SpielerAutoUnten.png");
            }
            if (canSee(Objekt.class)) {
                moveUp();
            }
        }
    
    }
        /**
        private void adjustImageSize() { // Methode um die Größe von Objekten zu ändern
            GreenfootImage image = getImage();
            image.scale(50, 60); // Größe anpassen
            setImage(image);
        }*/
    public static boolean getHatPaket() {
        return hatPaket;
    }
    
    public static void setHatPaket(boolean hatPaket) {
        Spieler.hatPaket = hatPaket;
    }

    public void deed(){
        dealer.setImage("leer.png");
    }
}
