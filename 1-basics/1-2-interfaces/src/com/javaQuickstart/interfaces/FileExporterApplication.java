package com.javaQuickstart.interfaces;

import com.javaQuickstart.interfaces.export.FileExportOperation;
import com.javaQuickstart.interfaces.export.SftpFileExportService;

public class FileExporterApplication {

  // Implement the FileExportOperation interface in another class, and then replace the Sftp exporter with it.
  // You shouldn't need to change anything else for the code to run!
    private static final FileExportOperation fileExportOperation = new SftpFileExportService();

    public static void main(String[] args) {
      fileExportOperation.export();
    }
}
