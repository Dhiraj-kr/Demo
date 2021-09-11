package java_example.collection;

import java.util.*;

/**
 * Created by DM on 9/18/2020.
 */
public class LRUCacheTest {

    static class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int maxSize;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.maxSize = capacity;
        }

        //return -1 if miss
        public int get(int key) {
            Integer v = super.get(key);
            return v == null ? -1 : v;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            System.out.println("remove Eldest Entry");
            return this.size() > maxSize; //must override it if used in a fixed cache
        }
    }

    public static void main(String arg[]){

        LRUCache cache=new LRUCache(3);
        cache.put(1,5);
        cache.put(2,4);
        cache.put(6,7);
        cache.put(5,1);
        Set<Map.Entry<Integer, Integer>> entrySet=cache.entrySet();
        entrySet.forEach(e->{
            System.out.print(e.getKey());
            System.out.print(e.getValue());
        });


    }

}
