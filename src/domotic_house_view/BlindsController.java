/**
 * Contenido en el paquete que agrupa los componentes de las vistas de la casa domótica, sus respectivos controladores y la máquina de estados.
 * Se importa la clase Model con el fin de acceder al modelo.
 * Se importa la clase Main con el fin de acceder a la máquina de estados del sistema.
 */
package domotic_house_view;
import domotic_house_model.CasaDomotica;
import domotic_house.Main;

/**
 * Controlador de las persianas de la sala domótica.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Angel Moreno Calvo
 * @author Pablo Martin Lopez
 */
public class BlindsController {
    private CasaDomotica model;
    private BlindsView view;
    
    /**
     * Constructor de la clase BlindsController a partir de su vista asociada y el modelo del sistema.
     * @param v Vista {@code BlindsView} asociada con el controlador.
     * @param m Modelo {@code Model} del sistema.
     */
    public BlindsController(BlindsView v, CasaDomotica m){
        view=v;
        model=m;
    }
    
    /**
     * Llamada a la máquina de estados para cerrar la ventana actual y volver a la vista principal de elección de vistas.
     */
    public void back_to_login(){
        Main.getStateMachineLogin().stop();
        Main.getStateMachineLogin().start();

    }
    
    /**
     * Actualiza el valor del porcentaje en que está abierta la primera persiana en el modelo y lo refleja visualmente en la vista.
     */
    public void blind1(){
        int i=1;
        int value=view.getIntensity1();
        model.setBlindValue(i ,value);
        
        view.intAct();
    }
    
    /**
     * Actualiza el valor del porcentaje en que está abierta la segunda persiana en el modelo y lo refleja visualmente en la vista.
     */
    public void blind2(){
        int i=2;
        int value=view.getIntensity2();
        model.setBlindValue(i ,value);
        view.intAct();
    }
    
    /**
     * Actualiza el valor del porcentaje en que está abierta la tercera persiana en el modelo y lo refleja visualmente en la vista.
     */
    public void blind3(){
        int i=3;
        int value=view.getIntensity3();
        model.setBlindValue(i ,value);
        view.intAct();
    }
    
}
