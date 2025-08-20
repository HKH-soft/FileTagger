package filetagger.filemanager;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;


public class FileManagmentJavaIOImplementation implements FileManagmentInteface{
    @Override
    public List<String> listAllFiles(Path path) throws IOException {
        List<String> nameList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) 
        {
            for (Path entry : stream) {
                    nameList.add(entry.getFileName().toString());
            }
        }
            return nameList;
    }

    @Override
    public <T> T readConfig(Path sourcePath, T configClass) throws IOException {
        Gson gson = new Gson();
        System.out.println(sourcePath+"path");
        try {
            // old version
            // FileInputStream fis = new FileInputStream(sourcePath.toFile());
            // String data = IOUtils.toString(fis, "UTF-8");
            StringBuilder data = new StringBuilder();
            Files.readAllLines(sourcePath).stream()
                .forEach(line -> data.append(line));
            System.out.println(data);
            configClass = (T) gson.fromJson(data.toString(), configClass.getClass());
        } catch (IOException e) {
            System.out.println(e);
        }
        return configClass;
    }

    @Override
    public void writeConfig(Path sourcePath,String change) throws IOException {
        byte[] changedFileInBytes = change.getBytes();
        try {
            Files.write(sourcePath, changedFileInBytes);
            System.out.println("writing was sccessful!");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public void appendConfig(Path sourcePath,String change) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'appendConfig'");
    
    }
    @Override
    public void addTag(String tag, Path sourcePath) {
        Path destPath = Paths.get(sourcePath.getParent().toString(), tag + sourcePath.getFileName().toString());
        System.out.println(destPath.getParent());

        try {
            Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File renamed successfully.");
        } catch (IOException e) {
            System.err.println("Failed to rename file: " + e.getMessage());
        }
    }
    @Override
    public void removeTag(String tag, Path sourcePath) {
        Path destPath = Paths.get(sourcePath.getParent().toString(), sourcePath.getFileName().toString().substring(tag.length()) );
        System.out.println(destPath.getParent());

        try {
            Files.move(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File renamed successfully.");
        } catch (IOException e) {
            System.err.println("Failed to rename file: " + e.getMessage());
        }
    }
}
