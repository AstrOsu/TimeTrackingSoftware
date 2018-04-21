
package timetracker;

import java.io.*;
import java.util.*;

/**
 * TODO create methods for exporting
 *
 * @author GG46195x
 */
public class blockStorage
{
    HashMap<Integer, LinkedList<timeBlock>> timeBlocks;

    public blockStorage(){
        timeBlocks = new HashMap<Integer, LinkedList<timeBlock>>();
    }

    public boolean contains(timeBlock block)
    {
        if(!timeBlocks.containsKey(block.key))
            return false;
        LinkedList l1 = timeBlocks.get(block.key);
        return l1.contains(block);
    }

    public void addBlock(timeBlock block)
    {
        if(!timeBlocks.containsKey(block.key))
        {
            timeBlocks.put(block.key, new LinkedList<timeBlock>());
        }
        LinkedList l1 = timeBlocks.get(block.key);
        if(l1.contains(block))
            return;

        ListIterator<timeBlock> lIter = l1.listIterator();

        while(lIter.hasNext())
        {
            timeBlock elem = lIter.next();

            if(elem.start.compareTo(block.start) > 0)
            {
                l1.add(lIter.nextIndex() - 1, block);
                return;
            }
        }

        timeBlocks.get(block.key).addLast(block);
    }

    public timeBlock removeBlock(timeBlock block)
    {
        if(timeBlocks.containsKey(block.key))
        {
           LinkedList l1 = timeBlocks.get(block.key);
           try
           {
               timeBlock tb = (timeBlock) l1.remove(l1.indexOf(block));
               return tb;
           }
           catch (IndexOutOfBoundsException e)
           {
               System.out.println("Error: TimeBlock not found in hash map.");
           }
        }
        return null;
    }
    
    public void mergeBlocks(timeBlock firstBlock, timeBlock secondBlock, String description)
    {
        timeBlock merged;
        if (description == null || description.isEmpty())
        {
            if (firstBlock.description == null || firstBlock.description.isEmpty())
                merged = new timeBlock(firstBlock.getStart(), secondBlock.getEnd(), secondBlock.description);
            else
                merged = new timeBlock(firstBlock.getStart(), secondBlock.getEnd(), firstBlock.description);
        }
        else
            merged = new timeBlock(firstBlock.getStart(), secondBlock.getEnd(), description);
        removeBlock(firstBlock); 
        removeBlock(secondBlock); 
        addBlock(merged); 
    }

    public String toString()
    {
        String hashMap = "";

        Set keys = timeBlocks.keySet();
        Iterator iter = keys.iterator();

        while(iter.hasNext())
        {
            Integer key = (Integer) iter.next();
            LinkedList l1 = timeBlocks.get(key);

            hashMap += "DATE: " + key + "\n";

            ListIterator<timeBlock> lIter = l1.listIterator();

            while(lIter.hasNext())
            {
                timeBlock elem = lIter.next();

                hashMap += "[" + (lIter.nextIndex() -1) + "] " +  elem.toString();
            }
        }

        return hashMap;
    }

    public void importFile(String fileName)
    {
        File f = new File(fileName);

    }
}
