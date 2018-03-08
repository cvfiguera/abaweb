package cl.aba.business.vo;

import java.util.List;

public class Filas implements java.io.Serializable {

	private static final long serialVersionUID = -7277746368219449239L;
	private List<Cells> c;
	
	public Filas() {
		super();
	}

	public Filas(List<Cells> c) {
		super();
		this.c = c;
	}

	public List<Cells> getC() {
		return c;
	}

	public void setC(List<Cells> c) {
		this.c = c;
	}
}
