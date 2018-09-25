/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recuperacio.setembre.lluc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author llucn
 */

public class Registre {
    
    String Observacions;
    Float Latitud, Longitud,Velocitat;
    Integer direccio,profunditat;
    private final Date data;
//mètode constructor que servirà per comporvar que les dades estan correctament introduides
    public Registre(String Latitud, String Longitud, String Velocitat, String Direccio, String Profunditat, String Observacions) throws RegistreException {

        try {
            this.Latitud=Float.parseFloat(Latitud);
         } catch (NumberFormatException e) {
             throw new RegistreException("error de tipo de dada,latitud");
         }
        try {
           this.Longitud= Float.parseFloat(Longitud);
         } catch (NumberFormatException e) {
             throw new RegistreException("error de tipo de dada,longitud");
         }
         try {
            this.Velocitat= Float.parseFloat(Velocitat);
         } catch (NumberFormatException e) {
             throw new RegistreException("error de tipo de dada,velocitat");
         }
        data = new Date();
//        this.Longitud = Longitud;
//        this.Velocitat = Velocitat;
            try {
                this.direccio = Integer.parseInt(Direccio);
                if ((this.direccio > 360) || (this.direccio <=0)) {
                    throw new RegistreException("valor incorrecte");
                }
            } catch (NumberFormatException e) {
                throw new RegistreException("error de tipo de dada,direccio");
            }
            try {
                this.profunditat = Integer.parseInt(Profunditat);
                
                
            } catch (NumberFormatException e) {
                throw new RegistreException("error de tipo de dada,prfunditat");
            }
            
//        this.Profunditat = Profunditat;
        
        this.Observacions = Observacions;
    }
    
    
//conjunt de metodes get per obtenir les dades introduides per l'usuari i per obtenir l'hora quan es du a terme l'acció
    
    
    public String getLatitud() {
        return Latitud.toString();
    }

    public String getLongitud() {
        return Longitud.toString();
    }

    public String getVelocitat() {
        return Velocitat.toString();
    }

    public String getDireccio() {
        return direccio.toString();
    }
    
    public String getProfunditat() {
        return profunditat.toString();
    }

    public String getObservacions() {
        return Observacions;
    }

    public String Obtenirhora(){
        DateFormat hourFormat = new SimpleDateFormat("HH:mm");
        return hourFormat.format(data);
    }
    
    public String Obtenirdia(){
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return hourdateFormat.format(data);
    }
    
    // clase creada per trectar les excepcions que es poden crear al introduir les dades incorrectament
    public class RegistreException extends Exception {
        private final String msg;
        public RegistreException(String msg){
            super();
            this.msg = msg;
        }
        @Override
        public String getMessage() {
            return msg;
        }
    }
 
    }  
