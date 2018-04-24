
package timetracker;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author GG46195x
 */
public class timeBlock 
{
    Calendar start, end;
    //long startTime, endTime;
    long duration;
    String description;
    public int key;

    public timeBlock(Calendar c, String d)
    {
        start = c;
        key = getKey(c);
        description = d;
    }
    
    public timeBlock(Calendar start, Calendar end, String d)
    {
        this.start = start;
        //startTime = startDate.getTimeInMillis();
        this.end = end; 
        //endTime = endDate.getTimeInMillis();
        key = getKey(start);
        description = d;
    }

    public timeBlock(String d)
    {
        description = d;
    }
    
    private void setStart(Calendar start)
    {
        this.start = start;

    }
    
    public Calendar getStart()
    {
        return start; 
    }
    
    public String getStartString()
    {
        String startString = "";
        startString += start.get(Calendar.MONTH)+1 + "/" + start.get(Calendar.DAY_OF_MONTH) + 
                     "/" + start.get(Calendar.YEAR); 
        return startString; 
    }
    
     public String getEndString()
    {
        String endString = "";
        endString+= end.get(Calendar.MONTH)+1 + "/" + end.get(Calendar.DAY_OF_MONTH) + 
                     "/" + end.get(Calendar.YEAR); 
        return endString;
    }
    
     public long getDurationinMinutes()
    {
        return TimeUnit.MILLISECONDS.toMinutes(duration); 
        
    }
    
     public String getDurationString() {
        long hours = TimeUnit.MILLISECONDS.toHours(getDuration());
        long minutes = TimeUnit.MILLISECONDS.toMinutes(getDuration()) -
                (TimeUnit.MILLISECONDS.toHours(getDuration())* 60);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(getDuration()) -
                (TimeUnit.MILLISECONDS.toMinutes(getDuration()) *60);
        String string = String.format("%d:%02d:%02d", hours, minutes, seconds);
        return string;
    }
     
     public String getStartTimeString(){
         String startTimeString=""; 
         startTimeString+= start.get(Calendar.HOUR) + ":" + start.get(Calendar.MINUTE) + ":" + start.get(Calendar.SECOND); 
         return startTimeString; 
     }
    
     public String getEndTimeString(){
         String endTimeString=""; 
         endTimeString+= end.get(Calendar.HOUR) + ":" + end.get(Calendar.MINUTE) + ":" + end.get(Calendar.SECOND); 
         return endTimeString; 
     }

    private void setEnd(Calendar ed)
    {
        end = ed;
    }
    
    public Calendar getEnd()
    {
        return end; 
    }

    /* Grant said we really dont need start and stop 
    but commenting out just in case 
    public void start()
    {
        setStart(Calendar.getInstance());
        key = getKey(start);
    }

    public void stop()
    {
        setEnd(Calendar.getInstance());
        duration = endTime - startTime;
    }
*/
    public long getDuration()
    {
       return end.getTimeInMillis() - start.getTimeInMillis(); 
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
    
    public String toString() 
    { 
        String blockString = ""; 
 
        blockString += "Start Date: " + start.getTime() + "; End Date: " + end.getTime() + "; Description: " + description + "\n"; 
        return blockString; 
    } 

}
