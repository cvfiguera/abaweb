 package cl.aba.business.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.aba.business.vo.Cells;
import cl.aba.business.vo.Columnas;
import cl.aba.business.vo.Filas;
import cl.aba.business.vo.GCharts;
import cl.aba.model.web.dao.GraficosDao;
import cl.aba.model.web.vo.GraficoVo;

@Service
public class GraficosServiceImpl implements GraficosService {

	@Autowired
	private GraficosDao graficosDao;
	
	@Override
	public GCharts getConsursoGrafico() {
		
		List<GraficoVo> graficos = graficosDao.getGraficoConcurso();
		GCharts graficoConcurso = new GCharts();
		List<Columnas> cols = new ArrayList<Columnas>();
		List<Filas> rows = new ArrayList<Filas>();
		
		cols.add(new Columnas(0, "Concurso", "string"));
		cols.add(new Columnas(1, "Cantidad Rbds", "number"));
		
		for(int i=0; i<graficos.size();i++) {
			GraficoVo grafico = graficos.get(i);
			List<Cells> celdas = new ArrayList<Cells>();
			celdas.add(new Cells(grafico.getId(), grafico.getNombre()));
			celdas.add(new Cells(grafico.getValor(), grafico.getValor()));
			rows.add(new Filas(celdas));
		}
		
		graficoConcurso.setCols(cols);
		graficoConcurso.setRows(rows);
		
		return graficoConcurso;
	}
	
	@Override
	public GCharts getAdjudicacionGrafico(Integer concursoId) {
		
		List<GraficoVo> graficos = graficosDao.getGraficoAdjudicaciones(concursoId);
		GCharts graficoAdj = new GCharts();
		List<Columnas> cols = new ArrayList<Columnas>();
		List<Filas> rows = new ArrayList<Filas>();
		
		cols.add(new Columnas(0, "Estado Adjudicación", "string"));
		cols.add(new Columnas(1, "Cantidad Rbds", "number"));
		
		for(int i=0; i<graficos.size();i++) {
			GraficoVo grafico = graficos.get(i);
			List<Cells> celdas = new ArrayList<Cells>();
			celdas.add(new Cells(grafico.getId(), grafico.getNombre()));
			celdas.add(new Cells(grafico.getValor(), grafico.getValor()));
			rows.add(new Filas(celdas));
		}
		
		graficoAdj.setCols(cols);
		graficoAdj.setRows(rows);
		
		return graficoAdj;
	}

	@Override
	public GCharts getMineducGrafico(Integer adjudicacionId, Integer concursoId) {
		
		List<GraficoVo> graficos = graficosDao.getGraficoMineduc(adjudicacionId,concursoId);
		GCharts graficoAdj = new GCharts();
		List<Columnas> cols = new ArrayList<Columnas>();
		List<Filas> rows = new ArrayList<Filas>();
		
		cols.add(new Columnas(0, "Estado Mineduc", "string"));
		cols.add(new Columnas(1, "Cantidad Rbds", "number"));
		
		for(int i=0; i<graficos.size();i++) {
			GraficoVo grafico = graficos.get(i);
			List<Cells> celdas = new ArrayList<Cells>();
			celdas.add(new Cells(grafico.getId(), grafico.getNombre()));
			celdas.add(new Cells(grafico.getValor(), grafico.getValor()));
			rows.add(new Filas(celdas));
		}
		
		graficoAdj.setCols(cols);
		graficoAdj.setRows(rows);
		
		return graficoAdj;
	}

