package com.examples.lesson06.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InfoServiceImpl implements InfoService {

  @Override
  public String calculateServerName() {
    return "TEST SERVER";
  }

  @Override
  public String calculateServerMemory() {
    return formatBytes(Runtime.getRuntime().maxMemory());
  }

  @Override
  public String calculateServerFreeMemory() {
    return formatBytes(Runtime.getRuntime().freeMemory());
  }

  @Override
  public String calculateServerCores() {
    return Integer.toString(Runtime.getRuntime().availableProcessors());
  }

  @Override
  public String calculateServerTime() {
    return new SimpleDateFormat().format(new Date());
  }

  private String formatBytes(long bytes) {
    if (bytes < 1024) {
      return bytes + "B";
    }
    if (bytes < 1024 * 1024) {
      return (bytes / 1024) + "KB";
    }
    return (bytes / (1024 * 1024)) + "MB";
  }
}
