
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
    
    private void setStart(Calendar start) { this.start = start;}

    private void setEnd(Calendar ed)
    {
        end = ed;
    }
    
    public Calendar getStart()
    {
        return start; 
    }
    
    public String getStartString()
    {
        return start.get(Calendar.MONTH) + 1 + "/" + start.get(Calendar.DAY_OF_MONTH) + "/" + start.get(Calendar.YEAR);
    }
    
    public String getEndString()
    {
        return end.get(Calendar.MONTH) + 1 + "/" + end.get(Calendar.DAY_OF_MONTH) + "/" + end.get(Calendar.YEAR);

    }

    @Override
    public String toString()
    {
        return start.getTime().toString() + "\r\n" + end.getTime().toString();
    }

     public long getDurationinMinutes()
    {
        return TimeUnit.MILLISECONDS.toMinutes(duration); 
        
    }
     
     public String getStartTimeString(){
         return start.get(Calendar.HOUR) + ":" + start.get(Calendar.MINUTE) + ":" + start.get(Calendar.SECOND);
     }
    
     public String getEndTimeString(){
         return end.get(Calendar.HOUR) + ":" + end.get(Calendar.MINUTE) + ":" + end.get(Calendar.SECOND);
     }
    
    public Calendar getEnd()
    {
        return end; 
    }

    /* Grant said we really dont need start and stop 
    but commenting out just in case */
    public void start()
    {
        setStart(Calendar.getInstance());
        key = getKey(start);
    }

    public void stop()
    {
        setEnd(Calendar.getInstance());
        duration = end.getTimeInMillis() - start.getTimeInMillis();
    }

    public long getDuration()
    {
       return start.getTimeInMillis() - end.getTimeInMillis(); 
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

}
