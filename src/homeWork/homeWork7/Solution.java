package homeWork.homeWork7;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class Solution {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        PluginManager pluginManager = new PluginManager("H:/JS/dz/07/ext");
        try {
            Plugin plugin = pluginManager.load("PluginName","homeWork.homeWork7.PluginImpl");
            plugin.doUsefull();
        } catch (MalformedURLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }


//        String path = "G:/JavaSchool/dz/07/ext/pluginName/";
//        File file = new File(path);
//        URLClassLoader pluginClassLoader = new URLClassLoader(new URL[] {file.toURI().toURL()});
//        Class cl = pluginClassLoader.loadClass("homeWork.homeWork7.PluginImpl");
//        System.out.println("*******************");
//        System.out.println(cl.getClassLoader());

    }
}