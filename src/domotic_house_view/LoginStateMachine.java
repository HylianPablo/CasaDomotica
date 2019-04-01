/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domotic_house_view;

/**
 *
 * @author angmore
 */
import javax.swing.JFrame;
import domotic_house_model.Model;
//import domotic_house_view.images;
//import domotic_house_view_images.*;
import domotic_house_model.Model;

public class LoginStateMachine {
    private JFrame current_state;
    private Model model;
    
    public LoginStateMachine(){
        model = new Model();
        start();
    }
    
    void start(){
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                current_state = new Login_window(model);
                current_state.setVisible(true);
            }
        });
    }
    
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
    
    
    //Este método debería poder usarse para todos las vistas
    public void stop(){
        current_state.dispose();
        //current_state.setVisible(false);
    }
}
