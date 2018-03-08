package cl.aba.business.vo;

public class PerfilVO implements java.io.Serializable {

	private static final long serialVersionUID = -9045626373269296097L;
	private String name;
	private String lastname;
	private String email;
	private String org;
	private String pass;
	private String newpass;
	private String repass;
	
	public PerfilVO() {
		super();
	}

	public PerfilVO(String name, String lastname, String email, String org, String pass, String newpass,
			String repass) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.org = org;
		this.pass = pass;
		this.newpass = newpass;
		this.repass = repass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public String getRepass() {
		return repass;
	}

	public void setRepass(String repass) {
		this.repass = repass;
	}
}
