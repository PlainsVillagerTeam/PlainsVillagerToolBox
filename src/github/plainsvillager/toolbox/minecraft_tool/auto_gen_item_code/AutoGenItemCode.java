package github.plainsvillager.toolbox.minecraft_tool.auto_gen_item_code;

import github.plainsvillager.toolbox.Main;

import java.util.Scanner;

/**
 * <h2>自动生成Minecraft物品代码</h2>
 *
 * @author PlainsVillager
 */
public class AutoGenItemCode {

    public static class Init {
        public static Scanner scI = Main.sc;

        public static void init() {
            System.out.println("根据对应MC版本自动生成一个物品的代码");
            System.out.println("可选的Minecraft版本：【1】1.19.3");
            //以后加上
            System.out.println("可选的Loader版本：【1】Forge 【2】Fabric");
            int choice = scI.nextInt();
            switch (choice) {
                case 1 -> {
                    forgeInit();
                }
                case 2 -> {
                    fabricInit();
                }
            }
        }

        private static void forgeInit() {
        }

        private static void fabricInit() {
            FabricItem fabricItem = new FabricItem();
            System.out.println("输入这个物品的命名空间（namespace）");
            fabricItem.setNamespace(scI.next());

            System.out.println("输入这个物品的路径（path）");
            fabricItem.setPath(scI.next());

            System.out.println("是否需要其他属性？（Y/N）");
            String needExtra = scI.next();
            switch (needExtra) {
                case "N" -> fabricItem.fabricGen();
                case "Y" -> {
                }
            }

            System.out.println("是否可燃（Y/N）");
            fabricItem.setFireProof(scI.next());

            fabricItem.fabricGen();
        }
    }

    protected static void forgeGen() {
    }


    /**
     *
     */
    public static class FabricItem {
        private String namespace;
        private String path;
        private String fireProof;

        public FabricItem() {
        }

        public FabricItem(String namespace, String path, String fireProof) {
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

        public String isFireProof() {
            return fireProof;
        }

        public void setFireProof(String fireProof) {
            this.fireProof = fireProof;
        }

        protected void fabricGen() {
            StringBuilder sb = new StringBuilder();

            sb.append("public class ModMain implements ModInitializer {\n" +
                    "\tpublic static final String MOD_ID =\"" + namespace + "\";\n" +
                    "    public static final Logger LOGGER = LoggerFactory.getLogger(\"modid\");\n" +
                    "\n\tpublic static final Item " + path.toUpperCase() + " =  new Item(new FabricItemSettings()");
            switch (fireProof){
                case "Y" :
                    sb.append(".fireproof());");
                default:
            }
            sb.append(";+"+
            "\n" +
                    "\t@Override\n" +
                    "\tpublic void onInitialize() {\n" +
                    "\t\tRegistry.register(Registries.ITEM,new Identifier(\"" +namespace + "\", \""+path+"\"), "+path.toUpperCase()+");\n" +
                    "\t\tLOGGER.info(\"Hello Fabric world!\");\n" +
                    "\t}\n" +
                    "}");
            System.out.println(sb);
        }
    }
}
