package timetracker;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Class to check valid file paths and export files.
 */

public class export {

    /**
     * Prints out object's entries from the hash map into a .txt file
     * @param timeblock, path
     * @throws IOException
     */

    public void txtFile(blockStorage timeblock, String path, String fileName) throws IOException {
        if (isValidPath(path)) {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "/"+fileName+".txt")));

            List alKeys = new ArrayList(timeblock.timeBlocks.keySet());
            Collections.reverse(alKeys);
            Iterator iter = alKeys.iterator();

            String output = "";

            while(iter.hasNext()) {
                Integer key = (Integer) iter.next();
                LinkedList list = timeblock.timeBlocks.get(key);
                for (timeBlock elem : (Iterable<timeBlock>) list) {
                    output += output.format("%-15s%-15s%-15s%-15s%-15s\n",
                            elem.getStartString(), elem.getStartTimeString(),
                            elem.getEndString(), elem.getEndTimeString(),
                            elem.getDurationString());
                    output += "Description: " + elem.getDescription() + "\n\n";
                }
            }
            Formatter formatter = new Formatter();
            out.println(formatter.format("%-15s%-15s%-15s%-15s%-15s", "Start Date",
                    "Start Time", "End Date", "End Time", "Duration"));
            out.print(output);
            out.flush();
            out.close();
        }
    }

    /**
     * Prints out object's entries from the hash map into a .csv file
     * @param timeblock, path
     * @throws IOException
     */

    public void csvFile(blockStorage timeblock, String path, String fileName) throws IOException {
        if (isValidPath(path)) {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "/"+fileName+".csv")));

            List alKeys = new ArrayList(timeblock.timeBlocks.keySet());
            Collections.reverse(alKeys);
            Iterator iter = alKeys.iterator();

            String output = "";

            while(iter.hasNext()) {
                Integer key = (Integer) iter.next();
                LinkedList list = timeblock.timeBlocks.get(key);
                for (timeBlock elem : (Iterable<timeBlock>) list) {
                    output += elem.getStartString() + "," + elem.getStartTimeString() + "," +
                            elem.getEndString() + "," + elem.getEndTimeString() + "," +
                            elem.getDurationString() + "," + elem.getDescription() + "\n";
                }
            }
            out.println("Start Date, Start Time , End Date, End Time, Duration, Description ");
            out.print(output);
            out.flush();
            out.close();
        }
    }

    /**
     * Checks to see if the file path chosen is valid
     * @param path
     * @return true if valid path, else false
     */

    public static boolean isValidPath(String path) {
        try {
            Paths.get(path);
        } catch (InvalidPathException | NullPointerException ex) {
            throw new NullPointerException("File path is invalid, please try again.");
        }
        return true;
    }
}
