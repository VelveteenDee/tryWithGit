package pojo;


public class PojoClass1 {
    private String email;
    private String password;

    PojoClass1() {}

    
    public PojoClass1(String email, String password) {
        this.email = email;
        this.password = password;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	 public String toString(){
         return "The email is " + this.email + " password is " + this.password ; 
 }

}
