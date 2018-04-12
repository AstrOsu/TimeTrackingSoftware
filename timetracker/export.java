package timetracker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.LinkedList;

public class export {

    /**
     * Prints out entries from the blockStorage hash map in to a .txt file
     * @param path
     * @throws IOException
     */
    public void txtFile(blockStorage timeblock, String path) throws IOException {
        if (isValidPath(path)) {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path + "/timeBlock.txt")));
            for (Integer key : timeblock.timeBlocks.keySet()) {
                LinkedList keyval = timeblock.timeBlocks.get(key);
                out.println(keyval.peek());
                keyval.pop();
            }
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
            return false;
        }
        return true;
    }
}
