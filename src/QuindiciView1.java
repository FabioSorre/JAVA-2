import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;





//Fabio Sorrentino Matr.147304 Ingegneria del Cinema e dei Mezzi di Comunicazione

public class QuindiciView1 extends Panel implements Observer, MouseListener
{
	
	private static final long serialVersionUID = 41623440160047657L;
	
	private QuindiciModel mView1;
	private Label  label;
	private Label lab1, lab2, lab3;
	private boolean check;
	
	public QuindiciView1(QuindiciModel m1, QuindiciController c)
	{
		mView1 = m1;
		mView1.addObserver(this);
		
		check = mView1.controlla();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbcMain = new GridBagConstraints();
		
		gbcMain.gridwidth = 1;
		gbcMain.gridheight = 1;
		gbcMain.weighty = 1.0;
		gbcMain.fill = GridBagConstraints.BOTH;
		gbcMain.anchor = GridBagConstraints.CENTER;
		gbcMain.insets.set(2, 1, 1, 1);
		
		for(int i=0; i<(mView1.getRighe()); i++)
		{
			gbcMain.gridy = i;
			
			for(int j=0; j<(mView1.getColonne()); j++)
			{
				label = new Label("", Label.CENTER);
				
				if(mView1.getMatrix(i, j)==16)
				{
					label.setText(" ");
				}
				else
				{
					label.setText(Integer.toString(mView1.getMatrix(i, j)));
				}
				
				label.setBackground(Color.WHITE);
				label.setPreferredSize(new Dimension(99, 99));
				
				if(j==0)
				{
					gbcMain.weightx = 0.6;
				}
				else if(j==2)
				{
					gbcMain.weightx = 1.0;
				}
				
				
				gbcMain.gridx = j;
				label.addMouseListener(this);
				
				if(check==false)
				{
					label.removeMouseListener(this);
				}
				
				add(label, gbcMain);
			}
			
			if(i==3)
			{
				gbcMain.insets.set(1, 1, 2, 1);
			}
			else
			{
				gbcMain.insets.set(1, 1, 1, 1);
			}
		}
		
		
		lab1 = new Label("Mosse", Label.CENTER);
		lab2 = new Label("Tempo ", Label.CENTER);
		lab3 = new Label("Modalità Off-play", Label.CENTER);
		
		lab1.setBackground(Color.LIGHT_GRAY);
		lab2.setBackground(Color.LIGHT_GRAY);
		lab3.setBackground(Color.LIGHT_GRAY);
		
		gbcMain.gridy = 4;
		gbcMain.gridx = 0;
		gbcMain.insets.set(1, 1, 1, 0);
		add(lab1, gbcMain);
		
		gbcMain.gridx = 1;
		gbcMain.insets.set(1, 0, 1, 0);
		add(lab2, gbcMain);
		
		gbcMain.gridx = 2;
		gbcMain.gridwidth = 2;
		gbcMain.insets.set(1, 0, 1, 1);
		add(lab3, gbcMain);
		
			
	}
	
	public void update(Observable o, Object data)
	{
		
		removeAll();

		check = mView1.controlla();
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbcMain2 = new GridBagConstraints();
		
		gbcMain2.gridwidth = 1;
		gbcMain2.gridheight = 1;
		gbcMain2.weighty = 1.0;
		gbcMain2.fill = GridBagConstraints.BOTH;
		gbcMain2.anchor = GridBagConstraints.CENTER;
		gbcMain2.insets.set(2, 1, 1, 1);
		
		for(int i=0; i<(mView1.getRighe()); i++)
		{
			gbcMain2.gridy = i;
			
			for(int j=0; j<(mView1.getColonne()); j++)
			{
				label = new Label("", Label.CENTER);
				
				if(mView1.getMatrix(i, j)==16)
				{
					label.setText(" ");
				}
				else
				{
					label.setText(Integer.toString(mView1.getMatrix(i, j)));
					label.validate();
				}
				
				label.setBackground(Color.WHITE);
				label.setPreferredSize(new Dimension(99, 99));
				
				if(j==0)
				{
					gbcMain2.weightx = 0.6;
				}
				else if(j==2)
				{
					gbcMain2.weightx = 1.0;
				}
				
				gbcMain2.gridx = j;
				label.addMouseListener(this);
				
				if(check==false)
				{
					label.removeMouseListener(this);
				}
				
				add(label, gbcMain2);
			}
			
			if(i==3)
			{
				gbcMain2.insets.set(1, 1, 2, 1);
			}
			else
			{
				gbcMain2.insets.set(1, 1, 1, 1);
			}
		}
		
		String move = "Mosse: " + mView1.getMosse();
		String time = "Tempo: " + mView1.getTime2() + " s";
			
		lab1 = new Label(move, Label.CENTER);
		lab2 = new Label(time, Label.CENTER);
		
		if(check==false)
		{
			lab3 = new Label("Finito! Rigioca...", Label.CENTER);
		}
		else
		{
			lab3 = new Label("Modalità Gioco    ", Label.CENTER);
		}
		
		lab1.setBackground(Color.LIGHT_GRAY);
		lab2.setBackground(Color.LIGHT_GRAY);
		lab3.setBackground(Color.LIGHT_GRAY);
		
		gbcMain2.gridy = 4;
		gbcMain2.gridx = 0;
		gbcMain2.insets.set(1, 1, 1, 0);
		add(lab1, gbcMain2);
		
		gbcMain2.gridx = 1;
		gbcMain2.insets.set(1, 0, 1, 0);
		add(lab2, gbcMain2);
		
		gbcMain2.gridx = 2;
		gbcMain2.gridwidth = 2;
		gbcMain2.insets.set(1, 0, 1, 1);
		add(lab3, gbcMain2);

		validate();
	}

	@Override
	public void mouseClicked(MouseEvent me) 
	{
		label = new Label();
		label = (Label) me.getComponent();
		if(!(label.getText()).equals(" "))
			mView1.sposta(Integer.parseInt(label.getText()));
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}