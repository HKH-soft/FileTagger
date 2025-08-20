package filetagger.logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;

import filetagger.filemanager.FileManagmentInteface;
import filetagger.filemanager.FileManagmentJavaIOImplementation;
import filetagger.models.Config;
import filetagger.models.NameTag;
import filetagger.models.Tags;


public class logic {
    FileManagmentInteface fileManagmentInteface = new FileManagmentJavaIOImplementation(); 
    Gson gson = new Gson();

    Config config = new Config();
    Tags tags = new Tags();
    NameTag nameTag = new NameTag();
    
    String currentLocation;
    
    public logic(String currentLocation) {
        this.currentLocation = currentLocation;
        try{
            Path configPath = Paths.get(currentLocation + "config.json");
            Path tagsPath = Paths.get(currentLocation + "tags.json");
            Path nameTagPath = Paths.get(currentLocation + "nameTags.json");

            if(!Files.isRegularFile(configPath)){
                String data = gson.toJson(config, config.getClass());
                fileManagmentInteface.writeConfig(configPath, data);
            }
            if(!Files.isRegularFile(tagsPath)){
                String data = gson.toJson(tags, tags.getClass());
                fileManagmentInteface.writeConfig(tagsPath, data);
            }
            if(!Files.isRegularFile(nameTagPath)){
                String data = gson.toJson(nameTag, nameTag.getClass());
                fileManagmentInteface.writeConfig(nameTagPath, data);
            }
            config = fileManagmentInteface.readConfig(configPath, config);
            tags = fileManagmentInteface.readConfig(tagsPath, tags);
            nameTag = fileManagmentInteface.readConfig(nameTagPath, nameTag);

        }catch(IOException e){
            System.out.println(e);
        }
    }

    public List<String> getNames(){
        try {
            return fileManagmentInteface.listAllFiles(Paths.get(currentLocation));
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return List.of("There was an error!");
    }
    
    public String getLocation(){
        return currentLocation;
    }

    public List<String> getTags(){
        return tags.tags();
    }
}
