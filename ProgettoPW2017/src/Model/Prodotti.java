
package Model;

/**
 * Gestione dei prodotti e di tutte le loro informazioni
 */
public class Prodotti
{

	private String codice;
	private String prodCol;
	private String prodTag;
	private String disp;
	private String sesso;
	private Double prezzo;
	private String nome;
	private String nomeImg;

	// codice
	public String getCodice()
	{
		return codice;
	}

	public void setCodice(String codice)
	{
		this.codice = codice;
	}

	// COLORE PRODOTTO
	public String getProdCol()
	{
		return prodCol;
	}

	public void setProdCol(String prodCol)
	{
		this.prodCol = prodCol;
	}

	// codice PRODOTTO
	public String getProdTag()
	{
		return prodTag;
	}

	public void setProdTag(String protTag)
	{
		this.prodTag = protTag;
	}

	// NUMERO dispONIBILITA'
	public String getDisp()
	{
		return disp;
	}

	public void setDisp(String disp)
	{
		this.disp = disp;
	}

	// sesso SCARPA
	public String getSesso()
	{
		return sesso;
	}

	public void setSesso(String sesso)
	{
		this.sesso = sesso;
	}

	// nome SCARPA
	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	// nome IMMAG
	public String getNomeI()
	{
		return nomeImg;
	}

	public void setNomeI(String nomeimg)
	{
		this.nomeImg = nomeimg;
	}

	public Double getPrezzo()
	{
		return prezzo;
	}

	public void setPrezzo(Double prezzo)
	{
		this.prezzo = prezzo;
	}
	
	public String toString()
	{
		return "Prodotti [codice=" + codice + ", prodCol=" + prodCol + ", prodTag=" + prodTag + "]";
	}
}
