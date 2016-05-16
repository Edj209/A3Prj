package com.mycompany.a3;

import java.util.ArrayList;
import java.util.Iterator;

public class GameObjectCollection implements ICollection {

	private ArrayList<Object> theList;

    //constructor
    public GameObjectCollection () {
        theList = new ArrayList<Object>();
    }

    public void add(Object newObject) {
        theList.add(newObject);
    }


    public Iterator getIterator(){
        return new GameObjectIterator ();

    }

    private class GameObjectIterator implements Iterator {
        private int currElementIndex;

        public GameObjectIterator() {
            currElementIndex = -1;
        }

        public boolean hasNext(){
            if(theList.size () <= 0) return false;
            if(currElementIndex == theList.size() -1)
                return false;
            return true;
        }

        public void remove() {
            theList.remove(currElementIndex);
        }

        public Object next(){
            currElementIndex++ ;
            return(theList.get(currElementIndex));


        }

    }

}
