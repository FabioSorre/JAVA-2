import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;

import javax.swing.JLabel;

//Fabio Sorrentino Matr.147304 Ingegneria del Cinema e dei Mezzi di Comunicazione

public class QuindiciView3 extends Panel
{
	
	private static final long serialVersionUID = -1462355919991248667L;
	
	private JLabel l1;

	
	public QuindiciView3(QuindiciController c)
	{
		l1 = new JLabel("<html><br/><br/><p align = 'center'><u>Istruzioni</u><br/>Clicca sui vari numeri per spostarli,<br/> fin quando non componi il quadrato ordinato <br/>dall'alto verso il basso.<br/><br/><br/><br/><br/>Creato da <i>Fabio Sorrentino</i><br/>Ingegneria del Cinema e dei Mezzi di comunicazione<br/>Corso di Programmazione e realizzazione di Interfacce grafiche.</p></html>");
		l1.setForeground(Color.BLACK);
		
		setLayout(new FlowLayout());
		add(l1, JLabel.CENTER);
		
	}

}
