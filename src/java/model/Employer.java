/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import annotation.URLannotation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hasinjo
 */
public class Employer {

    public Employer() {
    }

    public Employer(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

   
    int id ;
    String libelle;
    
    @URLannotation(url = "findall")
    public List<Employer> findAll(){
        List<Employer> all = new ArrayList<>();
        Employer p =  new Employer(1, "Hasinjo");
        all.add(p);
        return all;
    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}
