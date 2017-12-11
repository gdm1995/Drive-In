package Model;

/**
 *	Gestione dei prodotti selezionati e di tutte le loro informazioni
*/
public class Selezionati
{
	private String User;
	private String ProdCol;
	private String ProdTag;
	private String Quantita;
	private String Codice;
	
	
	
	// Codice
	public String getCodice()
	{
		return Codice;
	}
	public void SetCodice(String codice)
	{
		this.Codice= codice;
	}
	
	
	//Username
	public String getUser()
	{
		return User;
	}
	public void SetUser(String User)
	{
		this.User= User;
	}
	
	//prodCol
	public String getProdCol()
	{
		return ProdCol;
	}
	public void setProdCol(String ProdCol)
	{
		this.ProdCol= ProdCol;
	}
	
	//PRODTAG
	public String getProdTag()
	{
		return ProdTag;
	}
	public void setProdTag(String ProdTag)
	{
		this.ProdTag= ProdTag;
	}
	
	
	// quantita
	
	public String getQuantita()
	{
		return Quantita;
	}
	public void setQuantita(String Quantita)
	{
		this.Quantita= Quantita;
	}
	
	public String toString()
	{
		return "Selezionati [User=" + User + ", ProdCol=" + ProdCol + ", ProdTag=" + ProdTag
				+ ", Quantita=" + Quantita + ", Codice=" + Codice + "]";
	}
	
	
}
