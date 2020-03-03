package org.example;

/**
 * Hello world!
 *
 */
import java.util.AbstractList;
import java.util.Arrays;
import java.util.logging.*;

class MyList<E> extends AbstractList<E>{
    private int size = 0;
    private Object data[];
    private int i = 0;

    public MyList(){
        data = new Object[10];
        i=0;
    }

    @SuppressWarnings("unchecked")

    public E get(int index){
        return (E)data[index];
    }

    public boolean add(E e){
        data[i]=e;
        i++;
        if(i>=size)
            increaseSize();
        return true;
    }

    public E remove(int index){
        if(size< index)
            return null;
        Object x=data[index];
        for(int j=index;j<size-1;j++)
            data[j]=data[j+1];
        i--;
        size--;
        return (E)x;
    }

    public int size() {
        return size;
    }

    private void increaseSize(){
        size=data.length*2;
        data=Arrays.copyOf(data,size);
    }

    public String toString(){
        String s="";
        for (int i = 0; i < this.i; i++)
            s=s+data[i]+" ";
        return s;
    }
}

public class App
{
    private static final Logger logger = Logger.getLogger((App.class.getName()));

    public static void main( String[] args )
    {
        MyList<Integer> list = new MyList<Integer>();

        logger.severe("Initiating List");
        for(int i=0;i<15;i++)
            list.add(i);

        logger.info("LIST : ");
        String res=list.toString();
        logger.info(res);
        logger.info("Removing 3 and 4 from list");
        logger.info("Element removed " +list.remove(3));
        logger.info("Element removed " +list.remove(3));
        logger.info("Size of my list : "+list.size());
        logger.info("LIST : ");
        res = list.toString();
        logger.info(res);
    }
}
