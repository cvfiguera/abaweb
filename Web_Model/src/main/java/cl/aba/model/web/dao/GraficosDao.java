package cl.aba.model.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cl.aba.model.web.vo.GraficoVo;

@Repository
public interface GraficosDao {
	
	public List<GraficoVo> getGraficoConcurso();
	
	public List<GraficoVo> getGraficoAdjudicaciones(Integer concursoId);
	
	public List<GraficoVo> getGraficoMineduc(Integer adjudicacionId, Integer concursoId);
	
	public List<GraficoVo> getGraficoInstalacion(Integer adjudicacionId, Integer mineducId, Integer concursoId);
	
	public List<GraficoVo> getGraficoOperadora(Integer adjudicacionId, Integer mineducId,Integer conectadoId, Integer concursoId);
	
	public List<GraficoVo> getGraficoTecnologia(Integer adjudicacionId, Integer mineducId,
			Integer conectadoId, Integer operadoraId, Integer concursoId);

	public List<GraficoVo> getGraficoRegion(Integer adjudicacionId, Integer mineducId,
			Integer conectadoId, Integer operadoraId, Integer tecnologiaId, Integer concursoId);
}
