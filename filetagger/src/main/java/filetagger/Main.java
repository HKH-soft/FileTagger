package filetagger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import filetagger.filemanager.FileManagmentInteface;
import filetagger.filemanager.FileManagmentJavaIOImplementation;
import filetagger.models.Tags;

public class Main {
    public static void main(String[] args) {
        FileManagmentInteface fileManagmentInteface = new FileManagmentJavaIOImplementation();
        String location;
        if(args.length <= 0){
            location = ".";
        }else{
            location = args[0];
        }
        Path path = Paths.get(location);
        try {
            List<String> listAllFiles = fileManagmentInteface.listAllFiles(path);
            for (String name : listAllFiles) {
                System.out.println(name);
            }
            String fileName = listAllFiles.stream()
                .filter(name -> name.equals("testFile"))
                .findFirst()
                .orElseThrow();
            Path sourcePath = Paths.get(location,fileName);
            String tag = "[test] - ";
            Path newSourcePath = Paths.get(location,tag + fileName);
            fileManagmentInteface.addTag(tag, sourcePath);
            // Thread.sleep(2000);
            fileManagmentInteface.removeTag(tag, newSourcePath);
            String parentLocation = "/workspaces/FileTagger/filetagger/src/main/java/filetagger/Storage/";
            System.out.println(fileManagmentInteface.readConfig(Paths.get(parentLocation + "tags.json"), new Tags(List.of())));
    
            fileManagmentInteface.writeConfig(Paths.get(parentLocation + "test.json"), "this is a test for the new thing mannnnnnnnnnnnnnnn!");
        } catch (IOException /*| InterruptedException*/ e) {
            System.out.println(e);
        }
    }

    public Main() {
    }
}