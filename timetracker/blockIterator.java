
package timetracker;

import java.util.Iterator;

interface blockIterator extends Iterator<timeBlock>{
    timeBlock next();
    boolean hasNext();
}

