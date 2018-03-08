package cl.aba.model.web.common;
// Generated 27-04-2017 11:06:14 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Regiones generated by hbm2java
 */
public class Regiones  implements java.io.Serializable {


     private int regionId;
     private String nombreRegionTx;
     private String numeroRegionTx;
     private Set comunases = new HashSet(0);

    public Regiones() {
    }

	
    public Regiones(int regionId) {
        this.regionId = regionId;
    }
    public Regiones(int regionId, String nombreRegionTx, String numeroRegionTx, Set comunases) {
       this.regionId = regionId;
       this.nombreRegionTx = nombreRegionTx;
       this.numeroRegionTx = numeroRegionTx;
       this.comunases = comunases;
    }
   
    public int getRegionId() {
        return this.regionId;
    }
    
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
    public String getNombreRegionTx() {
        return this.nombreRegionTx;
    }
    
    public void setNombreRegionTx(String nombreRegionTx) {
        this.nombreRegionTx = nombreRegionTx;
    }
    public String getNumeroRegionTx() {
        return this.numeroRegionTx;
    }
    
    public void setNumeroRegionTx(String numeroRegionTx) {
        this.numeroRegionTx = numeroRegionTx;
    }
    public Set getComunases() {
        return this.comunases;
    }
    
    public void setComunases(Set comunases) {
        this.comunases = comunases;
    }




}

