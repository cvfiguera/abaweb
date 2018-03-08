package cl.aba.model.web.common;

import org.springframework.stereotype.Component;

@Component
public class QueryGraficos {
	
	public String sqlConcurso(){
		String sql = "select con.concurso_id as id , con.nombre as nombre, count(con.concurso_id) as valor ";
		sql += " from	web.rbd_concursos as rbd_c inner join ";
		sql += " web.concursos as con on con.concurso_id = rbd_c.concurso_id ";
		sql += " where 	con.fecha_termino is  null group by con.concurso_id, con.nombre";
		return sql;
	}
	
	public String sqlAdjudicado(Integer concursoId){
		String sql ="";
		sql +=" select  adjb.adj_adjudicado_estado_id as id , adjb.adjudicado_estado_tx as nombre, count(*) as valor ";
		sql +=" FROM web.rbd_estados est JOIN  ( SELECT rbd_estados.rbd_estado_id ";
		sql +=" FROM web.rbd_estados JOIN ( SELECT rbd_estados_1.rbd_concurso_id, max(rbd_estados_1.fecha_i) AS fecha_actualizacion  ";
		sql +=" FROM web.rbd_estados rbd_estados_1 GROUP BY rbd_estados_1.rbd_concurso_id  ) b ";
		sql +=" ON rbd_estados.rbd_concurso_id = b.rbd_concurso_id AND rbd_estados.fecha_i = b.fecha_actualizacion ) ";
		sql +=" estb ON estb.rbd_estado_id = est.rbd_estado_id  inner join web.adjudicado_estados as  adj ";
		sql +=" on adj.adjudicado_estado_id = est.adjudicado_id  inner join web.rbd_concursos  as rbd_c ";
		sql +=" on rbd_c.rbd_concurso_id = est.rbd_concurso_id  inner join ( select  adj.adj_adjudicado_estado_id, ";
		sql +=" adj.adjudicado_estado_tx  from  web.adjudicado_estados as adj  where adj.adj_adjudicado_estado_id = ";
		sql +=" adj.adjudicado_estado_id  ) as adjb on adjb.adj_adjudicado_estado_id =adj.adj_adjudicado_estado_id  ";
		sql +=" where rbd_c.concurso_id =" + concursoId;
		sql +=" group by adjb.adj_adjudicado_estado_id,adjb.adjudicado_estado_tx ";
		return sql;
	}
	
	public String  sqlMineduc(Integer concursoId, Integer adjudicadoId){
		String sql = "";
		sql +=" select  min.mineduc_estado_id as id, min.mineduc_estado_tx as nombre, count(min.mineduc_estado_id) as valor  ";
		sql +=" FROM web.rbd_estados est JOIN ";
		sql +=" ( SELECT rbd_estados.rbd_estado_id  FROM web.rbd_estados JOIN ";
		sql +=" ( SELECT rbd_estados_1.rbd_concurso_id,  max(rbd_estados_1.fecha_i) AS fecha_actualizacion ";
		sql +=" FROM web.rbd_estados rbd_estados_1  GROUP BY rbd_estados_1.rbd_concurso_id ";
		sql +=" ) b ON rbd_estados.rbd_concurso_id = b.rbd_concurso_id  AND rbd_estados.fecha_i = b.fecha_actualizacion ";
		sql +=" ) estb ON estb.rbd_estado_id = est.rbd_estado_id inner join web.adjudicado_estados as  adj ";
		sql +=" on adj.adjudicado_estado_id = est.adjudicado_id  inner join web.mineduc_estados as min  ";
		sql +=" on min.mineduc_estado_id = est.mineduc_id  inner join web.rbd_concursos  as rbd_c ";
		sql +=" on rbd_c.rbd_concurso_id = est.rbd_concurso_id  ";
		sql +=" where rbd_c.concurso_id = " + concursoId;
		sql +=" and adj.adj_adjudicado_estado_id =" + adjudicadoId;
		sql +=" group by min.mineduc_estado_id, min.mineduc_estado_tx";
		return sql;
	}
	
