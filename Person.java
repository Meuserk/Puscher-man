import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
import java.util.ArrayList;

public class Person extends SmoothOperator
{

    public double speed = 5.0;
    public void setVolume(int level){
        //GreenfootSound.setVolume(level);
    }

    public Person(){
        GreenfootImage image = getImage();   // Holt das aktuelle Bild des Objekts
        image.scale(50, 50);               // Skalieren des Bildes auf 100x100 Pixel
        setImage(image);                   // Setzt das skalierte Bild zurück auf das Objekt
    }

    public boolean atWorldEdge(){
        if(getX() < 20 || getX() > getWorld().getWidth() - 20)
            return true;
        if(getY() < 20 || getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }

    public void moveWithSpeed(int speed){
        move(speed);
    }

    public void act(){
        // Add your action code here.
        setVolume(50);
    }

    
    public void setSpeed(double speed){
        this.speed = speed;
    }
    
    public double getSpeed(){
        return speed;
    }
    
}

