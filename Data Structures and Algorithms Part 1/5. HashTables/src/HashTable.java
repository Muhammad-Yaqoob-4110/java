import java.util.LinkedList;

public class HashTable {
    private class Entry
    {
        private int k;
        private String v;
        public Entry(int k, String v)
        {
            this.k = k;
            this.v = v;
        }
    }

    private int size = 5;
    private LinkedList<Entry>[] list = new LinkedList[size];

    public void put(int key, String value)
    {
        Entry e = new Entry(key, value);
        var index = hashFunction(key);
        var bucket = list[index];
        if(bucket == null)
        {
            list[index] = new LinkedList<>();
            list[index].addLast(e);
        }
        else
        {
            for (Entry entry : bucket) 
            {
                if(entry.k == key)
                {
                    entry.v = value;
                    return;
                }
            }
            list[index].addLast(e);
        
        }
    }

    public String get(int key)
    {
        var bucket = getBucket(key);
        if(bucket == null)
            throw new IllegalStateException();
        
        for (Entry entry : bucket) 
        {
            if(entry.k == key)
            {
                return entry.v;
            }
        }
        return null;
    }

    
    
    public String remove(int key)
    {
        var bucket = getBucket(key);
        if(bucket == null)
            throw new IllegalStateException();
        
        for (Entry entry : bucket) 
        {
            if(entry.k == key)
            {
                String str = entry.v;
                bucket.remove(entry);
                return str;
            }
        }
        return null;
    }
    private int hashFunction(int k)
    {
        return k % size;
    }

    private LinkedList<HashTable.Entry> getBucket(int key) {
        var index = hashFunction(key);
        var bucket = list[index];
        return bucket;
    }
}
