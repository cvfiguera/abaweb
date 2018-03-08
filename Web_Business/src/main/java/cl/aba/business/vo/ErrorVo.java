package cl.aba.business.vo;

public class ErrorVo implements java.io.Serializable {

	private static final long serialVersionUID = -374164019704648174L;
	private Integer code;
	private String description;
	
	public ErrorVo() {
		super();
	}

	public ErrorVo(Integer code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
