
/**
 * Write a description of class LugarInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LugarInicial extends Lugar
{
    private static ValorDePartida puerta = new ValorDePartida( "LugarInicial.puerta", "cerrada" );
    
    public String descripcion(){
        String estadoPuerta = puerta.get();
        return "Estás en una habitación que tiene una puerta " + estadoPuerta +
               ". Es una habitación muy sosa, mejor salir de aquí";
    }
    
    
    
    /**
     * Cada vez que se ejecute una orden, podremos cambiar de lugar (o no)
     */
    public OrdenEjecutada ejecutaOrden(String orden){
        if( orden.startsWith( "salir" ) ){ 
            if( puerta.get().equals( "abierta" ) ){
                return new OrdenEjecutada( new SegundoLugar(), "Sales por la puerta" );
            }
            else{
                return new OrdenEjecutada( this, "No puedo salir con la puerta cerrada" );
            }
        }
        else if( orden.equals( "abrir puerta" ) ){
            puerta.set( "abierta" );
            return new OrdenEjecutada( this, "La puerta se ha abierto" );
        }
        else if( orden.equals( "cerrar puerta" ) ){
            puerta.set( "cerrada" );
            return new OrdenEjecutada( this, "La puerta se ha cerrado" );
        }
        else{
            return super.ejecutaOrden(orden);
        }
            
    }    
}
