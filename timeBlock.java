
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
    Time startTime; 
    Duration duration; 
    String description; 
    
    public void setStartTime(Time startTime)
    {
        this.startTime = startTime; 
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
    
    public Date getStartTime()
    {
        return startTime; 
    }
    
    public Duration getDuration()
    {
        return duration; 
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
