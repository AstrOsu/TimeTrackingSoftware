
package timetracker;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TODO create methods for exporting
 *
 * @author GG46195x
 */
public class blockStorage
{
    timeBlock currentTB;
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

            if(elem.start.getTime().compareTo(block.start.getTime()) > 0)
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
               return (timeBlock) l1.remove(l1.indexOf(block));
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
                merged = new timeBlock(firstBlock.start, secondBlock.end, secondBlock.description);
            else
                merged = new timeBlock(firstBlock.start, secondBlock.end, firstBlock.description);
        }
        else
            merged = new timeBlock(firstBlock.start, secondBlock.end, description);
        removeBlock(firstBlock); 
        removeBlock(secondBlock); 
        addBlock(merged); 
    }

    public String toString()
    {
        Set keys = timeBlocks.keySet();
        Iterator iter = keys.iterator();
        String hashMap = "" + keys.size() + "\r\n";

        while(iter.hasNext())
        {
            Integer key = (Integer) iter.next();
            LinkedList l1 = timeBlocks.get(key);

            hashMap += key + " " + l1.size() + "\r\n";

            for (timeBlock elem : (Iterable<timeBlock>) l1)
            {
                hashMap += elem.toString() + "\r\n";
            }
        }

        return hashMap;
    }

    public void importFile(String fileName) throws FileNotFoundException
    {
        File f = new File(fileName);

        if(!f.exists() || !f.canRead())
        {
            System.out.println("Error:  File " + fileName + " doesn't exist or can't be read.");
            return;
        }

        Scanner sc = new Scanner(f);
        int days = sc.nextInt();
        int key, blocks;//, year, month, day, hour, minute, seccond;
        timeBlock tb;
        Date date;
        SimpleDateFormat pattern = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy;");
        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < days; i++)
        {
            sc.next();
            key = sc.nextInt();
            sc.next();
            blocks = sc.nextInt();

            for(int j = 0; j < blocks; j++)
            {
                sc.next(); sc.next(); sc.next();
                String s = sc.next() + sc.next() + sc.next() + sc.next() + sc.next() + sc.next();
                try {
                    date = pattern.parse(s);
                    Calendar temp = Calendar.getInstance();
                    temp.setTime(date);
                }
                catch (ParseException e) {System.out.println("Unable to parse input file.");}
            }
        }
    }
}
