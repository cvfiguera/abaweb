package cl.aba.model.web.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import cl.aba.model.web.common.Contactos;

@Repository
public class ContactosDaoImpl extends HibernateWeb implements ContactosDao {

	@Override
	public List<Contactos> getContactos(int rbdId) {
		
		String hql = "FROM Contactos WHERE"
				+ " rbd.rbdId = " + rbdId + " AND fechaBaja IS NULL";
		
		return (List<Contactos>)(List)getObjectListHql(new Contactos(), hql);
	}

	@Override
	public List<Contactos> getContactosAll(int rbdId) {
		
		String hql = "FROM Contactos WHERE"
				+ " rbd.rbdId = " + rbdId;
		
		return (List<Contactos>)(List)getObjectListHql(new Contactos(), hql);
		
	}
}
