/**
 * Contenido en el paquete que agrupa las vistas y controladores y la maquina
 * de estados de la casa domótica
 * de la casa domótica.
 * Se importa el modelo para guardar los estados y establecerlos inicialmente.
 * Se importa la clase Main para poder realizar el cambio de ventana.
 */
package domotic_house_view;
import domotic_house_model.CasaDomotica;
import domotic_house.Main;
/**
 * Controlador de la Temperatura de la sala domótica.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Angel Moreno Calvo
 * @author Pablo Martin Lopez
 */
public class HeatingController {
    private CasaDomotica model;
    private HeatingView view;
    
    
    /**
    * Constructor de la clase HeatingControler a partir de una vista y un modelo.
    * 
    * @param v Vista de la sala domótica.
    * @param m Modelo de la sala domótica.
    */
    public HeatingController(HeatingView v, CasaDomotica m){
        model = m;
        view = v;
    }
    
    
    /**
     * Cierra la vista de la calefacción y devuelve la vista al menu.
     */
    public void back_to_login(){
        Main.getStateMachineLogin().stop();
        Main.getStateMachineLogin().start();

    }
    
    /**
     * Cambia el valor del slider guardado en modelo a traves de lo recibido por
     * la vista. 
     */
    public void slider(){
        int n=view.getIntensity();
        model.setHeating(n);
        view.actInt(n);
    }
    
    
    
}
