import java.util.Vector;

public class Customer extends User{
	private String city;
	public Vector<Item> itemsUploaded = null;
	public Vector<Item> itemsBought = null;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Customer() {
		itemsUploaded = new Vector<Item>();
		itemsBought = new Vector<Item>();
	}
	
}
