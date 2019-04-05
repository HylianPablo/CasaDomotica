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
public class BlindsController {
    private Model model;
    private BlindsView view;
    
    
    public BlindsController(BlindsView v, Model m){
        view=v;
        model=m;
    }
    
    public void back_to_login(){
        Main.getStateMachineLogin().stop();
        Main.getStateMachineLogin().start();

    }
    
    public void blind(int i, int value){
        model.setBlindValue(i ,value);
        view.intAct();
    }
    
}
