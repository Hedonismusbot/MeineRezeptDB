package com.mono.myrecipedb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ListContentOfDirectory {

    static Logger log = LogManager.getLogger() ;

    public static List<String> listContent (String directoryPath){
        //create file object (z.b. "C://FileIO" )
        File file = new File(directoryPath);
        String [] files = file.list();
        List<String> list = new ArrayList();
        log.info("Listing contents of: " + file.getPath());
        System.out.println("Listing contents of: " + file.getPath());
        for(int i=0 ; i < files.length ; i++)
        {
            log.debug(files[i]);
            list.add(files[i]);
        }

        return list ;
    }

}
