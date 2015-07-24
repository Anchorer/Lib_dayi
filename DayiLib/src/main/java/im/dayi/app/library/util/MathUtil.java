package im.dayi.app.library.util;

import java.math.BigDecimal;

/**
 * 数学工具
 * Created by Anchorer/duruixue on 2015/6/4.
 */
public class MathUtil {

    /**
     * 对float类型数据按指定位数转化
     * @param ft    源float数据
     * @param scale 保留小数位数
     */
    public static float formatFloat(float ft, int scale) {
        BigDecimal bd = new BigDecimal(ft);
        bd = bd.setScale(scale, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}
