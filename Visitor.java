package PRVMS;
public class Visitor extends Person
{
    private String visitorId;
    private String membershipType;
    private int visitCount;

    public Visitor()
    {

    }

    public Visitor(String firstName, String lastName, int age, String visitorId, String membershipType, int visitCount)
    {
        super(firstName, lastName, age);
        this.visitorId = visitorId;
        this.membershipType = membershipType;
        this.visitCount = visitCount;
    }

    public String getVisitorId()
    {
        return visitorId;
    }

    public void setVisitorId(String visitorId)
    {
        this.visitorId = visitorId;
    }

    public String getMembershipType()
    {
        return membershipType;
    }

    public void setMembershipType(String membershipType)
    {
        this.membershipType = membershipType;
    }

    public int getVisitCount()
    {
        return visitCount;
    }

    public void setVisitCount(int visitCount)
    {
        this.visitCount = visitCount;
    }
}

