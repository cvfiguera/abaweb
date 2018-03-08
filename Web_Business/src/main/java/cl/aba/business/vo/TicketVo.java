package cl.aba.business.vo;

import java.util.Date;

import cl.aba.validar.ValorFecha;

public class TicketVo implements java.io.Serializable {

	private static final long serialVersionUID = -5806976526685332778L;
	private int nroTicketCallCenter;
	private Long rbd;
	private String concurso;
	private String anexo;
	private String estadoEES;
	private String nombreEstablecimiento;
	private String region;
	private String comuna;
	private String operadora;
	private String origen;
	private Boolean generaWF;
	private Boolean escalable;
	private String estado;
	private String tipo;
	private String categoria;
	private String escalarA;
	private String nroTicketEscalado;
	private Boolean generadoOperadora;
	private String fechaAtencion;
	private String fechaEscalado;
	private String fechaCambioEstado;
	private String tecnologia;
	private String motivo;
	private String comentario;
	
	public TicketVo() {
		super();
	}

	public TicketVo(int nroTicketCallCenter, Long rbd, String concurso, String anexo, String estadoEES,
			String nombreEstablecimiento, String region, String comuna, String operadora, String origen,
			Boolean generaWF, Boolean escalable, String estado, String tipo, String categoria, String escalarA,
			String nroTicketEscalado, Boolean generadoOperadora, Date fechaAtencion, Date fechaEscalado,
			Date fechaCambioEstado, String tecnologia, String motivo, String comentario) {
		super();
		this.nroTicketCallCenter = nroTicketCallCenter;
		this.rbd = rbd;
		this.concurso = concurso;
		this.anexo = anexo;
		this.estadoEES = estadoEES;
		this.nombreEstablecimiento = nombreEstablecimiento;
		this.region = region;
		this.comuna = comuna;
		this.operadora = operadora;
		this.origen = origen;
		this.generaWF = generaWF;
		this.escalable = escalable;
		this.estado = estado;
		this.tipo = tipo;
		this.categoria = categoria;
		this.escalarA = escalarA;
		this.nroTicketEscalado = nroTicketEscalado;
		this.generadoOperadora = generadoOperadora;
		ValorFecha vf = new ValorFecha(fechaAtencion,"yyyy-MM-dd");
		this.fechaAtencion = vf.getFechaString();
		vf = new ValorFecha(fechaEscalado,"yyyy-MM-dd");
		this.fechaEscalado = vf.getFechaString();
		vf = new ValorFecha(fechaCambioEstado,"yyyy-MM-dd");
		this.fechaCambioEstado = vf.getFechaString();
		this.tecnologia = tecnologia;
		this.motivo = motivo;
		this.comentario = comentario;
	}

	public int getNroTicketCallCenter() {
		return nroTicketCallCenter;
	}

	public void setNroTicketCallCenter(int nroTicketCallCenter) {
		this.nroTicketCallCenter = nroTicketCallCenter;
	}

	public Long getRbd() {
		return rbd;
	}

	public void setRbd(Long rbd) {
		this.rbd = rbd;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public String getEstadoEES() {
		return estadoEES;
	}

	public void setEstadoEES(String estadoEES) {
		this.estadoEES = estadoEES;
	}

	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Boolean getGeneraWF() {
		return generaWF;
	}

	public void setGeneraWF(Boolean generaWF) {
		this.generaWF = generaWF;
	}

	public Boolean getEscalable() {
		return escalable;
	}

	public void setEscalable(Boolean escalable) {
		this.escalable = escalable;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getEscalarA() {
		return escalarA;
	}

	public void setEscalarA(String escalarA) {
		this.escalarA = escalarA;
	}

	public String getNroTicketEscalado() {
		return nroTicketEscalado;
	}

	public void setNroTicketEscalado(String nroTicketEscalado) {
		this.nroTicketEscalado = nroTicketEscalado;
	}

	public Boolean getGeneradoOperadora() {
		return generadoOperadora;
	}

	public void setGeneradoOperadora(Boolean generadoOperadora) {
		this.generadoOperadora = generadoOperadora;
	}

	public String getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getFechaEscalado() {
		return fechaEscalado;
	}

	public void setFechaEscalado(String fechaEscalado) {
		this.fechaEscalado = fechaEscalado;
	}

	public String getFechaCambioEstado() {
		return fechaCambioEstado;
	}

	public void setFechaCambioEstado(String fechaCambioEstado) {
		this.fechaCambioEstado = fechaCambioEstado;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
