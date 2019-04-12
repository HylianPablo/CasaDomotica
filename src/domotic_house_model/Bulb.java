/**
 * Tipo de dato que representa una bombilla,
 * aprota funcinalidades de encendido o apagado, valor de la intensidad a la que 
 * se encuentra la bombilla y el color que tiene dicha bombilla.
 * El estado inicial de la bombilla sera apagado, con intensidad 0, y color
 * blanco.
 * Aporta la posibilidad de poder variar cualquiera de estas funcionalidades.
 * 
 */

package domotic_house_model;




/**
 * Modelo de la sala domótica de luces.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
public class Bulb {
    private boolean encendido;
    private int intensidad;
    private String color;
    
    
    /**
     * Inicializa la bombilla apagada, sin intensidad y con color blanco.
     */
    public Bulb(){
        encendido = false;
        intensidad = 50;
        color = "WHITE";
    }
    
    /**
     * Cambia el valor del estado.
     * @param state valor booleano al que se cambiara el estado de la bombilla.
     */
    public void setEncendido(boolean state ){
        encendido = state;
    }
    /**
     * Cambia el valor guardado de la intensidad.
     * @param i valor numero de 1 a 100 
     */
    public void setIntensidad(int i ){
        intensidad = i;
    }
    /**
     * Cambia el valor del color por uno de los colores de view.
     * @param c string del color en ingles en mayusculas.
     */
    public void setColor(String c ){
        color = c;
    }
    /**
     * Consuta el parametro encendido.
     * 
     * @return si esta encencendida el valor de retorno sera {@code true}
     */
    public boolean getEncendido( ){
        return encendido;
    }
    /**
     * Consulta el valor de la intensidad.
     * 
     * @return valor numerico comprendido entre 0 y 100
     */
    public int getIntensidad( ){
        return intensidad;
    }
    /**
     * Consulta el valor numerico del color.
     * 
     * @return string en mayusculas con un color en ingles.
     */
    public String getColor( ){
        return color;
    }
    
}
