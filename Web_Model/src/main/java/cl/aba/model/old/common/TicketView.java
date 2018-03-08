package cl.aba.model.old.common;

import java.sql.Timestamp;
import java.util.Date;



public class TicketView implements java.io.Serializable {

	private static final long serialVersionUID = 518002903662420443L;
	private int nroTicketCallCenter;
	private Long rbd;
	private String anexo;
	private Integer estadoId;
	private String estadoEES;
	private String nombreEstablecimiento;
	private Integer codigoRegion;
	private String region;
	private Integer codigoComuna;
	private String comuna;
	private Integer codigoOperadora;
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
	private Timestamp fechaAtencion;
	private Timestamp fechaEscalado;
	private Date fechaCambioEstado;
	private Integer codigoTecnologia;
	private String tecnologia;
	private String motivo;
	private String comentario;
	
	public TicketView() {
		super();
	}

	public TicketView(int nroTicketCallCenter, Long rbd, String anexo, Integer estadoId, String estadoEES,
			String nombreEstablecimiento, Integer codigoRegion, String region, Integer codigoComuna, String comuna,
			Integer codigoOperadora, String operadora, String origen, Boolean generaWF, Boolean escalable,
			String estado, String tipo, String categoria, String escalarA, String nroTicketEscalado,
			Boolean generadoOperadora, Timestamp fechaAtencion, Timestamp fechaEscalado, Date fechaCambioEstado,
			Integer codigoTecnologia, String tecnologia, String motivo, String comentario) {
		super();
		this.nroTicketCallCenter = nroTicketCallCenter;
		this.rbd = rbd;
		this.anexo = anexo;
		this.estadoId = estadoId;
		this.estadoEES = estadoEES;
		this.nombreEstablecimiento = nombreEstablecimiento;
		this.codigoRegion = codigoRegion;
		this.region = region;
		this.codigoComuna = codigoComuna;
		this.comuna = comuna;
		this.codigoOperadora = codigoOperadora;
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
		this.fechaAtencion = fechaAtencion;
		this.fechaEscalado = fechaEscalado;
		this.fechaCambioEstado = fechaCambioEstado;
		this.codigoTecnologia = codigoTecnologia;
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

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
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

	public Integer getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(Integer codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getCodigoComuna() {
		return codigoComuna;
	}

	public void setCodigoComuna(Integer codigoComuna) {
		this.codigoComuna = codigoComuna;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public Integer getCodigoOperadora() {
		return codigoOperadora;
	}

	public void setCodigoOperadora(Integer codigoOperadora) {
		this.codigoOperadora = codigoOperadora;
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

	public Timestamp getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Timestamp fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public Timestamp getFechaEscalado() {
		return fechaEscalado;
	}

	public void setFechaEscalado(Timestamp fechaEscalado) {
		this.fechaEscalado = fechaEscalado;
	}

	public Date getFechaCambioEstado() {
		return fechaCambioEstado;
	}

	public void setFechaCambioEstado(Date fechaCambioEstado) {
		this.fechaCambioEstado = fechaCambioEstado;
	}

	public Integer getCodigoTecnologia() {
		return codigoTecnologia;
	}

	public void setCodigoTecnologia(Integer codigoTecnologia) {
		this.codigoTecnologia = codigoTecnologia;
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
