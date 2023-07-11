package object;

import java.awt.Image;
import javax.swing.ImageIcon;


public class RedPipe extends Object {

private Image redPipeImage;
private ImageIcon redPipeIcon;

    public RedPipe(int x, int y){

        super(x,y,43,65);

        this.redPipeIcon = new ImageIcon(getClass().getResource("/Images/tuyauRouge.png"));
        this.redPipeImage = this.redPipeIcon.getImage();

    }

    public Image getRedPipeImage() {
        return redPipeImage;
    }





}