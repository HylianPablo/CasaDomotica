/**
 * Contenido en el paquete que agrupa los componentes de la vista 
 * de la casa domótica, sus respectivos controladores y la máquina de estados.
 * Se importa la clase Main con el fin de utilizarla para realizar el cambio 
 * de ventanas.
 * Se importa la clase Model con el fin de acceder al modelo.
 */
package domotic_house_view;
import domotic_house.Main;
import domotic_house_model.CasaDomotica;
/**
 * Controlador del menu del salon domotico .
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Angel Moreno Calvo
 * @author Pablo Martin Lopez
 */
public class controllerLoginWindow {
    private Login_window login_view;
    private CasaDomotica model;
    
    
    /**
     * Inicializador del controlador del menu a traves de la vista del menu y
     * el modelo.
     * @param v Vista {@code Login_window} de la ventana inicial menú.
     * @param m Modelo global del sistema.
     */
    public controllerLoginWindow(Login_window v, CasaDomotica m){
        login_view = v;
    }
    
    
    /**
     * Ordena a la máquina de estados cambiar la vista por la de luminaria.
     */
    public void process_light(){
        Main.getStateMachineLogin().lights();
    }
    
    /**
     * Ordena a la máquina de estados cambiar la vista por la de temperatura.
     */
    public void process_heating(){
        Main.getStateMachineLogin().heating();
    }
    
    /**
     * Ordena a la máquina de estados cambiar la vista por la de las persianas.
     */
    public void process_blinds(){
        Main.getStateMachineLogin().blinds();
    }
    
    /**
     * Cierra la ventana principal y termina el programa.
     */
    public void exit(){
        login_view.dispose();
        System.exit(0);
    }
    
    
    
}
