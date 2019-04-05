/**
 * Contenido en el paquete que agrupa los componentes de la clase principal de la casa domótica. Actúa únicamente como lanzador.
 * Se importa la clase View con el fin de activarla y mostrarla por pantalla.
 */
package domotic_house;
import domotic_house_view.LoginStateMachine;
/**
 * Clase principal o lanzadora de la sala domótica de luces.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
public class Main {
    private static LoginStateMachine state_machine;
    public static void main(String args[]){
        state_machine = new LoginStateMachine();
    }
    
    public static LoginStateMachine getStateMachineLogin(){
       return state_machine; 
    }
}
