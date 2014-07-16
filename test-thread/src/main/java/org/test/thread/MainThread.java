package org.test.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by a203696 on 08/07/2014.
 */
public class MainThread {
    public static void main (String ... argv) {
        int proc = Runtime.getRuntime().availableProcessors();
        System.out.println("Nombre de processeurs disponible " + proc);

        Executor executor = Executors.newSingleThreadExecutor();

        executor.execute(new MonRunnable());

        ScheduledExecutorService execute = Executors.newSingleThreadScheduledExecutor();

        //Execute MonRunnable toutes les secondes
        execute.scheduleAtFixedRate(new MonRunnable(), 0, 1, TimeUnit.SECONDS);
    }
}
