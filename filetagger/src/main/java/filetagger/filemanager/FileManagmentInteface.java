package filetagger.filemanager;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileManagmentInteface {
    public List<String> listAllFiles(Path currentPath) throws IOException ;
    public void addTag(String tag, Path sourcePath) ;
    public void removeTag(String tag, Path sourcePath);
    public <T> T readConfig(Path sourcePath, T configClass) throws IOException ;
    public void writeConfig(Path sourcePath,String change) throws IOException;
    public void appendConfig(Path sourcePath,String change);
}
