package cl.aba.model.web.dao;

import java.util.List;

import cl.aba.model.web.common.Contactos;

public interface ContactosDao {

	public List<Contactos> getContactos(int rbdId);
	
	public List<Contactos> getContactosAll(int rbdId);
}
