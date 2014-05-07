
/**
 * Write a description of class SegundoLugar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SegundoLugar extends Lugar
{
    @Override
    public OrdenEjecutada ejecutaOrden( String orden ){
        if( orden.contains( "volver" ) ){
            return new OrdenEjecutada( new LugarInicial(), "Se está mejor en la habitación inicial que aquí" );
        }
        else{
            return super.ejecutaOrden(orden);
        }
    }
}
