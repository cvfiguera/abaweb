package cl.aba.business.vo;

import java.util.List;

public class DatatableOptions implements java.io.Serializable {

	private static final long serialVersionUID = -4929046452668544348L;
	Integer draw;
	Integer start;
	Integer length;
	List<String> columns;
	Integer sortColumn;
	String sortDir;
	
	public DatatableOptions() {
		super();
	}

	public DatatableOptions(Integer draw, Integer start, Integer length, List<String> columns, Integer sortColumn,
			String sortDir) {
		super();
		this.draw = draw;
		this.start = start;
		this.length = length;
		this.columns = columns;
		this.sortColumn = sortColumn;
		this.sortDir = sortDir;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public Integer getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(Integer sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortDir() {
		return sortDir;
	}

	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}

}
