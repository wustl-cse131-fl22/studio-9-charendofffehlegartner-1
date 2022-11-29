package assignment7;

public class Student {
	// define instance variables for student - all must be private 
	private String firstName;
	private String lastName;
	private int studID;
	private int credattempts;
	private int credpass;
	private double gradequality;
	private double BearBucksBalance;

	public Student(String firstName, String lastName, int studID)
	{
		// define the variables and set them 
		this.firstName = firstName;
		this.lastName = lastName;
		this.studID = studID;

	}

	// create the getters and return proper data types for each 
	public String getFullName()
	{
		String FullName = firstName + " "+ lastName;
		return FullName;

	}
	public int getId()
	{
		return studID;	
	}

	//method with no return but calculates the course grade and updates GPA 
	public void submitGrade(double grade, int credits) // go over this method 
	{
		this.gradequality = gradequality + (grade *credits);
		// if grade is over 1.7 it is a passing grade 
		if (grade >= 1.7) 
		{
			this.credpass = credits + credpass;	
		}
		this.credattempts = credits + credattempts;


	}
	// method that returns number of attempted credits
	public int getTotalAttemptedCredits()
	{
		return credattempts;
	}

	// method to return number of passing credits
	public int getTotalPassingCredits()
	{
		return credpass;	
	}

	// method to calculate the GPA using guality points and credits 
	public double calculateGradePointAverage()
	{
		double gpa = gradequality/credattempts;
		return gpa;
	}
	// method that returns a students class standing based on passing credits 
	public String getClassStanding()
	{	if (credpass<30)
	{
		return "First Year";
	}
	else if (30<=credpass && credpass<60)
	{
		return "Sophomore";
	}
	else if (60<= credpass && credpass<90)
	{
		return "Junior";
	}
	else if(90<=credpass)
	{
		return "Senior";
	}
	return "";
	}

	// method determines eligibility based on credits attempted and GPA 
	public boolean isEligibleForPhiBetaKappa()
	{
		if (credattempts>= 98 && gradequality/credattempts >= 3.60) // should this be creattempt or credpass?
		{
			return true;
		}
		else if (credattempts>= 75 && gradequality/credattempts >= 3.80)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	// increase bear bucks amount
	public void depositBearBucks(double amount)
	{
		this.BearBucksBalance = BearBucksBalance + amount;
	}

	// decrease bear bucks amount
	public void deductBearBucks(double amount)
	{
		this.BearBucksBalance = BearBucksBalance - amount;
	}

	public double getBearBucksBalance()
	{
		return this.BearBucksBalance;
	}

	// cash out policy for bear bucks depending on balance
	public double cashOutBearBucks()
	{
		if (BearBucksBalance > 10)
		{

			double cashout = BearBucksBalance -10.0;
			this.BearBucksBalance = 0; //why wont it let this line run?
			return cashout;


		}
		else 
		{
			this.BearBucksBalance = 0; //same as above but why not work - shoudl i just leave it and not set to zero bc return is right ?
			return BearBucksBalance;
		}

	}
	// method for legacy kids : this = parent 1 and other = parent 2. deals with the child / student that is legacy 
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id)
	{
		// creates the child of two alum parents 
		// determine the last name of the child depending on hyphenated or not
		String lastName = "";

		if (isHyphenated == true)
		{
			lastName = this.lastName + "-" + other.lastName;	
		}
		else
		{
			lastName = this.lastName;
		}

		double BearBucksBalancenew=  this.cashOutBearBucks() + other.cashOutBearBucks();

		Student legacy = new Student(firstName, lastName, id);
		legacy.depositBearBucks(BearBucksBalancenew);

		return legacy;

	}
	public String toString()
	{
		return this.firstName + " "+this.lastName + " "+ this.studID;
	}

}
