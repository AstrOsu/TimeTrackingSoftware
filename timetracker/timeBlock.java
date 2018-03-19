
package timetracker;

import java.time.Duration;
import java.util.*;

/**
 *
 * @author GG46195x
 */
public class timeBlock 
{
    Calendar startDate;
    long startTime, endTime;
    Duration duration; 
    String description; 

    public timeBlock(Calendar c){startDate = c;}


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
    
    public void setDuration(Duration duration)
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
    
    /*public Date getEndDate()
    {
        return startTime+duration; // have to figure out how to find duration of day/ time mix
    }*/
}
