
package timetracker;

import java.sql.Time;
import java.time.Duration;
import java.util.Date;

/**
 *
 * @author GG46195x
 */
public class timeBlock 
{
    Date startDate; 
    long startTime, endTime;
    Duration duration; 
    String description; 

    public timeBlock(){}


    public void setStartTime(long startTime)
    {
        this.startTime = startTime; 
    }

    public void setEndTime(long endTime)
    {
        this.endTime = endTime;
    }
    
    public void setStartDate(Date startDate)
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
    
    public Date getStartDate()
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
    
    /*public Date getEndDate()
    {
        return startTime+duration; // have to figure out how to find duration of day/ time mix
    }*/
}
