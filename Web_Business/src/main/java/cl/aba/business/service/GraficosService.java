package cl.aba.business.service;

import cl.aba.business.vo.GCharts;

public interface GraficosService {
	
	public GCharts getConsursoGrafico();

	public GCharts getAdjudicacionGrafico(Integer concursoId);
	
	public GCharts getMineducGrafico(Integer adjudicacionId, Integer concursoId);
	
	public GCharts getInstalacionGrafico(Integer adjudicacionId, Integer mineducId, Integer concursoId);
	
	public GCharts getOperadoraGrafico(Integer adjudicacionId, Integer mineducId, Integer conectadoId, Integer concursoId);
	
	public GCharts getTecnologiaGrafico(Integer adjudicacionId, Integer mineducId, 
			Integer conectadoId, Integer operadoraId, Integer concursoId);
	
	public GCharts getRegionGrafico(Integer adjudicacionId, Integer mineducId, 
			Integer conectadoId, Integer operadoraId, Integer tecnologiaId, Integer concursoId);
}
