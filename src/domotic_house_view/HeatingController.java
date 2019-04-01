/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domotic_house_view;
import domotic_house_model.Model;
import domotic_house.Main;
/**
 *
 * @author root
 */
public class HeatingController {
    private Model model;
    private HeatingView view;
    
    public HeatingController(HeatingView v, Model m){
        model = m;
        view = v;
    }
    
    public void back_to_login(){
        Main.getStateMachineLogin().stop();
        Main.getStateMachineLogin().start();

    }
    public void slider(){
        
    }
    
    
    
}
