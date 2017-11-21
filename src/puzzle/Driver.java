/** 
* Author: Nika Khaburzania (github.com/nikakhaburzania)
*/

package puzzle;

import controller.*;
import model.*;
import view.*;

public class Driver {

	public static void main(String[] args) {
		
	//creating model, view and controller objects and passing model and view as arguments to controller 
	GameModel model = new GameModel();	
	GameView view = new GameView(model);
	GameController controller = new GameController(view, model);
	
	//stating that view is the observer of model 
	model.addObserver(view);

	view.setVisible(true);
	
	}
}