	public String sqlConectado(Integer concursoId, Integer adjudicadoId, Integer mineducId){
		String sql ="";
		sql +=" select  con.conectado_estado_id as id, ";
		sql +=" con.conectado_estado_tx as nombre,  ";
		sql +=" count(con.conectado_estado_id) as valor ";
		sql +=" FROM web.rbd_estados est JOIN   ";
		sql +=" ( SELECT rbd_estados.rbd_estado_id  FROM web.rbd_estados JOIN   ";
		sql +=" ( SELECT rbd_estados_1.rbd_concurso_id,  max(rbd_estados_1.fecha_i) AS fecha_actualizacion   ";
		sql +=" FROM web.rbd_estados rbd_estados_1  GROUP BY rbd_estados_1.rbd_concurso_id   ";
		sql +=" ) b ON rbd_estados.rbd_concurso_id = b.rbd_concurso_id  AND rbd_estados.fecha_i = b.fecha_actualizacion   ";
		sql +=" ) estb ON estb.rbd_estado_id = est.rbd_estado_id  ";
		sql +=" inner join web.adjudicado_estados as  adj  on adj.adjudicado_estado_id = est.adjudicado_id   ";
		sql +=" inner join web.mineduc_estados as min on min.mineduc_estado_id = est.mineduc_id ";
		sql +=" inner join web.conectado_estados as con on con.conectado_estado_id = est.conectado_id   ";
		sql +=" inner join web.rbd_concursos  as rbd_c on rbd_c.rbd_concurso_id = est.rbd_concurso_id   "; 
		sql +=" where rbd_c.concurso_id =" + concursoId;
		sql +=" and adj.adj_adjudicado_estado_id =" + adjudicadoId;
		sql +=" and min.mineduc_estado_id = " + mineducId;
		sql +=" group by con.conectado_estado_id,con.conectado_estado_tx ";
		return sql;
	}
	public String sqlOperadora(Integer concursoId, Integer adjudicadoId, Integer mineducId, Integer conectadoId){
		String sql ="";
		sql +=" SELECT  ope.operadora_id as id, ";
		sql +=" ope.nombre_social_tx as nombre, ";
		sql +=" count(*) as valor ";
		sql +=" FROM  web.rbd_estados as est inner join  ";
		sql +=" ( SELECT rbd_estados_1.rbd_concurso_id, max(rbd_estados_1.fecha_i) AS fecha_actualizacion    "; 
		sql +="   FROM web.rbd_estados rbd_estados_1  GROUP BY rbd_estados_1.rbd_concurso_id   ";
		sql +=" ) as rbd_a on rbd_a.rbd_concurso_id = est.rbd_concurso_id and est.fecha_i = rbd_a.fecha_actualizacion ";
		sql +=" inner join web.adjudicado_estados as adj on adj.adjudicado_estado_id = est.adjudicado_id ";
		sql +=" inner join web.rbd_concursos as rbd_c on rbd_c.rbd_concurso_id = est.rbd_concurso_id inner join  ";
		sql +=" ( web.instalaciones inst JOIN ( SELECT insta.instalacion_id ";
		sql +=" FROM web.instalaciones insta JOIN ( SELECT instalaciones_1.rbd_concurso_id, ";
		sql +=" max(instalaciones_1.fecha_alta_servicio_fe) AS fecha_fas ";
		sql +=" FROM web.instalaciones instalaciones_1 ";
		sql +=" GROUP BY instalaciones_1.rbd_concurso_id ";
		sql +=" ) fecha_max ON insta.rbd_concurso_id = fecha_max.rbd_concurso_id  ";
		sql +=" AND insta.fecha_alta_servicio_fe = fecha_max.fecha_fas ";
		sql +=" ) insta1 ON inst.instalacion_id = insta1.instalacion_id ";
		sql +=" )  on inst.rbd_concurso_id = rbd_c.rbd_concurso_id ";
		sql +=" inner join web.operadoras as ope on ope.operadora_id = inst.operadora_id ";
		sql +=" where rbd_c.concurso_id = " + concursoId;
		sql +=" and adj.adj_adjudicado_estado_id =" + adjudicadoId;
		sql +=" and est.conectado_id =" + conectadoId;
		sql +=" and est.mineduc_id = " + mineducId;
		sql +=" group by ope.operadora_id, ope.nombre_social_tx ";
		return sql;
	}
	
