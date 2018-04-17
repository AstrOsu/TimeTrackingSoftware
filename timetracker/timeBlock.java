
package timetracker;

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
    
    public timeBlock(Calendar start, Calendar end, String d)
    {
        startDate = start;
        startTime = startDate.getTimeInMillis();
        endDate = end; 
        endTime = endDate.getTimeInMillis();
        key = getKey(start);
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
    
    public Calendar getStartDate()
    {
        return startDate; 
    }
    
    public String getStartString()
    {
        //return string representation of start date 
    }
    
     public String getEndString()
    {
        //return string representation of start date 
    }
    
     public String getDurationString()
    {
        //return string representation of start date 
    }
    

    private void setEndDate(Calendar ed)
    {
        endDate = ed;
        endTime = endDate.getTimeInMillis();
    }
    
    public Calendar getEndDate()
    {
        return endDate; 
    }

    public void start()
    {
        setStartDate(Calendar.getInstance());
        key = getKey(startDate);
        //state = new workingState(); 
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

}
