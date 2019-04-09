/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domotic_house_model;
    
/**
 *
 * @author angmore
 */
public class Blind {
    private int value;
    
    public Blind(){
        value = 100;
    }
    
    public void setValue(int v){
        value = v;
    }
    
    public int getValue(){
        return value;
    }
    
}
