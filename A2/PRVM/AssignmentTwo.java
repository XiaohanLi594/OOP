package PRVM;
import PRVM.VisitorComparator;
public class AssignmentTwo
{
    public static void main(String[] args)
    {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree()
    {
        System.out.println("Executing Part Three");
        Ride rollerCoaster = new Ride("Roller Coaster", 120, new Employee("John", "Doe", 30, "E001", "Operator", 30000), true);

        rollerCoaster.addVisitorToQueue(new Visitor("Jack", "Smith", 25, "V001", "Regular", 1));
        rollerCoaster.addVisitorToQueue(new Visitor("Sharon", "Johnson", 22, "V002", "Regular", 2));
        rollerCoaster.addVisitorToQueue(new Visitor("Benny", "Brown", 28, "V003", "Regular", 3));
        rollerCoaster.addVisitorToQueue(new Visitor("Leo", "Davis", 20, "V004", "Regular", 4));
        rollerCoaster.addVisitorToQueue(new Visitor("Nehemia", "Taylor", 24, "V005", "Regular", 5));

        rollerCoaster.removeVisitorFromQueue(new Visitor("Sharon", "Johnson", 22, "V002", "Regular", 2));

        rollerCoaster.printQueue();
    }

    public void partFourA()
    {
        System.out.println("Executing Part Four A");
        Ride rollerCoaster = new Ride("Roller Coaster", 120, new Employee("John", "Doe", 30, "E001", "Operator", 30000), true);

        rollerCoaster.addVisitorToHistory(new Visitor("Tom", "Hanks", 35, "V006", "VIP", 1));
        rollerCoaster.addVisitorToHistory(new Visitor("Sheryl", "Crow", 30, "V007", "Regular", 2));
        rollerCoaster.addVisitorToHistory(new Visitor("Ben", "Stiller", 40, "V008", "VIP", 3));
        rollerCoaster.addVisitorToHistory(new Visitor("David", "Beckham", 45, "V009", "VIP", 4));
        rollerCoaster.addVisitorToHistory(new Visitor("Jason", "Statham", 50, "V010", "Regular", 5));

        boolean hasVisitor = rollerCoaster.checkVisitorFromHistory(new Visitor("Tom", "Hanks", 35, "V006", "VIP", 1));
        System.out.println("Visitor exists in history: " + hasVisitor);

        System.out.println("Number of visitors in ride history: " + rollerCoaster.numberOfVisitors());

        rollerCoaster.printRideHistory();
    }

    public void partFourB()
    {
        System.out.println("Executing Part Four B");
        Ride rollerCoaster = new Ride("Roller Coaster", 120, new Employee("John", "Doe", 30, "E001", "Operator", 30000), true);

        rollerCoaster.addVisitorToHistory(new Visitor("Tom", "Hanks", 35, "V006", "VIP", 1));
        rollerCoaster.addVisitorToHistory(new Visitor("Sheryl", "Crow", 30, "V007", "Regular", 2));
        rollerCoaster.addVisitorToHistory(new Visitor("Ben", "Stiller", 40, "V008", "VIP", 3));
        rollerCoaster.addVisitorToHistory(new Visitor("David", "Beckham", 45, "V009", "VIP", 4));
        rollerCoaster.addVisitorToHistory(new Visitor("Jason", "Statham", 50, "V010", "Regular", 5));

        System.out.println("Visitors before sorting:");
        rollerCoaster.printRideHistory();

        rollerCoaster.sortRideHistory(new VisitorComparator());

        System.out.println("Visitors after sorting:");
        rollerCoaster.printRideHistory();
    }

    public void partFive()
    {
        System.out.println("Executing Part Five");
    }

    public void partSix()
    {
        System.out.println("Executing Part Six");
    }

    public void partSeven()
    {
        System.out.println("Executing Part Seven");
    }
}





