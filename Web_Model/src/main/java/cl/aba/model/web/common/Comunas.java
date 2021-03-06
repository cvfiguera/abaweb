package cl.aba.model.web.common;
// Generated 27-04-2017 11:06:14 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Comunas generated by hbm2java
 */
public class Comunas  implements java.io.Serializable {


     private int comunaId;
     private Regiones regiones;
     private String nombreComunaTx;
     private Integer numeroComuna;
     private Set rbds = new HashSet(0);

    public Comunas() {
    }

	
    public Comunas(int comunaId) {
        this.comunaId = comunaId;
    }
    public Comunas(int comunaId, Regiones regiones, String nombreComunaTx, Integer numeroComuna, Set rbds) {
       this.comunaId = comunaId;
       this.regiones = regiones;
       this.nombreComunaTx = nombreComunaTx;
       this.numeroComuna = numeroComuna;
       this.rbds = rbds;
    }
   
    public int getComunaId() {
        return this.comunaId;
    }
    
    public void setComunaId(int comunaId) {
        this.comunaId = comunaId;
    }
    public Regiones getRegiones() {
        return this.regiones;
    }
    
    public void setRegiones(Regiones regiones) {
        this.regiones = regiones;
    }
    public String getNombreComunaTx() {
        return this.nombreComunaTx;
    }
    
    public void setNombreComunaTx(String nombreComunaTx) {
        this.nombreComunaTx = nombreComunaTx;
    }
    public Integer getNumeroComuna() {
        return this.numeroComuna;
    }
    
    public void setNumeroComuna(Integer numeroComuna) {
        this.numeroComuna = numeroComuna;
    }
    public Set getRbds() {
        return this.rbds;
    }
    
    public void setRbds(Set rbds) {
        this.rbds = rbds;
    }




}


