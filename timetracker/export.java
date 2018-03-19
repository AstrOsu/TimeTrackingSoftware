package timetracker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class export {
    public static void txtFile() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(System.getProperty("user.home") + "/Desktop/" + "timeBlock.txt"));
        BufferedWriter buffer = new BufferedWriter(out);
        buffer.write("test");
        out.newLine();
        buffer.close();
    }
}
