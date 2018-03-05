package timetracker;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner keyb = new Scanner(System.in);
        System.out.println("Type anything to begin timeblock:");

        timeBlock tb = new timeBlock();

        while(!keyb.hasNext()) {}

        keyb.nextLine();
        tb.setStartTime(System.currentTimeMillis());

        System.out.println("Timer started, type anything to stop.");

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

        /**
         * exporting to txt files
         */
        export exp = new export();
        exp.txtFile();
    }
}