	@Override
	public GCharts getInstalacionGrafico(Integer adjudicacionId, Integer mineducId, Integer concursoId) {

		List<GraficoVo> graficos = graficosDao.getGraficoInstalacion(adjudicacionId, mineducId, concursoId);
		GCharts graficoAdj = new GCharts();
		List<Columnas> cols = new ArrayList<Columnas>();
		List<Filas> rows = new ArrayList<Filas>();
		
		cols.add(new Columnas(0, "Estado Instalación", "string"));
		cols.add(new Columnas(1, "Cantidad Rbds", "number"));
		
		for(int i=0; i<graficos.size();i++) {
			GraficoVo grafico = graficos.get(i);
			List<Cells> celdas = new ArrayList<Cells>();
			celdas.add(new Cells(grafico.getId(), grafico.getNombre()));
			celdas.add(new Cells(grafico.getValor(), grafico.getValor()));
			rows.add(new Filas(celdas));
		}
		
		graficoAdj.setCols(cols);
		graficoAdj.setRows(rows);
		
		return graficoAdj;
	}

	@Override
	public GCharts getOperadoraGrafico(Integer adjudicacionId, Integer mineducId, Integer conectadoId, Integer concursoId) {
		
		List<GraficoVo> graficos = graficosDao.getGraficoOperadora(adjudicacionId, mineducId, conectadoId,concursoId);
		GCharts graficoAdj = new GCharts();
		List<Columnas> cols = new ArrayList<Columnas>();
		List<Filas> rows = new ArrayList<Filas>();
		
		cols.add(new Columnas(0, "Operadora", "string"));
		cols.add(new Columnas(1, "Cantidad Rbds", "number"));
		
		for(int i=0; i<graficos.size();i++) {
			GraficoVo grafico = graficos.get(i);
			List<Cells> celdas = new ArrayList<Cells>();
			celdas.add(new Cells(grafico.getId(), grafico.getNombre()));
			celdas.add(new Cells(grafico.getValor(), grafico.getValor()));
			rows.add(new Filas(celdas));
		}
		
		graficoAdj.setCols(cols);
		graficoAdj.setRows(rows);
		
		return graficoAdj;
	}

	@Override
	public GCharts getTecnologiaGrafico(Integer adjudicacionId, Integer mineducId, Integer conectadoId,
			Integer operadoraId,Integer concursoId) {
		System.out.println(concursoId);
		List<GraficoVo> graficos = graficosDao.getGraficoTecnologia(adjudicacionId, mineducId, conectadoId, operadoraId,concursoId);
		GCharts graficoAdj = new GCharts();
		List<Columnas> cols = new ArrayList<Columnas>();
		List<Filas> rows = new ArrayList<Filas>();
		
		cols.add(new Columnas(0, "Tecnología", "string"));
		cols.add(new Columnas(1, "Cantidad Rbds", "number"));
		
		for(int i=0; i<graficos.size();i++) {
			GraficoVo grafico = graficos.get(i);
			List<Cells> celdas = new ArrayList<Cells>();
			celdas.add(new Cells(grafico.getId(), grafico.getNombre()));
			celdas.add(new Cells(grafico.getValor(), grafico.getValor()));
			rows.add(new Filas(celdas));
		}
		
		graficoAdj.setCols(cols);
		graficoAdj.setRows(rows);
		
		return graficoAdj;
	}

	@Override
	public GCharts getRegionGrafico(Integer adjudicacionId, Integer mineducId, Integer conectadoId,
			Integer operadoraId, Integer tecnologiaId, Integer concursoId) {

		List<GraficoVo> graficos = graficosDao.getGraficoRegion(adjudicacionId, mineducId, conectadoId, operadoraId, tecnologiaId, concursoId);
		GCharts graficoAdj = new GCharts();
		List<Columnas> cols = new ArrayList<Columnas>();
		List<Filas> rows = new ArrayList<Filas>();
		
		cols.add(new Columnas(0, "Región", "string"));
		cols.add(new Columnas(1, "Cantidad Rbds", "number"));
		
		for(int i=0; i<graficos.size();i++) {
			GraficoVo grafico = graficos.get(i);
			List<Cells> celdas = new ArrayList<Cells>();
			celdas.add(new Cells(grafico.getId(), grafico.getNombre()));
			celdas.add(new Cells(grafico.getValor(), grafico.getValor()));
			rows.add(new Filas(celdas));
		}
		
		graficoAdj.setCols(cols);
		graficoAdj.setRows(rows);
		
		return graficoAdj;
	}

}
