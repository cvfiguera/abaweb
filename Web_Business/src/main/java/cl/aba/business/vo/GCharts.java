package cl.aba.business.vo;

import java.util.List;

public class GCharts implements java.io.Serializable {

	private static final long serialVersionUID = -3398187447220053609L;
	private List<Columnas> cols;
	private List<Filas> rows;
	
	public GCharts() {
		super();
	}

	public List<Columnas> getCols() {
		return cols;
	}

	public void setCols(List<Columnas> cols) {
		this.cols = cols;
	}

	public List<Filas> getRows() {
		return rows;
	}

	public void setRows(List<Filas> rows) {
		this.rows = rows;
	}
}
