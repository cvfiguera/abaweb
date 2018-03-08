package cl.aba.model.web.common;
// Generated 27-04-2017 11:06:14 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * RbdConcursos generated by hbm2java
 */
public class RbdConcursos  implements java.io.Serializable {


     private int rbdConcursoId;
     private Concursos concursos;
     private Rbd rbd;
     private String marcaParque;
     private Date fechaFin;
     private Set listaEsperas = new HashSet(0);
     private Set rbdEstadoses = new HashSet(0);
     private Set excepcionesPagos = new HashSet(0);
     private Set adjudicacioneses = new HashSet(0);
     private Set instalacioneses = new HashSet(0);

    public RbdConcursos() {
    }

	
    public RbdConcursos(int rbdConcursoId) {
        this.rbdConcursoId = rbdConcursoId;
    }
    public RbdConcursos(int rbdConcursoId, Concursos concursos, Rbd rbd, String marcaParque, Date fechaFin, Set listaEsperas, Set rbdEstadoses, Set excepcionesPagos, Set adjudicacioneses, Set instalacioneses) {
       this.rbdConcursoId = rbdConcursoId;
       this.concursos = concursos;
       this.rbd = rbd;
       this.marcaParque = marcaParque;
       this.fechaFin = fechaFin;
       this.listaEsperas = listaEsperas;
       this.rbdEstadoses = rbdEstadoses;
       this.excepcionesPagos = excepcionesPagos;
       this.adjudicacioneses = adjudicacioneses;
       this.instalacioneses = instalacioneses;
    }
   
    public int getRbdConcursoId() {
        return this.rbdConcursoId;
    }
    
    public void setRbdConcursoId(int rbdConcursoId) {
        this.rbdConcursoId = rbdConcursoId;
    }
    public Concursos getConcursos() {
        return this.concursos;
    }
    
    public void setConcursos(Concursos concursos) {
        this.concursos = concursos;
    }
    public Rbd getRbd() {
        return this.rbd;
    }
    
    public void setRbd(Rbd rbd) {
        this.rbd = rbd;
    }
    public String getMarcaParque() {
        return this.marcaParque;
    }
    
    public void setMarcaParque(String marcaParque) {
        this.marcaParque = marcaParque;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public Set getListaEsperas() {
        return this.listaEsperas;
    }
    
    public void setListaEsperas(Set listaEsperas) {
        this.listaEsperas = listaEsperas;
    }
    public Set getRbdEstadoses() {
        return this.rbdEstadoses;
    }
    
    public void setRbdEstadoses(Set rbdEstadoses) {
        this.rbdEstadoses = rbdEstadoses;
    }
    public Set getExcepcionesPagos() {
        return this.excepcionesPagos;
    }
    
    public void setExcepcionesPagos(Set excepcionesPagos) {
        this.excepcionesPagos = excepcionesPagos;
    }
    public Set getAdjudicacioneses() {
        return this.adjudicacioneses;
    }
    
    public void setAdjudicacioneses(Set adjudicacioneses) {
        this.adjudicacioneses = adjudicacioneses;
    }
    public Set getInstalacioneses() {
        return this.instalacioneses;
    }
    
    public void setInstalacioneses(Set instalacioneses) {
        this.instalacioneses = instalacioneses;
    }




}

