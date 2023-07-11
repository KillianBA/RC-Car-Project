package personnages;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Mario extends Personnage{
private Image marioImage;
public void setMarioImage(Image marioImage) {
    this.marioImage = marioImage;
}



private ImageIcon marioIcon;



public Mario(int x, int y) {
    
    super(x, y, 28, 50);
    this.marioIcon = new ImageIcon("src/Images/marioMarcheDroite.png");
    this.marioImage = this.marioIcon.getImage();
        

        
        
    }
    
public Image getMarioImage() {
    return marioImage;
}




    
}
