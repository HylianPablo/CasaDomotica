/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
     * Inicializacion de la ventana de menu.
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
     * Inicializacion de la ventana de la luminaria.
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
     * Inicializacion de la ventana del termostato.
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
     * Inicializacion de la ventana de las persianas.
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
    
    
    //Este método debería poder usarse para todos las vistas
    /**
     * Elimina la vista
     */
    public void stop(){
        current_state.dispose();
        current_state=null;
        //current_state.setVisible(false);
    }
}
