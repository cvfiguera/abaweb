package cl.aba.business.vo;

import java.util.Date;

public class ContactoVo implements java.io.Serializable {

	private static final long serialVersionUID = 1385052344511530265L;
	private Integer contactoId;
	private Long rbd;
	private String nombre;
	private String cargo;
	private String fono1;
	private String fono2;
	private String mail;
	private Date fechaBaja;
	
	public ContactoVo() {
		super();
	}

	public ContactoVo(Integer contactoId, Long rbd, String nombre, String cargo, String fono1, String fono2,
			String mail, Date fechaBaja) {
		super();
		this.contactoId = contactoId;
		this.rbd = rbd;
		this.nombre = nombre;
		this.cargo = cargo;
		this.fono1 = fono1;
		this.fono2 = fono2;
		this.mail = mail;
		this.fechaBaja = fechaBaja;
	}

	public Integer getContactoId() {
		return contactoId;
	}

	public void setContactoId(Integer contactoId) {
		this.contactoId = contactoId;
	}

	public Long getRbd() {
		return rbd;
	}

	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFono1() {
		return fono1;
	}

	public void setFono1(String fono1) {
		this.fono1 = fono1;
	}

	public String getFono2() {
		return fono2;
	}

	public void setFono2(String fono2) {
		this.fono2 = fono2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
}
