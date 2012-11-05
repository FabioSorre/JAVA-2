import java.util.Collections;
import java.util.Comparator;
import java.util.Observable;
import java.util.Vector;

//Fabio Sorrentino Matr.147304 Ingegneria del Cinema e dei Mezzi di Comunicazione

public class QuindiciModel extends Observable
{
	private int mx[][];
	private int righe, colonne;
	private long time = 0, time1 = 0, time2 = 0;
	private int mosse;
	private Vector<Long> v = new Vector<Long>();
	public boolean zero = true;
	
	public QuindiciModel(int riga2, int colonna2)
	{
		righe = riga2;
		colonne = colonna2;
		mx = new int[righe][colonne];
	
		int k=1;
		for(int i1=0; i1<(righe); i1++)
		{
			for(int j1=0; j1<(colonne); j1++)
			{
				mx[i1][j1] = k;
				k++;
			}
		}
		
	}
	
	public void riordina()
	{
		int k=1;
		for(int i1=0; i1<(righe); i1++)
		{
			for(int j1=0; j1<(colonne); j1++)
			{
				mx[i1][j1] = k;
				k++;
			}
		}
		setChanged();
		notifyObservers();
	}
	
	public void disordina(int numeroscambi)
	{
		int tamp, tmp, tmp1, tmp2, tmp3;
		boolean end = true;
		
		//Levare i commenti per vincere con una mossa, per velocizzare i controlli
		/*
		tmp = getElementMatrix_X(15);
		tmp1 = getElementMatrix_Y(15);
		tmp2 = getElementMatrix_X(16);
		tmp3 = getElementMatrix_Y(16);
	
		scambia(tmp, tmp1, tmp2, tmp3);
		*/
		
		//Eseguo due scombinazioni per evitare di ritornare alla soluzione con il "mescolamento",
		//senza renderlo inrisolvibile
		int set = 15;
		while(end)
		{
			for(int k=4; k>=3; k--)
			{
				tmp = getElementMatrix_X(set-k);
				tmp1 = getElementMatrix_Y(set-k);
				tmp2 = getElementMatrix_X(set);
				tmp3 = getElementMatrix_Y(set);
			
				scambia(tmp, tmp1, tmp2, tmp3);
			}

			if(set==15)
			{
				set = set - 2;
			}
			else if(set==13)
			{
				end = false;
			}
			
		}
		
		boolean z = true;
		int tamp1, tamp2, tamp3, tamp4, tamp5, tamp6, tamp7, tamp8, tamp9;
		
		tamp1 = tamp2 = tamp3 = tamp4 = tamp5 = tamp6 = tamp7 = tamp8 = tamp9 = 1;
		
		//Mescolamento
		for(int i=0; i<numeroscambi; i++)
		{
			z = true;
			tmp = 0;
			tmp1 = 0;
			tmp2 = getElementMatrix_X(16);
			tmp3 = getElementMatrix_Y(16);
			
			//Range per la posizione
			int n = 0;
			int m2 = 3;
			int m3 = 4;
			int m4 = 5;
			
			while(z)
			{	
				if(tmp2==0)
				{
					if(tmp3==0)
					{

						//In base alla posizione dell'etichetta, genero a caso una direzione di spostamento.
						tamp =  (int) ((Math.random()*(n-m2+1))+m2);
						
						//Controllo per vedere se è già stata effettuata questa mossa, nello scambio precedente.
						if(tamp1==tamp)
						{
							while(tamp1==tamp)
							{
								tamp =  (int) ((Math.random()*(n-m2+1))+m2);
							}
							tamp1=tamp;
						}
						
						switch(tamp)
						{
							case 1: 
									tmp = tmp2;
									tmp1 = tmp3 + 1;
				
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
									
							case 2:
									tmp = tmp2 + 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							
						}
					}
					else if (tmp3==3)
					{
						tamp =  (int) ((Math.random()*(n-m2+1))+m2);
						
						if(tamp2==tamp)
						{
							while(tamp2==tamp)
							{
								tamp =  (int) ((Math.random()*(n-m2+1))+m2);
							}
							tamp2=tamp;
						}
						
						switch(tamp)
						{
							case 1: 
									
									tmp = tmp2;
									tmp1 = tmp3 - 1;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							
							case 2: 
									tmp = tmp2 + 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							
						}
					}
					else
					{
						tamp =  (int) ((Math.random()*(n-m3+1))+m3);
						
						if(tamp3==tamp)
						{
							while(tamp3==tamp)
							{
								tamp = (int) ((Math.random()*(n-m3+1))+m3);
							}
							tamp3=tamp;
						}
						
						switch(tamp)
						{
							case 1: 
									tmp = tmp2;
									tmp1 = tmp3 + 1;
				
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
									
							case 2:
									tmp = tmp2;
									tmp1 = tmp3 - 1;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
						
							case 3: 
									tmp = tmp2 + 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							
						}
					}
					
				}
				else if(tmp2==3)
				{
					if(tmp3==0)
					{
						tamp = (int) ((Math.random()*(n-m2+1))+m2);
						
						if(tamp4==tamp)
						{
							while(tamp4==tamp)
							{
								tamp = (int) ((Math.random()*(n-m2+1))+m2);
							}
							tamp4=tamp;
						}
						
						switch(tamp)
						{
							case 1: 
									tmp = tmp2;
									tmp1 = tmp3 + 1;
				
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
									
							case 2:
									tmp = tmp2 - 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							
						}
					}
					else if (tmp3==3)
					{
						tamp = (int) ((Math.random()*(n-m2+1))+m2);
						
						if(tamp5==tamp)
						{
							while(tamp5==tamp)
							{
								tamp = (int) ((Math.random()*(n-m2+1))+m2);
							}
			
							tamp5=tamp;
						}
						
						switch(tamp)
						{		
							case 1:
									tmp = tmp2;
									tmp1 = tmp3 - 1;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							case 2:
									tmp = tmp2 - 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							
						}
					}
					else
					{
						tamp = (int) ((Math.random()*(n-m3+1))+m3);
						
						if(tamp6==tamp)
						{
							while(tamp6==tamp)
							{
								tamp = (int) ((Math.random()*(n-m3+1))+m3);
							}
							tamp6=tamp;
						}
						
						switch(tamp)
						{
							case 1: 
									tmp = tmp2;
									tmp1 = tmp3 + 1;
				
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
									
							case 2:
									tmp = tmp2;
									tmp1 = tmp3 - 1;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							case 3:
									tmp = tmp2 - 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							
						}
					}
				}
				else
				{
					if(tmp3==0)
					{
						tamp = (int) ((Math.random()*(n-m3+1))+m3);
						
						if(tamp7==tamp)
						{
							while(tamp7==tamp)
							{
								tamp = (int) ((Math.random()*(n-m3+1))+m3);
							}
							tamp7=tamp;
						}
						switch(tamp)
						{
							case 1: tmp = tmp2;
									tmp1 = tmp3 + 1;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
									
							case 2:
									tmp = tmp2 + 1;
									tmp1 = tmp3;
							
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
							
									break;
									
							case 3:
									tmp = tmp2 - 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							
						}
					}
					else if(tmp3==3)
					{
						tamp = (int) ((Math.random()*(n-m3+1))+m3);
						
						if(tamp8==tamp)
						{
							while(tamp8==tamp)
							{
								tamp = (int) ((Math.random()*(n-m3+1))+m3);
							}
							tamp8=tamp;
						}
						
						switch(tamp)
						{
							case 1: 
									tmp = tmp2 - 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;

							case 2:
									tmp = tmp2;
									tmp1 = tmp3 - 1;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							case 3:
									tmp = tmp2 + 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
						}
					}
					else
					{
						tamp = (int) ((Math.random()*(n-m4+1))+m4);
						
						if(tamp9==tamp)
						{
							while(tamp9==tamp)
							{
								tamp = (int) ((Math.random()*(n-m4+1))+m4);
							}
							tamp9=tamp;
						}
						
						switch(tamp)
						{
							case 1: 
									tmp = tmp2;
									tmp1 = tmp3 - 1;
				
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
									
							case 2:
									tmp = tmp2;
									tmp1 = tmp3 + 1;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							case 3:
									tmp = tmp2 - 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							case 4: 
									tmp = tmp2 + 1;
									tmp1 = tmp3;
									
									scambia(tmp, tmp1, tmp2, tmp3);
									setChanged();
									z = false;
									
									break;
							
						}
					}
				}
			}
		}
		
		
		time1 = System.currentTimeMillis();
		mosse = 0;
		
		setChanged();
		notifyObservers();
		
	}

