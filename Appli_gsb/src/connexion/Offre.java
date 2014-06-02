package connexion;

public class Offre{
	private String visMat;
	private long rapNum;
	private String medDepot;
	private int qte;
	
	public Offre(String mat, long rapnum, String depotlegal, int quantite) {
		// TODO Stub du constructeur généré automatiquement
		this.visMat=mat;
		this.rapNum=rapnum;
		this.medDepot=depotlegal;
		this.qte=quantite;
	}
	
	public void setVismat(String maj)
	{
		this.visMat=maj;
	}
	public String getVismat()
	{
		return this.visMat;
	}
	
	public void setNumrap(long maj)
	{
		this.rapNum=maj;
	}
	public long getNumrap()
	{
		return this.rapNum;
	}
	
	public void setDepot(String maj)
	{
		this.medDepot=maj;
	}
	public String getDepot()
	{
		return this.medDepot;
	}
	
	public void setQte(int maj)
	{
		this.qte=maj;
	}
	public int getQte()
	{
		return this.qte;
	}
	
}
