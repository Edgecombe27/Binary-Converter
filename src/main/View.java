package main;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Calculator: View
 * 
 * Created October 10 2015
 * 
 * by Spencer Edgecombe
 * 
 */

public class View {

	private JFrame frame;//window
	
	private JPanel buttonPanel;//container for buttons
	
	private JPanel textPanel;//container for TextFields

	private GridLayout gl;//grid layout to organize buttons
	
	private JButton[] b = new JButton[12];//buttons
	
	private JTextField text;//number in base 10

	private JTextField base;//base to convert to
	
	private Controls controls;//interface for Controlling

	public View(Controls c) {
		// TODO Auto-generated constructor stub
		
		controls = c;
		
		//setting up Window
		
		frame = new JFrame("Base 10 Converter");
		
		frame.setSize(200,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.addComponentListener(new ComponentAdapter(){
			
			//resizing
			public void componentResized(ComponentEvent e){
				textPanel.setSize(frame.getWidth(), frame.getHeight()/5);
				text.setSize((int)(textPanel.getWidth()*0.8),textPanel.getHeight());
				base.setSize((int)(textPanel.getWidth()*0.2),textPanel.getHeight());
				base.setLocation(text.getWidth(), 0);
				buttonPanel.setSize(frame.getWidth(),(int) (frame.getHeight()*0.7));
				buttonPanel.setLocation(0, textPanel.getHeight());
			}
			
		});
		
		//setting up text container
		
		textPanel = new JPanel(null);
		
		textPanel.setSize(frame.getWidth(), frame.getHeight()/5);
		textPanel.setLocation(0, 0);
		
		frame.add(textPanel);
		
		
		//setting up textfield for base 10
		
		text = new JTextField();
		
		text.setSize((int)(textPanel.getWidth()*0.8),textPanel.getHeight());
		text.setLocation(0, 0);
		text.setFont(new Font("Courrier New", Font.PLAIN, 16));
		
		textPanel.add(text);
		
		//setting up textfield for base input
		
		base = new JTextField();
		
		base.setSize((int)(textPanel.getWidth()*0.2),textPanel.getHeight());
		base.setLocation(text.getWidth(), 0);
		base.setFont(new Font("Courrier New", Font.PLAIN, 16));
		base.setText("2");
		
		textPanel.add(base);
		
		//setting up grid layout
		
		gl = new GridLayout();
		
		gl.setColumns(3);
		gl.setRows(4);
		gl.setHgap(5);
		gl.setVgap(5);
		
		//setting up button container
		
		buttonPanel = new JPanel(gl);
		
		buttonPanel.setSize(frame.getWidth(),(int) (frame.getHeight()*0.7));
		buttonPanel.setLocation(0, textPanel.getHeight());
		
		frame.add(buttonPanel);
		
		//setting up buttons
		
		for(int i = 0; i < b.length; i++){
			b[i] = new JButton();
			
			if(i < 9){
				b[i].setText(i+1+"");
				b[i].setName(i+1+"");
			}else if(i == 9){
				b[i].setText("C");
				b[i].setName("clear");
				b[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						controls.clearPressed();
					}
				});
			}else if(i == 10){
				b[i].setText("X");
				b[i].setName("delete");
				b[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						controls.deletePressed();
					}
				});
			}else if(i == 11){
				b[i].setText("=");
				b[i].setName("equals");
				b[i].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						controls.equalsPressed();
					}
				});
			}
			
			b[i].setFocusable(false);
			b[i].setFocusPainted(false);
			
			buttonPanel.add(b[i]);
		}
		
		setActionListeners();
		
		frame.setVisible(true);
		
	}
	
	/*
	 * Accessor for the focus of text
	 * 
	 * @return the text's focus as a boolean
	 */
	
	public boolean textFocused(){
		return text.hasFocus();
	}
	
	/*
	 * Accessor for the focus of base
	 * 
	 * @return base's focus as a boolean
	 */
	
	public boolean baseFocused(){
		return base.hasFocus();
	}
	
	/*
	 * Accessor for text's text
	 * 
	 * @return the text of text
	 */
	
	public String getText(){
		return text.getText();
	}
	
	/*
	 * Mutator for text
	 * 
	 * @param the text to be put in text
	 */
	
	public void setText(String s){
		text.setText(s);
	}
	
	/*
	 * Accessor for base's text
	 * 
	 * @return s: the text of base
	 */
	
	public String getBase(){
		return base.getText();
	}
	
	/*
	 * Mutator for base
	 * 
	 * @param s: the text to be put in base
	 */
	
	public void setBase(String s){
		base.setText(s);
	}
	
	/*
	 * Gives each button from 0-8 an action listener to avoid a mess in the constructor.
	 * 
	 */
	
	private void setActionListeners(){
		b[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controls.numberPressed(b[0]);
			}
		});
		b[1].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controls.numberPressed(b[1]);
			}
		});
		b[2].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controls.numberPressed(b[2]);
			}
		});
		b[3].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controls.numberPressed(b[3]);
			}
		});
		b[4].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controls.numberPressed(b[4]);
			}
		});
		b[5].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controls.numberPressed(b[5]);
			}
		});
		b[6].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controls.numberPressed(b[6]);
			}
		});
		b[7].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controls.numberPressed(b[7]);
			}
		});
		b[8].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controls.numberPressed(b[8]);
			}
		});
	
	}
	
	/*
	 * Static interface of view that allows other classes to control the view and connect it to a model.
	 */
	
	public static interface Controls{
		
		/*
		 * for buttons with number values action
		 */
		
		public void numberPressed(JButton b);
		
		/*
		 * equals button action
		 */
		
		public void equalsPressed();
		
		/*
		 * clear button action
		 */
		
		public void clearPressed();
		
		/*
		 * delete button action
		 */
		
		public void deletePressed();
		
	}

}
