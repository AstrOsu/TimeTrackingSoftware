package timetracker;


import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws InterruptedException, IOException {

        Scanner keyb = new Scanner(System.in);
        System.out.println("Type anything to begin timeblock:");

        /**
         * exporting to txt files
         */
        //export exp = new export();
        //exp.txtFile();

        timeBlock tb = new timeBlock(Calendar.getInstance(), "First one plz work");

        System.out.println("Timer started, type anything to stop.  " +  tb.key);

        //while(!keyb.hasNext()) {}

        //keyb.nextLine();
        //tb.setStartDate( Date());

        while(!keyb.hasNext()) {}
        keyb.nextLine();

        tb.setEndDate(Calendar.getInstance());

        System.out.println("Timer Stopped.  Total duration: " + tb.getDuration() + " ms"  );
        System.out.println(tb.toString());


        blockStorage bs = new blockStorage();

        bs.addBlock(tb);

        System.out.println(bs.toString());

        for(int i = 10; i > 0; i--)
        {
            System.out.println(i);
            Thread.sleep(1000);
        }

        keyb.close();
    }
}
