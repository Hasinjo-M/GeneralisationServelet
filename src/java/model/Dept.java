/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annotion.URLannotation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hasinjo
 */
public class Dept {
 
    @URLannotation(url = "/findall")
    public List<Employer> findAll(){
        List<Employer> all = new ArrayList<>();
        Employer p =  new Employer(1, "Hasinjo");
        all.add(p);
        return all;
    }
}
