/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domotic_house_view;
import domotic_house.Main;

/**
 *
 * @author angmore
 */
public class controllerLoginWindow {
    private Login_window login_view;
    
    public controllerLoginWindow(Login_window v){
        login_view = v;
    }
    
    public void process_light(){
        Main.getStateMachineLogin().lights();
    }
    
    
}
