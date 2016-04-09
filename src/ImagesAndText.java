import javax.swing.Icon;

public class ImagesAndText {
	private String name;
	private Icon img;
	private String itemId;
	public boolean isInserted;
	public float price;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public ImagesAndText(String text, Icon icon, String itemId, boolean isInserted, float price)
	{
		this.name = text;
		this.img = icon;
		this.itemId = itemId;
		this.isInserted = isInserted;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Icon getImg() {
		return img;
	}
	public void setImg(Icon img) {
		this.img = img;
	}
	
}
