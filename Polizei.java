import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Polizei extends Person{
    /**GreenfootSound sirene = new GreenfootSound("sirene.mp3");
    public void polizeisirene() {
        sirene.playLoop();
    }*/
    public void act(){
        move();
    }

    public void move(){
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * speed);
        int y = (int) Math.round(getY() + Math.sin(angle) * speed);
        
        setLocation(x, y);   
    }
    
    public void moveByPixel(int pixel){
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * pixel);
        int y = (int) Math.round(getY() + Math.sin(angle) * pixel);
        
        setLocation(x, y);   
    }

    public boolean canSee(Class clss){
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        return actor != null;        
    }

    public void eat(Class clss){
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) {
            getWorld().removeObject(actor);
        }
    }
    

    public void anKreuzungWenden(){
        int pixelNachTurn = 17;
        int pixelVorTurn = 0;
    //hier wird das Wenden geregelt, basierend darauf, gegen welche Kreuzung
        //sie rennen
        //Zero degrees is towards the east, increases clockwise
        
        //kann in jede Richtung fahren
        if(canSee(Kreuzung.class)){
            moveByPixel(pixelVorTurn);
            switch(Greenfoot.getRandomNumber(4)){
                case 0:
                    setRotation(0);
                    break;
                case 1:
                    setRotation(90);
                    break;
                case 2:
                    setRotation(180);
                    break;
                case 3:
                    setRotation(270);
                    break;
            }
            moveByPixel(pixelNachTurn);
        }
        
        //kann nicht nach oben, also nicht nach 270 grad
        else if(canSee(KreuzungA.class)){
            moveByPixel(pixelVorTurn);
            switch(Greenfoot.getRandomNumber(3)){
                case 0:
                    setRotation(0);
                    break;
                case 1:
                    setRotation(90);
                    break;
                case 2:
                    setRotation(180);
                    break;
            }
            moveByPixel(pixelNachTurn);
        }
        
        //kann nicht nach unten, also nicht nach 90 grad
        else if(canSee(KreuzungB.class)){
            moveByPixel(pixelVorTurn);
            switch(Greenfoot.getRandomNumber(3)){
                case 0:
                    setRotation(0);
                    break;
                case 1:
                    setRotation(180);
                    break;
                case 2:
                    setRotation(270);
                    break;
            }
            moveByPixel(pixelNachTurn);
        }
        
        //kann nicht nach Rechts, also nicht nach 0 grad
        else if(canSee(KreuzungC.class)){
            moveByPixel(pixelVorTurn);
            switch(Greenfoot.getRandomNumber(3)){
                case 0:
                    setRotation(90);
                    break;
                case 1:
                    setRotation(180);
                    break;
                case 2:
                    setRotation(270);
                    break;
            }
            moveByPixel(pixelNachTurn);
        }
        
        //kann nicht nach links, also nach 180
        else if(canSee(KreuzungE.class)){
            moveByPixel(pixelVorTurn);
            switch(Greenfoot.getRandomNumber(3)){
                case 0:
                    setRotation(90);
                    break;
                case 1:
                    setRotation(0);
                    break;
                case 2:
                    setRotation(270);
                    break;
                }
            moveByPixel(pixelNachTurn);
        }
        
        //Wendeaktion am Ende vom Highway
        else if(canSee(KreuzungF.class)){
            setRotation(getRotation()-90);
            moveByPixel(90); //warum 96? so breit ist halt die Straße
            setRotation(getRotation()-90);
        }
        
        //wenden, weil dead end
        else if(canSee(KreuzungD.class)){
            
            setRotation(getRotation()+180);
            moveByPixel(10);

        }
        
        else{}
    }
}