package com.edutilos.converter;

import com.edutilos.pojo.SystemDetails;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

/**
 * Created by edutilos on 30/08/2016.
 */
public class SystemDetailsConverter extends StrutsTypeConverter {
    private Logger logger = LogManager.getLogger(SystemDetailsConverter.class);
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        String input = values[0];
        logger.info(input);
        String[]splitted = input.split(";");
        for(String str: splitted)
                logger.info(str);
        /*
          private String env;
  private double ram ;
  private String os ;
  private String cpu;
  private String videoCard ;
         */
        try {
            String env = splitted[0];
            long  ram = Long.valueOf(splitted[1]);
            String os = splitted[2];
            String cpu = splitted[3];
            String videoCard = splitted[4];
            return new SystemDetails(env, ram , os, cpu, videoCard);
        } catch(Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public String convertToString(Map context, Object o) {
        SystemDetails sd = (SystemDetails)o;
           /*
          private String env;
  private double ram ;
  private String os ;
  private String cpu;
  private String videoCard ;
         */
        String env = sd.getEnv();
        long ram = sd.getRam();
        String os = sd.getOs();
        String cpu = sd.getCpu();
        String videoCard = sd.getVideoCard();
        return String.format("%s;%d;%s;%s;%s", env, ram, os, cpu, videoCard);
    }
}
