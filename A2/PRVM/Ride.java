package PRVM;

import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

public class Ride implements RideInterface {
    private String rideName;
    private int heightRequirement;
    private Employee employee;
    private boolean isOpen;
    private LinkedList<Visitor> queue; // 等待队列
    private List<Visitor> rideHistory; // 乘车历史

    public Ride(String rideName, int heightRequirement, Employee employee, boolean isOpen) {
        this.rideName = rideName;
        this.heightRequirement = heightRequirement;
        this.employee = employee;
        this.isOpen = isOpen;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println(visitor.getFirstName() + " has been added to the queue.");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getFirstName() + " has been removed from the queue.");
        } else {
            System.out.println(visitor.getFirstName() + " is not in the queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Current queue:");
        for (Visitor visitor : queue) {
            System.out.println(visitor.getFirstName() + " " + visitor.getLastName());
        }
    }

    @Override
    public void runOneCycle() {
        int maxCapacity = 2; // 假设每次最多允许两个游客乘坐
        int count = 0;
        while (!queue.isEmpty() && count < maxCapacity) {
            Visitor visitor = queue.remove();
            rideHistory.add(visitor);
            System.out.println(visitor.getFirstName() + " is riding " + rideName);
            count++;
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getFirstName() + " has been added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history:");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getFirstName() + " " + visitor.getLastName());
        }
    }

    public void sortRideHistory(Comparator<Visitor> comparator) {
        rideHistory.sort(comparator);
    }

    // Getter 和 Setter 方法
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getHeightRequirement() {
        return heightRequirement;
    }

    public void setHeightRequirement(int heightRequirement) {
        this.heightRequirement = heightRequirement;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
