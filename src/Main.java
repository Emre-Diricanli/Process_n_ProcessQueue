import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        ProcessQueue queue = new ProcessQueue(10);

        // Variables to keep track of total waiting and service times for later averages
        double totalWaitingTime = 0;
        double totalServiceTime = 0;
        double arrivalTime = 0;

        // Create and enqueue processes
        for (int i = 1; i <= 10; i++) {
            int processID = i;
            int priority = random.nextInt(100);
            double serviceTime = random.nextDouble();
            arrivalTime = random.nextDouble();
            arrivalTime += random.nextDouble() * 2;
            Process process = new Process(processID, priority, serviceTime, arrivalTime);
            queue.enqueue(process);
        }

        double currentTime = 0;

        // Dequeue and process each process in the queue
        while (queue.size() > 0) {
            Process process = queue.dequeue();
            if (process.getArrivalTime() > currentTime) {
                currentTime = process.getArrivalTime();
            }

                // Update the waiting time and service time
                double waitingTime = currentTime - process.getArrivalTime();
                process.setWaitingTime(waitingTime);
                totalWaitingTime += waitingTime;

                double processServiceTime = process.getServiceTime();
                totalServiceTime += processServiceTime;
                currentTime += processServiceTime;

                double timeInSystem = process.getWaitingTime() + process.getServiceTime();

                // Print the process information
                System.out.println("Process ID: " + process.getProcessID());
                System.out.println("Priority: " + process.getPriority());
                System.out.println("Arrival Time: " + process.getArrivalTime());
                System.out.println("Waiting Time: " + process.getWaitingTime());
                System.out.println("Service Time: " + process.getServiceTime());
                System.out.println("Time in System: " + timeInSystem);

                System.out.println();
            }


            double averageWaitingTime = totalWaitingTime / 50;
            double averageServiceTime = totalServiceTime / 50;

            System.out.println("Average Waiting Time: " + averageWaitingTime);
            System.out.println("Average Service Time: " + averageServiceTime);
    }
}