/**
 * Contenido en el paquete que agrupa los componentes de la vista 
 * de la casa domótica.
 * Se importa la clase Main con el fin de utilizarla para realizar el cambio 
 * de ventanas.
 * Se importa la clase Model con el fin de acceder al modelo.
 */
package domotic_house_view;
import domotic_house.Main;
import domotic_house_model.Model;
/**
 * Controlador del menu del salon domotico .
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Angel Moreno Calvo
 * @author Pablo Martin Lopez
 */
public class controllerLoginWindow {
    private Login_window login_view;
    private Model model;
    
    
    /**
     * Inicializador del controlador del menu a traves de la vista del menu y
     * el modelo.
     * @param v vista de la ventana menu.
     * @param m modelo global.
     */
    public controllerLoginWindow(Login_window v, Model m){
        login_view = v;
    }
    
    
    /**
     * Manda a la maquina de estados cambiar la vista por de la la luminaria.
     */
    public void process_light(){
        Main.getStateMachineLogin().lights();
    }
    
    /**
     * Manda a la maquina de estados cambiar la vista por la de la temperatura.
     */
    public void process_heating(){
        Main.getStateMachineLogin().heating();
    }
    
    /**
     * Manda a la maquina de estados cambiar la vista por la de las persianas.
     */
    public void process_blinds(){
        Main.getStateMachineLogin().blinds();
    }
    
    
    
}
