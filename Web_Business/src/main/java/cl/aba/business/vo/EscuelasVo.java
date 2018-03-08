package cl.aba.business.vo;

import java.math.BigDecimal;
import java.util.Date;

import cl.aba.validar.ValorDouble;
import cl.aba.validar.ValorFecha;

public class EscuelasVo implements java.io.Serializable {
	
	private static final long serialVersionUID = -5966195198145043553L;
	private Integer concursoId;
	private Integer rbdId;
	private Long rbd;
	private String anexo;
	private String concurso;
	private String nombreEES;
	private String direccion;
	private Long matricula;
	private String comuna;
	private String region;
	private String subEstadoAdjudicado;
	private String estadoConectado;
	private String estadoMineduc;
	private String tecnologia;
	private String operadora;
	private String precioMensual;
	private String velocidadBajada;
	private String velocidadSubida;
	private String fechaFAS;
	
	public EscuelasVo() {
		super();
	}

	public EscuelasVo(Integer concursoId, Integer rbdId, Long rbd, String anexo, String concurso, String nombreEES,
			String direccion, Long matricula, String comuna, String region, String subEstadoAdjudicado,
			String estadoConectado, String estadoMineduc, String tecnologia, String operadora, BigDecimal precioMensual,
			BigDecimal velocidadBajada, BigDecimal velocidadSubida, Date fechaFAS) {
		super();
		this.concursoId = concursoId;
		this.rbdId = rbdId;
		this.rbd = rbd;
		this.anexo = anexo;
		this.concurso = concurso;
		this.nombreEES = nombreEES;
		this.direccion = direccion;
		this.matricula = matricula;
		this.comuna = comuna;
		this.region = region;
		this.subEstadoAdjudicado = subEstadoAdjudicado;
		this.estadoConectado = estadoConectado;
		this.estadoMineduc = estadoMineduc;
		this.tecnologia = tecnologia;
		this.operadora = operadora;
		ValorDouble val = new ValorDouble(precioMensual,"$ ###,###.###");
		this.precioMensual = val.getValorDecimal();
		val = new ValorDouble(velocidadBajada,"###,###.###");
		this.velocidadBajada = val.getValorDecimal();
		val = new ValorDouble(velocidadSubida,"###,###.###");
		this.velocidadSubida = val.getValorDecimal();
		ValorFecha vf = null;
		if(fechaFAS != null){
			vf = new ValorFecha(fechaFAS, "yyyy-MM-dd");
			this.fechaFAS = vf.getFechaString();
		}else{
			this.fechaFAS = "";
		}
		
	}





	public Integer getConcursoId() {
		return concursoId;
	}

	public void setConcursoId(Integer concursoId) {
		this.concursoId = concursoId;
	}

	public Integer getRbdId() {
		return rbdId;
	}

	public void setRbdId(Integer rbdId) {
		this.rbdId = rbdId;
	}

	public Long getRbd() {
		return rbd;
	}

	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public String getNombreEES() {
		return nombreEES;
	}

	public void setNombreEES(String nombreEES) {
		this.nombreEES = nombreEES;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSubEstadoAdjudicado() {
		return subEstadoAdjudicado;
	}

	public void setSubEstadoAdjudicado(String subEstadoAdjudicado) {
		this.subEstadoAdjudicado = subEstadoAdjudicado;
	}

	public String getEstadoConectado() {
		return estadoConectado;
	}

	public void setEstadoConectado(String estadoConectado) {
		this.estadoConectado = estadoConectado;
	}

	public String getEstadoMineduc() {
		return estadoMineduc;
	}

	public void setEstadoMineduc(String estadoMineduc) {
		this.estadoMineduc = estadoMineduc;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(String precioMensual) {
		this.precioMensual = precioMensual;
	}

	public String getVelocidadBajada() {
		return velocidadBajada;
	}

	public void setVelocidadBajada(String velocidadBajada) {
		this.velocidadBajada = velocidadBajada;
	}

	public String getVelocidadSubida() {
		return velocidadSubida;
	}

	public void setVelocidadSubida(String velocidadSubida) {
		this.velocidadSubida = velocidadSubida;
	}

	public String getFechaFAS() {
		return fechaFAS;
	}

	public void setFechaFAS(String fechaFAS) {
		this.fechaFAS = fechaFAS;
	}
}
