import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Fabio Sorrentino Matr.147304 Ingegneria del Cinema e dei Mezzi di Comunicazione

public class QuindiciController implements ActionListener 
{
	private QuindiciModel m;
	private QuindiciView1 v1;
	private QuindiciView2 v2;
	private QuindiciView3 v3;
	private static boolean check;
	
	public QuindiciController()
	{
		m = new QuindiciModel(4,4);
		v1 = new QuindiciView1(m, this);
		v2 = new QuindiciView2(m, this);
		v3 = new QuindiciView3(this);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		String cmd = ae.getActionCommand();
		
		if("Nuova Partita".equals(cmd))
		{
			m.disordina(100);
			QuindiciMain.changeView(1);
		}
		else if("Classifica".equals(cmd))
		{
			if(!check)
			{
				m.riordina();
				m.removeElement();
			}
			QuindiciMain.changeView(2);
		}
		else if("About...".equals(cmd))
		{
			QuindiciMain.changeView(3);
		}
		else if("Fine".equals(cmd))
		{
			System.exit(-1);
		}
		
	}

	public Component getView1()
	{
		return v1;
	}
	
	public Component getView2() 
	{
		return v2;
	}
	
	public Component getView3() 
	{
		return v3;
	}
	
	public static void setCheck()
	{
		check = false;
	}
}
