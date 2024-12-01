import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World{


    private int packetCount;
    private Label packetLabel;  // Label für "Package received"
    private Label moneyLabel;   // Label für "Money"
    private Label_Level levelLabel;
    private Spieler spieler;
    private Polizei[] polizeis; // Declare the array
    private int count;
    public int score;
    private int level;
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(){    
        // Create a new world with 1730x1024 cells with a cell size of 1x1 pixels. 
        super(1730, 1024, 1); 
        packetLabel = new Label ("Package received!"); //Label wird initialisiert
        // Initialize the array with a size of 10
        polizeis = new Polizei[10];

        // Populate the array with 7 Polizei_l1 and 3 Polizei_l2
        for (int i = 0; i < 7; i++) {
            polizeis[i] = new Polizei_L1(100,100);
        }

        for (int i = 7; i < 10; i++) {
            polizeis[i] = new Polizei_L2(100,100);
        }

        Score();
        prepare();
        
        
    }
    
    private void prepare() {

        //es folgt die Platzierung der Kreuzungsobjekte. Das ist messy und mit vielen
        //Koordinaten, also einfach nicht zu genau hingucken am Besten

        //kann überall hin, blau
        Kreuzung turnE = new Kreuzung();
        addObject(turnE,720,115);
        Kreuzung turnF = new Kreuzung();
        addObject(turnF,720,395);
        Kreuzung turnG = new Kreuzung();
        addObject(turnG,720,650);
        Kreuzung turnJ = new Kreuzung();
        addObject(turnJ,1191,395);
        Kreuzung turnO = new Kreuzung();
        addObject(turnO,1191,650);
        Kreuzung turnM = new Kreuzung();
        addObject(turnM,1532,395);

        //kann nicht nach oben fahren
        KreuzungA turnA = new KreuzungA();
        addObject(turnA,245,115);
        KreuzungA turnC = new KreuzungA();
        addObject(turnC,245,650);
        KreuzungA turnI = new KreuzungA();
        addObject(turnI,994,395);
        KreuzungA turnP = new KreuzungA();
        addObject(turnP,245,395);

        //kann nicht nach unten fahren
        KreuzungB turnB = new KreuzungB();
        addObject(turnB,341,115);
        KreuzungB turnD =new KreuzungB();
        addObject(turnD,341,650);
        KreuzungB turnQ = new KreuzungB();
        addObject(turnQ,341,395);
        KreuzungB turnH = new KreuzungB();
        addObject(turnH,994,650);

        //kann nicht nach rechts fahren
        KreuzungC turnK = new KreuzungC();
        addObject(turnK,1191,115);
        //KreuzungC turnT = new KreuzungC();
        //addObject(turnT,1191,875);
        //KreuzungC turnL = new KreuzungC();
        //addObject(turnL,1532,115);

        //kann nicht nach links fahren
        KreuzungE turnR = new KreuzungE();
        addObject(turnR,1532,875);
        KreuzungE turnS = new KreuzungE();
        addObject(turnS,1532,650);
        KreuzungE turnU = new KreuzungE();
        addObject(turnU,720,875);

        //umdrehen
        //KreuzungD turnaroundA = new KreuzungD();
        //addObject(turnaroundA,245,35);

        KreuzungD turnaroundC = new KreuzungD();
        addObject(turnaroundC,35,115);
        KreuzungD turnaroundD = new KreuzungD();
        addObject(turnaroundD,35,395);
        KreuzungD turnaroundE = new KreuzungD();
        addObject(turnaroundE,130,650);

        //KreuzungD turnaroundG = new KreuzungD();
        //addObject(turnaroundG,341,750);
        KreuzungD turnaroundH = new KreuzungD();
        addObject(turnaroundH,720,35);
        KreuzungD turnaroundI = new KreuzungD();
        addObject(turnaroundI,720,990);
        KreuzungD turnaroundJ = new KreuzungD();
        addObject(turnaroundJ,1700,875); //turnaround unten rechts
        KreuzungD turnaroundK = new KreuzungD();
        addObject(turnaroundK,1191,35);
        KreuzungD turnaroundL = new KreuzungD();
        addObject(turnaroundL,1191,990);
        KreuzungD turnaroundM = new KreuzungD();
        addObject(turnaroundM,1532,35);
        KreuzungD turnaroundN = new KreuzungD();
        addObject(turnaroundN,1532,990);
        KreuzungD turnaroundO = new KreuzungD();
        addObject(turnaroundO,1400,650);
        KreuzungD turnaroundP = new KreuzungD();
        addObject(turnaroundP,1700,650);
        KreuzungD turnaroundQ = new KreuzungD();
        addObject(turnaroundQ,1700,395);
        KreuzungD turnaroundR = new KreuzungD();
        addObject(turnaroundR,1130,875);

        KreuzungF turnaroundB = new KreuzungF();
        addObject(turnaroundB,341,35);
        KreuzungF turnaroundF = new KreuzungF();
        addObject(turnaroundF,245,990);

        /**Hindernisse werden hinzugefuegt und 
         * auf die richtigen größen gebracht
         */
        //1.Spalte
        Objekt objekt1_1 = new Objekt(337,130);
        addObject(objekt1_1,55,24);

        Objekt objekt1_2 = new Objekt(290,229);
        addObject(objekt1_2,76,256);

        Objekt objekt1_3_1 = new Objekt(250,198);
        addObject(objekt1_3_1,95,524);

        Objekt objekt1_3_2 = new Objekt(100,100);
        addObject(objekt1_3_2,10,630);

        Objekt objekt1_4 = new Objekt(320,400);
        addObject(objekt1_4,60,877);

        //1.Spalte Weg
        Objekt objektW1 = new Objekt(30,70);
        addObject(objektW1,10,110);

        Objekt objektW2 = new Objekt(30,70);
        addObject(objektW2,10,400);

        //2.Spalte
        Objekt objekt2_1 = new Objekt(44,140);
        addObject(objekt2_1,295,24);

        Objekt objekt2_2 = new Objekt(44,228);
        addObject(objekt2_2,294,256);

        Objekt objekt2_3 = new Objekt(44,201);
        addObject(objekt2_3,294,525);

        Objekt objekt2_4 = new Objekt(43,355);
        addObject(objekt2_4,294,853);

        //3.Spalte
        Objekt objekt3_1 = new Objekt(335,132);
        addObject(objekt3_1,530,23);

        Objekt objekt3_2 = new Objekt(333,228);
        addObject(objekt3_2,531,257);

        Objekt objekt3_3 = new Objekt(330,200);
        addObject(objekt3_3,532,524);

        Objekt objekt3_4 = new Objekt(330,360);
        addObject(objekt3_4,533,856);

        //4.Spalte
        Objekt objekt4_1 = new Objekt(425,100);
        addObject(objekt4_1,955,40);

        Objekt objekt4_2 = new Objekt(420,230);
        addObject(objekt4_2,956,257);

        Objekt objekt4_3_1 = new Objekt(228,203);
        addObject(objekt4_3_1,858,523);
        Objekt objekt4_3_2 = new Objekt(150,200);
        addObject(objekt4_3_2,1093,524);

        Objekt objekt4_4 = new Objekt(420,177);
        addObject(objekt4_4,956,766);

        Objekt objekt4_5 = new Objekt(423,130);
        addObject(objekt4_5,954,963);

        //5.Spalte
        Objekt objekt5_1_1 = new Objekt(296,100);
        addObject(objekt5_1_1,1361,38);

        Objekt objekt5_1_2 = new Objekt(245,70);
        addObject(objekt5_1_2,1360,110);

        Objekt objekt5_2 = new Objekt(295,230);
        addObject(objekt5_2,1360,257);

        Objekt objekt5_3_1 = new Objekt(295,200);
        addObject(objekt5_3_1,1360,524);

        Objekt objekt5_3_2 = new Objekt(40,100);
        addObject(objekt5_3_2,1436,650);

        Objekt objekt5_4 = new Objekt(295,350);
        addObject(objekt5_4,1362,851);

        //6.Spalte
        Objekt objekt6_1 = new Objekt(100,95);
        addObject(objekt6_1,1605,44);

        Objekt objekt6_2 = new Objekt(100,140);
        addObject(objekt6_2,1640,85);

        Objekt objekt6_3 = new Objekt(200,230);
        addObject(objekt6_3,1658,255);

        Objekt objekt6_4 = new Objekt(200,200);
        addObject(objekt6_4,1658,525);

        Objekt objekt6_5 = new Objekt(200,175);
        addObject(objekt6_5,1658,765);

        Objekt objekt6_6 = new Objekt(200,140);
        addObject(objekt6_6,1658,966);

        spieler = new Spieler(15);
        addObject(spieler,1116,867);

        Dealer dealer = new Dealer(100,100);
        addObject(dealer, 208, 129);

        Paket paket = new Paket(75,75);
        addObject(paket,826,78);

        // Add the first three Polizei objects to the map at specific coordinates
        addObject(polizeis[0], 1380,650);
        addObject(polizeis[1], 1380,650);
        addObject(polizeis[2], 1380,650);
        
    }

    public void showPacketLabel()   {
        //Falls das packetLabel noch nicht da ist, dann wird es hinzugefügt
        if (!getObjects(Label.class).contains(packetLabel)) {
            addObject(packetLabel, 123, 90);
        }
    }
    public void hidePacketLabel()   {
        //packetLabel wird entfernt
        removeObject(packetLabel); 
    }
    public int getLevel() { //gibt den aktuellen level zurück
        return level;
    }

    public void Score ()    {
        score = 0;
        packetCount= 0;
        level = 1;
        moneyLabel = new Label ("Money: "+ count +" $");
        addObject(moneyLabel, 80, 50);
    }
    public void updateScore(int points) {
        // Erhöht den Punktestand um die übergebenen Punkte
        score += points;
        // Erhöht die Anzahl der Pakete um 1
        packetCount += 1;
        // Aktualisiert das Geld-Label mit dem neuen Punktestand
        moneyLabel.setText("Money: " + score + " $");
        // Überprüft, ob die Anzahl der Pakete 3 erreicht hat
        if (packetCount == 3) {
            // Setzt den Punktestand zurück
            score = 0;
            // Erhöht Levelstand
            level = 2;
            // Erstellt ein neues Level-Label für Level 2
            levelLabel = new Label_Level("Level 2");
            // Fügt das Level-Label zur Welt hinzu
            addObject(levelLabel, 858, 423);
            // Verzögert das Spiel um 100 Frames
            Greenfoot.delay(100);
            // Entfernt das Level-Label aus der Welt
            removeObject(levelLabel);
            // Aktualisiert das Geld-Label mit dem zurückgesetzten Punktestand
            moneyLabel.setText("Money: " + score + " $");
            // Setzt neues Bild für den Spieler
            spieler.setImage(new GreenfootImage("RollerCharVorne.png"));
            // Setzt die Position des Spielers
            spieler.setLocation(1116, 867);
            // Setzt die Position und Rotation der Polizeifiguren
            polizeis[0].setLocation(1380, 650);
            polizeis[0].setRotation(0);
            polizeis[1].setLocation(1380, 650);
            polizeis[1].setRotation(0);
            polizeis[2].setLocation(1380, 650);
            polizeis[2].setRotation(0);
            addObject(polizeis[3], 1380,650);
            polizeis[3].setRotation(0);
        }

        // Überprüft, ob die Anzahl der Pakete 6 erreicht hat
        if (packetCount == 6) {
            // Setzt den Punktestand zurück
            score = 0;
            // Erhöht Levelstand
            level = 3;
            // Erstellt ein neues Level-Label für Level 3
            levelLabel = new Label_Level("Level 3");
            // Fügt das Level-Label zur Welt hinzu
            addObject(levelLabel, 858, 423);
            // Verzögert das Spiel um 100 Frames
            Greenfoot.delay(100);
            // Entfernt das Level-Label aus der Welt
            removeObject(levelLabel);
            // Aktualisiert das Geld-Label mit dem zurückgesetzten Punktestand
            moneyLabel.setText("Money: " + score + " $");
            // Setzt die Position des Spielers
            spieler.setLocation(1116, 867);
            // Setzt die Position und Rotation der Polizeifiguren
            polizeis[0].setLocation(1380, 650);
            polizeis[0].setRotation(0);
            polizeis[1].setLocation(1380, 650);
            polizeis[1].setRotation(0);
            polizeis[2].setLocation(1380, 650);
            polizeis[2].setRotation(0);
            polizeis[3].setLocation(1380, 650);
            polizeis[3].setRotation(0);
            addObject(polizeis[4], 1380,650);
            polizeis[4].setRotation(0);
            addObject(polizeis[7], 1380,650);
            polizeis[7].setRotation(0);
        }

        // Überprüft, ob die Anzahl der Pakete 9 erreicht hat
        if (packetCount == 9) {
            // Setzt den Punktestand zurück
            score = 0;
            // Setzt Level zurück
            level = 0;
            // Erstellt ein neues Level-Label für Level 4
            levelLabel = new Label_Level("Level 4");
            // Fügt das Level-Label zur Welt hinzu
            addObject(levelLabel, 858, 423);
            // Verzögert das Spiel um 100 Frames
            Greenfoot.delay(100);
            // Entfernt das Level-Label aus der Welt
            removeObject(levelLabel);
            // Aktualisiert das Geld-Label mit dem zurückgesetzten Punktestand
            moneyLabel.setText("Money: " + score + " $");
            // Setzt die Position des Spielers
            spieler.setLocation(1116, 867);
            // Setzt die Position und Rotation der Polizeifiguren
            polizeis[0].setLocation(1380, 650);
            polizeis[0].setRotation(0);
            polizeis[1].setLocation(1380, 650);
            polizeis[1].setRotation(0);
            polizeis[2].setLocation(1380, 650);
            polizeis[2].setRotation(0);
            polizeis[3].setLocation(1380, 650);
            polizeis[3].setRotation(0);
            polizeis[4].setLocation(1380, 650);
            polizeis[4].setRotation(0);
            polizeis[7].setLocation(1380, 650);
            polizeis[7].setRotation(0);
            addObject(polizeis[8], 1380,650);
            polizeis[8].setRotation(0);
        }
    }
    
}