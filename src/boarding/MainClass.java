package boarding;

import java.io.File;

import java.io.PrintStream;
import java.util.Scanner;

import entities.Entity;
import entities.Single;
import heapclasses.BinaryHeap;
import persondata.Person;

public class MainClass {
	public static Scanner inputStream;
	public static Scanner inputLine;
	public static PrintStream outputStream;
	public static PrintStream console;
	
	public static Database myData;
	public static BinaryHeap PriorityQueue;
	
	/** 
	 * Initializes input and output streams
	 */
	public static void setupIO() {
		try {
			inputStream = new Scanner(new File("queue.in"));
			outputStream = new PrintStream(new File("queue.out"));
			
			// backup the console and set the new output stream
			console = System.out;
			System.setOut(outputStream);
		}
		catch (Exception exc) {
			System.out.println(exc + "Exception in setupIO");
		}
	}
	
	/**
	 * Initializes the database and registers every
	 * person from the input stream
	 */
	public static void registerDatabase() {
		// start reading
		int passengerNumber = inputStream.nextInt();
		inputStream.nextLine();
		
		myData = new Database();
		
		for (int i = 0; i < passengerNumber; i++) {
			// read info
			String entityID = inputStream.next();
			String name = inputStream.next();
			int age = inputStream.nextInt();
			String ticketType = inputStream.next();
			boolean hasPriorityBoarding = inputStream.nextBoolean();
			boolean hasSpecialNeeds = inputStream.nextBoolean();
			
			inputStream.nextLine();
			
			// register the person in the system
			Person newPerson = new Person(name, age, ticketType,
						hasPriorityBoarding, hasSpecialNeeds);
			
			myData.registerPerson(newPerson, entityID);
		}
	}

	/**
	 * Executes every command extracted from the input stream
	 */
	public static void executeCommands() {
		// start executing commands
		
		PriorityQueue = new BinaryHeap();
		
		boolean firstListCall = true; // handling newline printing
		
		while (inputStream.hasNextLine()) {
			// get line
			String currentLine = inputStream.nextLine();
			inputLine = new Scanner(currentLine);
			
			// find command
			String command;
			if (inputLine.hasNext()) {
				command = inputLine.next();
			} else {
				// entered the last empty line, skip this
				continue;
			}
			
			if (command.equals("insert")) {
				String entityID = inputLine.next();
				
				Entity entity = myData.extractEntity(entityID);
				
				PriorityQueue.insert(entity, entity.getPriority());
			}
			
			if (command.equals("embark")) {
				PriorityQueue.embark();
			}
			
			if (command.equals("list")) {
				if (firstListCall == false) {
					/* only the following 'list' calls
					 * shall print a newline
					 */
					
					// dependent on OS
					System.out.print(System.lineSeparator());
				}
				
				PriorityQueue.list();
				
				firstListCall = false; // at least one call
			}
			
			if (command.equals("delete")) {
				String entityID = inputLine.next();
				String personName = null;
				
				if (inputLine.hasNext()) {
					personName = inputLine.next();
				}
				
				Person newPerson = new Person(personName);
				Entity newEntity = new Single(entityID);
				
				newEntity.addPerson(newPerson);
				PriorityQueue.delete(newEntity);
			}
		}
	}
	
	/**
	 * Closes input and output streams
	 */
	public static void restoreIO() {
		inputStream.close();
		inputLine.close();
		outputStream.close();
		
		// restore console
		System.setOut(console);
	}
	
	public static void main(String[] args) {
		setupIO();
		registerDatabase();
		executeCommands();
		restoreIO();
	}
}
