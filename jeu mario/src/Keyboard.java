import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{

     

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D){
        
            if(Main.screen.getxPos() ==-1){
                Main.screen.setxPos(0);
                Main.screen.setxBackground1(-50);
                Main.screen.setxBackground2(750);
            }

                Main.screen.setDx(1);
            Main.screen.mario.setRightDirection(true);   
            Main.screen.mario.setWalking(true);
            


        }
        else if(e.getKeyCode() == KeyEvent.VK_Q) {
            
            Main.screen.mario.setRightDirection(false);   
            Main.screen.mario.setWalking(true);
            Main.screen.setDx(-1);
        }  
   
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Main.screen.setDx(0);
        Main.screen.mario.setWalking(false);
    }

    @Override
        public void keyTyped(KeyEvent e) {
    }
        



}