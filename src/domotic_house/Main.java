/**
 * Contenido en el paquete que agrupa los componentes de la clase principal de la casa domótica. Actúa como lanzador y gestor de la máquina de estados.
 * Se importa la clase LoginStateMachine con el fin de inicializar la máquina de estados del sistema.
 */
package domotic_house;
import domotic_house_view.LoginStateMachine;
/**
 * Clase principal y lanzadora de la máquina de estados de la casa domótica.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
public class Main {
    private static LoginStateMachine state_machine;
    
    /**
     * Inicializador de la clase principal y de la máquina de estados.
     * @param args Array de argumentos de la clase principal. Este se encuentra vacío.
     */
    public static void main(String args[]){
        state_machine = new LoginStateMachine();
    }
    
    /**
     * Devuelve una referencia a la máquina de estados del sistema.
     * 
     * @return Clase {@code LoginStateMachine} que representa a la máquina de estados del sistema.
     */
    public static LoginStateMachine getStateMachineLogin(){
       return state_machine; 
    }
}
