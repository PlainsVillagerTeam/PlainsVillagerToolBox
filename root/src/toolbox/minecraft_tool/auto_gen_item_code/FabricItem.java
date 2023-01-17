package toolbox.minecraft_tool.auto_gen_item_code;

public class FabricItem extends ModLoaderItem{


    public FabricItem() {
        super();
    }

    public FabricItem(String namespace, String path, String fireProof) {
        super(namespace,path,fireProof);
    }

    public String getNamespace() {
        return super.getNamespace();
    }

    public void setNamespace(String namespace) {
        super.setNamespace(namespace);
    }

    public String getPath() {
        return super.getPath();
    }

    public void setPath(String path) {
        super.setPath(path);
    }

    public String isFireProof() {
        return super.getFireProof();
    }

    public void setFireProof(String fireProof) {
        super.setFireProof(fireProof);
    }

    protected void fabricGen() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("public class ModMain implements ModInitializer {\n" +
                "\tpublic static final String MOD_ID =\"" + getNamespace() + "\";\n" +
                "    public static final Logger LOGGER = LoggerFactory.getLogger(\"modid\");\n" +
                "\n\tpublic static final Item " + getPath().toUpperCase() + " =  new Item(new FabricItemSettings()");
        switch (getFireProof()){
            case "Y" :
                stringBuilder.append(".fireproof())");
            default:
                break;
        }
        stringBuilder.append(";+"+
                "\n" +
                "\t@Override\n" +
                "\tpublic void onInitialize() {\n" +
                "\t\tRegistry.register(Registries.ITEM,new Identifier(\"" +getNamespace() + "\", \""+getPath()+"\"), "+getPath().toUpperCase()+");\n" +
                "\t\tLOGGER.info(\"Hello Fabric world!\");\n" +
                "\t}\n" +
                "}");
        System.out.println(stringBuilder);
    }
}
