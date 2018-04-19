
package timetracker;
import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Main extends javax.swing.JFrame
{



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {
        blockStorage b = new blockStorage();
        timeBlock tb = new timeBlock("" + System.currentTimeMillis());


        for(int i = 0; i < 10; i++)
        {
            tb.start();

            Thread.sleep(4000);

            tb.stop();

            b.addBlock(tb);
        }

        
    }
}
