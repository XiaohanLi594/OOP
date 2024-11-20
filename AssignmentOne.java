import java.util.ArrayList;
public class AssignmentOne
{
    public static void main(String[] args)
    {
        HealthProfessional hp1 = new HealthProfessional(1, "Dr. Sergey Bromberg", "FRACGP MBBS (VIC)");
        hp1.printDetails();

        HealthProfessional hp2 = new HealthProfessional(2, "Dr. Justin Wong", "MBBS");
        hp2.printDetails();

        HealthProfessional hp3 = new HealthProfessional(3, "Dr. Nora Sadek", "MRCGP");
        hp3.printDetails();

        HealthProfessional hp4 = new HealthProfessional(4, "Dr. Valerie Tan", "BSc (Hons) MBBS");
        hp4.printDetails();

        HealthProfessional hp5 = new HealthProfessional(5, "Dr. Sarah Morrell", "FRACGP");
        hp5.printDetails();

        // Part 3
        HealthProfessional gp1 = new GeneralPractitioner(1, "Dr. Sergey Bromberg", "FRACGP MBBS (VIC)", "General Practitioner");
        HealthProfessional gp2 = new GeneralPractitioner(2, "Dr. Justin Wong", "MBBS", "Pediatrician");
        HealthProfessional gp3 = new GeneralPractitioner(3, "Dr. Emily Chen", "MD", "Physician");
        HealthProfessional ohp1 = new OtherHealthProfessional(4, "Dr. Nora Sadek", "MRCGP", "Surgeon");
        HealthProfessional ohp2 = new OtherHealthProfessional(5, "Dr. Valerie Tan", "BSc (Hons) MBBS", "Clinician");

        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        System.out.println("------------------------------");
        ohp1.printDetails();
        ohp2.printDetails();
        System.out.println("------------------------------");

        // Part 4
        Appointment appointment1 = new Appointment("Wen Yu", "1234567890", "10:00", gp1);
        Appointment appointment2 = new Appointment("Qi Liu", "5945945940", "08:00", ohp1);
        Appointment appointment3 = new Appointment("Andre Li", "6176176170", "14:30", gp2);

        System.out.println("Appointment 1 Details:");
        appointment1.printAppointmentDetails();
        System.out.println("------------------------------");
        System.out.println("Appointment 2 Details:");
        appointment2.printAppointmentDetails();
        System.out.println("------------------------------");
        System.out.println("Appointment 3 Details:");
        appointment3.printAppointmentDetails();
        System.out.println("------------------------------");

        // Part 5
        ArrayList<Appointment> appointmentList = new ArrayList<>();
        createAppointment(appointmentList, "Wen Yu", "1234567890", "10:00", gp1);
        createAppointment(appointmentList, "Qi Liu", "5945945940", "08:00", gp2);
        createAppointment(appointmentList, "Andre Li", "6176176170", "14:30", ohp1);
        createAppointment(appointmentList, "Donk Niko", "9876543210", "09:30", ohp2);

        printExistingAppointments(appointmentList);
        cancelBooking(appointmentList, "5945945940");
        printExistingAppointments(appointmentList);
    }

    public static void createAppointment(ArrayList<Appointment> appointmentList, String name, String phone, String time, HealthProfessional doctor)
    {
        if (name == null || phone == null || time == null || doctor == null)
        {
            System.out.println("Cannot make a reservation must fill in all information.");
            return;
        }
        Appointment newAppointment = new Appointment(name, phone, time, doctor);
        appointmentList.add(newAppointment);
        System.out.println("The reservation was successful: " + name + " and " + doctor.getName());
        System.out.println("------------------------------");
    }

    public static void printExistingAppointments(ArrayList<Appointment> appointmentList)
    {
        if (appointmentList.isEmpty())
        {
            System.out.println("There are no current reservations.");
        }
        else
        {
            System.out.println("Existing Reservations:");
            for (Appointment appointment : appointmentList)
            {
                appointment.printDetails();
                System.out.println("------------------------------");
            }
        }
    }

    public static void cancelBooking(ArrayList<Appointment> appointmentList, String phone)
    {
        boolean found = false;
        for (int i = 0; i < appointmentList.size(); i++)
        {
            if (appointmentList.get(i).getReservationNumber().equals(phone))
            {
                appointmentList.remove(i);
                System.out.println("Phone number after canceling an reservation: " + phone);
                found = true;
                break;
            }
        }
        if (!found)
        {
            System.out.println("No phone number was found for the appointment: " + phone);
        }
        System.out.println("------------------------------");
    }
}

// Part 1
class HealthProfessional
{
    private int id;
    private String name;
    private String presentation;

    public HealthProfessional()
    {
        this.id = 0;
        this.name = "Unknown";
        this.presentation = "No presentation";
    }

    public HealthProfessional(int id, String name, String presentation)
    {
        this.id = id;
        this.name = name;
        this.presentation = presentation;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return presentation;
    }

    public void printDetails()
    {
        System.out.printf("ID: %d, Name: %s, Description: %s%n", id, name, presentation);
    }
}

// Part 2
class GeneralPractitioner extends HealthProfessional
{
    private String specialty;

    public GeneralPractitioner()
    {
        super();
        this.specialty = "General Practice";
    }

    public GeneralPractitioner(int id, String name, String description, String specialty)
    {
        super(id, name, description);
        this.specialty = specialty;
    }

    @Override
    public void printDetails()
    {
        System.out.printf("Type: General Practitioner, ID: %d, Name: %s, Description: %s, Specialty: %s%n", getId(), getName(), getDescription(), specialty);
    }
}

class OtherHealthProfessional extends HealthProfessional
{
    private String professionType;

    public OtherHealthProfessional()
    {
        super();
        this.professionType = "Unknown";
    }

    public OtherHealthProfessional(int id, String name, String description, String professionType)
    {
        super(id, name, description);
        this.professionType = professionType;
    }

    @Override
    public void printDetails()
    {
        System.out.printf("Type: Other Health Professional, ID: %d, Name: %s, Description: %s, Profession Type: %s%n", getId(), getName(), getDescription(), professionType);
    }
}

// Part 4
class Appointment
{
    private String reservationName;
    private String reservationNumber;
    private String reservationTime;
    private HealthProfessional appointmentDoctor;

    public Appointment()
    {
        this.reservationName = "Unknown";
        this.reservationNumber = "1234567890";
        this.reservationTime = "09:00";
        this.appointmentDoctor = null;
    }

    public Appointment(String reservationName, String reservationNumber, String reservationTime, HealthProfessional appointmentDoctor)
    {
        this.reservationName = reservationName;
        this.reservationNumber = reservationNumber;
        this.reservationTime = reservationTime;
        this.appointmentDoctor = appointmentDoctor;
    }

    public String getReservationNumber()
    {
        return reservationNumber;
    }

    public void printAppointmentDetails()
    {
        System.out.printf("Reservation Name: %s, Phone: %s, Preferred Time: %s%n", reservationName, reservationNumber, reservationTime);
        if (appointmentDoctor != null)
        {
            System.out.print("Appointment Information for Doctor: ");
            appointmentDoctor.printDetails();
        }
        else
        {
            System.out.println("Appointment doctor not selected.");
        }
    }

    public void printDetails()
    {
        printAppointmentDetails();
    }
}


