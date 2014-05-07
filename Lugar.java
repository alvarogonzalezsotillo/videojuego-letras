import java.util.*;

/**
 * Write a description of class Lugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Lugar
{
    
    /**
     * Cuando el lugar ejecuta una orden, devuelve una orden ejecutada, que contiene
     * el nuevo lugar al que se viaja y un mensaje que ha provocado la nueva orden
     */
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
        if( orden.equals( "acabar el juego" ) ){
            Escribidor.escribe( "Aún no se guarda el juego, tendrás que volver a empezar luego.\nAdiós." );
            System.exit(0);
        }
        if( orden.equals( "ayuda" ) ){
            return new OrdenEjecutada( this, "Tú escribe cosas, a ver qué pasa" );
        }
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
 
    /**
     * Todo lo que un lugar debe saber estará guardado en ValorDePartida. Tiene que tener un nombre para
     * poder identificarlo (por ejemplo, "Habitacion23.luzEncendida") y un valor inicial en el juego (por
     * ejemplo, "si")
     * Cuando se grave una partida, se guardarán todos los ValorDePartida y el lugar donde esté el personaje
     */
    public static class ValorDePartida{
        private String _nombre;
        private String _valorInicial;
        
        public ValorDePartida( String n, String vi ){
            _nombre = n;
            _valorInicial = vi;
        }
        
        public String get(){
            if( _valoresDePartida.containsKey( _nombre ) ){
                return _valoresDePartida.get(_nombre);
            }
            else{
                return _valorInicial;
            }
        }
        
        public void set( String valor ){
            _valoresDePartida.put(_nombre, valor );
        }
    }
    
    private static HashMap<String,String> _valoresDePartida = new HashMap<String,String>();
    
}
