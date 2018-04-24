/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetracker;

/**
 *
 * @author anitaimoh
 */
public class blockLabels {
    private String label, description;
    public blockLabels(String desc, String lab){
        label = lab;
        description = desc;
        
    }
    
    public String getLabel(){
        return label;
    }
    
    public String getDescription(){
        return description;
    }
    
}
