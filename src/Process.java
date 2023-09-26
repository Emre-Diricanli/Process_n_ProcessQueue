public class Process implements Comparable<Process> {
    private int processID;
    private int priority;
    private double serviceTime;
    private double arrivalTime;
    private int completionOrder;
    private double waitingTime;

    public Process(int processID, int priority, double serviceTime, double arrivalTime) {
        this.processID = processID;
        this.priority = priority;
        this.serviceTime = serviceTime;
        this.arrivalTime = arrivalTime;
        this.completionOrder = 0;
    }

    public int getPriority() {
        return priority;
    }

    public int getProcessID() {
        return processID;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public double getWaitingTime() {
        return waitingTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public int getCompletionOrder() {
        return completionOrder;
    }

    public void setCompletionOrder(int completionOrder) {
        this.completionOrder = completionOrder;
    }

    @Override
    public int compareTo(Process other) {
        if (this.priority != other.priority) {
            return Integer.compare(other.priority, this.priority);
        } else {
            return Double.compare(this.arrivalTime, other.arrivalTime);
        }
    }

    public void setWaitingTime(double waitingTime) {
        this.waitingTime = waitingTime;
    }
}
