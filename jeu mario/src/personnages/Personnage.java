package personnages;

import javax.swing.ImageIcon;



public class Personnage {

private int width, height;
private int x, y;
private boolean walking;
private boolean rightDirection;
public int count;

public Personnage(int x, int y, int width, int height){




}

public int getHeight() {
    return height;
}

public void setHeight(int height) {
    this.height = height;
}

public int getWidth() {
    return width;
}

public void setWidth(int width) {
    this.width = width;
}

public int getY() {
    return y;
}

public void setY(int y) {
    this.y = y;
}

public int getX() {
    return x;
}

public void setX(int x) {
    this.x = x;
}

public boolean isWalking() {
    return walking;
}

public void setWalking(boolean walking) {
    this.walking = walking;
}

public boolean isRightDirection() {
    return rightDirection;
}

public void setRightDirection(boolean rightDirection) {
    this.rightDirection = rightDirection;
}

public java.awt.Image walk( String name, int frequence){

    String path;
    ImageIcon icon;
    java.awt.Image img;
    
    if(this.walking == false ){
        if(this.rightDirection == true){
            path = "/images/" + name + "ArretDroite.png";
        }else {
            path = "/images/" + name + "ArretGauche.png";
        }
    }else{
        this.count++;
        if(this.count /frequence == 0){

            if(this.rightDirection == true) {
                path = "/images/" + name + "ArretDroite.png";
            }
            else{
                path = "/images/" + name + "ArretGauche.png";   

            }
        }else{
            if(this.rightDirection == true){
                path = "/images/" + name + "MarcheDroite.png";

            }else{
                path = "/images/" + name + "MarcheGauche.png"; 
            }
            
        }
    }

if(this.count == 2  * frequence){

                this.count = 0;
            }
icon = new ImageIcon(getClass().getResource(path));
img = icon.getImage();

return img;
}




















    
}
