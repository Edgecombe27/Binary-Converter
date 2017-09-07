package main;

import javax.swing.JButton;

/*
 * Controller
 * 
 * Created October 10 2015
 * 
 * by Spencer Edgecombe
 */

public class Controller implements View.Controls{

	private Model model;//manipulates inputs
	
	private View view;//what the user sees
	
	public Controller() {
		// TODO Auto-generated constructor stub
		
		model = new Model();
		
		view = new View(this);
		
		
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see main.View.Controls#numberPressed(javax.swing.JButton)
	 */

	@Override
	public void numberPressed(JButton b) {
		// TODO Auto-generated method stub
		if(view.textFocused()){
			view.setText(view.getText()+b.getText());
		}else{
			view.setBase(view.getBase()+b.getText());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see main.View.Controls#equalsPressed()
	 */

	@Override
	public void equalsPressed() {
		// TODO Auto-generated method stub
		view.setText(model.calculate(Integer.parseInt(view.getText()), Integer.parseInt(view.getBase())));
	}

	/*
	 * (non-Javadoc)
	 * @see main.View.Controls#clearPressed()
	 */
	
	@Override
	public void clearPressed() {
		// TODO Auto-generated method stub
		if(view.textFocused()){
			view.setText("");
		}else{
			view.setBase("");
		}
	}

	/*
	 * (non-Javadoc)
	 * @see main.View.Controls#deletePressed()
	 */
	
	@Override
	public void deletePressed() {
		// TODO Auto-generated method stub
		if(view.textFocused()){
			view.setText(view.getText().substring(0, view.getText().length()-1));
		}else{
			view.setBase(view.getBase().substring(0, view.getBase().length()-1));
		}
	}

}
