
package timetracker;
import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Main extends javax.swing.JFrame
{



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException, IOException {
        blockStorage b = new blockStorage();
        //timeBlock tb = new timeBlock("" + System.currentTimeMillis());
        b.importFile("TimeBlocks.txt");

        /* Used to generate time blocks
        for(int i = 0; i < 10; i++)
        {
            timeBlock tb = new timeBlock("" + System.currentTimeMillis());
            tb.start();
            //System.out.println("Timer started.  " +  tb.key);
            Thread.sleep(1000);
            tb.stop();
            //System.out.println(i);
            b.addBlock(tb);
        }*/

        //writes b.toString to a file

        FileOutputStream outputStream = new FileOutputStream("storage.txt");
        byte[] strToBytes = b.toString().getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
    }
}
