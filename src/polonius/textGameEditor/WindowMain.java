package polonius.textGameEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * 
 * @author Jacek Piłka
 *
 * Interfejs programu
 *
 */

public class WindowMain extends JFrame {
	private static final long serialVersionUID = 1L;

	static ScheduledExecutorService scheduler;	//Scheduler do wielowštkowoci (umożliwia m.in. sterowanie podczas symulacji)
	
	static int X=250;	//Wymiary okna
	static int Y=300;
	
	static JFrame window;
	
	public WindowMain() {
		setTitle("Model Isinga");	//Tytuł okna
		setSize(X,Y);	//Rozmiar okna
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//Wyłšczenie programu po kliknięciu czerwonego "X"
		
		JPanel greetin = new JPanel();
		add(BorderLayout.NORTH, greetin);
		greetin.add(new JLabel("Menu:"));
		
		add(BorderLayout.EAST, new JPanel());
		add(BorderLayout.WEST, new JPanel());
		
		JPanel options = new JPanel();	//Panel opcji
		add(BorderLayout.CENTER, options);	//Położenie panelu
		
		options.setLayout(new GridLayout(9,1));
		options.add(new JLabel("Witamy w grze tekstowej"));
		
		JButton start = new JButton("Start");	//Przyciski, pola tekstowe i comboBoxy
		JButton choose = new JButton("Wybór scenariusza");
		JButton editor = new JButton("Edytor scenariuszy");
		JButton stop = new JButton("Koniec");
		
		options.add(new JPanel());
		options.add(start);
		options.add(new JPanel());
		options.add(choose);
		options.add(editor);
		options.add(stop);
		options.add(new JPanel());
		options.add(new JLabel("by Jacek Piłka"));
		
		stop.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				window.dispose();
			}
			
		});
	}
	
	public static void main(String[] args) {
		window = new WindowMain();	//Stworzenie okna
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Toolkit tools=Toolkit.getDefaultToolkit();	//Umożliwia ustawienie położenai okna w przestrzeni
		Dimension dim=tools.getScreenSize();
		final int framewidth=X;
		final int frameheight=Y;
		window.setLocation((int)dim.getWidth()/2 - framewidth/2, (int) dim.getHeight()/2 - frameheight/2);
		window.setVisible(true);	//Wywietlenie okna
	}

}