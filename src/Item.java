
public class Item {
	private float price;
	private int age;
	private String city;
	private String companyName;
	private float weight;
	private boolean sold;
	private float revisedPrice;
	private float negoPrice;
	private String details;	
	private String imageFile;
	private Category category;
	private String buyerId;
	private String UploaderId;
	
	public Item()
	{
		category = new Category();
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public float getRevisedPrice() {
		return revisedPrice;
	}
	public void setRevisedPrice(float revisedPrice) {
		this.revisedPrice = revisedPrice;
	}
	public float getNegoPrice() {
		return negoPrice;
	}
	public void setNegoPrice(float negoPrice) {
		this.negoPrice = negoPrice;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public String getUploaderId() {
		return UploaderId;
	}

	public void setUploaderId(String uploaderId) {
		UploaderId = uploaderId;
	}
	
	
	
}
