import java.util.*;
import java.io.*;
public class Escribidor
{
    
    public static void espera(long ms){
            try{
                Thread.sleep(ms);
            }
            catch( InterruptedException e ){
            }
        }
    
    public static void escribe(long ms,  String ... s){
        escribe( ms, true, s );
    }

    public static void escribe(String ... s){
        escribe( 10, true, s );
    }
    
    public static void escribe(long ms, boolean separator, String ... s){
        for( int i = 0 ; i < s.length ; i++ ){
            if( separator && i > 0 ){
                System.out.print( ' ' );
            }
            for( char c: s[i].toCharArray() ){
                System.out.print(c);
                if( c != ' ' ){
                    espera(ms);

                }
            }
        }
    }
    
    private static Scanner _in = new Scanner(System.in);
    
    public static String leeOrden(){
        return _in.nextLine().toLowerCase().trim();
    }
    

}
