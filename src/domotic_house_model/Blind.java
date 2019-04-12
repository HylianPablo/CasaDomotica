/**
 * Tipo de dato que representa una persiana,
 * aprota funcinalidades para saber y cambier el porcentaje de cerrado y abierto
 * de la persiana.
 * El estado inicial de la persiana sera cerrado al 100%
 */
package domotic_house_model;
    
/**
 * Modelo de una persiana.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
public class Blind {
    private int value;
    
    /**
     * Inicializa la persiana como cerrada al 100 por ciento.
     */
    public Blind(){
        value = 100;
    }
    
    /**
     * Establece el valor de cerrado.
     * @param v numero entero entre 100 y 0.
     */
    public void setValue(int v){
        value = v;
    }
    /**
     * Comprueba el porcentaje de cerrado de la persiana.
     * 
     * @return Valor entero entre 100 y 0
     */
    public int getValue(){
        return value;
    }
    
}
