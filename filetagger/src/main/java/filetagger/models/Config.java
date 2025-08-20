package filetagger.models;

public record Config(
    Integer fontSize
) {
    public Config(){
        this(12);
    }
}
