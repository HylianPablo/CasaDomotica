/**
 * Contenido en el paquete que agrupa las vistas y controladores y la maquina
 * de estados de la casa domótica.
 * Se importa el modelo para guardar los estados y establecerlos inicialmente.
 * Se importa la clase Main para poder realizar el cambio de ventana.
 */
package domotic_house_view;

/**
 * Maquina de estados de la sala domótica.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Pablo Martínez López
 * @author Ángel Moreno Calvo
 */
import javax.swing.JFrame;
import domotic_house_model.Model;

public class LoginStateMachine {
    private JFrame current_state;
    private Model model;
    
    /**
     * Inicializacion de la maquina de estados, donde se empieza con el menu.
     */
    public LoginStateMachine(){
        model = new Model();
        start();
    }
    
    /**
     * Inicializacion de la ventana de menu y hace visible la vista de login.
     */
    void start(){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                current_state = new Login_window(model);
                current_state.setVisible(true);
            }
        });
    }
    
    
    /**
     * Inicializacion de la ventana de la luminaria y hace visible la vista de
     * las luces.
     */
    public void lights(){
        current_state.setVisible(false);
        // Queda eliminar
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                current_state = new LightView(model);
                current_state.setVisible(true);
            }
        });
    }
    
    /**
     * Inicializacion de la ventana del termostato y la hace visible la vista
     * de la calefacción.
     */
    public void heating(){
        current_state.setVisible(false);
        // Queda eliminar
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                current_state = new HeatingView(model);
                current_state.setVisible(true);
            }
        });
    }
    
    /**
     * Inicializacion de la ventana de las persianas y hace visible su vista.
     */
    public void blinds(){
        current_state.setVisible(false);
        // Queda eliminar
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                current_state = new BlindsView(model);
                current_state.setVisible(true);
            }
        });
    }
    
    
    /**
     * Elimina la vista que se encuentre abierta y la elimina.
     */
    public void stop(){
        current_state.dispose();
        current_state=null;
    }
}
