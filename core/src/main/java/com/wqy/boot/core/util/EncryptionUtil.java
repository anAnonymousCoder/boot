package com.wqy.boot.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * 加密工具类
 *
 * @author wqy
 * @version 1.0 2020/11/13
 */
public class EncryptionUtil {

    //单例
    private EncryptionUtil() {
    }

    //MD5加盐
    private static final String salt = "NUIST";

    private static final Logger logger = LoggerFactory.getLogger(EncryptionUtil.class);

    /**
     * 信息摘要加密算法
     *
     * @param password        原密码
     * @param digestAlgorithm 信息摘要算法
     * @return 加密后的32位密码
     */
    public static String encrypt(String password, String digestAlgorithm) {
        password = password.concat(salt);
        MessageDigest md;
        byte[] bytes;
        try {
            md = MessageDigest.getInstance(digestAlgorithm);
            bytes = password.getBytes(StandardCharsets.UTF_8);
            byte[] mdBytes = md.digest(bytes);
            StringBuilder hexValue = new StringBuilder();
            for (byte b : mdBytes) {
                int val = ((int) b) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());  //打印错误
            return password;  //没有对应的加密算法则返回原密码
        }
    }

    /**
     * 将输入的密码和数据库中的密码进行比对
     *
     * @param inputPwd           输入的密码
     * @param password        数据库取出的md5密码
     * @param digestAlgorithm 信息摘要算法
     * @return 比对结果
     */
    public static boolean equals(String inputPwd, String password, String digestAlgorithm) {
        return password.contentEquals(encrypt(inputPwd, digestAlgorithm));
    }


}
