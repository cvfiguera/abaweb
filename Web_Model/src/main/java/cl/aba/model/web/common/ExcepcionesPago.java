package cl.aba.model.web.common;
// Generated 27-04-2017 11:06:14 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * ExcepcionesPago generated by hbm2java
 */
public class ExcepcionesPago  implements java.io.Serializable {


     private int excepcionPagoId;
     private RbdConcursos rbdConcursos;
     private Date fechaI;
     private Date fechaF;
     private String motivo;

    public ExcepcionesPago() {
    }

	
    public ExcepcionesPago(int excepcionPagoId) {
        this.excepcionPagoId = excepcionPagoId;
    }
    public ExcepcionesPago(int excepcionPagoId, RbdConcursos rbdConcursos, Date fechaI, Date fechaF, String motivo) {
       this.excepcionPagoId = excepcionPagoId;
       this.rbdConcursos = rbdConcursos;
       this.fechaI = fechaI;
       this.fechaF = fechaF;
       this.motivo = motivo;
    }
   
    public int getExcepcionPagoId() {
        return this.excepcionPagoId;
    }
    
    public void setExcepcionPagoId(int excepcionPagoId) {
        this.excepcionPagoId = excepcionPagoId;
    }
    public RbdConcursos getRbdConcursos() {
        return this.rbdConcursos;
    }
    
    public void setRbdConcursos(RbdConcursos rbdConcursos) {
        this.rbdConcursos = rbdConcursos;
    }
    public Date getFechaI() {
        return this.fechaI;
    }
    
    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }
    public Date getFechaF() {
        return this.fechaF;
    }
    
    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }
    public String getMotivo() {
        return this.motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }




}


