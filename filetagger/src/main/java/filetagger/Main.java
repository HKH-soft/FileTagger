package filetagger;

import filetagger.ui.UserInterface;
import filetagger.ui.UserInterfaceCLIImplementation;

public class Main {
    public static void main(String[] args) {
        // FileManagmentInteface fileManagmentInteface = new FileManagmentJavaIOImplementation();
        // String location;
        // if(args.length <= 0){
        //     location = ".";
        // }else{
        //     location = args[0];
        // }
        // Path path = Paths.get(location);
        // try {
        //     List<String> listAllFiles = fileManagmentInteface.listAllFiles(path);
        //     for (String name : listAllFiles) {
        //         System.out.println(name);
        //     }
        //     String fileName = listAllFiles.stream()
        //         .filter(name -> name.equals("testFile"))
        //         .findFirst()
        //         .orElseThrow();
        //     Path sourcePath = Paths.get(location,fileName);
        //     String tag = "[test] - ";
        //     Path newSourcePath = Paths.get(location,tag + fileName);
        //     fileManagmentInteface.addTag(tag, sourcePath);
        //     // Thread.sleep(2000);
        //     fileManagmentInteface.removeTag(tag, newSourcePath);
        //     String parentLocation = "/workspaces/FileTagger/filetagger/src/main/java/filetagger/Storage/";
        //     fileManagmentInteface.readConfig(Paths.get(parentLocation + "tags.json"), new Tags(List.of()));
    
        //     // fileManagmentInteface.writeConfig(Paths.get(parentLocation + "test.json"), tags);
        //     Path configPath = Paths.get(parentLocation + "config");
        //     System.out.println(Files.isRegularFile(configPath));

        // } catch (IOException /*| InterruptedException*/ e) {
        //     System.out.println(e);
        // }
        UserInterface ui = new UserInterfaceCLIImplementation();
        ui.start();
    }

    public Main() {
    }
}