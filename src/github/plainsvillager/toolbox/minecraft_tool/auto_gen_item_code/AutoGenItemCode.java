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
                case 1 -> forgeInit();
                case 2 -> fabricInit();
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
//            switch (needExtra) {
//                case "N" -> fabricItem.fabricGen();
//                case "Y" -> {
//
//                }
//            }

            System.out.println("是否可燃（Y/N）");
            fabricItem.setFireProof(scI.next());

            fabricItem.fabricGen();
        }
    }
}
