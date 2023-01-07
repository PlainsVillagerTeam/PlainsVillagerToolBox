package github.plainsvillager.toolbox.coin_tossing;

import java.util.Random;

/**
 * <h2>抛硬币模块</h2>
 * 实现功能：抛几次<br>
 * 计划：面向对象（计划不用static）
 */
public class CoinTossing {
    private boolean is;

    public CoinTossing() {
        judge(this);
    }


    private void judge(CoinTossing c) {
        Random r = new Random();
        int random = r.nextInt(2);
        switch (random) {
            case 0 -> c.is = false;
            case 1 -> c.is = true;
        }
    }

    public String getIs() {
        String getT = this.is + "";
        switch (getT) {
            case "true" -> {
                return "正面";
            }
            case "false" -> {
                return "反面";
            }
        }
        return getT;
    }
}
