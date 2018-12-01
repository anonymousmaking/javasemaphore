//package Semaphores.boundedbuffer;

/**
 * This is the producer thread for the bounded buffer problem.
 */
import java.util.*;

public class Producer implements Runnable {
    // Packet: Packets which arrive every 10 units and require 5 units processing (or service) time.
    // Declare variables
    private int sleepTime = 0;
    private int proccesingTime = 0;
    private double startTime = 0;
    private double endTime = 0;
    private double interarrival_time = 0;
    protected static int packetCount= 0;

    public Producer(Buffer b) {
        buffer = b;
    }

    public Producer(Buffer b, int proccesingTime, int sleepTime) {
        this.buffer = b;
        this.proccesingTime = proccesingTime;
        this.sleepTime = sleepTime;
    }
    public void run() {
        //Date message;
        Packet packet;
        while (true) {
            // Init packet with processing time
            packet = new Packet(proccesingTime);
            // insert packet into buffer
            // Get current start time
            startTime = System.currentTimeMillis();
            buffer.insert(packet);
            packetCount++;
            System.out.println("Packet number: " + packetCount);
            // Get current end time
            endTime = System.currentTimeMillis();
            //interarrival_time = endTime - startTime;
            // Delay 10 seconds
            SleepUtilities.nap(sleepTime);
        }
    }
    private Buffer buffer;
}
