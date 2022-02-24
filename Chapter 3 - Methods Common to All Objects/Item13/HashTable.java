package Item13;

public class HashTable implements Cloneable
{
    private Entry[] buckets;

    private static class Entry
    {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }
    }
    
    // Remainder omitted
    
    // Broken clone method - results in shared mutable state!
    @Override
    public HashTable clone()
    {
        try
        {
            HashTable result = (HashTable) super.clone();
            result.buckets = buckets.clone();

            return result;
        }
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }
}
