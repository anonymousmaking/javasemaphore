import java.util.ArrayList;

public class Packet {
    // Variables
    private double serviceTime = 0;
    private double endServiceTime = 0;
    private double turnaroundTime = 0;
    private double startTime = 0;
    private double waitTime = 0;
    // Static Variables
    protected static double maxServiceTime = 0;
    protected static double maxTurnaroundTime = 0;
    protected static double maxWaitTime = 0;
    protected static double avgServiceTime = 0;
    protected static double avgTurnaroundTime = 0;
    protected static double avgWaitTime = 0;
    protected static double totalServiceTime = 0;
    // Collections
    protected static ArrayList<Double> serviceTimeList = new ArrayList<Double>();
    protected static ArrayList<Double> turnaroundList = new ArrayList<Double>();
    protected static ArrayList<Double> waitTimeList = new ArrayList<Double>();

    /**
     * Constructor
     * @param time
     */
    public Packet(int time) {
        this.serviceTime = time;
        this.startTime = System.currentTimeMillis();

    }





    private void calculateMax() {
        if (serviceTime > maxServiceTime) {
            maxServiceTime = endServiceTime;
        }
        if (waitTime > maxWaitTime) {
            maxWaitTime = waitTime;
        }
        if (turnaroundTime > maxTurnaroundTime) {
            maxTurnaroundTime = turnaroundTime;
        }
    }

    private void addToList() {
        waitTimeList.add(waitTime);
        turnaroundList.add(turnaroundTime);
        serviceTimeList.add(endServiceTime);
        totalServiceTime += endServiceTime;
    }

    public void calculateAvg() {
        // Add to list
        for (double num : waitTimeList) {
            avgWaitTime += num;
        }
        avgWaitTime = avgWaitTime / waitTimeList.size();

        // Add to list
        for (double num : turnaroundList) {
            avgTurnaroundTime += num;
        }
        avgTurnaroundTime = avgTurnaroundTime / turnaroundList.size();
        // Add to list
        for (double num : serviceTimeList) {
            avgServiceTime += num;
        }
        avgServiceTime = avgServiceTime / serviceTimeList.size();
    }

    public void calculateResult(){
        endServiceTime = System.currentTimeMillis() - endServiceTime;
        if (turnaroundTime == 0) {
            turnaroundTime = System.currentTimeMillis() - startTime;
            waitTime = turnaroundTime - endServiceTime;
        }
        addToList();
        calculateMax();
    }

    @Override
    public String toString() {
        return turnaroundTime + " wait time: " + waitTime + "ms";
    }



    // Getter, Setter

    public double getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    public double getEndServiceTime() {
        return endServiceTime;
    }

    public void setEndServiceTime(double endServiceTime) {
        this.endServiceTime = endServiceTime;
    }

    public double getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(double turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public double getStartTime() {
        return startTime;
    }

    public void setStartTime(double startTime) {
        this.startTime = startTime;
    }

    public double getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(double waitTime) {
        this.waitTime = waitTime;
    }

    public static double getMaxServiceTime() {
        return maxServiceTime;
    }

    public static void setMaxServiceTime(double maxServiceTime) {
        Packet.maxServiceTime = maxServiceTime;
    }

    public static double getMaxTurnaroundTime() {
        return maxTurnaroundTime;
    }

    public static void setMaxTurnaroundTime(double maxTurnaroundTime) {
        Packet.maxTurnaroundTime = maxTurnaroundTime;
    }

    public static double getMaxWaitTime() {
        return maxWaitTime;
    }

    public static void setMaxWaitTime(double maxWaitTime) {
        Packet.maxWaitTime = maxWaitTime;
    }

    public static double getAvgServiceTime() {
        return avgServiceTime;
    }

    public static void setAvgServiceTime(double avgServiceTime) {
        Packet.avgServiceTime = avgServiceTime;
    }

    public static double getAvgTurnaroundTime() {
        return avgTurnaroundTime;
    }

    public static void setAvgTurnaroundTime(double avgTurnaroundTime) {
        Packet.avgTurnaroundTime = avgTurnaroundTime;
    }

    public static double getAvgWaitTime() {
        return avgWaitTime;
    }

    public static void setAvgWaitTime(double avgWaitTime) {
        Packet.avgWaitTime = avgWaitTime;
    }

    public static double getTotalServiceTime() {
        return totalServiceTime;
    }

    public static void setTotalServiceTime(double totalServiceTime) {
        Packet.totalServiceTime = totalServiceTime;
    }

    public static ArrayList<Double> getServiceTimeList() {
        return serviceTimeList;
    }

    public static void setServiceTimeList(ArrayList<Double> serviceTimeList) {
        Packet.serviceTimeList = serviceTimeList;
    }

    public static ArrayList<Double> getTurnaroundList() {
        return turnaroundList;
    }

    public static void setTurnaroundList(ArrayList<Double> turnaroundList) {
        Packet.turnaroundList = turnaroundList;
    }

    public static ArrayList<Double> getWaitTimeList() {
        return waitTimeList;
    }

    public static void setWaitTimeList(ArrayList<Double> waitTimeList) {
        Packet.waitTimeList = waitTimeList;
    }
}
