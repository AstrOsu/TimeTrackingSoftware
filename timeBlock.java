
package timetracker;

/**
 *
 * @author GG46195x
 */
public class timeBlock 
{
    double startTime; 
    double duration; 
    String description; 
    
    public void setStartTime(double startTime)
    {
        this.startTime = startTime; 
    }
    
    public void setDuration(double duration)
    {
        this.duration = duration; 
    }
    
    public void setDescription(String description)
    {
        this.description = description; 
    }
    
    public double getStartTime()
    {
        return startTime; 
    }
    
    public double getDuration()
    {
        return duration; 
    }
    
    public String getDescription()
    {
        return description;   
    }
    
    public double getEndTime()
    {
        return startTime+duration; 
    }
}
