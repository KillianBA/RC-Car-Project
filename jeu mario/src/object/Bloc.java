package object;

import javax.swing.ImageIcon;

import java.awt.Image;

public class Bloc extends Object{

    private Image blocImage;
    private ImageIcon blocIcon;

    public Bloc(int x, int y){

        super(x,y,43,65);

        this.blocIcon = new ImageIcon(getClass().getResource("/Images/bloc.png"));
        this.blocImage = this.blocIcon.getImage();

    }

    public Image getblocImage() {
        return blocImage;
    }




}
