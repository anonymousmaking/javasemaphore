//package Semaphores.boundedbuffer;

import java.util.concurrent.TimeUnit;

/**
 * This creates the buffer and the producer and consumer threads.
 * average service time per packet: time the server will actually process the packet;
 *
 * maximum service time per packet;
 *
 * average turnaround (or processing) time per packet : end_time – creation_time;
 *
 * maximum turnaround (or processing) time per packet;
 *
 * average wait time per packet : turnaround_time – service_time;
 *
 * maximum wait time per packet;
 *
 * processor (or CPU) utilization = total processor busy time / total time;
 *
 * processor throughput (packets/second) = total # of packets / total # of seconds.
 *
 */
public class Factory {
    public static double startTime = 0;
    public static double endTime = 0;
    public static  volatile  boolean kill = false;
    static Thread producer;
    static Thread consumer;
    static Packet packet;


    public static void main(String args[]) {
        Buffer server = new BoundedBuffer();
        packet = new Packet(12);
        producer = new Thread(new Producer(server,12, 10));
        consumer = new Thread(new Consumer(server));
        startTime = System.currentTimeMillis();
        producer.start();
        consumer.start();
    }

    public static void killAll(){
        if(Factory.kill == true){
           endTime = System.currentTimeMillis() - startTime;
            packet.calculateAvg();
            // Print out result
            printResult();
            producer.stop();
            consumer.stop();
        }
    }

    /**
     * Get average and max value from Packet and print out
     */
    public static void printResult(){
        System.out.println("Wait Times| Average:" + Packet.getAvgWaitTime() + "| Max: " + Packet.getMaxWaitTime() +
                "\nTurnaround Times| Average : " + Packet.getAvgTurnaroundTime() + "| Max: " + Packet.getMaxTurnaroundTime()+
                "\nService Times| Average : " + Packet.getAvgServiceTime() + "| Max: " + Packet.getMaxServiceTime()+
                "\nDrop Packets: " + (BoundedBuffer.dropCount/ (BoundedBuffer.totalCountPacket + BoundedBuffer.dropCount)) +
                "\nProccesor Util: " + (Packet.totalServiceTime / endTime)*100 + "%");
    }
}
