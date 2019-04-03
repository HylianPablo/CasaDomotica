/**
 * Contenido en el paquete que agrupa los componentes del controlador de la casa domótica.
 * Se importa la clase Model con el fin de acceder al modelo.
 */
package domotic_house_view;
import domotic_house_model.Model;
import domotic_house.Main;
/**
 * Controlador de la sala domótica de luces.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
public class LightController {
    private LightView view;
    private Model model;
    
    /**
    *Constructor de la clase controlador a partir de una vista y un modelo.
    *@param v Vista de la sala domótica.
    *@param m Modelo de la sala domótica.
    */
    public LightController(LightView v, Model m){
        view = v;
        model = m;
    }
    
    /**
    *Da instrucciones para cambiar la imagen del botón asociado a la bombilla 
    * dependiendo si estaba encendida o apagada, llamando a la vista para realizar la acción.
    *@param i Entero que representa la bombilla a cambiar la imagen.
    */
    public void change_state(int i){
        switch(i+1) {
            case 1:
                view.color_bulb1((model.getEncendido(i)) ? model.getColor(i) : "GREY");
                break;
            case 2:
                view.color_bulb2((model.getEncendido(i)) ? model.getColor(i) : "GREY");
                break;
            case 3:
                view.color_bulb3((model.getEncendido(i)) ? model.getColor(i) : "GREY");
                break;
            case 4:
                view.color_bulb4((model.getEncendido(i)) ? model.getColor(i) : "GREY");
                break;
            case 5:
                view.color_bulb5((model.getEncendido(i)) ? model.getColor(i) : "GREY");
                break;
            default:
                break;
        }
    }
    
    
    /**
    *Da instrucciones para activar o reactivar el botón dependiendo el estado 
    * en que estuviese. Esto se traduce en activar o desactivar los botones de selección derechos.
    *@param i Entero que representa la bombilla a activar o desactivar.
    */
    public void activate(int i){
        if(model.getState() == i){
            model.setState(-1);
            view.clear();
            view.setOptionsFalse();
        }
        
        else{
            model.setState(i);
            view.show_info(i);
            if(model.getEncendido((model.getState()))){
                view.setOptionsTrue();
            }else{
                view.setOptionsFalse();
            }
        }
        //change_mode();
        view.refresh_on_off();
    }
    /**
    * Manda cambiar el estado de la bombilla seleccionada en el modelo 
    * y muestra los cambios en la vista en el contenedor on_off.
    */
    public void on_off(){
        model.change_Encendido(model.getState());
        if(model.getEncendido((model.getState()))){
            view.setOptionsTrue();
        }else{
            view.setOptionsFalse();
             
        }
        change_state(model.getState());
        view.refresh_on_off();
        
    }
    /**
    * Enciende todas las bombillas de vista a color blanco y máxima intensidad 
    * y manda guardar su estado en el modelo.
    */
    public void all_on(){
        model.all_on();
        for(int i = 0;i< 5; i++){
            
            model.setIntensidad(i, 100);
            model.setColor(i,"WHITE");
            change_state(i);
        }
        if(model.getState() != -1){
            view.show_info(model.getState());
            view.setOptionsTrue();
        }
        
        view.refresh_on_off();
    }
    /**
    * Apaga todas las bombillas en la vista y pone su estado a apagado en el modelo.
    */
    public void all_off(){
        
        model.all_off();
        for(int i = 0;i< 5; i++){
            change_state(i);
        }
        if(model.getState() != -1){
            view.show_info(model.getState());
            view.setOptionsFalse();
        }
        view.refresh_on_off();
        }
    
    /**
    *Da instrucciones para cambiar el color de la bombilla seleccionada actualmente.
    *@param s Cadena de texto que representa el color a cambiar.
    */
    public void color(String s){
        model.setColor(model.getState(),s);
        change_state(model.getState());
        switch(s){
            case "RED":
                view.changeColorRed();
                break;
            case "YELLOW":
                view.changeColorYellow();
                break;
            case "WHITE":
                view.changeColorWhite();
                break;
            case "GREEN":
                view.changeColorGreen();
                break;
            case "BLUE":
                view.changeColorBlue();
                break;
            default:
                break;
        }
        
    }
    /**
     * Manda a view el valor de la intensidad en un momento cuelquiera de la 
     * bombilla que se encuentra en ese momento encendida.
     * @param n valor de la intensidad a introducir
     */
    public void intensidad(int n){
        if(model.getState()>=0){
            model.setIntensidad(model.getState(),n);
            view.actInt(model.getIntensidad(model.getState()));
        }
        
       
    }
    /**
     * Da instrucciones para cambiar el modo en el modelo.
     */
    public void change_mode(){
        
        if(mode_all_on()){
            model.setMode("ALL_ON");
        }
        else if(mode_all_off())
            model.setMode("ALL_OFF");
        else if(mode_ambiente())
            model.setMode("AMBIENTE");
        else if(mode_lectura())
            model.setMode("LECTURA");
        else
            model.setMode("NONE");
        view.change_color_button();
            
    }
    
    
    /**
     * Establece los valores del modo lectura en el modelo y da instrucciones
     * a la vista para mostrar las modificaciones. Esto se traduce a apagar las bombillas 2,4 y 5,
     * y encender las bombillas 1 y 3 con un 60% de intensidad y en color blanco.
     */        
    public void lectura(){
        model.setEncendido(0,true);
        model.setEncendido(2, true);
        model.setEncendido(1, false);
        model.setEncendido(3, false);
        model.setEncendido(4, false);
        model.setColor(0, "WHITE");
        model.setColor(2, "WHITE");
        model.setIntensidad(0, 60);
        model.setIntensidad(2, 60);
        for(int i = 0; i< 5;i++){
            change_state(i);
        }
        if(model.getState() != -1){
            view.show_info(model.getState());
            if(model.getEncendido(model.getState()))
                view.setOptionsTrue();
            else
                view.setOptionsFalse();
        }
        view.refresh_on_off();
    }
    
    /**
     * Establece los valores del modo ambiente en el modelo y da instrucciones a la vista para mostrar las modificaciones. Esto se traduce en encender todas las bombillas con un 30% de intensidad y en color amarillo.
     */        
    public void ambiente(){
        model.all_on();
        for(int i = 0; i< 5;i++){ 
            model.setIntensidad(i, 30);
            model.setColor(i, "YELLOW");
            change_state(i);
            
        }
        if(model.getState() != -1){
            view.show_info(model.getState());
            view.setOptionsTrue();
        }
        view.refresh_on_off();
    }
    
    /**
     * Comprueba si todas las bombillas se encuentran encendidas.
     * @return retorna un booleano, {@code true} en el caso de que se cumplan las condiciones, {@code false} en caso de que no se cumplan.
     */
    public boolean mode_all_on(){
        for(int i = 0; i< 5;i++){
            if(model.getIntensidad(i) != 100)
                return false;
            if(!model.getColor(i).equals("WHITE"))
                return false;
            if(!model.getEncendido(i))
                return false;
        }
        
        return true;
    }
    
    /**
     * Comprueba que todas las bombillas están apagadas.
     * @return Valor booleano {@code true} si todas las bombillas están apagadas y {@code false} en caso contrario.
     * 
     */
    public boolean mode_all_off(){
        for(int i = 0; i< 5;i++){
            if(model.getEncendido(i))
                return false;
        }
        
        return true;
    }
    
    /**
     * Comprueba los requisitos de las bombillas establecidos para el modo ambiente. Esto es que todas estén encendidas, con una intensidad del 30% y en color amarillo.
     * @return Valor booleano {@code true} en caso de cumplir las condiciones y {@code false} en caso contrario.  
     */
    public boolean mode_ambiente(){
        for(int i = 0; i< 5;i++){
            if(model.getIntensidad(i) != 30)
                return false;
            if(!model.getColor(i).equals("YELLOW"))
                return false;
            if(!model.getEncendido(i))
                return false;
        }
        
        return true;
    }
    
    /**
     * Comprueba los requisitos de las bombillas establecidos para el modo lectura. Esto es que la primera y tercera bombilla estén encendidas y las restantes apagadas. Las bombillas encendidas contarán con una intensidad del 60% y en color blanco.
     * @return Valor booleano {@code true} en caso de cumplir las condiciones y {@code false} en caso contrario.  
     */
    public boolean mode_lectura(){
        if(!model.getEncendido(0) || !model.getEncendido(2)){
            return false;
        }
        if(!model.getColor(0).equals("WHITE") || !model.getColor(2).equals("WHITE"))
                return false;
                
        if(model.getIntensidad(0) != 60 || model.getIntensidad(2) != 60)
                return false;
        if(model.getEncendido(1) || model.getEncendido(3) || model.getEncendido(4))
                return false;
        
        return true;
    }
    
    public void back_to_login(){
        Main.getStateMachineLogin().stop();
        Main.getStateMachineLogin().start();
    }
}
