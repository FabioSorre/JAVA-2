import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

//Fabio Sorrentino Matr.147304 Ingegneria del Cinema e dei Mezzi di Comunicazione

public class QuindiciView2 extends Panel implements Observer, ActionListener
{
	
	private static final long serialVersionUID = -3628897673892184664L;
	
	private QuindiciModel mView2;
	private Label label, lab1;
	private Button b;
	public String s;
	
	public QuindiciView2(QuindiciModel m1, QuindiciController c)
	{
		mView2 = m1;
		mView2.addObserver(this);
		
		s = new String();
		
		lab1 = new Label("Miglior tempi", Label.CENTER);
		lab1.setFont(new Font("Times", Font.BOLD, 16));
		lab1.setBackground(Color.LIGHT_GRAY);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		add(lab1, gbc);

		gbc.gridwidth = 1;
		
		for(int i=1; i<=20; i++)
		{
			if(i==10)
			{
				s = "Lista vuota";
			}
			else
			{
				s = " ";	
			}
			label = new Label(s, Label.CENTER);
			label.setPreferredSize(new Dimension(50, 25));
			label.setBackground(Color.WHITE);
			gbc.gridy = i;
			add(label, gbc);
		}
		
		b = new Button("Torna indietro");
		b.addActionListener(this);
		
		gbc.gridy = 21;
		add(b, gbc);
		
		validate();
	}
	
	public void update(Observable o, Object data)
	{
		removeAll();
		
		s = new String();
		
		lab1 = new Label("Miglior tempi", Label.CENTER);
		lab1.setFont(new Font("Times", Font.BOLD, 16));
		lab1.setBackground(Color.LIGHT_GRAY);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		add(lab1, gbc);

		gbc.gridwidth = 1;
	
		for(int i=1; i<=(mView2.getVettSize()); i++)
		{
			s = Integer.toString(i) + ".   " + (mView2.getTime(mView2.getVett(i-1)));
			label = new Label(s, Label.CENTER);
			label.setPreferredSize(new Dimension(50, 25));
			label.setBackground(Color.WHITE);
			gbc.gridy = i;
			add(label, gbc);
			validate();
		}
		
		if(mView2.getVettSize()==0)
		{
			for(int j = mView2.getVettSize()+1; j<=20; j++)
			{
				if(j==10)
				{
					s = "Lista vuota";
				}
				else
				{
					s = " ";	
				}
				label = new Label(s, Label.CENTER);
				label.setPreferredSize(new Dimension(50, 25));
				label.setBackground(Color.WHITE);
				gbc.gridy = j;
				add(label, gbc);
			}
		}
		else
		{
			for(int j = mView2.getVettSize()+1; j<=20; j++)
			{
				s = " ";
				label = new Label(s, Label.CENTER);
				label.setPreferredSize(new Dimension(50, 25));
				label.setBackground(Color.WHITE);
				gbc.gridy = j;
				add(label, gbc);
			}
		}
		
		b = new Button("Torna indietro");
		b.addActionListener(this);
	
		gbc.gridy = 21;
		add(b, gbc);
		validate();
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		String cmd = ae.getActionCommand();
		if("Torna indietro".equals(cmd))
		{
			QuindiciMain.changeView(4);
		}
		
	}
	
}
