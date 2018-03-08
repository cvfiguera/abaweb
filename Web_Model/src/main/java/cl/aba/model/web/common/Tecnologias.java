package cl.aba.model.web.common;
// Generated 27-04-2017 11:06:14 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Tecnologias generated by hbm2java
 */
public class Tecnologias  implements java.io.Serializable {


     private int tecnologiaId;
     private String nombreTx;
     private String observacionTx;
     private Set listaEsperas = new HashSet(0);
     private Set adjudicacioneses = new HashSet(0);
     private Set instalacioneses = new HashSet(0);

    public Tecnologias() {
    }

	
    public Tecnologias(int tecnologiaId) {
        this.tecnologiaId = tecnologiaId;
    }
    public Tecnologias(int tecnologiaId, String nombreTx, String observacionTx, Set listaEsperas, Set adjudicacioneses, Set instalacioneses) {
       this.tecnologiaId = tecnologiaId;
       this.nombreTx = nombreTx;
       this.observacionTx = observacionTx;
       this.listaEsperas = listaEsperas;
       this.adjudicacioneses = adjudicacioneses;
       this.instalacioneses = instalacioneses;
    }
   
    public int getTecnologiaId() {
        return this.tecnologiaId;
    }
    
    public void setTecnologiaId(int tecnologiaId) {
        this.tecnologiaId = tecnologiaId;
    }
    public String getNombreTx() {
        return this.nombreTx;
    }
    
    public void setNombreTx(String nombreTx) {
        this.nombreTx = nombreTx;
    }
    public String getObservacionTx() {
        return this.observacionTx;
    }
    
    public void setObservacionTx(String observacionTx) {
        this.observacionTx = observacionTx;
    }
    public Set getListaEsperas() {
        return this.listaEsperas;
    }
    
    public void setListaEsperas(Set listaEsperas) {
        this.listaEsperas = listaEsperas;
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