	//Scambia due elementi della matrice, tramite le loro coordinate
	private void scambia(int a1,int b1,int a2,int b2)
	{
		int tmp, tmp2, tmp3;
		
		tmp2 = mx[a1][b1];
		tmp3 = mx[a2][b2];
		tmp = a1;
		a1 = a2;
		a2 = tmp;
		tmp = b1;
		b1 = b2;
		b2 = tmp;
		mx[a1][b1]= tmp2;
		mx[a2][b2]= tmp3;
	}
	
	//Controlla se il puzzle è completo
	public boolean controlla()
	{
		int k=1;
		int z = 0;
		boolean check = false;
		
		for(int i1=0; i1<(righe); i1++)
		{
			for(int j1=0; j1<(colonne); j1++)
			{
				z = mx[i1][j1];
				if(z!=k)
				{
					check = true;
				}
				k++;
			}
		}
	
		//Se è completo, gestisco il tempo ottenuto nel vettore
		if(!check)
		{
			addOrderVett();
		}
		
		return check;
	}
	
	public void addOrderVett()
	{
		if(!zero)
		{
			v.add(getTimeNumber());
			
			Comparator<Long> cm = new Comparator <Long>()
			{
				public int compare(Long time1, Long time2)
				{

					if(time1==time2)
					{
						return 0;
					}
					else if((time1.compareTo(time2)>0))
					{
						return 1;
					}
					else
					{
						return -1;
					}
					
				}
			};
			Collections.sort(v, cm);
		}
		zero = false;
	}
	
