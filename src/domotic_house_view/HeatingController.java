/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domotic_house_view;
import domotic_house_model.Model;
import domotic_house.Main;
/**
 * Controlador de la Temperatura de la sala domótica.
 * Práctica de Interacción Persona-Computadora.
 * Universidad de Valladolid.
 * @author Angel Moreno Calvo
 * @author Pablo Martin Lopez
 */
public class HeatingController {
    private Model model;
    private HeatingView view;
    
    
    /**
    *Constructor de la clase controlador a partir de una vista y un modelo.
    *@param v Vista de la sala domótica.
    *@param m Modelo de la sala domótica.
    */
    public HeatingController(HeatingView v, Model m){
        model = m;
        view = v;
    }
    
    
    /**
     * Devuelve la vista al menu.
     */
    public void back_to_login(){
        Main.getStateMachineLogin().stop();
        Main.getStateMachineLogin().start();

    }
    
    /**
     * Cambia el valor del slider
     * @param n 
     */
    public void slider(/*int n*/){
        int n=view.getIntensity();
        model.setHeating(n);
        view.actInt(n);
    }
    
    
    
}
