package com.study.drools.util;

public class RandomUtils {
    /**
     * 生成随机数
     *
     * @param num
     * @return
     */
    public static String generateRandom(int num) {
        String chars = "0123456789";
        StringBuffer number = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int rand = (int) (Math.random() * 10);
            number = number.append(chars.charAt(rand));
        }
        return number.toString();
    }

}
