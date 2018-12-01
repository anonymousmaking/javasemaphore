//package Semaphores.boundedbuffer;

/**
 * This is the consumer thread for the bounded buffer problem.
 */

import java.lang.reflect.ParameterizedType;
import java.util.*;

public class Consumer implements Runnable {
    // Variables
    public double startTime = 0;
    public double endTime = 0;
    public double serviceTime = 0;

    public Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        //Date message;
        Packet packet;

        while (true) {
            // Remove packet from buffer
            // Firewall accepted packet
            startTime = System.currentTimeMillis();
            packet = (Packet) buffer.remove();
            endTime = System.currentTimeMillis();
            serviceTime = endTime - startTime;
            packet.setEndServiceTime(System.currentTimeMillis());
            SleepUtilities.nap((int)packet.getServiceTime());
            // Calculate Result
            packet.calculateResult();
            //System.out.println("Result:" + packet);
        }
    }

    private Buffer buffer;
}


