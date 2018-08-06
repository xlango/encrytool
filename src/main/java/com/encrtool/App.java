package com.encrtool;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import java.io.*;
import java.security.Key;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Key getKey1(String encodeKey) throws Exception {

        // 创建一个空的8位字节数组（默认值为0）
        byte[] arrBTmp = encodeKey.getBytes();
        System.out.println("密钥长度为 "+arrBTmp.length);
        byte[] arrB = new byte[8];
        // 将原始字节数组转换为8位
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        // 生成密钥

        //System.out.println(arrB.length);
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
        return key;
    }

    /**
     * <p>DES加密文件
     * @param file 源文件
     * @param destFile 加密后的文件
     * @throws Exception
     */
    public static Boolean encrypt(String file, String destFile,String encodeKey) throws Exception {
        try {
            if (encodeKey.length()<=0){
                System.out.println("密钥长度必须大于0");
                return false;
            }else {
                Cipher cipher = Cipher.getInstance("DES");
                cipher.init(Cipher.ENCRYPT_MODE, getKey1(encodeKey));

                InputStream is = null;
                try {
                    is = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    System.out.println("输入路径找不到该文件！");
                    return false;
                }
                OutputStream out = new FileOutputStream(destFile);
                CipherInputStream cis = new CipherInputStream(is, cipher);
                byte[] buffer = new byte[1024];
                int r;
                while ((r = cis.read(buffer)) > 0) {
                    out.write(buffer, 0, r);
                }

                cis.close();
                is.close();
                out.close();
            }
            return true;
        } catch (Exception e) {
            System.out.println("命令错误！");
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        if (encrypt(args[0],args[1],args[2])){
            System.out.println("加密成功，请查看文件： "+args[1]);
        }else {
            System.out.println("加密失败");
        }

    }
}