	//Restituisce la coordinata X
	public int getElementMatrix_X(int val)
	{
		int i = 0;
		int j = 0;
		int tmp1 = 0;
		
		for(i=0; i<(righe); i++)
		{
			for(j=0; j<(colonne); j++)
			{
				if(val==mx[i][j])
				{
					tmp1 = i;
				}
			}
		}
		
		return tmp1;
	}
	
	//Restituisce la coordinata Y
	public int getElementMatrix_Y(int val)
	{
		int i = 0;
		int j = 0;
		int tmp1 = 0;
		
		for(i=0; i<(righe); i++)
		{
			for(j=0; j<(colonne); j++)
			{
				if(val==mx[i][j])
				{
					tmp1 = j;
				}
			}
		}
		
		return tmp1;
	}
	
	//Controllo per effettuare lo spostamento della label, più conteggio mosse
	public void sposta(int val)
	{
		int tmp, tmp1, tmp2, tmp3;
		
		tmp = getElementMatrix_X(val);
		tmp1 = getElementMatrix_Y(val);
		
		tmp2 = getElementMatrix_X(16);
		tmp3 = getElementMatrix_Y(16);
		
		//Controllo se sopra, sotto e ai lati
		if((tmp==tmp2) && ((tmp1+1)==tmp3))
		{
			scambia(tmp, tmp1, tmp2, tmp3);
			mosse++;
			setChanged();
		}
		if((tmp==(tmp2+1)) && (tmp1==tmp3))
		{
			scambia(tmp, tmp1, tmp2, tmp3);
			mosse++;
			setChanged();
		}
		if(((tmp==tmp2) && ((tmp1-1)==tmp3)))
		{
			scambia(tmp, tmp1, tmp2, tmp3);
			mosse++;
			setChanged();
		}
		if((tmp==(tmp2-1)) && (tmp1==tmp3))
		{
			scambia(tmp, tmp1, tmp2, tmp3);
			mosse++;
			setChanged();
		}
		
		notifyObservers();
	}
	
	public int getRighe()
	{
		return righe;
	}
	
	public int getColonne()
	{
		return colonne;
	}
	
	public int getMatrix(int i, int j)
	{
		return mx[i][j];
	}
	
	public int getMosse()
	{
		return mosse;
	}
	
	public long getTimeNumber()
	{
		
		time2 = System.currentTimeMillis();
		time = (time2 - time1)/1000;

		return time;
	}
	
	//Restituisce il tempo al vettore, formato minuti/secondi
	public String getTime(long time)
	{
		String s = null;
		long z = 0;
		
		if(time>=60)
		{
			z = Math.round(time/60);
			time = time - (60*z);
		}
		
		
		if(z!=0)
		{
			if(time>=10)
			{
				s = z + ":" + time + " minuti/secondi";
			}
			else
			{
				s = z + ":0" + time +  " minuti/secondi";
			}
		}
		else
		{
			if(time==1)
			{
				s = " " + time + " secondo";
			}
			else
			{
				s = " " + time + " secondi";
			}
		}

		
		return s;
		
	}
	
	//Restituisce il tempo alla label, formato " s"
	public String getTime2()
	{
		String s = null;
		long z = 0;
	
		time = getTimeNumber();
		
		if(time>=60)
		{
			z = Math.round(time/60);
			time = time - (60*z);
		}
		
		
		if(z!=0)
		{
			if(time>=10)
			{
				s = z + ":" + time;
			}
			else
			{
				s = z + ":0" + time;
			}
		}
		else
		{
			if(time==1)
			{
				s = " " + time;
			}
			else
			{
				s = " " + time;
			}
		}

		return s;
		
	}

	public int getVettSize() 
	{
		int i;
		
		i = v.size();

		return i;
	}
	
	public void removeElement()
	{
		int i = getVettSize();
		v.removeElementAt(i-1);
		QuindiciController.setCheck();
	}
	
	public Long getVett(int pos)
	{
		return v.elementAt(pos);
		
	}
	

}
