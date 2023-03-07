/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Hasinjo
 */
public class Utilitaire {
    public String[] splitURL(HttpServletRequest request){
        String urldefault = request.getPathInfo();
        String[] taburl = urldefault.split("/");
        return taburl;
    }
}
