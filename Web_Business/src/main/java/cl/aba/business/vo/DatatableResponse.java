package cl.aba.business.vo;

import java.util.List;

public class DatatableResponse implements java.io.Serializable{

	private static final long serialVersionUID = -8469962303385765193L;
	private Integer draw;
	private Long recordsTotal;
	private Long recordsFiltered;
	private List<Object> data;
	
	public DatatableResponse() {
		super();
	}

	public DatatableResponse(Integer draw, Long recordsTotal, Long recordsFiltered, List<Object> data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<Object> getData() {
		return data;
	}

	public void setData(List<Object> data) {
		this.data = data;
	}

}
