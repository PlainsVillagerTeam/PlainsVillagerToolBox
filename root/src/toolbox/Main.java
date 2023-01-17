package toolbox;

import toolbox.coin_tossing.CoinTossing;
import toolbox.minecraft_tool.auto_gen_item_code.AutoGenItemCode;

import java.util.Scanner;

/**
 * <h2>主类</h2>
 * @author PlainsVillager
 * @version 0.1
 * @since 1.14514
 */
public class Main {
    public static final String VERSION = "0.2";
    public static Scanner sc = new Scanner(System.in); // 扫描输入

    /**
     * <h2>主方法</h2>
     * @param args main形参
     * @throws Exception 退出
     * @throws IllegalStateException 非选项
     */
    public static void main(String[] args) throws Exception {

        // 本来想用Runnable接口的
        Thread welcomeThread = new Thread(Main::welcome);
        welcomeThread.start();
        // 现在线程死亡

        Thread mainT = new Thread(()->{
            while (true) {
                int choice = sc.nextInt(); //接收选择
                switch (choice) {
                    case 1 -> {
                        System.out.println("请输入抛硬币的次数");
                        int times = sc.nextInt();
                        for (int i = 0; i < times; i++) {
                            System.out.println(new CoinTossing().getIs());
                        }
                    }
                    case 2 -> AutoGenItemCode.Init.init();
                    case 114514 -> System.exit(0);
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                }
                System.out.println("如果继续，请继续输入选项！");
            }
        });
        mainT.start();

    }

    /**
     * 欢迎方法
     */
    private static void welcome() {
        System.out.println("欢迎来到村民工具箱，版本：" + VERSION);
        System.out.println("主页：https://github.com/PlainsVillager/PlainsVillagerToolBox");
        System.out.println("贡献：fork后创建自己的特性分支或“feat_1”这种格式，并提交pull request");
        System.out.println("QQ群：214368462");
        System.out.println("选项：（请输入对应数字）");
        System.out.println("【1】：抛硬币——可以在你犹豫不决时做出选择");
        System.out.println("【2】：Minecraft工具：根据对应MC版本自动生成一个物品的代码，不同类之间使用===========号间隔");
        System.out.println("【3】：查车牌号归属地");
        System.out.println("更多功能逐渐开发中！");
        System.out.println("【114514】：“优雅地”退出程序");
    }
}