	public String sqlTecnologia(Integer concursoId, Integer adjudicadoId, Integer mineducId, Integer conectadoId, Integer operadoraId){
		String sql ="";
		sql +=" SELECT  tec.tecnologia_id as id, tec.nombre_tx as nombre, count(*) as valor ";
		sql +=" FROM  web.rbd_estados as est inner join ";
		sql +=" ( SELECT rbd_estados_1.rbd_concurso_id,  ";
		sql +=" max(rbd_estados_1.fecha_i) AS fecha_actualizacion    ";
		sql +=" FROM web.rbd_estados rbd_estados_1  GROUP BY rbd_estados_1.rbd_concurso_id  ";
		sql +=" ) as rbd_a on rbd_a.rbd_concurso_id = est.rbd_concurso_id and est.fecha_i = rbd_a.fecha_actualizacion";
		sql +=" inner join web.adjudicado_estados as adj on adj.adjudicado_estado_id = est.adjudicado_id";
		sql +=" inner join web.rbd_concursos as rbd_c on rbd_c.rbd_concurso_id = est.rbd_concurso_id inner join ";
		sql +=" ( web.instalaciones inst JOIN  ( SELECT insta.instalacion_id";
		sql +=" FROM web.instalaciones insta JOIN ";
		sql +=" ( SELECT instalaciones_1.rbd_concurso_id,";
		sql +=" max(instalaciones_1.fecha_alta_servicio_fe) AS fecha_fas";
		sql +=" FROM web.instalaciones instalaciones_1";
		sql +=" GROUP BY instalaciones_1.rbd_concurso_id";
		sql +=" ) fecha_max ON insta.rbd_concurso_id = fecha_max.rbd_concurso_id ";
		sql +=" AND insta.fecha_alta_servicio_fe = fecha_max.fecha_fas";
		sql +=" ) insta1 ON inst.instalacion_id = insta1.instalacion_id";
		sql +=" )  on inst.rbd_concurso_id = rbd_c.rbd_concurso_id";
		sql +=" inner join web.tecnologias as tec on tec.tecnologia_id = inst.tecnologia_id";
		sql +=" where rbd_c.concurso_id =" + concursoId;
		sql +=" and adj.adj_adjudicado_estado_id =" + adjudicadoId;
		sql +=" and est.conectado_id =" + conectadoId;
		sql +=" and est.mineduc_id =" + mineducId;
		sql +=" and inst.operadora_id =" + operadoraId;
		sql +=" group by tec.tecnologia_id, tec.nombre_tx";
		return sql;
	}
	
	public String sqlRegiones(Integer concursoId, Integer adjudicadoId, Integer mineducId, 
			Integer conectadoId, Integer operadoraId, Integer tecnologiaId){
		String sql ="";
		sql +=" SELECT reg.region_id as id, ";
		sql +=" reg.nombre_region_tx as nombre, ";
		sql +=" count(*) as valor";
		sql +=" FROM  web.rbd_estados as est inner join   ";
		sql +=" ( SELECT rbd_estados_1.rbd_concurso_id,   max(rbd_estados_1.fecha_i) AS fecha_actualizacion    "; 
		sql +=" FROM web.rbd_estados rbd_estados_1  GROUP BY rbd_estados_1.rbd_concurso_id   "; 
		sql +=" ) as rbd_a on rbd_a.rbd_concurso_id = est.rbd_concurso_id and est.fecha_i = rbd_a.fecha_actualizacion  ";
		sql +=" inner join web.adjudicado_estados as adj on adj.adjudicado_estado_id = est.adjudicado_id  ";
		sql +=" inner join web.rbd_concursos as rbd_c on rbd_c.rbd_concurso_id = est.rbd_concurso_id inner join   ";
		sql +=" ( web.instalaciones inst JOIN   ";
		sql +=" ( SELECT insta.instalacion_id FROM web.instalaciones insta JOIN   ";
		sql +=" ( SELECT instalaciones_1.rbd_concurso_id, max(instalaciones_1.fecha_alta_servicio_fe) AS fecha_fas  ";
		sql +=" FROM web.instalaciones instalaciones_1 GROUP BY instalaciones_1.rbd_concurso_id  ";
		sql +=" ) fecha_max ON insta.rbd_concurso_id = fecha_max.rbd_concurso_id   ";
		sql +=" AND insta.fecha_alta_servicio_fe = fecha_max.fecha_fas  ";
		sql +=" ) insta1 ON inst.instalacion_id = insta1.instalacion_id  ";
		sql +=" )  on inst.rbd_concurso_id = rbd_c.rbd_concurso_id  ";
		sql +=" inner join web.rbd as rbd on rbd.rbd_id = rbd_c.rbd_id ";
		sql +=" inner join web.comunas as com on com.comuna_id = rbd.comuna_id ";
		sql +=" inner join web.regiones as reg on com.region_id = reg.region_id ";
		sql +=" where rbd_c.concurso_id = " + concursoId;
		sql +=" and adj.adj_adjudicado_estado_id =" + adjudicadoId;
		sql +=" and est.conectado_id =  " + conectadoId;
		sql +=" and est.mineduc_id =" + mineducId;
		sql +=" and inst.operadora_id =" + operadoraId;
		sql +=" and inst.tecnologia_id=" + tecnologiaId;
		sql +=" group by reg.region_id , reg.nombre_region_tx ";
		return sql;
	}

}
