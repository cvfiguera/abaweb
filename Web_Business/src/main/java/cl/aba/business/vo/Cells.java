package cl.aba.business.vo;

public class Cells implements java.io.Serializable {

	private static final long serialVersionUID = -5423323590260572356L;
	private Object v;
	private Object f;
	
	public Cells() {
		super();
	}

	public Cells(Object v, Object f) {
		super();
		this.v = v;
		this.f = f;
	}

	public Object getV() {
		return v;
	}

	public void setV(Object v) {
		this.v = v;
	}

	public Object getF() {
		return f;
	}

	public void setF(Object f) {
		this.f = f;
	}	
}
