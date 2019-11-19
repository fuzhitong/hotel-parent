/**
 * Project Name:dt60_pure
 * File Name:MD5.java
 * Package Name:cn.java.utils
 * Date:上午11:59:07
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 *
*/

package net.fuzt.utils;

import java.security.MessageDigest;

/**
 * Description: MD5加密的工具<br/>
 * Date: 上午10:18:30 <br/>
 * 
 * @author 丁鹏
 * @version
 * @see
 */
public class MD5Tool {

    /**
     * 定义个16进制
     */
    private static final String[] digital = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
            "f" };

    /**
     * 
     * Description: 通过MD5算法进行一次加密<br/>
     *
     * @author 丁鹏
     * @param txt：明文
     * @return：加密之后的32位的字符串
     * @throws Exception
     */
    private static String encription(String txt) throws Exception {
        // 通过MD5对明文进行加密---->密文(32位字符串)
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest((txt + "").getBytes("UTF-8"));
        StringBuffer miWen = new StringBuffer("");
        for (byte b : digest) {
            int temp = b;
            if (temp < 0) {
                temp += 256;
            }
            // temp此时一定为正数
            int index1 = temp / 16;
            int index2 = temp % 16;
            // miWen += digital[index1] + digital[index2];
            miWen.append(digital[index1]).append(digital[index2]);
        }
        return miWen.toString();
    }

    /**
     * 
     * Description: md5加密最终方法<br/>
     *
     * @author 丁鹏
     * @param txt
     * @return
     * @throws Exception
     */
    public static String md5(String txt) throws Exception {
        return encription(encription(encription(txt) + txt + "dingPeng") + "dingPeng" + txt);
    }

}
