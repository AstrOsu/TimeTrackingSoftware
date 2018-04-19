package timetracker;


import java.io.*;
import java.nio.Buffer;
import java.util.*;
import java.awt.*;
//import java.swing.*;

public class TestMain
{

    public static void main(String[] args) throws InterruptedException, IOException {

        Scanner keyb = new Scanner(System.in);
        /**
         * exporting to txt files
         */
        //export exp = new export();
        //exp.txtFile();

        timeBlock tb = new timeBlock("First one plz work");

        tb.start();
        System.out.println("Timer started, type anything to stop.  " +  tb.key);

        //while(!keyb.hasNext()) {}

        //keyb.nextLine();
        //tb.setStartDate( Date());

        while(!keyb.hasNext()) {}
        keyb.nextLine();

        tb.stop();

        System.out.println("Timer Stopped.  Total duration: " + tb.getDuration() + " ms"  );
        System.out.println(tb.toString());


        blockStorage bs = new blockStorage();
        bs.addBlock(tb);

        System.out.println(bs.toString());

        FileOutputStream outputStream = new FileOutputStream("uhplzwork.txt");
        byte[] strToBytes = bs.toString().getBytes();
        outputStream.write(strToBytes);
        outputStream.close();

        for(int i = 10; i > 0; i--)
        {
            System.out.println(i);
            Thread.sleep(1000);
        }

        keyb.close();
    }
}
