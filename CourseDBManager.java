/*
 * Name: Esther Soon
 * Class: CMSC 204-38176
 * Instructor: Farnaz Eivazi
 * Date: 3/29/2022
 * Description: Write a program that creates a database of courses
*/
 /**@author Esther Soon*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBManager implements CourseDBManagerInterface{
	
	public CourseDBStructure cds = new CourseDBStructure(20);

	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement cde=new CourseDBElement(id,crn,credits,roomNum,instructor);
		cds.add(cde);
	}
	
	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * @throws IOException 
	 * 
	 */
	@Override
	public CourseDBElement get(int crn){
		try {
            return cds.get(crn);
	    } catch(Exception e) {
	    	System.out.println(e);
	    	return null;
	    }	
	}
	
	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(input));
			String line;
			while((line=br.readLine())!=null) {
				String[] broke = line.split(" ");
				cds.add(new CourseDBElement(broke[0], Integer.parseInt(broke[1]), Integer.parseInt(broke[2]), broke[3], broke[4]));
			}
			br.close();
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}catch(IOException ex) {
			System.out.println(ex);
		}
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
		return cds.showAll();
	}
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     

}
