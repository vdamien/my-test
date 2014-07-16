package org.test.thread;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by a203696 on 08/07/2014.
 */
public class ClientLauncher {
    public static void main(String... argv) {
        final ExecutorService service = Executors.newFixedThreadPool(10);


        for (int i=0; i<20; i++) {
            System.out.println("Requete " + i);

            //On traite la requète via notre executor
            service.execute(new Runnable() {

                @Override
                public void run() {
                    Socket socket = null;
                    try {
                        socket = new Socket(InetAddress.getLocalHost(), 10000);

                        System.out.println("Demande de connexion");

                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String message_distant = in.readLine();
                        System.out.println(message_distant);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

        }

    }
}
