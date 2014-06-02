package connexion;

public class Utilisateur {
	private String matricule;
	private String nom;
	private String prenom;
	private String adresse;
	private long codePostal;
	private String ville;
	private String dateEmbauche;
	private String labCode;
	private String secLibelle;
	
	public Utilisateur(String mat, String lastname, String firstname, String adr, long CP, String town, String date, String libelle, String labCode){
		// TODO Stub du constructeur généré automatiquement
		this.matricule=mat;
		this.nom=lastname;
		this.prenom=firstname;
		this.adresse=adr;
		this.codePostal=CP;
		this.ville=town;
		this.dateEmbauche=date;
		this.secLibelle=libelle;
		this.labCode=labCode;
	}
	
	public void setMatricule(String maj)
	{
		this.matricule=maj;
	}
	public String getMatricule()
	{
		return this.matricule;
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
		this.codePostal=maj;
	}
	public long getCP()
	{
		return this.codePostal;
	}
	
	public void setVille(String maj)
	{
		this.ville=maj;
	}
	public String getVille()
	{
		return this.ville;
	}
	
	public void setDateEmb(String maj)
	{
		this.dateEmbauche=maj;
	}
	public String getDateEmb()
	{
		return this.dateEmbauche;
	}
	
	public void setLibelleSecteur(String maj)
	{
		this.secLibelle=maj;
	}
	public String getLibelleSecteur()
	{
		return this.secLibelle;
	}
	
	public void setLabCode(String maj)
	{
		this.labCode=maj;
	}
	public String getLabCode()
	{
		return this.labCode;
	}

}
