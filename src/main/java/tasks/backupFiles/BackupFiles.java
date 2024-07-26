package tasks.backupFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackupFiles {
    public static void main(String[] args) {
        File sourceDir = new File(".");
        File backupDir = new File("./backup/");

        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        File[] files = sourceDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Files.copy(file.toPath(), new File(backupDir.getAbsolutePath() +
                                File.separator + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Backup of file: " + file.getName());
                    } catch (IOException e) {
                        System.err.println("Error copying file: " + file.getName());
                    }
                }
            }
        }
    }
}
