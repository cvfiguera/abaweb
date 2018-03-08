package cl.aba.model.old.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import cl.aba.model.web.vo.Parametro;

@Transactional(value = "transactionManagerOld")
public class HibernateOld  extends HibernateDaoSupport {

	protected Logger log = Logger.getLogger(getClass().getName());
	
	@Autowired
	public void annyMethodName(@Qualifier("sessionFactoryOld") SessionFactory sessionFactory) {

		setSessionFactory(sessionFactory);
	}

	final protected void error(String message) {
		log.error(message);
	}

	final protected void error(String message, Throwable t) {
		log.error(message, t);
	}

	final protected void debug(String message) {
		log.error(message);
	}

	final protected void debug(String message, Throwable t) {
		log.error(message, t);
	}

	final protected void info(String message) {
		log.info(message);
	}
	

	public Object getObjectSqlUnique(Object object, String hql) {
		Object obj = null;
		Session session = null;
		if (object != null) {
			try {
				session = getHibernateTemplate().getSessionFactory().openSession();
				obj = session.createSQLQuery(hql).setResultTransformer(Transformers.aliasToBean(object.getClass()))
						.uniqueResult();
			} catch (Exception e) {
				error("Al intentar realizar la consulta " + hql, e);
			} finally {
				session.close();
			}
		} else {
			error("Objeto null al realizar la consulta");
		}

		return obj;
	}

	public Object getObjectListSql(Object object, String hql) {
		List<Object> list = null;
		info("Iniciando Conexion a Base datos 12");
		Session session = null;
		if (object != null) {
			try {
				session = getHibernateTemplate().getSessionFactory().openSession();
				list = session.createSQLQuery(hql).setResultTransformer(Transformers.aliasToBean(object.getClass()))
						.list();
			} catch (Exception e) {
				error("Al intentar realizar la consulta " + hql, e);
			} finally {
				session.close();
			}

		} else {
			error("Objeto null al realizar la consulta");
		}

		return list;
	}

	public void addObject(Object object) {
		Session session = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			session.save(object);
			session.flush();
			// session.beginTransaction().commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getObjectHqlUnique(Object object, String hql) {
		Object obj = null;
		Session session = null;
		if (object != null) {
			try {
				session = getHibernateTemplate().getSessionFactory().openSession();
				obj = session.createQuery(hql).uniqueResult();
			} catch (Exception e) {
				error("Al intentar realizar la consulta " + hql, e);
			} finally {
				session.close();
			}
		} else {
			error("Objeto null al realizar la consulta");
		}

		return obj;
	}
	
	public Object getObjectHqlUniqueParam(Object object, String hql, List<Parametro> params) {
		Object obj = null;
		Session session = null;
		Query query;
		
		if (object != null) {
			try {
				session = getHibernateTemplate().getSessionFactory().openSession();
				query = session.createQuery(hql);
				
				for (int i=0; i<params.size();i++) {
					Parametro param = params.get(i);
					
					if(param.getValor() instanceof List<?> && (param.getValor()!=null))
						query.setParameterList(param.getNombre(), (List<?>) param.getValor());
					else if(param.getValor() instanceof Date && (param.getValor()!=null))
						query.setTimestamp(param.getNombre(), (Date) param.getValor());
					else
						query.setParameter(param.getNombre(), param.getValor());
				}
				
				obj = query.uniqueResult();
				
			} catch (Exception e) {
				error("Al intentar realizar la consulta " + hql, e);
			} finally {
				session.close();
			}
		} else {
			error("Objeto null al realizar la consulta");
		}

		return obj;
	}

	public List<Object> getObjectListHqlWithParam(Object object, String hql, List<Parametro> params,
			Integer ini, Integer fin) {
		List<Object> list = null;
		Session session = null;
		Query query;
		
		if (object != null) {
			try {
				session = getHibernateTemplate().getSessionFactory().openSession();
				query = session.createQuery(hql);
				
				for (int i=0; i<params.size();i++) {
					Parametro param = params.get(i);
					
					if(param.getValor() instanceof List<?> && (param.getValor()!=null))
						query.setParameterList(param.getNombre(), (List<?>) param.getValor());
					else if(param.getValor() instanceof Date)
						query.setTimestamp(param.getNombre(), (Date) param.getValor());
					else
						query.setParameter(param.getNombre(), param.getValor());
				}
				
				if ((ini != null) && (fin !=null))
					list = query.setFirstResult(ini).setMaxResults(fin).list();
				else
					list = query.list();
				
			} catch (Exception e) {
				error("Al intentar realizar la consulta " + hql + " " + e.getMessage() + " Cause " + e.getCause());
			} finally {
				session.close();
			}

		} else {
			error("Objeto nulo, no se ha realizado la consulta -> " + hql);
		}

		return list;
	}
	
	public List<Object> getObjectListHql(Object object, String hql) {
		List<Object> list = null;
		Session session = null;
		if (object != null) {
			try {
				session = getHibernateTemplate().getSessionFactory().openSession();
				list = session.createQuery(hql).list();
			} catch (Exception e) {
				error("Al intentar realizar la consulta " + hql + " " + e.getMessage() + " Cause " + e.getCause());
			} finally {
				session.close();
			}

		} else {
			error("Objeto nulo, no se ha realizado la consulta -> " + hql);
		}

		return list;
	}

	public List<Object> getObjectListHqlTrans(Object object, String hql) {
		List<Object> list = null;
		Session session = null;
		if (object != null) {
			try {
				session = getHibernateTemplate().getSessionFactory().openSession();
				list = session.createQuery(hql).setResultTransformer(Transformers.aliasToBean(object.getClass())).list();
			} catch (Exception e) {
				error("Al intentar realizar la consulta " + hql + " " + e.getMessage() + " Cause " + e.getCause());
			} finally {
				session.close();
			}

		} else {
			error("Objeto nulo, no se ha realizado la consulta -> " + hql);
		}

		return list;
	}
	
	public List<Object> getObjectListHqlRange(Object object, String hql, Integer ini,
			Integer fin) {
		List<Object> list = null;
		Session session = null;
		if (object != null) {
			try {
				session = getHibernateTemplate().getSessionFactory().openSession();
				list = session.createQuery(hql).setFirstResult(ini).setMaxResults(fin).list();
			} catch (Exception e) {
				error("Al intentar realizar la consulta " + hql + " " + e.getMessage() + " Cause " + e.getCause());
			} finally {
				session.close();
			}

		} else {
			error("Objeto nulo, no se ha realizado la consulta -> " + hql);
		}

		return list;
	}
	
	public void addObjectList(List<Object> list) {
		Session session = null;
		Transaction tx = null;
		try {
			session = getHibernateTemplate().getSessionFactory().openSession();
			for (int i = 0; i < list.size(); i++) {
				Object obj = new Object();
				obj = list.get(i);
				session.save(obj);

				session.flush();
				session.clear();
			}
		} catch (Exception e) {
			error(" Problemas en hibernate");
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
