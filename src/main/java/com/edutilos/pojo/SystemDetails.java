package com.edutilos.pojo;


public class SystemDetails {
  private String env;
  private long ram ;
  private String os ;
  private String cpu;
  private String videoCard ;


  public SystemDetails(String env, long ram, String os, String cpu, String videoCard) {
    this.env = env;
    this.ram = ram;
    this.os = os;
    this.cpu = cpu;
    this.videoCard = videoCard;
  }

  public SystemDetails() {
  }

  public String getEnv() {
    return env;
  }

  public void setEnv(String env) {
    this.env = env;
  }

  public long getRam() {
    return ram;
  }

  public void setRam(long ram) {
    this.ram = ram;
  }

  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public String getCpu() {
    return cpu;
  }

  public void setCpu(String cpu) {
    this.cpu = cpu;
  }

  public String getVideoCard() {
    return videoCard;
  }

  public void setVideoCard(String videoCard) {
    this.videoCard = videoCard;
  }

  @Override
  public String toString() {
    return "SystemDetails{" +
            "env='" + env + '\'' +
            ", ram=" + ram +
            ", os='" + os + '\'' +
            ", cpu='" + cpu + '\'' +
            ", videoCard='" + videoCard + '\'' +
            '}';
  }
}
