import java.io.File;
import java.io.FileFilter;

public class HiddenFiles {
    public static void main(String[] args) {
        // Old style
        System.out.println("Old style");
        File[] hiddenFiles = new File("C:\\Test").listFiles(new FileFilter(){
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        if (hiddenFiles == null || hiddenFiles.length == 0) {
            System.out.println("Директория C:\\Test пуста");
        }

        for (File file : hiddenFiles) System.out.println(file);

        // Java 8 style
        System.out.println("New style");
        File[] hiddenFilesJava8 = new File("C:\\Test").listFiles(File::isHidden);
        for (File file : hiddenFilesJava8) System.out.println(file);
    }
}
