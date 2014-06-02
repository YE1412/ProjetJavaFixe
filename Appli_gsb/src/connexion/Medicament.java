package connexion;

public class Medicament {
	private String depotLegal;
	private String nomCom;
	private String famille;
	private String compo;
	private String effet;
	private String contreInd;
	private String prixEch;
	private String famille_libelle;
	
	public Medicament(String depot, String nom, String fam, String comp, String eff, String contr, String price, String libelle_fam) {
		// TODO Stub du constructeur généré automatiquement
		this.depotLegal=depot;
		this.nomCom=nom;
		this.famille=fam;
		this.compo=comp;
		this.effet=eff;
		this.contreInd=contr;
		this.prixEch=price;
		this.famille_libelle=libelle_fam;
	}

	public void setDepotLegal(String maj)
	{
		this.depotLegal=maj;
	}
	public String getDepotLegal()
	{
		return this.depotLegal;
	}
	
	public void setNom(String maj)
	{
		this.nomCom=maj;
	}
	public String getNom()
	{
		return this.nomCom;
	}
	
	public void setFam(String maj)
	{
		this.famille=maj;
	}
	public String getFam()
	{
		return this.famille;
	}
	
	public void setComp(String maj)
	{
		this.compo=maj;
	}
	public String getComp()
	{
		return this.compo;
	}
	
	public void setEffet(String maj)
	{
		this.effet=maj;
	}
	public String getEffet()
	{
		return this.effet;
	}
	
	public void setContreInd(String maj)
	{
		this.contreInd=maj;
	}
	public String getContreInd()
	{
		return this.contreInd;
	}
	
	public void setPrx(String maj)
	{
		this.prixEch=maj;
	}
	public String getPrx()
	{
		return this.prixEch;
	}
	
	public void setFamLibelle(String maj)
	{
		this.famille_libelle=maj;
	}
	public String getFamLibelle()
	{
		return this.famille_libelle;
	}
}
