import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Polizei extends Person{

    public void act(){
        move();
        // Add your action code here.
        
    }

    public void move(){
        double angle = Math.toRadians( getRotation() );
        int x = (int) Math.round(getX() + Math.cos(angle) * speed);
        int y = (int) Math.round(getY() + Math.sin(angle) * speed);
        
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
    
    //private int counter = 30;
    
    /*if(doWeExecute() == true){
            anKreuzungWenden();
        }
        private boolean doWeExecute(){
        for(int i = counter; i < 50; i++){
            return false;
        }
    */
    public void anKreuzungWenden(){
        
        /*
         * Die Idee hier: Ich will anKreuzungWenden() nicht zu oft ausführen. Deshalb setze 
         * ich jedes mal, wenn ich etwas sehe, den counter auf 0 um zu warten, bis ich mich
         * von der Kreuzung entfernt habe
         *
        counter++;
        if (counter < 30){
            return;
        }*/
    //hier wird das Wenden geregelt, basierend darauf, gegen welche Kreuzung
        //sie rennen
        //Zero degrees is towards the east, increases clockwise
        
        //kann in jede Richtung fahren
        if(canSee(Kreuzung.class)){
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
            //counter = 0;
        }
        
        //kann nicht nach oben, also nicht nach 270 grad
        else if(canSee(KreuzungA.class)){
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
            //counter = 0;
        }
        
        //kann nicht nach unten, also nicht nach 90 grad
        else if(canSee(KreuzungB.class)){
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
            //counter = 0;
        }
        
        //kann nicht nach Rechts, also nicht nach 0 grad
        else if(canSee(KreuzungC.class)){
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
            //counter = 0;
        }
        
        //wenden, weil dead end
        else if(canSee(KreuzungD.class)){
            setRotation(getRotation()+180);
        }
        
        else{}
    }
}