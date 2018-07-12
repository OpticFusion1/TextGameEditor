package polonius.textGameEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Editor extends JFrame {
	private static final long serialVersionUID = 1L;
	
	static int X=500;	//Wymiary okna
	static int Y=500;
	
	static JFrame window;
	
	public Editor(){
		setTitle("Edytor Tekstówek");	//Tytuł okna
		setSize(X,Y);	//Rozmiar okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//Wyłšczenie programu po kliknięciu czerwonego "X"
		
		JPanel upperPanel = new JPanel();
		add(BorderLayout.NORTH, upperPanel);
		upperPanel.setLayout(new GridLayout(1,4));
		JButton open = new JButton("Otwórz/Nowy");
		upperPanel.add(open);
		upperPanel.add(new JPanel());
		upperPanel.add(new JPanel());
		upperPanel.add(new JLabel("by Jacek Piłka"));
		
		add(BorderLayout.EAST, new JPanel());
		add(BorderLayout.WEST, new JPanel());
		
		final JPanel optionsMain = new JPanel();	//Panel opcji
		add(BorderLayout.CENTER, optionsMain);	//Położenie panelu
		
		final JPanel optionsUpper=new JPanel();
		JPanel optionsLesser=new JPanel();
		
		optionsMain.setLayout(new GridLayout(2,1));
		optionsMain.add(optionsUpper);
		optionsMain.add(optionsLesser);
		
		JTextField situationName=new JTextField();
		JTextArea situationDescritpion=new JTextArea();
		
		optionsUpper.add(BorderLayout.NORTH, situationName);
		
		optionsUpper.setLayout(new GridLayout(5,2));
		
		optionsUpper.add(new JLabel("Nazwa Sytuacji"));		
		optionsUpper.add(new JPanel());
		
		optionsUpper.add(situationName);
		optionsUpper.add(new JPanel());
		
		optionsUpper.add(new JPanel());
		optionsUpper.add(new JPanel());
		
		optionsUpper.add(situationDescritpion);
		optionsUpper.add(new JPanel());
		
		optionsUpper.add(new JPanel());
		optionsUpper.add(new JLabel("by Jacek Piłka"));
		
		open.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				optionsUpper.disable();
			}
		});
		
		Toolkit tools=Toolkit.getDefaultToolkit();	//Umożliwia ustawienie położenai okna w przestrzeni
		Dimension dim=tools.getScreenSize();
		final int framewidth=X;
		final int frameheight=Y;
		this.setLocation((int)dim.getWidth()/2 - framewidth/2, (int) dim.getHeight()/2 - frameheight/2);
	}
}
