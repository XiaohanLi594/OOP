package PRVM;
public class Ride
{
    private String rideName;
    private int heightRequirement;
    private Employee employee;
    private boolean isOpen;

    public Ride()
    {

    }

    public Ride(String rideName, int heightRequirement, Employee employee, boolean isOpen)
    {
        this.rideName = rideName;
        this.heightRequirement = heightRequirement;
        this.employee = employee;
        this.isOpen = isOpen;
    }

    public String getRideName()
    {
        return rideName;
    }

    public void setRideName(String rideName)
    {
        this.rideName = rideName;
    }

    public int getHeightRequirement()
    {
        return heightRequirement;
    }

    public void setHeightRequirement(int heightRequirement)
    {
        this.heightRequirement = heightRequirement;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }

    public boolean isOpen()
    {
        return isOpen;
    }

    public void setOpen(boolean open)
    {
        isOpen = open;
    }
}
