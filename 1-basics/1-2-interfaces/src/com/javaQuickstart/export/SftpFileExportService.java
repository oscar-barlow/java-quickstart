package com.javaQuickstart.export;

public class SftpFileExportService implements FileExportOperation {

  @Override
  public void export() {
    System.out.println("Uploading file to SFTP...");
  }
}
