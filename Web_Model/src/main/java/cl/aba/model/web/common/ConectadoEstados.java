package cl.aba.model.web.common;
// Generated 27-04-2017 11:06:14 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * ConectadoEstados generated by hbm2java
 */
public class ConectadoEstados  implements java.io.Serializable {


     private int conectadoEstadoId;
     private String conectadoEstadoTx;
     private Set rbdEstadoses = new HashSet(0);

    public ConectadoEstados() {
    }

	
    public ConectadoEstados(int conectadoEstadoId) {
        this.conectadoEstadoId = conectadoEstadoId;
    }
    public ConectadoEstados(int conectadoEstadoId, String conectadoEstadoTx, Set rbdEstadoses) {
       this.conectadoEstadoId = conectadoEstadoId;
       this.conectadoEstadoTx = conectadoEstadoTx;
       this.rbdEstadoses = rbdEstadoses;
    }
   
    public int getConectadoEstadoId() {
        return this.conectadoEstadoId;
    }
    
    public void setConectadoEstadoId(int conectadoEstadoId) {
        this.conectadoEstadoId = conectadoEstadoId;
    }
    public String getConectadoEstadoTx() {
        return this.conectadoEstadoTx;
    }
    
    public void setConectadoEstadoTx(String conectadoEstadoTx) {
        this.conectadoEstadoTx = conectadoEstadoTx;
    }
    public Set getRbdEstadoses() {
        return this.rbdEstadoses;
    }
    
    public void setRbdEstadoses(Set rbdEstadoses) {
        this.rbdEstadoses = rbdEstadoses;
    }




}


