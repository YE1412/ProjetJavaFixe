package connexion;

public class Rapport {
	private String visMat;
	private long rapNum;
	private long praNum;
	private String rapDate;
	private String rapBilan;
	private String rapMotif;
	private String praNom;
	private String praPrenom;
	public Rapport(String mat, long numr, long nump, String date, String bilan, String motif, String nom, String prenom) {
		// TODO Stub du constructeur généré automatiquement
		this.visMat=mat;
		this.rapNum=numr;
		this.praNum=nump;
		this.rapDate=date;
		this.rapBilan=bilan;
		this.rapMotif=motif;
		this.praNom=nom;
		this.praPrenom=prenom;
	}
	
	public void setMatricule(String maj)
	{
		this.visMat=maj;
	}
	public String getMatricule()
	{
		return this.visMat;
	}
	
	public void setRapnum(long maj)
	{
		this.rapNum=maj;
	}
	public long getRapnum()
	{
		return this.rapNum;
	}
	
	public void setPranum(long maj)
	{
		this.praNum=maj;
	}
	public long getPranum()
	{
		return this.praNum;
	}
	
	public void setDate(String maj)
	{
		this.rapDate=maj;
	}
	public String getDate()
	{
		return this.rapDate;
	}
	
	public void setBilan(String maj)
	{
		this.rapBilan=maj;
	}
	public String getBilan()
	{
		return this.rapBilan;
	}
	
	public void setMotif(String maj)
	{
		this.rapMotif=maj;
	}
	public String getMotif()
	{
		return this.rapMotif;
	}
	
	public void setPraNom(String maj)
	{
		this.praNom=maj;
	}
	public String getPraNom()
	{
		return this.praNom;
	}
	
	public void setPraPrenom(String maj)
	{
		this.praPrenom=maj;
	}
	public String getPraPrenom()
	{
		return this.praPrenom;
	}
	
	
	

}
