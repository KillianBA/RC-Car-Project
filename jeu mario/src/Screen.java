import javax.swing.ImageIcon;
import javax.swing.JPanel;

import object.Bloc;
import object.RedPipe;
import personnages.Mario;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Screen  extends JPanel{

    private  ImageIcon backgroundIcon;
    private Image backgroundImage1;
    private Image backgroundImage2;

    private ImageIcon castleIcon1;
    private Image castleImage1;

    private ImageIcon startIcon;
    private Image startImage;


    private int xBackground1;
    private int xBackground2;
    

    private int dx;
    private int xPos;

    public Mario mario;
    public RedPipe redPipe1;
    public Bloc bloc1;


    public Screen(){

            super();
            this.xBackground1 = -50;
            this.xBackground2 = 750;
            this.dx = 0;
            this.xPos = -1;

            //Important de le mettre sous cette forme pôur pouvoir faire un jar
            backgroundIcon = new ImageIcon(getClass().getResource("\\Images\\fondEcran.png"));
            this.backgroundImage1 = this.backgroundIcon.getImage();
            this.backgroundImage2 = this.backgroundIcon.getImage();

            castleIcon1 = new ImageIcon(getClass().getResource("\\Images\\chateau1.png"));
            this.castleImage1 = this.castleIcon1.getImage();

            startIcon = new ImageIcon(getClass().getResource("\\Images\\depart.png"));
            this.startImage = this.startIcon.getImage();

            mario = new Mario(300, 245);
            redPipe1 = new RedPipe(600, 230);
            bloc1 = new Bloc(400 , 180);

            Thread chronoScrenn = new Thread(new Chrono());
            
            chronoScrenn.start();

            this.setFocusable(true);
            this.requestFocusInWindow();
            this.addKeyListener(new Keyboard());
        }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDx() {
        return dx;
    }
    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }
    public int getxBackground1() {
        return xBackground1;
    }

    public void setxBackground1(int xBackground1) {
        this.xBackground1 = xBackground1;
    }

    

    public int getxBackground2() {
        return xBackground2;
    }

    public void setxBackground2(int xBackground2) {
        this.xBackground2 = xBackground2;
    }
    

public void backgroundDeplacement(){



if(this.xBackground1 == -800){

this.xBackground1 = 800;

}
else if (this.xBackground2 == -800){ 
    this.xBackground2 = 800;
}

else if (this.xBackground1 == 800){ 
    this.xBackground1 = -800;
}
else if (this.xBackground2 == 800){ 
    this.xBackground2 =  -800;
}
System.out.println(xPos);
if(this.xPos >=0){

    this.xPos = this.xPos + this.dx;
this.xBackground1 = this.xBackground1 - this.dx;
this.xBackground2 = this.xBackground2 - this.dx;
}
}

public void paintComponent(Graphics g) {

    super.paintComponent(g);
    Graphics g2 = (Graphics2D)g;

    this.backgroundDeplacement();

    g2.drawImage(this.backgroundImage1,this.xBackground1,0,null);
    g2.drawImage(this.backgroundImage2,this.xBackground2,0,null);
    g2.drawImage(this.mario.walk("mario", 25), 300, 245, null);
    g2.drawImage(castleImage1, 10 - this.xPos, 95, null);
    g2.drawImage(startImage, 220 - this.xPos, 234, null);
    g2.drawImage(this.redPipe1.getRedPipeImage(), this.redPipe1.getX() - this.xPos, this.redPipe1.getY(), null);
    g2.drawImage(this.bloc1.getblocImage(), this.bloc1.getX() - this.xPos, this.bloc1.getY(), null);
}
    
}
