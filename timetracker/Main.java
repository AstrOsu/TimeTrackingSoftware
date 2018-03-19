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
        export exp = new export();
        exp.txtFile();

        timeBlock tb = new timeBlock(Calendar.getInstance());

        while(!keyb.hasNext()) {}

        keyb.nextLine();
        //tb.setStartDate( Date());

        System.out.println("Timer started, type anything to stop.  " +  tb.getKey(tb.startDate));

        while(!keyb.hasNext()) {}

        keyb.nextLine();
        tb.setEndTime(System.currentTimeMillis());

        System.out.println("Timer Stopped.  Total duration: " + tb.getDuration() + " ms" +
                "\nProgram will close in 10 seconds.");

        for(int i = 10; i > 0; i--)
        {
            System.out.println(i);

            Thread.sleep(1000);
        }

        keyb.close();
    }
}
