
package timetracker;

import java.time.Duration;
import java.util.*;

/**
 *
 * @author GG46195x
 */
public class timeBlock 
{
    Calendar startDate, endDate;
    long startTime, endTime;
    long duration;
    String description;
    public int key;

    public timeBlock(Calendar c, String d)
    {
        startDate = c;
        key = getKey(c);
        description = d;
    }

    public timeBlock(String d)
    {
        description = d;
    }


    public String toString()
    {
        String blockString = "";

        blockString += "Start Date: " + startDate.getTime() + "; End Date: " + endDate.getTime() + "; Description: " + description + "\n";
        return blockString;
    }
    
    private void setStartDate(Calendar sd)
    {
        startDate = sd;
        startTime = startDate.getTimeInMillis();
    }

    private void setEndDate(Calendar ed)
    {
        endDate = ed;
        endTime = endDate.getTimeInMillis();
    }

    public void start()
    {
        setStartDate(Calendar.getInstance());
        key = getKey(startDate);
    }

    public void stop()
    {
        setEndDate(Calendar.getInstance());
        duration = endTime - startTime;
    }

    public long getDuration()
    {
        return duration;
    }
    
    public void setDescription(String description)
    {
        this.description = description; 
    }

    
    public String getDescription()
    {
        return description;
    }

    public int getKey(Calendar c)
    {
        return (c.get(c.DATE)*1000000) + ((c.get(c.MONTH)+1)*10000) + (c.get(c.YEAR));
    }


    public int getKey()
    {
        return key;
    }

    /*public Date getEndDate()
    {
        return startTime+duration; // have to figure out how to find duration of day/ time mix
    }*/
}
