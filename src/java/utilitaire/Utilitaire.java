/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import annotion.URLannotation;
import etu1789.framework.Mapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
    
    public List<String> searchClassNames(String packageName) throws IOException
    {
    	String[] pathnames;
    	List<String>result = new ArrayList<String>();
        
        File f = new File("C:\\Users\\Hasinjo\\Desktop\\GeneralisationServelet\\build\\web\\WEB-INF\\classes\\"+packageName+"");        
        pathnames = f.list();
        for (String pathname : pathnames) {
           pathname = pathname.substring(0, pathname.length()-6);         
           result.add(packageName+"."+pathname);
        }
        return result;
    }
    
    public HashMap<String,Object> stockage() throws IOException, ClassNotFoundException{          
        HashMap<String,Object> result = new HashMap();
        List<String> listeClassesPackage = searchClassNames("model");
        Class classe = null;
        List<String> listClassCorrespondant = new ArrayList();
        List<Method> listMethodCorrespondant = new ArrayList();
        List<String> listAnnotationCorrespondant = new ArrayList();
        for(String nomClass : listeClassesPackage){
            classe = Class.forName(nomClass.replace(".class", ""));
            for(Method method : classe.getDeclaredMethods()) {
                if(method.isAnnotationPresent(URLannotation.class)) {
                    URLannotation annotation = method.getAnnotation(URLannotation.class);
                    listClassCorrespondant.add(classe.getSimpleName());
                    listMethodCorrespondant.add(method);
                    listAnnotationCorrespondant.add(annotation.url());
                    result.put("ListeClasse", listClassCorrespondant);
                    result.put("ListeMethod", listMethodCorrespondant);
                    result.put("ListeAnnotation", listAnnotationCorrespondant);
                }
            }
        }
        return result;
    }
    
    
    public List<String> listeAnnotation(String class_name) throws ClassNotFoundException {
        Class classe = null;
        List<String> listAnnotationCorrespondant = new ArrayList();
        classe = Class.forName(class_name.replace(".class", ""));
            for(Method method : classe.getDeclaredMethods()) {
                if(method.isAnnotationPresent(URLannotation.class)) {
                    URLannotation annotation = method.getAnnotation(URLannotation.class);
                    listAnnotationCorrespondant.add(annotation.url());
                }
            }
        return listAnnotationCorrespondant; 
    }
    
    public List<Method> liste_methope_annoatation(String annotation,String class_name) throws ClassNotFoundException{
        Class classe = Class.forName(class_name.replace(".class", ""));
        List<Method> listMethodCorrespondant = new ArrayList();
        for(Method method : classe.getDeclaredMethods()) {
              if(method.isAnnotationPresent(URLannotation.class)) {
                  listMethodCorrespondant.add(method);
              }
        }
        return listMethodCorrespondant;
    }
    
    public Method getMethod(HashMap<String, Mapping> MappingUrls) throws IOException, ClassNotFoundException{
        Method rep = null;
        String cle = new String();
        Set<String> keys = MappingUrls.keySet();
        for(String key : keys) {
            cle = key;
        }
        Mapping map = MappingUrls.get(cle);
        String class_name = map.getClassName();
        String method = map.getMethod();
        
        List<Method> liste_method = liste_methope_annoatation(cle,class_name);
        
        for (Method method1 : liste_method) {
            if(method1.getName().equals(method))
                return method1;
        }        
        return rep;
    }
}
