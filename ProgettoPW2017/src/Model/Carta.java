package Model;

/**
 *	Gestione delle carte e di tutte le loro informazioni
*/
public class Carta
{
	private String iban;
	private String cvv;
	private String expire;

	public Carta(String iban)
	{
		this.iban = iban;
	}
	
	public Carta(String iban, String cvv, String expire)
	{
		this.iban = iban;
		this.cvv = cvv;
		this.expire = expire;
	}
	public String getIban()
	{
		return iban;
	}
	public void setIban(String iban)
	{
		this.iban = iban;
	}
	public String getCvv()
	{
		return cvv;
	}
	public void setCvv(String cvv)
	{
		this.cvv = cvv;
	}
	public String getExpire()
	{
		return expire;
	}
	public void setExpire(String expire)
	{
		this.expire = expire;
	}
	
	public String toString() 
	{
		return "Carta [iban=" + iban + ", cvv=" + cvv + ", expire=" + expire + "]";
	}

}
