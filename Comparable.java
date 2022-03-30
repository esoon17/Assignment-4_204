/*
 * Name: Esther Soon
 * Class: CMSC 204-38176
 * Instructor: Farnaz Eivazi
 * Date: 3/29/2022
 * Description: Write a program that creates a database of courses
*/
 /**@author Esther Soon*/

public interface Comparable {
	/**
	 * Compares element's crn
	 * @param boolean true/false if crn match
	 */
	public boolean compareTo(CourseDBElement element);
}
