public class BienImmobilier{
	private double prix;
	private String description;
	private String contact;

	BienImmobilier(double prix, String description, String contact){
		this.prix = prix;
		this.description = description;
		this.contact = contact;
	}

	public double getPrix(){
		return prix;
	}
	public String getdescription(){
		return description;
	}
	public String getcontact(){
		return contact;
	}

	public String toString(){
		return "prix : " + prix + " description : " + description + " contact : " + contact;
	}
}