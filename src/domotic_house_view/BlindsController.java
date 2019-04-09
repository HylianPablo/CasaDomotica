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
    
    public void blind1(/*int i, int value*/){
        int i=1;
        int value=view.getIntensity1();
        model.setBlindValue(i ,value);
        
        view.intAct();
    }
    
    public void blind2(/*int i, int value*/){
        int i=2;
        int value=view.getIntensity2();
        model.setBlindValue(i ,value);
        view.intAct();
    }
    
    public void blind3(/*int i, int value*/){
        int i=3;
        int value=view.getIntensity3();
        model.setBlindValue(i ,value);
        view.intAct();
    }
    
}
