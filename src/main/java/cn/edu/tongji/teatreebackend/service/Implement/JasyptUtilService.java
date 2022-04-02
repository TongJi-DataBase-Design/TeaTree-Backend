package cn.edu.tongji.teatreebackend.service.Implement;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.PBEConfig;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

/**
 *  JasyptUtilService类
 *
 * @author 梁乔
 * @date 2022/3/31 0:33
 */
public class JasyptUtilService {

    /**
     * Jasypt生成加密结果
     * @param password 配置文件中设定的加密密
     * @param value 加密值
     * @return
     */
    public static String encyptPwd(String password,String value){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptor(password));
        String result = encryptor.encrypt(value);
        return result;
    }

    /**
     * 解密
     * @param password 配置文件中设定的加密密码
     * @param value 解密密文
     * @return
     */
    public static String decyptPwd(String password,String value){
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setConfig(cryptor(password));
        String result = encryptor.decrypt(value);
        return result;
    }

    public static PBEConfig cryptor(String password){
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        return config;
    }

    public static void main(String[] args){
        //加密
        System.out.println(encyptPwd("jasypt","123456"));
        //解密
        System.out.println(decyptPwd("jasypt","0T9+N1VQGfxzcRli07NKuw=="));
    }
}
