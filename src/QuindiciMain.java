import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Fabio Sorrentino Matr.147304 Ingegneria del Cinema e dei Mezzi di Comunicazione

public class QuindiciMain
{
	private static Frame f;
	private static QuindiciController sc;
	private static boolean z = true;
	
	public QuindiciMain()
	{
		f = new Frame("Esercitazione 2");
		f.setLocation(50, 50);
		f.setSize(413, 527);
		f.setResizable(false);
		
		Color bgcolor = new Color(220, 220, 220, 220);
		f.setBackground(bgcolor);
		
		WindowAdapter wa = new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{	
				we.getWindow().dispose();
			};
		};
		f.addWindowListener(wa);
		 
		//Menù Iniziale
		Menu link = new Menu("Avvia");
		link.add(new MenuItem("Nuova Partita"));
		link.addSeparator();
		link.add(new MenuItem("Classifica"));
		
		Menu link2 = new Menu("Fine");
		link2.add(new MenuItem("About..."));
		link2.addSeparator();
		link2.add(new MenuItem("Fine"));
		
		MenuBar mb = new MenuBar();
		mb.add(link);
		mb.add(link2);
		f.setMenuBar(mb);
		
		sc = new QuindiciController();
		
		link.addActionListener(sc);
		link2.addActionListener(sc);
		
		if(z)
		{
			f.add(sc.getView1());
			z = false;
		}
		
		f.setVisible(true);
		
	}
	
	//Funzione che cambia le viste
	public static void changeView(int i)
	{
		
		if(i==1)
		{
			f.removeAll();
			f.add(sc.getView1());
			f.setVisible(true);
		}
		else if(i==2)
		{
			f.removeAll();
			f.add(sc.getView2());
			f.setVisible(true);
		}
		else if(i==3)
		{
			f.removeAll();
			f.add(sc.getView3());
			f.setVisible(true);
		}
		else if(i==4)
		{
			f.removeAll();
			Label l = new Label();
			String s = new String();
			s = "                 Avvia una nuova partita tramite il menù.";
			l.setText(s);
			l.setFont(new Font("Times", Font.PLAIN, 16));
			l.setBackground(Color.WHITE);
			f.add(l);
			f.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) 
	{
		Runnable r = new Runnable()
		{
			public void run()
			{
				new QuindiciMain();
			};
		};
		
		EventQueue.invokeLater(r);
	}
}
