
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

    public String toString()
    {
        String blockString = "";

        blockString += "Start Date: " + startDate.getTime() + "; End Date: " + endDate.getTime() + "; Description: " + description + "\n";
        return blockString;
    }

    public void setStartTime(long startTime)
    {
        this.startTime = startTime; 
    }

    public void setEndTime(long endTime)
    {
        this.endTime = endTime;
    }
    
    public void setStartDate(Calendar startDate)
    {
        this.startDate = startDate; 
    }

    public void setEndDate(Calendar ed)
    {
        endDate = ed;
        duration = endDate.getTimeInMillis() - startDate.getTimeInMillis();
    }
    
    public void setDuration(long duration)
    {
        this.duration = duration; 
    }
    
    public void setDescription(String description)
    {
        this.description = description; 
    }
    
    public Calendar getStartDate()
    {
        return startDate;
    }
    
    public long getDuration()
    {
        return endTime - startTime;
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
