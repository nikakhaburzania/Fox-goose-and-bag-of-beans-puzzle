/** 
* Author: Nika Khaburzania (github.com/nikakhaburzania)
*/

package model;

import javax.swing.SwingConstants;
import java.util.ArrayList;
import java.util.Observable;

public class GameModel extends Observable{
	
	//declaring variables
	private int boatLocation = SwingConstants.RIGHT;
	private int farmerOldLocation;
	private int farmerNewLocation;
	private int foxOldLocation;
	private int foxNewLocation;
	private int gooseOldLocation;
	private int gooseNewLocation;
	private int beansOldLocation;
	private int beansNewLocation;
	
	private int reason;
	
	private ArrayList<String> leftSide;
	private ArrayList<String> centerSide;
	private ArrayList<String> rightSide;
	
	/** 
	 * constructor making 3 ArrayLists for left, middle and right for tracking positions and adding items
	 */
	public GameModel(){
		leftSide = new ArrayList<String>();
		centerSide = new ArrayList<String>();
		rightSide = new ArrayList<String>();
		
		rightSide.add("farmer");
		rightSide.add("goose");
		rightSide.add("beans");
		rightSide.add("fox");
	}
	
	/**
	 * updating farmer's location in ArrayLists & notifying observers
	 */
	public void updateFarmerPosition(){
		if(farmerOldLocation == 2 && farmerNewLocation == 3){
			rightSide.add("farmer"); //adding to array list
			centerSide.remove("farmer"); //removing from array list
		} else if (farmerOldLocation == 3 && farmerNewLocation == 2){
			centerSide.add("farmer"); //adding to array list
			rightSide.remove("farmer"); //removing from array list
		} else if (farmerOldLocation == 2 && farmerNewLocation == 1){
			leftSide.add("farmer"); //adding to array list
			centerSide.remove("farmer"); //removing from array list
		} else if (farmerOldLocation == 1 && farmerNewLocation == 2){
			leftSide.remove("farmer"); //removing from array list
			centerSide.add("farmer"); //adding to array list
			
		}
		updateDisplay();
	}
	
	/**
	 * updating fox's location in ArrayList & notifying observers
	 */
	public void updateFoxPosition(){
		if(foxOldLocation == 2 && foxNewLocation == 3){
			rightSide.add("fox"); //adding to array list
			centerSide.remove("fox"); //removing from array list
			System.out.println("moving from 2 to 3");
		} else if (foxOldLocation == 3 && foxNewLocation == 2){
			centerSide.add("fox"); //adding to array list
			rightSide.remove("fox"); //removing from array list
			
		} else if (foxOldLocation == 2 && foxNewLocation == 1){
			leftSide.add("fox"); //adding to array list
			centerSide.remove("fox"); //removing from array list

			System.out.println("removing from center");
		} else if (foxOldLocation == 1 && foxNewLocation == 2){
			leftSide.remove("fox"); //removing from array list
			centerSide.add("fox"); //adding to array list=
			
		}
		updateDisplay();
	}
	
	/**
	 * updating goose's location in ArrayLists & notifying observers
	 */
	public void updateGoosePosition(){
		if(gooseOldLocation == 2 && gooseNewLocation == 3){
			rightSide.add("goose"); //adding to array list
			centerSide.remove("goose"); //removing from array list
			System.out.println("moving from 2 to 3");
		} else if (gooseOldLocation == 3 && gooseNewLocation == 2){
			centerSide.add("goose"); //adding to array list
			rightSide.remove("goose"); //removing from array list
			
		} else if (gooseOldLocation == 2 && gooseNewLocation == 1){
			leftSide.add("goose"); //adding to array list
			centerSide.remove("goose"); //removing from array list

			System.out.println("removing from center");
		} else if (gooseOldLocation == 1 && gooseNewLocation == 2){
			leftSide.remove("goose"); //removing from array list
			centerSide.add("goose"); //adding to array list
			
			System.out.println("moving from 1 to 2");
		}
		updateDisplay();
	}
	
	
	/**
	 * updating bean's location in ArrayLists & notifying observers
	 */
	public void updateBeansPosition(){
		if(beansOldLocation == 2 && beansNewLocation == 3){
			rightSide.add("beans"); //adding to array list
			centerSide.remove("beans"); //removing from array list
			System.out.println("moving from 2 to 3");
		} else if (beansOldLocation == 3 && beansNewLocation == 2){
			centerSide.add("beans"); //adding to array list
			rightSide.remove("beans"); //removing from array list
			
		} else if (beansOldLocation == 2 && beansNewLocation == 1){
			leftSide.add("beans"); //adding to array list
			centerSide.remove("beans"); //removing from array list

			System.out.println("removing from center");
		} else if (beansOldLocation == 1 && beansNewLocation == 2){
			leftSide.remove("beans"); //removing from array list
			centerSide.add("beans"); //adding to array list
			
			System.out.println("moving from 1 to 2");
		}
		updateDisplay();
	}
	
