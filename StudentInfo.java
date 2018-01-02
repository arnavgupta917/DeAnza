/*
 * Arnav Gupta
 * Class and Section : Su17 CIS D035A 61Z Java Programming
 * Assignment Number : 2
 * Due date : 07/14/17
 * Date Submitted : 07/12/17
 */
public class StudentInfo {
	private String name;
	private String address;
	private int age;
	private String phoneNumber;

	/**
	 * Default Constructor to set default values for the StudentInfo
	 *
	 */
	public StudentInfo() {
		this.name = "";
		this.address = "";
		this.age = 0;
		this.phoneNumber = "";
	}
	
	/**
	 * Constructor to set values for the StudentInfo
	 *
	 * @param name as name of the StudentInfo
	 * @param address address as address of the StudentInfo
	 * @param age as an age of the student
	 * @param phoneNumber as an phone number of the student
	 * @return void
	 */
	public StudentInfo(String name, String address, int age, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
		
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}
	
	/**
	 * Default Constructor to set default values for the StudentInfo
	 *
	 * @param age as an age to be set for the StudentInfo. The value should be set between 0 and 150 
	 * @return void
	 */
	public void setAge(int age) {
		if (age <= 0 || age > 150) {
			System.out.printf("Not updated the age due to invalid age = " + age );
			return; 
		}
		this.age = age;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void printStudentInfo() {
		System.out.printf("Name = " + name);
		System.out.printf(", Address = " + address);
		System.out.printf(", Age = " + age);
		System.out.println(", Phone Number = " + phoneNumber);
		
	}


}
