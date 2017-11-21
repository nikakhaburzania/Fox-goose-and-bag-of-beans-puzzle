/** 
* Author: Nika Khaburzania (github.com/nikakhaburzania)
*/

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import model.*;
import view.*;

public class GameController {
	private GameView view;
	private GameModel model;
	
	public GameController(GameView view, GameModel model){ //constructor
		this.view = view;
		this.model = model;
		
		//adding listener to boat/farmer/fox/goose/beans buttons
		
		this.view.addBoatLeftButtonListener(new BoatLeftButtonListener());
		this.view.addBoatRightButtonListener(new BoatRightButtonListener());
		
		this.view.addFarmerLeftButtonListener(new FarmerLeftButtonListener());
		this.view.addFarmerRightButtonListener(new FarmerRightButtonListener());

		this.view.addFoxLeftButtonListener(new FoxLeftButtonListener());
		this.view.addFoxRightButtonListener(new FoxRightButtonListener());
		
		this.view.addGooseLeftButtonListener(new GooseLeftButtonListener());
		this.view.addGooseRightButtonListener(new GooseRightButtonListener());
		
		this.view.addBeansLeftButtonListener(new BeansLeftButtonListener());
		this.view.addBeansRightButtonListener(new BeansRightButtonListener());
	}
	
	/**
	 * listener for left button of boat
	 */
	class BoatLeftButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getCenterSide().contains("farmer")){
				model.setBoatLocationLeft();
				model.winOrLose();
			} 
			
		}
		
	}
	
	/**
	 * listener for right button of boat 
	 */
	class BoatRightButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getCenterSide().contains("farmer")){
				model.setBoatLocationRight();
				model.winOrLose();
			}
			
		}
		
	}
	
	/**
	 * listener for left button of farmer
	 */
	class FarmerLeftButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getRightSide().contains("farmer") && model.getBoatLocation() == SwingConstants.RIGHT && model.getCenterSide().size()<2){
				System.out.println("farmer is in right side & can move to boat which is also on right");
				model.setFarmerNewLocation(3,2);
				model.winOrLose();
			} else if(model.getCenterSide().contains("farmer") && model.getBoatLocation() == SwingConstants.LEFT){
				model.setFarmerNewLocation(2,1);
				model.winOrLose();
			} else {
				System.out.println("We run into a problem, please follow rules.");
			}
			
		}
		
	}
	
	/**
	 * listener for right button of farmer
	 */
	class FarmerRightButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getLeftSide().contains("farmer") && model.getBoatLocation() == SwingConstants.LEFT && model.getCenterSide().size()<2){
				System.out.println("farmer is in right side & can move to boat which is also on right");
				model.setFarmerNewLocation(1,2);
				model.winOrLose();
			} else if(model.getCenterSide().contains("farmer") && model.getBoatLocation() == SwingConstants.RIGHT){
				model.setFarmerNewLocation(2,3);
				model.winOrLose();
			} else {
				System.out.println("We run into a problem, please follow rules.");
			}
			
		}
		
	}
	
	/**
	 * listener for left button of fox
	 */
	class FoxLeftButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getRightSide().contains("fox") && model.getBoatLocation() == SwingConstants.RIGHT  && model.getCenterSide().size()<2){
				System.out.println("fox is in right side & can move to boat which is also on right");
				model.setFoxNewLocation(3,2);
				model.winOrLose();
			} else if(model.getCenterSide().contains("fox") && model.getBoatLocation() == SwingConstants.LEFT){
				model.setFoxNewLocation(2,1);
				if(model.getCenterSide().contains("farmer")){
					model.setFarmerNewLocation(2,1);
				}
				model.winOrLose();
			} else {
				System.out.println("We run into a problem, please follow rules.");
			}
			
		}
		
	}
	
	/**
	 * listener for right button of fox
	 */
	class FoxRightButtonListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getLeftSide().contains("fox") && model.getBoatLocation() == SwingConstants.LEFT && model.getCenterSide().size()<2){
				System.out.println("fox is in right side & can move to boat which is also on right");
				model.setFoxNewLocation(1,2);				
				model.winOrLose();
			} else if(model.getCenterSide().contains("fox") && model.getBoatLocation() == SwingConstants.RIGHT){
				model.setFoxNewLocation(2,3);
				if(model.getCenterSide().contains("farmer")){
					model.setFarmerNewLocation(2,3);
				}
				model.winOrLose();
			} else {
				System.out.println("We run into a problem, please follow rules.");
			}
			
		}
		
	}
	
	/**
	 * listener for left button of goose
	 */
	class GooseLeftButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getRightSide().contains("goose") && model.getBoatLocation() == SwingConstants.RIGHT  && model.getCenterSide().size()<2){
				System.out.println("goose is in right side & can move to boat which is also on right");
				model.setGooseNewLocation(3,2);
				model.winOrLose();
			} else if(model.getCenterSide().contains("goose") && model.getBoatLocation() == SwingConstants.LEFT){
				model.setGooseNewLocation(2,1);
				if(model.getCenterSide().contains("farmer")){
					model.setFarmerNewLocation(2,1);
				}
				model.winOrLose();
			} else {
				System.out.println("We run into a problem, please follow rules.");
			}
			
		}
		
	}
	
	/**
	 * listener for right button of goose
	 */
	class GooseRightButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getLeftSide().contains("goose") && model.getBoatLocation() == SwingConstants.LEFT && model.getCenterSide().size()<2){
				System.out.println("goose is in right side & can move to boat which is also on right");
				model.setGooseNewLocation(1,2);
				model.winOrLose();
			} else if(model.getCenterSide().contains("goose") && model.getBoatLocation() == SwingConstants.RIGHT){
				model.setGooseNewLocation(2,3);	
				if(model.getCenterSide().contains("farmer")){
					model.setFarmerNewLocation(2,3);
				}
				model.winOrLose();
			} else {
				System.out.println("We run into a problem, please follow rules.");
			}
			
		}
		
	}
	
	/**
	 * listener for left button of beans
	 */
	class BeansLeftButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getRightSide().contains("beans") && model.getBoatLocation() == SwingConstants.RIGHT && model.getCenterSide().size()<2){
				System.out.println("beans is in right side & can move to boat which is also on right");
				model.setBeansNewLocation(3,2);
				model.winOrLose();
			} else if(model.getCenterSide().contains("beans") && model.getBoatLocation() == SwingConstants.LEFT){
				model.setBeansNewLocation(2,1);
				if(model.getCenterSide().contains("farmer")){
				model.setFarmerNewLocation(2,1);
				}
				model.winOrLose();
			} else {
				System.out.println("We run into a problem, please follow rules.");
			}
			
		}
		
	}
	
	/**
	 * listener for right button of beans
	 */
	class BeansRightButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(model.getLeftSide().contains("beans") && model.getBoatLocation() == SwingConstants.LEFT && model.getCenterSide().size()<2){
				System.out.println("beans is in right side & can move to boat which is also on right");
				if(model.getCenterSide().contains("farmer")){
					model.setBeansNewLocation(1,2);
				}
				model.winOrLose();
			} else if(model.getCenterSide().contains("beans") && model.getBoatLocation() == SwingConstants.RIGHT){
				model.setBeansNewLocation(2,3);
				if(model.getCenterSide().contains("farmer")){
					model.setFarmerNewLocation(2,3);
				}
				model.winOrLose();
			} else {
				System.out.println("We run into a problem, please follow rules.");
			}
			
		}
		
	}
	
}
