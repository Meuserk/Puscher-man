import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World{



    private Label packetLabel;  // Label für "Package received"
    private Label moneyLabel;   // Label für "Money"
    private int count;
    public int score;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld(){    
        // Create a new world with 1730x1024 cells with a cell size of 1x1 pixels. 
        super(1730, 1024, 1); 
        packetLabel = new Label ("Package received!"); //Label wird initialisiert
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
        Kreuzung turnH = new Kreuzung();
        addObject(turnH,994,650);
        Kreuzung turnJ = new Kreuzung();
        addObject(turnJ,1191,395);
        Kreuzung turnO = new Kreuzung();
        addObject(turnO,1191,650);

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

        //kann nicht nach rechts fahren
        KreuzungC turnK = new KreuzungC();
        addObject(turnK,1191,115);
        KreuzungC turnL = new KreuzungC();
        addObject(turnL,1532,115);
        KreuzungC turnM = new KreuzungC();
        addObject(turnM,1532,395);
        KreuzungC turnN = new KreuzungC();
        addObject(turnN,1532,650);

        //umdrehen
        //KreuzungD turnaroundA = new KreuzungD();
        //addObject(turnaroundA,245,35);
        KreuzungD turnaroundB = new KreuzungD();
        addObject(turnaroundB,341,35);
        KreuzungD turnaroundC = new KreuzungD();
        addObject(turnaroundC,35,115);
        KreuzungD turnaroundD = new KreuzungD();
        addObject(turnaroundD,35,395);
        KreuzungD turnaroundE = new KreuzungD();
        addObject(turnaroundE,130,650);
        KreuzungD turnaroundF = new KreuzungD();
        addObject(turnaroundF,245,750);
        //KreuzungD turnaroundG = new KreuzungD();
        //addObject(turnaroundG,341,750);
        KreuzungD turnaroundH = new KreuzungD();
        addObject(turnaroundH,720,35);
        KreuzungD turnaroundI = new KreuzungD();
        addObject(turnaroundI,720,750);
        KreuzungD turnaroundJ = new KreuzungD();
        addObject(turnaroundJ,994,750);
        KreuzungD turnaroundK = new KreuzungD();
        addObject(turnaroundK,1191,35);
        KreuzungD turnaroundL = new KreuzungD();
        addObject(turnaroundL,1191,750);
        KreuzungD turnaroundM = new KreuzungD();
        addObject(turnaroundM,1532,35);
        KreuzungD turnaroundN = new KreuzungD();
        addObject(turnaroundN,1532,750);
        KreuzungD turnaroundO = new KreuzungD();
        addObject(turnaroundO,1260,650);

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

        Spieler spieler = new Spieler(5);
        addObject(spieler,1116,867);

        Paket paket = new Paket();
        addObject(paket,826,78);

        Dealer dealer = new Dealer();
        addObject(dealer,208,673);
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
    public void Score ()    {
        score = 0;
        moneyLabel = new Label ("Money: "+ count +" $");
        addObject(moneyLabel, 80, 50);
    }
    public void updateScore(int points)    {
        score += points; // Geld erhöhen
        moneyLabel.setText("Money: " + score +" $");
    }

    // public static void removeDealer() {
    //     removeObject(dealer);
    //     Dealer dealer = new Dealer();
       
    // }
}
