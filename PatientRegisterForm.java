import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient
{
	static int id;
	String uniId;
	String firstName;
	String lastName;
	int age;
	String gender;
	List<Appointment> ap = new ArrayList<>();

	Patient()
	{
		uniId = "APOLLO" + id;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first name");
		firstName = sc.nextLine();
		System.out.println("Enter the last name");
		lastName = sc.nextLine();
		System.out.println("Enter the age");
		age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the gender");
		gender = sc.nextLine();
	}

	{
		id++;
	}

	@Override
	public String toString() {
		return uniId + " " + firstName + " " + lastName + " " + age + " " + gender;
	}
}

class Appointment 
{
	String date;
	String time;
	String docName;

	public Appointment() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the date");
		date = sc.nextLine();
		System.out.println("enter the time");
		time = sc.nextLine();
		System.out.println("enter the Dr.name");
		docName = sc.nextLine();
	}

	@Override
	public String toString() 
	{
		return date + " " + time + " " + docName;
	}
}


public class PatientRegisterForm 
{
	static List<Patient> p = new ArrayList<>();

	public static void addPatient() 
	{
		p.add(new Patient());
	}

	public static void bookAppointment()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id to book appointment");
		String id = sc.nextLine();
		int index = search(id);
		
		if (index != -1)
		{
			p.get(index).ap.add(new Appointment());
		} 
		
		else
		{
			System.out.println("cannot book patient not exist");
		}
	}

	public static int search(String id)
	{

		boolean b = false; // specify whether the id exist or not
		int i = 0;
		
		for (; i < p.size(); i++) 
		{
			if (p.get(i).uniId.equalsIgnoreCase(id)) 
			{
				b = true;// id exist in the list
				break;
			}
		}
		
		if (b) 
		{
			System.out.println(p.get(i));
			return i;
		} 
		
		else 
		{
			System.out.println("Not exist please try again with new id");
			return -1;
		}
	}

	public static void displayLog() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id to check appointment log");
		String id = sc.nextLine();
		int index = search(id);
		
		if (index != -1)
		{
			System.out.println(p.get(index).ap);
		}
		
		else
		{
			System.out.println("patient not exist");
		}
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		while (true) 
		{
			System.out.println("__________________________________________________________");
			System.out.println();
			System.out.println("Press 1 : For Register Patient Name ");
			System.out.println();
			System.out.println("Press 2 : For Book Appoinment ");
			System.out.println();
			System.out.println("Press 3 : For View All The Patient Details ");
			System.out.println();
			System.out.println("Press 4 : For Display Appoinment Log ");
			System.out.println();
			System.out.println("Press 5 : For Exit ");
			System.out.println();
			System.out.println("__________________________________________________________");
			
			int x = sc.nextInt();
			
			switch (x)
			{
			case 1:
				addPatient();
				System.out.println(p);
				break;
				
			case 2:
				bookAppointment();
				break;
				
			case 3:
				System.out.println("enter id to search");
				sc.nextLine();
				String id = sc.nextLine();
				search(id);
				break;
				
			case 4:
				displayLog();
				break;
				
			case 5:
				System.exit(0);
			}
		}

	}
}
