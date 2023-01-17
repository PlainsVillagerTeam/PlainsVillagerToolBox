package toolbox.minecraft_tool.auto_gen_item_code;

public abstract class ModLoaderItem {
    private String namespace;
    private String path;
    private String fireProof;

    public ModLoaderItem() {
    }

    public ModLoaderItem(String namespace, String path, String fireProof) {
        this.namespace = namespace;
        this.path = path;
        this.fireProof = fireProof;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFireProof() {
        return fireProof;
    }

    public void setFireProof(String fireProof) {
        this.fireProof = fireProof;
    }
}
