/** 
* Author: Nika Khaburzania (github.com/nikakhaburzania)
*/

	package view;
	import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Graphics;
	import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
	import java.awt.image.BufferedImage;
	import java.io.File;
	import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
	import java.util.Observer;

	import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.*;

	public class GameView extends JFrame implements Observer{
		
		private GameModel model;
		private JLabel farmerImage;
		private JLabel gooseImage;
		private JLabel beansImage;
		private JLabel foxImage;
		
		ArrayList<JLabel> leftSide;
		ArrayList<JLabel> centerSide;
		ArrayList<JLabel> rightSide;
		
		private JLabel boatImage;
		JPanel boatItems;
		
		JPanel grassPanel;
		JPanel grassPanel2;
		JPanel waterPanel;
		
		private JButton boatLeft;
		private JButton boatRight;
		private JButton foxLeft;
		private JButton foxRight;
		private JButton gooseLeft;
		private JButton gooseRight;
		private JButton beansLeft;
		private JButton beansRight;
		private JButton farmerLeft;
		private JButton farmerRight;
		
		public GameView(GameModel model){
			
			//creating title, setting layout and exit button operation
			super("Game");
			this.model = model; 
			this.setLayout(new BorderLayout());
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setMinimumSize(new Dimension(1400, 750));
	        this.setMaximumSize(new Dimension(2260,860));
	        this.setResizable(false);
	        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			
			//creating new panels to set backgrounds
			grassPanel = new grassPanel();
			grassPanel.setPreferredSize(new Dimension(175,getHeight()));
			waterPanel = new waterPanel();
			waterPanel.setPreferredSize(new Dimension(1050,getHeight()));
			grassPanel2 = new grassPanel();
			grassPanel2.setPreferredSize(new Dimension(175,getHeight()));
			
			//setting background image for each panel
			this.add(grassPanel,BorderLayout.LINE_START);
			this.add(waterPanel,BorderLayout.CENTER);
			this.add(grassPanel2,BorderLayout.LINE_END);			
			
			//importing images and putting them in JLabels
			foxImage = new JLabel(new ImageIcon("src/resources/fox.png"));
			gooseImage = new JLabel(new ImageIcon("src/resources/goose.png"));
			beansImage = new JLabel(new ImageIcon("src/resources/beans.png"));
			farmerImage = new JLabel(new ImageIcon("src/resources/farmer.png"));
			boatImage = new JLabel(new ImageIcon("src/resources/boat.png"));
			
			waterPanel.setLayout(new GridLayout(2,1));
			boatItems = new JPanel();
			boatItems.setLayout((LayoutManager) new BoxLayout(boatItems, BoxLayout.Y_AXIS));
			
			waterPanel.add(boatImage);
			boatImage.setHorizontalAlignment(SwingConstants.RIGHT);
			waterPanel.add(boatItems);
			
			boatItems.setOpaque(false);
			
			//adding items to right side of ArrayList (starting position)
			grassPanel2.add(farmerImage);
			grassPanel2.add(gooseImage);
			grassPanel2.add(beansImage);
			grassPanel2.add(foxImage);
		
			//creating new JPanel for south part of program for controller buttons
			JPanel jSouth = new JPanel(new FlowLayout());
			this.add(jSouth, BorderLayout.SOUTH);
			
			//creating JLabels for buttons
			JLabel boatLabel = new JLabel("Boat: ");
			JLabel foxLabel = new JLabel("Fox: ");
			JLabel gooseLabel = new JLabel("Goose: ");
			JLabel beansLabel = new JLabel("Beans: ");
			JLabel farmerLabel = new JLabel("Farmer: ");
			
			//creating JButtons for buttons
			boatLeft = new JButton("<");
			boatRight = new JButton(">");
			foxLeft = new JButton("<");
			foxRight = new JButton(">");
			gooseLeft = new JButton("<");
			gooseRight = new JButton(">");
			beansLeft = new JButton("<");
			beansRight = new JButton(">");
			farmerLeft = new JButton("<");
			farmerRight = new JButton(">");
			
			//adding JLabels and JButtons to jSouth panel
			jSouth.add(boatLabel);
			jSouth.add(boatLeft); jSouth.add(boatRight);
			jSouth.add(farmerLabel);
			jSouth.add(farmerLeft); jSouth.add(farmerRight);
			jSouth.add(gooseLabel);
			jSouth.add(gooseLeft); jSouth.add(gooseRight);
			jSouth.add(foxLabel);
			jSouth.add(foxLeft); jSouth.add(foxRight);
			jSouth.add(beansLabel);
			jSouth.add(beansLeft); jSouth.add(beansRight);
			
			
			this.pack();
		
		}
		
		
		/**
		 * class for painting the background of grass panels
		 */
		class grassPanel extends JPanel {
		    private BufferedImage image,image2;

		    public grassPanel() {
		    	
		    	setLayout(new GridLayout(4,1));
		    	
		        try {
		        	image = ImageIO.read(new File("src/resources/grass.png"));

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		   
		    @Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, this);
		    }
		}
		
		/**
		 * class for painting the background of water panels
		 */
		class waterPanel extends JPanel {
		    private BufferedImage image,image2;
		    public waterPanel() {
		    	
		    	setLayout(new BorderLayout());
		        
		    	try {
		        	image = ImageIO.read(new File("src/resources/water.png"));

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		   
		    @Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.drawImage(image, 0, 0, this);
		    }
		}
	
		/**
		 * adding action listener to each button in frame
		 */
		public void addBoatLeftButtonListener(ActionListener listenForLeftButton){
			boatLeft.addActionListener(listenForLeftButton);
		}
		
		public void addBoatRightButtonListener(ActionListener listenForRightButton){
			boatRight.addActionListener(listenForRightButton);
		}
		
		public void addFarmerLeftButtonListener(ActionListener listenForLeftButton){
			farmerLeft.addActionListener(listenForLeftButton);
		}
		
		public void addFarmerRightButtonListener(ActionListener listenForRightButton){
			farmerRight.addActionListener(listenForRightButton);
		}
		
		public void addFoxLeftButtonListener(ActionListener listenForLeftButton){
			foxLeft.addActionListener(listenForLeftButton);
		}
		
		public void addFoxRightButtonListener(ActionListener listenForRightButton){
			foxRight.addActionListener(listenForRightButton);
		}
		
		public void addGooseLeftButtonListener(ActionListener listenForLeftButton){
			gooseLeft.addActionListener(listenForLeftButton);
		}
		
		public void addGooseRightButtonListener(ActionListener listenForRightButton){
			gooseRight.addActionListener(listenForRightButton);
		}
		
		public void addBeansLeftButtonListener(ActionListener listenForLeftButton){
			beansLeft.addActionListener(listenForLeftButton);
		}
		
		public void addBeansRightButtonListener(ActionListener listenForRightButton){
			beansRight.addActionListener(listenForRightButton);
		}
		
	
		/**
		 * method to update farmer's position when the button is clicked
		 */
		 public void updateFarmerPosition(int currentPosition, int newPosition){
				if(currentPosition == 2 && newPosition == 3){
					grassPanel2.add(farmerImage); //adding to panel
				} else if (currentPosition == 3 && newPosition == 2){
					boatItems.add(farmerImage); //adding to panel
					
					if(model.getBoatLocation() == SwingConstants.RIGHT) {
						farmerImage.setAlignmentX( Component.RIGHT_ALIGNMENT );
					} else {
						farmerImage.setAlignmentX( Component.LEFT_ALIGNMENT );
					}
					
				} else if (currentPosition == 2 && newPosition == 1){
					grassPanel.add(farmerImage); //adding to panel
				} else if (currentPosition == 1 && newPosition == 2){
					boatItems.add(farmerImage); //adding to panel
					
					if(model.getBoatLocation() == SwingConstants.RIGHT) {
						farmerImage.setAlignmentX( Component.RIGHT_ALIGNMENT );
					} else {
						farmerImage.setAlignmentX( Component.LEFT_ALIGNMENT );
					}
				}
		 }
		
		 /**
		  * method to update fox's position when the button is clicked
		  */
		public void updateFoxPosition(int currentPosition, int newPosition){
			if(currentPosition == 2 && newPosition == 3){
				grassPanel2.add(foxImage); //adding to panel
			} else if (currentPosition == 3 && newPosition == 2){
				
				boatItems.add(foxImage); //adding to panel
				if(model.getBoatLocation() == SwingConstants.RIGHT) {

					foxImage.setAlignmentX( Component.RIGHT_ALIGNMENT );
				} else {
					foxImage.setAlignmentX( Component.LEFT_ALIGNMENT );
				}
			} else if (currentPosition == 2 && newPosition == 1){
				
				grassPanel.add(foxImage); //adding to panel
			} else if (currentPosition == 1 && newPosition == 2){
				
				boatItems.add(foxImage); //adding to panel
				if(model.getBoatLocation() == SwingConstants.RIGHT) {

					foxImage.setAlignmentX( Component.RIGHT_ALIGNMENT );
				} else {
					foxImage.setAlignmentX( Component.LEFT_ALIGNMENT );
				}
			}
		}
		
		
		/**
		 * method to update goose's position when the button is clicked
		 */
		public void updateGoosePosition(int currentPosition, int newPosition){
			if(currentPosition == 2 && newPosition == 3){
				grassPanel2.add(gooseImage); //adding to panel
			} else if (currentPosition == 3 && newPosition == 2){
				boatItems.add(gooseImage); //adding to panel
			} else if (currentPosition == 2 && newPosition == 1){
				grassPanel.add(gooseImage); //adding to panel
			} else if (currentPosition == 1 && newPosition == 2){
				boatItems.add(gooseImage); //adding to panel
			}
		}
		
		/**
		 * method to update beans position when the button is clicked
		 */
		public void updateBeansPosition(int currentPosition, int newPosition){
			if(currentPosition == 2 && newPosition == 3){
				grassPanel2.add(beansImage); //adding to panel
			} else if (currentPosition == 3 && newPosition == 2){
				
				boatItems.add(beansImage); //adding to panel
				
				
			} else if (currentPosition == 2 && newPosition == 1){
				
				grassPanel.add(beansImage); //adding to panel
			} else if (currentPosition == 1 && newPosition == 2){
				
				boatItems.add(beansImage); //adding to panel
			}
		}
		
		/**
		 * update method for observer
		 */
		@Override
		public void update(Observable o, Object arg) {
			GameModel gameObs = (GameModel) o ;

				boatImage.setHorizontalAlignment(gameObs.getBoatLocation());
				updateFarmerPosition(gameObs.getFarmerOldLocation(), gameObs.getFarmerNewLocation());
				updateFoxPosition(gameObs.getFoxOldLocation(), gameObs.getFoxNewLocation());
				updateGoosePosition(gameObs.getGooseOldLocation(), gameObs.getGooseNewLocation());
				updateBeansPosition(gameObs.getBeansOldLocation(), gameObs.getBeansNewLocation());
				System.out.println("On left side we have" + model.getLeftSide());
				System.out.println("In water we have" + model.getCenterSide());
				System.out.println("On right side we have" + model.getRightSide());
				
				//print and set title as winner or loser
				if(model.winOrLose() == "win") {
					this.setTitle("CONGRATULATIONS!");
					 lastFrame gameWon = new lastFrame("<html><font color='green'>CONGRATULATIONS You Won!</font></html>");
					 gameWon.setTitle("CONGRATULATIONS You Won!");
					 gameWon.setVisible(true);
				} else if (model.winOrLose() == "lost") {
					if(model.getReason() == 1){
						this.setTitle("Game over! fox eat goose");
						 lastFrame gameOver = new lastFrame("<html><font color='red'>GAME OVER! Fox eat Goose..</font></html>");
						gameOver.setTitle("GAME OVER! Fox eat Goose.."); 
						gameOver.setVisible(true);
					} else if(model.getReason() == 2){
						this.setTitle("Game over! goose eat beans");
						lastFrame gameOver = new lastFrame("<html><font color='red'>GAME OVER! Goose eat Beans..</font></html>");
						gameOver.setTitle("GAME OVER! Goose eat Beans.."); 
						gameOver.setVisible(true);
					}
					//setting all buttons once the game is finished
					 boatLeft.setEnabled(false);
					 boatRight.setEnabled(false);
					 foxLeft.setEnabled(false);
					 foxRight.setEnabled(false);
					 gooseLeft.setEnabled(false);
					 gooseRight.setEnabled(false);
					 beansLeft.setEnabled(false);
					 beansRight.setEnabled(false);
					 farmerLeft.setEnabled(false);
					 farmerRight.setEnabled(false);
				}
				
				//different statements so the items on boat follow the boat from right to left or vice versa
				
				if(model.getBoatLocation() == SwingConstants.RIGHT && model.getCenterSide().contains("farmer")) {
					farmerImage.setAlignmentX( Component.RIGHT_ALIGNMENT );
				} else if (model.getCenterSide().contains("farmer")){
					farmerImage.setAlignmentX( Component.LEFT_ALIGNMENT );
				}
				
				if(model.getBoatLocation() == SwingConstants.RIGHT && model.getCenterSide().contains("fox")) {
					foxImage.setAlignmentX( Component.RIGHT_ALIGNMENT );
				} else if (model.getCenterSide().contains("fox")){
					foxImage.setAlignmentX( Component.LEFT_ALIGNMENT );
				}
				
				if(model.getBoatLocation() == SwingConstants.RIGHT && model.getCenterSide().contains("goose")) {
					gooseImage.setAlignmentX( Component.RIGHT_ALIGNMENT );
				} else if (model.getCenterSide().contains("goose")){
					gooseImage.setAlignmentX( Component.LEFT_ALIGNMENT );
				}
				
				if(model.getBoatLocation() == SwingConstants.RIGHT && model.getCenterSide().contains("beans")) {
					beansImage.setAlignmentX( Component.RIGHT_ALIGNMENT );
				} else if (model.getCenterSide().contains("beans")){
					beansImage.setAlignmentX( Component.LEFT_ALIGNMENT );
				}
				
				
			//repainting after update
				pack();
				repaint();
		
	}
		
		/**
		 * class for a new frame that pops up after match is finished and displays if a player has won or lost
		 */
		class lastFrame extends JFrame{
			lastFrame(String string){
				super(string);
				this.setLayout(new BorderLayout());
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        this.setMinimumSize(new Dimension(250, 250));
		        JLabel gameResult = new JLabel(string);
		        this.add(gameResult, BorderLayout.CENTER);
		        gameResult.setHorizontalAlignment(JLabel.CENTER);
		        gameResult.setVerticalAlignment(JLabel.CENTER);
		        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			}
	}
	
}
