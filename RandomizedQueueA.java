/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gordl
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.reflect.Array;

public class RandomizedQueueA<Item> {
    private Item[] data;
    public RandomizedQueueA() {
//        Item[] a = (Item[]) Array.newInstance(data.getClass().getComponentType(), 0); // more type safe than option b ?
//        this.data = a;
         Item[] b = (Item[]) new Object[0];
         this.data = b;
    }
    public static void main(String[] args) {
        // test constructor
        RandomizedQueueA<Integer> rq1 = new RandomizedQueueA<>();
        System.out.printf("rq has type: %s%n", rq1.getClass().getName());
    }
}
