/**
 * Contenido en el paquete que agrupa los componentes del modelo de la casa domótica.
 * Se importa la clase Bulb con el fin de utilizarla como objeto.
 */
package domotic_house_model;

import java.awt.Color;
/**
 * Modelo de la sala domótica de luces.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
public class CasaDomotica {
    
    private Bulb[] bombillas;
    private int state;
    private String mode;
    private int heating;
    private Color color_heat;
    private Blind[] blinds;
    
    
    /**
    *Constructor de la clase Model. En el se crea un array de objetos Bulb 
    * que representa a las cinco bombillas.
    */
    public CasaDomotica(){
        bombillas = new Bulb[5];
        for(int i = 0; i<5 ;i++){
            bombillas[i] = new Bulb();
        }
        state = -1;
        mode = "ALL_OFF";
        
        
        heating = 20;
        color_heat = Color.ORANGE;
        blinds = new Blind[3];
        for(int i = 0; i<3;i++)
            blinds[i] = new Blind();
        
    }
  
    /**
    *Comprueba si una determinada bombilla se encuentra encendida.
    *@param i Entero que representa la bombilla a comprobar.
    *@return Valor booleano que indica si la bombilla está encendida o no.
    */
    public boolean getEncendido(int i){
        return bombillas[i].getEncendido();
    }
    
    /**
    *Comprueba la intensidad de una determinada bombilla.
    *@param i Entero que representa la bombilla a comprobar.
    *@return Entero que representa la intensidad de la bombilla seleccionada.
    */
    public int getIntensidad(int i){
        return bombillas[i].getIntensidad();
    }
    
    /**
    *Comprueba el color de una determinada bombilla.
    *@param i Entero que representa la bombilla a comprobar.
    @return Cadena de caracteres que representa el color de la bombilla seleccionada.
    */
    public String getColor(int i){
        return bombillas[i].getColor();
    }
    
    /**
    *Comprueba el estado del sistema, que indica que bombilla está encendida 
    * o si están todas apagadas.
    *@return Número entero que representa la bombilla seleccionada.
    */
    public int getState(){
        return state;
    }
    
    /**
     * Compreba si hay algun modo activado.
     * @return el estado guardado por el controlador.
     */
    public String getMode(){
        return mode;
    }
    
    
    
    /**
     * Establece el estado del modo del sistema.
     * @param m Un string, el cuan sera NONE en el caso de que 
     * no haya ningun estado activado.
     */
    public void setMode(String m){
        mode = m;
    }
    
    /**
    *Establece el color de una determinada bombilla.
    *@param i Entero que representa la bombilla seleccionada.
    *@param c Cadena de caracteres que representa el color a establecer.
    */
    public void setColor(int i, String c){
        if(i>=0){
        bombillas[i].setColor(c);
        }
    }
     /**
    *Establece la intensidad de una determinada bombilla.
    *@param i Entero que representa la bombilla seleccionada.
    *@param intensity Entero que representa la intensidad a establecer.
    */
    public void setIntensidad(int i,int intensity){
        bombillas[i].setIntensidad(intensity);
    }
     /**
    *Enciende o apaga la bombilla seleccionada.
    *@param i Entero que representa la bombilla seleccionada.
    *@param b Booleano que representa el estado en que quedará 
    * la bombilla, siendo true encendido y false apagado.
    */
    public void setEncendido(int i,boolean b){
        bombillas[i].setEncendido(b);
    }
    
    /**
    *Establece un estado determinado, representando este que bombilla está seleccionada.
    * @param s Número entero que selecciona la bombilla seleccioanda comenzando 
    * en cero y llegando hasta cuatro.  Será -1 si no hay ninguna bombilla seleccionada.
    */
    public void setState(int s){
        state = s;
    }
    
    /**
     * Obtiene el número asociado un color, sigueindo el orden que se muestra en la interfaz.
     * @param s Cadena de caracteres que representa el color a transformar en número.
     * @return Número entero desde 0 a 4 que representa un color determinado.
     */
    public int get_number_color(String s){
        switch(s){
            case "RED":
                return 1;
                
            case "YELLOW":
                return 2;
                
            case "WHITE":
                return 0;
                
            case "GREEN":
                return 3;
                
            case "BLUE":
                return 4;
                
            default:
                return 0;
        }
    }
    
    /**
    *Cambia el estado de la bombilla seleccionada a encendido.
    * @param i Número entero que representa la bombilla seleccionada.
    */
    public void change_Encendido(int i){
        bombillas[i].setEncendido(!bombillas[i].getEncendido());
    }
    
    /**
    *Cambia el estado de todas las bombillas a activado.
    */
    public void all_on(){
        for(int i = 0; i < 5; i++){
            bombillas[i].setEncendido(true);
        }
    }
    
    /**
    *Cambia el estado de todas las bombillas a desactivado.
    */
    public void all_off(){
        for(int i = 0; i < 5; i++){
            bombillas[i].setEncendido(false);
        }
    }
    
    
    
    /**
     * Comprueba los grados a los que se encuetra la calefaccion del sistema.
     * @return Entero entre 10  y 30
     */
    public int getHeating(){
        return heating;
    }
    
    
    /**
     * Establece la temperatura del sistema de calefaccion.
     * @param h valor entero entre 10 y 30.
     */
    public void setHeating(int h){
        heating = h;
    }
    
    /**
     * Comprueba el color al que se asocia la temperatura del sistema de 
     * calefaccion.
     * @return objeto color distindo de @code{NULL} 
     */
    public Color getColorHeat(){
        return color_heat;
    }
    
    
    /**
     * Establece el valor guardado del porcentaje de cerrado de las ventanas.
     * @param i Numero de la ventana a cambiar de valor.
     * @param value El valor que se desea poner, debe ser positivo y menor de
     * 100.
     */
    public void setBlindValue(int i, int value){
        blinds[i-1].setValue(value);
    }
    
    /**
     * Comprueba el valor de cerrado de una ventana.
     * @param i Número de la ventana de la que se quiere saber el valor.
     * @return Entero, menor de 100 y mayor de 0.
     */
    public int getBlindValue(int i){
        return blinds[i-1].getValue();
    }
}
