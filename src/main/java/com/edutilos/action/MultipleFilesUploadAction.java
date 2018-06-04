package com.edutilos.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MultipleFilesUploadAction extends ActionSupport {

    private List<File> myFiles = new ArrayList<>();
    private List<String> myFileFileNames = new ArrayList<>();
    private List<String> myFileContentTypes = new ArrayList<>();
    private String destDir ;

    public String execute() {
       destDir = "C:/Users/edutilos/Desktop/temp";
        Logger logger = LogManager.getLogger(MultipleFilesUploadAction.class);
        logger.info("<<all source files>");
        for(File f: myFiles)
        logger.info(f);
        logger.info("<<all dest files>>");
        for(String str: myFileFileNames)
        logger.info(str);
        logger.info("<<all content types>>");
        for(String str: myFileContentTypes)
        logger.info(str);

        String res = SUCCESS;
        int counter = 0 ;
        for(File f: myFiles) {
            try {
                File destFile = new File(destDir, myFileFileNames.get(counter++));
                FileUtils.copyFile(f, destFile);
            } catch(Exception ex) {
                ex.printStackTrace();
                res = ERROR;
            }
        }
        return res;
    }


    public List<File> getMyFile() {
        return myFiles;
    }

    public void setMyFile(List<File> myFiles) {
        this.myFiles = myFiles;
    }

    public List<String> getMyFileFileName() {
        return myFileFileNames;
    }

    public void setMyFileFileName(List<String> myFileFileNames) {
        this.myFileFileNames = myFileFileNames;
    }

    public List<String> getMyFileContentType() {
        return myFileContentTypes;
    }

    public void setMyFileContentType(List<String> myFileContentTypes) {
        this.myFileContentTypes = myFileContentTypes;
    }
}