	/**
	 * getter which returns what is present on the left side of grass
	 */
	public ArrayList<String> getLeftSide(){
		return leftSide;
	}
	
	/**
	 * getter which returns what is present on the river
	 */
	public ArrayList<String> getCenterSide(){
		return centerSide;
	}

	/**
	 * getter which returns what is present on the right side of grass
	 */
	public ArrayList<String> getRightSide(){
		return rightSide;
	}
	
	/**
	 * setter for boat's new location, moving boat to left side and updating the display by notifying observer 
	 */
	public void setBoatLocationLeft(){
		boatLocation = SwingConstants.LEFT;
		updateDisplay();
	}
	
	/**
	 * setter for boat's new location, moving boat to right side and updating the display by notifying observer 
	 */
	public void setBoatLocationRight(){
		boatLocation = SwingConstants.RIGHT;
		updateDisplay();
	}
	

	/**
	 * setter for farmer's new location and updating the position
	 */
	public void setFarmerNewLocation(int currentLocation, int newLocation){ 
		farmerOldLocation = currentLocation;
		farmerNewLocation = newLocation;
		updateFarmerPosition();
	}
	
	/**
	 * getter method which returns the farmer's old location 
	 */
	public int getFarmerOldLocation(){
		return farmerOldLocation;
	}
	
	/**
	 * getter which returns the farmer's new location 
	 */
	public int getFarmerNewLocation(){
		return farmerNewLocation;
	}
	
	/**
	 * setter for fox's new location and updating the position
	 */
	public void setFoxNewLocation(int currentLocation, int newLocation){ 
		foxOldLocation = currentLocation;
		foxNewLocation = newLocation;
		updateFoxPosition();
	}
	
	/**
	 * getter method which returns the fox's old location 
	 */
	public int getFoxOldLocation(){
		return foxOldLocation;
	}
	
	/**
	 * getter which returns the fox's new location 
	 */
	public int getFoxNewLocation(){
		return foxNewLocation;
	}
	
	/**
	 * setter for goose's new location and updating the position
	 */
	public void setGooseNewLocation(int currentLocation, int newLocation){ 
		gooseOldLocation = currentLocation;
		gooseNewLocation = newLocation;
		updateGoosePosition();
	}
	
	/**
	 * getter which returns the goose's old location 
	 */
	public int getGooseOldLocation(){
		return gooseOldLocation;
	}
	
	/**
	 * getter which returns the goose's new location 
	 */
	public int getGooseNewLocation(){
		return gooseNewLocation;
	}
	
	/**
	 * setter for bean's new location and updating the position
	 */
	public void setBeansNewLocation(int currentLocation, int newLocation){ 
		beansOldLocation = currentLocation;
		beansNewLocation = newLocation;
		updateBeansPosition();
	}
	
	/**
	 * getter which returns the bean's old location 
	 */
	public int getBeansOldLocation(){
		return beansOldLocation;
	}
	
	/**
	 * getter which returns the bean's new location 
	 */
	public int getBeansNewLocation(){
		return beansNewLocation;
	}
	
	/**
	 * getter which returns the boat's location 
	 */
	public int getBoatLocation(){
		return boatLocation;
	}
	
	
	/**
	 * determine if a player has won or lost
	 */
	public String winOrLose(){
		if(leftSide.size() == 4){
			return "win";
		} else if((rightSide.contains("fox") && rightSide.contains("goose") && !(rightSide.contains("farmer"))) &&  boatLocation == SwingConstants.LEFT ||
				(leftSide.contains("fox") && leftSide.contains("goose") && !(leftSide.contains("farmer")))  && boatLocation == SwingConstants.RIGHT){
			reason = 1;
			return "lost";
		}else if(rightSide.contains("goose") && rightSide.contains("beans") && !(rightSide.contains("farmer")) &&  boatLocation == SwingConstants.LEFT ||
				leftSide.contains("goose") && leftSide.contains("beans")  && !(leftSide.contains("farmer")) &&  boatLocation == SwingConstants.RIGHT){
			reason = 2;
			return "lost";
		}
		
		
		return null;
	}
	
	public int getReason(){
		return reason;
	}
	
	/**
	 * notifying observers; reduce code length by using this method when needed
	 */
	public void updateDisplay(){
		setChanged();
		notifyObservers();
	}
	
	
}
