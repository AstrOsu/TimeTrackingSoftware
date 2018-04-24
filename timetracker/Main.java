package timetracker;
/**
 *
 *
 */

import java.io.IOException;
import timetracker.*;
public class Main
{



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException, IOException {
        //Create and populate blockStorage
        //blockStorage b = new blockStorage();
        //timeBlock tb = new timeBlock("" + System.currentTimeMillis());
        //b.importFile("TimeBlocks.txt");

        //Make GUI
        testgui2 home = new testgui2();
        String[] hello = new String[5];
        home.main(hello);
    }
}
