public class ArrayQueue
{

    static final int defaultsize = 100;

    Integer data[];
    int head;
    int tail;
    int size;

    ArrayQueue(int maxsize)
    {
        data = new Integer[maxsize];
        head = 0;
        tail = 0;
        size = maxsize;
    }

    ArrayQueue()
    {
        data = new Integer[defaultsize];
        head = 0;
        tail = 0;
        size = defaultsize;
    }

    public void enqueue(Integer elem)
    {
        // Assert.notFalse((tail+1)%size != head, "Queue Full");
        data[tail] = elem;
        tail = (tail + 1) % size;
    }

    public Integer dequeue()
    {
        Integer retval;

        if (head == tail)
            return null;
        retval = data[head];
        head = (head + 1) % size;
        return retval;
    }

    public boolean empty()
    {
        return head == tail;
    }

    public String toString()
    {
        String result = "[";
        int tmpHead = head;
        if (tmpHead != tail)
        {
            result = result + data[tmpHead];
            tmpHead = (tmpHead + 1) % size;
            while (tmpHead != tail)
            {
                result = result + "," + data[tmpHead];
                tmpHead = (tmpHead + 1) % size;
            }
        }
        result = result + "]";
        return result;
    }

}