/*
 * Name: Esther Soon
 * Class: CMSC 204-38176
 * Instructor: Farnaz Eivazi
 * Date: 3/29/2022
 * Description: Write a program that creates a database of courses
*/
 /**@author Esther Soon*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	static double LOAD_FACTOR = 1.5;
	public int sizeOfHash = 0;
	public LinkedList<CourseDBElement>[] hashTable;
	
	/**
     * Constructor
     * @param t - String t
     * @param size - size
     */
	public CourseDBStructure(String t, int size) {
		sizeOfHash = size;
		hashTable = new LinkedList[sizeOfHash];
	}
	
	/**
     * Checks if the number is a prime number
     * @param y number to check
     * @return boolean on if y is prime
     */
    public boolean isPrime(int y) {
        for (double x = 2; x < y; x++) {
            if (y / x % 1 == 0) {
                return false;
            }
        }
        return true;
    }
	
    /**
     * Constructor
     * @param size - size
     */
	public CourseDBStructure(int size) {
		size = (int)(size / LOAD_FACTOR);
        do {
            size++;
        } while (!((((size - 3) / 4.0) % 1 == 0) && isPrime(size)));
		sizeOfHash = size;
		hashTable = new LinkedList[sizeOfHash];
	}

	/** 
	* Adds a CourseDBElement object to the CourseDBStructure using the hashcode
	* of the CourseDatabaseElemen object's crn value.
	* If the CourseDatabaseElement already exists, exit quietly
	*  
	* @param element the CourseDBElement to be added to CourseDBStructure
	*/
	@Override
	public void add(CourseDBElement element) {
		int crn = element.getCRN();
	    int code = crn % sizeOfHash;
		LinkedList<CourseDBElement> current = hashTable[code];
		if (current == null) {
			hashTable[code] = new LinkedList<CourseDBElement>();
		}
		for (CourseDBElement i : hashTable[code]) {
			 if (i.compareTo(element)) {
	                i.setID(element.getID());
	                i.setCRN(element.getCRN());
	                i.setCredits(element.getCredits());
	                i.setInstructor(element.getInstructor());
	                i.setRoomNum(element.getRoomNum());
	                return;
	            }
		}
		hashTable[code].add(element);
	}
	
	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		int code = crn % sizeOfHash;
		LinkedList<CourseDBElement> course = hashTable[code];
		if (course == null) {
			throw new IOException();
		} else {
			for (Object element: course.toArray()) {
	            CourseDBElement course1 = (CourseDBElement) element;
	            if (course1.getCRN() == crn) {
	                return course1;
	            }
	        }
		}
		return null;
	}

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> array = new ArrayList<>();
		for (int i = 0; i < sizeOfHash; i++) {
			while (hashTable[i] != null) {
				for (int j = 0; j < hashTable[i].size(); j++) {
					CourseDBElement element = (CourseDBElement) hashTable[i].get(j);
					array.add("\n" + "Course:" + element.getID()
					+ " CRN:" + element.getCRN()
					+ " Credits:" + element.getCredits()
					+ " Instructor:" + element.getInstructor()
					+ " Room:" + element.getRoomNum());
				}
				break;
			}
		}
	    return array;
	}
	
	/**
	* Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	*/
	@Override
	public int getTableSize() {
		return sizeOfHash;
	}

}
