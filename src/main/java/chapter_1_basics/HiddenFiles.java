package chapter_1_basics;

import java.io.File;
import java.io.FileFilter;

public class HiddenFiles {
    public static void main(String[] args) {
        // Old style
//        System.out.println("Old style");
//        File[] hiddenFiles = new File("C:\\Test").listFiles(new FileFilter(){
//            public boolean accept(File file) {
//                return file.isHidden();
//            }
//        });
//
//        if (hiddenFiles == null || hiddenFiles.length == 0) {
//            System.out.println("Директория C:\\Test пуста");
//        }

        File directory = new File("").getAbsoluteFile();
        System.out.println("Ищем скрытые файлы. Проверяем directory = " + directory);

        // Old style
        System.out.println("Old style");
        File[] hiddenFiles = directory.listFiles(new FileFilter(){
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        if (hiddenFiles == null || hiddenFiles.length == 0) {
            System.out.println("Директория пуста");
            return;
        }

        for (File file : hiddenFiles) System.out.println(file);

        // Java 8 style
        System.out.println("New style");
        File[] hiddenFilesJava8 = directory.listFiles(File::isHidden);
        for (File file : hiddenFilesJava8) {
            System.out.println(file);
        }
    }
}
