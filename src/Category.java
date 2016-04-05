
public class Category {
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isEmpty()
	{
		if(name == null)
			return true;		
		else
			return false;
	}
	
	public Category()
	{
		
	}
}
