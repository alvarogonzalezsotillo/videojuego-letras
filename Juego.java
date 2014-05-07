
/**
 * Write a description of class Juego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego
{
    private Estado _estado;
    
    public Juego( Estado estadoInicial ){
        _estado = estadoInicial;
    }
    
    public void jugar(){
        
        while( true ){
            String descripcion = _estado.descripcion();
            Escribidor.escribe( descripcion + "\n");

            String orden = Escribidor.leeOrden();
            Estado nuevoEstado = _estado.ejecutaOrden(orden);
            _estado = nuevoEstado;
            Escribidor.escribe( _estado.mensaje() + "\n" );
        }
        
    }
    
    public static void main( String args[] ){
        Lugar l = new LugarInicial();
        Estado e = new Estado(l, "Bienvenido a este juego");
        Juego j = new Juego(e);
        j.jugar();
    }
}
