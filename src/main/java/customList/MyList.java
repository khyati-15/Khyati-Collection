package customList;

import java.util.AbstractList;
import java.util.Arrays;


public class MyList<E> extends AbstractList<E>{
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