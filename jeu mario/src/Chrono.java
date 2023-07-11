

public class Chrono implements Runnable {

    private final int PAUSE = 3;

    

    @Override
    public void run() {

        while(true){    
            
            Main.screen.repaint();


            try {
                Thread.sleep(PAUSE);
            } catch (InterruptedException e) {
            }


        }
       
    }






}