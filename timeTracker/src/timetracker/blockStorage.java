package timetracker;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author GG46195x
 */
public class blockStorage implements blockIterator
{
    HashMap<Date, List<timeBlock>> timeBlocks;
    
    public Iterator blockIterator(){
        return new Iterator<timeBlock>(); 
    }
    
    
    public void addBlock(Date startDate, timeBlock block){
        if(!timeBlocks.containsKey(startDate)) {
            timeBlocks.put(startDate, new ArrayList<>());
        }
        timeBlocks.get(startDate).add(block);
    }
    
    public void removeBlock(Date startDate, timeBlock block){
        
}
    
}