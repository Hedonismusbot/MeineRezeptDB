package com.mono.myrecipedb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListContentOfDirectory {

    static Logger log = LogManager.getLogger() ;

    /**
     * Erzeugt Liste der Unterordnernamen <p/> (nicht recursiv | ignoriert Files)
     *
     * @param directoryPath Rezept Ordner Pfad
     * @return Liste Rezept Namen
     */

    public static List<File> listContent (String directoryPath){
        //Creating a File object for directory
        File filedirectoryPath = new File(directoryPath);
        String [] contents = filedirectoryPath.list();
        ArrayList<File> list = new ArrayList();
        Optional<String[]> opt = Optional.ofNullable(contents);
        log.info("Listing contents of: " + directoryPath );
        if (opt.isPresent()) {
            log.debug(" Ordner gefunden: " + contents.length);

            for (int i = 0; i < contents.length; i++) {
                File test = new File(directoryPath + "\\" + contents[i]);
                if (test.exists() && test.isDirectory()) {
                    log.trace("Rezept Ordner gefunden, der Liste hinzugefügt: " + contents[i]);
                    list.add(new File(contents[i]));
                }

            }
        }else{
            log.error("FEHLER: keine Rezepte gefuden");
        }
        return list ;
    }

}
