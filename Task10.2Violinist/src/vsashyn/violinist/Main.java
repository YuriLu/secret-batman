/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsashyn.violinist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import vsashyn.semaphore.*;

/**
 *
 * @author vsa
 */
public class Main {

    public static void main(String args[]) throws InterruptedException {

        Game game = new Game();
        List<Thread> violinists = new ArrayList<>(7);

        ListIterator<Thread> iterator = violinists.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        for (int i = 0; i < 7; i++) {
            iterator.add(new Violinist(game));
        }
        System.out.println(violinists);

        iterator = violinists.listIterator();
        while (iterator.hasNext()) {
            iterator.next().start();
            Thread.sleep(1000);
        }

    }
}
