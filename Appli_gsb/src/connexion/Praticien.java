package connexion;

public class Praticien {
	private long numero;
	private String nom;
	private String prenom;
	private String adresse;
	private long cp;
	private String ville;
	private double coeff;
	private String type;
	
	public Praticien(long num, String firstName, String lastName, String address, long CP, String town, double noto, String type_code) {
		// TODO Stub du constructeur généré automatiquement
		this.numero=num;
		this.nom=firstName;
		this.prenom=lastName;
		this.adresse=address;
		this.cp=CP;
		this.ville=town;
		this.coeff=noto;
		this.type=type_code;
	}
	
	public void setNum(long maj)
	{
		this.numero=maj;
	}
	public long getNum()
	{
		return this.numero;
	}
	
	public void setNom(String maj)
	{
		this.nom=maj;
	}
	public String getNom()
	{
		return this.nom;
	}
	
	public void setPrenom(String maj)
	{
		this.prenom=maj;
	}
	public String getPrenom()
	{
		return this.prenom;
	}
	
	public void setAdresse(String maj)
	{
		this.adresse=maj;
	}
	public String getAdresse()
	{
		return this.adresse;
	}
	
	public void setCP(long maj)
	{
		this.cp=maj;
	}
	public long getCp()
	{
		return this.cp;
	}
	
	public void setVille(String maj)
	{
		this.ville=maj;
	}
	public String getVille()
	{
		return this.ville;
	}
	
	public void setCoeff(double maj)
	{
		this.coeff=maj;
	}
	public double getcoeff()
	{
		return this.coeff;
	}
	
	public void setType(String maj)
	{
		this.type=maj;
	}
	public String getType()
	{
		return this.type;
	}
	
	

}
