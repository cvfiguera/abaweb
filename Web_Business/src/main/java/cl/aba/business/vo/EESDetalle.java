package cl.aba.business.vo;

import java.util.List;

public class EESDetalle implements java.io.Serializable {

	private static final long serialVersionUID = -5767130133338527096L;
	private InstalacionVo instalacion;
	private AdjudicacionVo adjudicacion;
	private List<ListaEsperaVo> listaEspera;
	private List<TicketVo> listaTicket;
	private List<ContactoVo> contactos;
	
	public EESDetalle() {
		super();
	}

	public EESDetalle(InstalacionVo instalacion, AdjudicacionVo adjudicacion, List<ListaEsperaVo> listaEspera,
			List<TicketVo> listaTicket, List<ContactoVo> contactos) {
		super();
		this.instalacion = instalacion;
		this.adjudicacion = adjudicacion;
		this.listaEspera = listaEspera;
		this.listaTicket = listaTicket;
		this.contactos = contactos;
	}

	public InstalacionVo getInstalacion() {
		return instalacion;
	}

	public void setInstalacion(InstalacionVo instalacion) {
		this.instalacion = instalacion;
	}

	public AdjudicacionVo getAdjudicacion() {
		return adjudicacion;
	}

	public void setAdjudicacion(AdjudicacionVo adjudicacion) {
		this.adjudicacion = adjudicacion;
	}

	public List<ListaEsperaVo> getListaEspera() {
		return listaEspera;
	}

	public void setListaEspera(List<ListaEsperaVo> listaEspera) {
		this.listaEspera = listaEspera;
	}

	public List<TicketVo> getListaTicket() {
		return listaTicket;
	}

	public void setListaTicket(List<TicketVo> listaTicket) {
		this.listaTicket = listaTicket;
	}

	public List<ContactoVo> getContactos() {
		return contactos;
	}

	public void setContactos(List<ContactoVo> contactos) {
		this.contactos = contactos;
	}
}
