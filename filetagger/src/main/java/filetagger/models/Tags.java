package filetagger.models;

import java.util.List;

public record Tags(
    List<String> tags
) {
    public Tags(){
        this(List.of());
    }
}
