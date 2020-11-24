package com.mono.myrecipedb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ListContentOfDirectory {

    static Logger log = LogManager.getLogger() ;

    /**
     * Erzeugt Ordner Namensliste im Format: <p/> Pfad/Rezeptname
     *
     * @param directoryPath
     * @return list
     */

    public static List<File> listContent (String directoryPath){
        //Creating a File object for directory
        File filedirectoryPath = new File(directoryPath);
        String [] contents = filedirectoryPath.list();
        List<File> list = new ArrayList();
        log.info("Listing contents of: " + directoryPath .toString());
        for(int i=0 ; i < contents.length ; i++)
        {
            log.debug(contents[i]);
            list.add(new File(contents[i]));
        }

        return list ;
    }

}
