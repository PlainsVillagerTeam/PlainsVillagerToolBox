package github.plainsvillager.toolbox.minecraft_tool.auto_gen_item_code;

import github.plainsvillager.toolbox.ToolBoxVersion;


@ToolBoxVersion(value = "0.3-beta.2")
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

    /**
     * 创建方法，抽象，返回void
     * @author PlainsVillager
     * @see FabricItem#generate()
     */
    protected abstract void generate();
}
