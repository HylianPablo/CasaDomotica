/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domotic_house_view;
import domotic_house.Main;
import domotic_house_model.Model;
/**
 *
 * @author angmore
 */
public class controllerLoginWindow {
    private Login_window login_view;
    private Model model;
    
    public controllerLoginWindow(Login_window v, Model m){
        login_view = v;
    }
    
    public void process_light(){
        Main.getStateMachineLogin().lights();
    }
    
    public void process_heating(){
        Main.getStateMachineLogin().heating();
    }
    
    public void process_blinds(){
        Main.getStateMachineLogin().blinds();
    }
    
    
}
