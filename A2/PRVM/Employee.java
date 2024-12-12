package PRVM;
public class Employee extends Person
{
    private String employeeId;
    private String position;
    private double salary;

    public Employee()
    {

    }

    public Employee(String firstName, String lastName, int age, String employeeId, String position, double salary)
    {
        super(firstName, lastName, age);
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }

    public String getPosition()
    {
        return position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
}

