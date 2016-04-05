import javax.swing.Icon;

public class ImagesAndText {
	private String name;
	private Icon img;
	private String imgFile;
	public boolean isInserted;
	
	public String getImgFile() {
		return imgFile;
	}
	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
	public ImagesAndText(String text, Icon icon, String imgFile, boolean isInserted)
	{
		this.name = text;
		this.img = icon;
		this.imgFile = imgFile;
		this.isInserted = isInserted;
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
