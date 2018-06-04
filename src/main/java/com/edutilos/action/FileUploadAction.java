package com.edutilos.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Created by edutilos on 30/08/2016.
 */
public class FileUploadAction extends ActionSupport{
    private File myFile ;
    private String myFileFileName;
    private String myFileContentType ;
    private String destDir ;
  private Logger logger = LogManager.getLogger(FileUploadAction.class);

    public String execute() {
        destDir = "C:/Users/edutilos/Desktop/temp";
       // destDir ="";
        logger.info(String.format("src File = %s", myFile));
        logger.info(String.format("dest file = %s", myFileFileName));
        logger.info(String.format("contentType = %s", myFileContentType));
        try {
            File destFile = new File(destDir , myFileFileName);
            FileUtils.copyFile(myFile, destFile);
        } catch(Exception ex) {
            ex.printStackTrace();
            return ERROR;
        }
        return SUCCESS ;
    }


    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }
}
