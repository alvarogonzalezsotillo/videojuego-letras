
/**
 * Write a description of class Estado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Estado
{
    private Lugar _lugar;
    private String _mensaje;
    
    public Estado( Lugar l, String mensaje){
        _lugar = l;
        _mensaje = mensaje;
    }
    
    public String descripcion(){
        return _lugar.descripcion();
    }
    
    public String mensaje(){
        return _mensaje;
    }
    
    public Estado ejecutaOrden( String orden ){
        Lugar.OrdenEjecutada oe = _lugar.ejecutaOrden(orden);
        return new Estado(oe.nuevoLugar(), oe.mensaje());
    }
    
}
