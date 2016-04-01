
public class Manager extends User{
	private String gender;
	private String dateOfBirth;
	private String address;
	private String biometricID;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBiometricID() {
		return biometricID;
	}
	public void setBiometricID(String biometricID) {
		this.biometricID = biometricID;
	}
	public Manager()
	{
		
	}
}
