package cl.aba.model.web.dao;

import java.util.List;
import cl.aba.model.web.common.AdjudicadoEstados;
import cl.aba.model.web.common.Comunas;
import cl.aba.model.web.common.Concursos;
import cl.aba.model.web.common.ConectadoEstados;
import cl.aba.model.web.common.MineducEstados;
import cl.aba.model.web.common.Operadoras;
import cl.aba.model.web.common.Regiones;
import cl.aba.model.web.common.Tecnologias;

public interface FiltrosDao {
	
	public Concursos getConcurso(int concurso_id);
	
	public List<Concursos> getConcursos();

	public Operadoras getOperadora(int operadora_id);
	
	public List<Operadoras> getOperadorasAll();
	
	public Tecnologias getTecnologia(int tecnologia_id);
	
	public List<Tecnologias> getTecnologias();
	
	public AdjudicadoEstados getAdjudicado(int estado_id);
	
	public List<AdjudicadoEstados> getEstados();
	
	public List<AdjudicadoEstados> getSubEstados(int adjudicado);
	
	public MineducEstados getMineducEstados(int mineduc_id);

	public List<MineducEstados> getMineduc();
	
	public ConectadoEstados getConectadoEstado(int conectado_id);
	
	public List<ConectadoEstados> getConectados();
	
	public Comunas getComuna(int comuna_id);
	
	public List<Comunas> getComunas();
	
	public List<Comunas> getComunas(int reg);
	
	public Regiones getRegion(int region_id);
	
	public List<Regiones> getRegiones();
}
