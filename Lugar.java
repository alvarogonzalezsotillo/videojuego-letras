import java.util.*;

/**
 * Write a description of class Lugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Lugar
{
    public class OrdenEjecutada{
        private Lugar _nuevoLugar;
        private String _mensaje;
        public OrdenEjecutada(Lugar nuevoLugar, String mensaje ){
            _nuevoLugar = nuevoLugar;
            _mensaje = mensaje;
        }
        
        public Lugar nuevoLugar(){
            return _nuevoLugar;
        }
        
        public String mensaje(){
            return _mensaje;
        }
    }
    
    /**
     * Cada vez que entremos a un lugar, pondremos su descripción en la pantalla como si
     * estuvieramos mirando. No olvides llamar el sitio con determinante antes (el/la panaderia/restaurante)
     */ 
    public String descripcion(){
        return "Estas en " + getClass().getName() + ", pero el programador aún no ha hecho nada interestante aquí";
    }
    /**
     * ja ja ja 
     */
    /**
     * Cada vez que se ejecute una orden, podremos cambiar de lugar (o no)
     */
    public OrdenEjecutada ejecutaOrden(String orden){
        if( orden.startsWith("ir") ){
            return new OrdenEjecutada( this, "Me gustaría ir allí, pero no sé de qué forma" );
        }
        else if( orden.startsWith( "coger" ) ){
            return new OrdenEjecutada( this, "Me gustaría coger esa cosa, pero no sé de qué forma" );
        }
        else if( orden.startsWith( "hablar" ) ){
            return new OrdenEjecutada( this, "Por más que lo intento, no me hace caso" );
        }
        else{
            return new OrdenEjecutada(this,"Al hacer '" + orden + "' no pasa nada");
        }
    }
    
    private static HashMap<String,String> _valoresDePartida = new HashMap<String,String>();
    
    public String getValorDePartida( String nombre, String valorInicial ){
        if( _valoresDePartida.containsKey(nombre) ){
            return _valoresDePartida.get(nombre);
        }
        else{
            return valorInicial;
        }
    }
    
    public void setValorDePartida( String nombre, String valor){
        _valoresDePartida.put(nombre,valor);
    }
    
    
}
