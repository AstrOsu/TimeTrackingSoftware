package timetracker;


import java.io.*;
/**
 *
 *
 */
public class Main
{



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException, IOException {
        //Create and populate blockStorage
        blockStorage b = new blockStorage();
        //timeBlock tb = new timeBlock("" + System.currentTimeMillis());
        b.importFile("TimeBlocks.txt");

        //Make GUI
        HomePage home = new HomePage();
        String[] hello = new String[5];
        HomePage.main(hello);

        //Save Hashmap to a file
        FileOutputStream outputStream = new FileOutputStream("storage.txt");
        byte[] strToBytes = b.toString().getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
    }
}
