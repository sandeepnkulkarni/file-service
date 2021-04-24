package local.snk.fileservice;

public class File {
    private final String name;
    private final long size;

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }
}
