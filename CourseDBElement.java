/*
 * Name: Esther Soon
 * Class: CMSC 204-38176
 * Instructor: Farnaz Eivazi
 * Date: 3/29/2022
 * Description: Write a program that creates a database of courses
*/
 /**@author Esther Soon*/

public class CourseDBElement implements Comparable{
	
	public String courseID;
	public int crn;
	public int credits;
	public String roomNumber;
	public String instructor;
	
	/**
	 * Constructor 
	 * @param courseID
	 * @param crn
	 * @param credits
	 * @param roomNumber
	 * @param instructor
	 */
	public CourseDBElement(String courseID, int crn, int credits, String roomNumber, String instructor) {
		this.courseID = courseID;
		this.crn = crn;
		this.credits = credits;
		this.roomNumber = roomNumber;
		this.instructor = instructor;
	}
	
	/**
	 * Returns the elements credits
	 * @return credits
	 */
	public int getCredits() {
		return credits;
	}
	
	/**
	 * Sets the elements credits
	 * @param credits
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	/**
	 * Return instructor
	 * @return instructor 
	 */
	public String getInstructor() {
		return instructor;
	}
	
	/**
	 * Set the instuctor
	 * @param instructor
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	/**
	 * Constructor
	 */
	public CourseDBElement() {
	}
	
	/**
	 * Return CRN
	 * @return CRN
	 */
	public int getCRN() {
		return crn;
	}
	
	/**
	 * Return Course ID
	 * @return Course ID
	 */
	public String getID() {
		return courseID;
	}
	
	/**
	 * Return roomNumber
	 * @return roomNumber
	 */
	public String getRoomNum() {
		return roomNumber;
	}
	
	/**
	 * Set roomNumber
	 * @param roomNumber
	 */
	public void setRoomNum(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * Set courseID
	 * @param courseID
	 */
	public void setID(String courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * Set CRN
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}
	
	/**
	 * Compares element's crn
	 * @param boolean true/false if crn match
	 */
	@Override
	public boolean compareTo(CourseDBElement element) {
		if (element.crn == crn) {
			return true;
		} else 
			return false;
	}

}
