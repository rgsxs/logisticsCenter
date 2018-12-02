package com.file;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;



/**
 * AES Coder<br/>
 * secret key length: 128bit, default: 128 bit<br/>
 * mode: ECB/CBC/PCBC/CTR/CTS/CFB/CFB8 to CFB128/OFB/OBF8 to OFB128<br/>
 * padding: Nopadding/PKCS5Padding/ISO10126Padding/
 * 
 * @author Aub
 * 
 */
public class AESCoder {

	/**
	 * 密钥算法
	 */
	private static final String KEY_ALGORITHM = "AES";

	private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

	/**
	 * 初始化密钥
	 * 
	 * @return byte[] 密钥
	 * @throws Exception
	 */
	public static byte[] initSecretKey(String code) {
		// 返回生成指定算法的秘密密钥的 KeyGenerator 对象

		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance(KEY_ALGORITHM);

			// 初始化此密钥生成器，使其具有确定的密钥大小
			// AES 要求密钥长度为 128
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(code.getBytes());
			kg.init(128, secureRandom);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return new byte[0];
		}
		// 生成一个密钥
		SecretKey secretKey = kg.generateKey();
		return secretKey.getEncoded();
	}

	/**
	 * 转换密钥
	 * 
	 * @param key
	 *            二进制密钥
	 * @return 密钥
	 */
	private static Key toKey(byte[] key) {
		// 生成密钥
		return new SecretKeySpec(key, KEY_ALGORITHM);
	}

	/**
	 * 加密
	 * 
	 * 
	 * @param InputStream
	 *            待加密输入流
	 * @param code
	 *            密码
	 * @return CipherInputStream 已加密输入流
	 * @throws Exception
	 */
	public static InputStream encrypt(InputStream in, String code)
			throws Exception {

		byte[] key = initSecretKey(code);

		Key k = toKey(key);

		Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
		cipher.init(Cipher.ENCRYPT_MODE, k);// 初始化

		CipherInputStream cis = new CipherInputStream(in, cipher);

		return cis;
	}

	/**
	 * 加密
	 * 
	 * 
	 * @param InputStream
	 *            待加密输出流
	 * @param code
	 *            密码
	 * @return CipherInputStream 已加密输出流
	 * @throws Exception
	 */
	public static OutputStream encrypt(OutputStream out, String code)
			throws Exception {

		byte[] key = initSecretKey(code);

		Key k = toKey(key);

		Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
		cipher.init(Cipher.ENCRYPT_MODE, k);// 初始化

		CipherOutputStream cos = new CipherOutputStream(out, cipher);

		return cos;
	}

	/**
	 * 解密
	 * 
	 * 
	 * @param InputStream
	 *            待解密输入流
	 * @param code
	 *            密码
	 * @return CipherInputStream 已解密输入流
	 * @throws Exception
	 */
	public static InputStream decrypt(InputStream in, String code)
			throws Exception {

		byte[] key = initSecretKey(code);

		Key k = toKey(key);

		Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
		cipher.init(Cipher.DECRYPT_MODE, k);// 初始化

		CipherInputStream cis = new CipherInputStream(in, cipher);

		return cis;
	}

	/**
	 * 解密
	 * 
	 * 
	 * @param InputStream
	 *            待解密输出流
	 * @param code
	 *            密码
	 * @return CipherInputStream 已加密输出流
	 * @throws Exception
	 */
	public static OutputStream decrypt(OutputStream out, String code)
			throws Exception {

		byte[] key = initSecretKey(code);

		Key k = toKey(key);

		Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM);// 创建密码器
		cipher.init(Cipher.DECRYPT_MODE, k);// 初始化

		CipherOutputStream cos = new CipherOutputStream(out, cipher);

		return cos;
	}
	
	public static String decrypt(String sSrc, String sKey) throws Exception {
		try {
			//判断Key是否正确
			if (sKey == null) {
				System.out.print("Key为空null");
				return null;
			}
			byte[] raw = initSecretKey(sKey);
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = hex2byte(sSrc);
			try {
				byte[] original = cipher.doFinal(encrypted1);
				String originalString = new String(original);
				return originalString;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	//判断Key是否正确
	public static String encrypt(String sSrc, String sKey) throws Exception {
		if (sKey == null) {
			System.out.print("Key为空null");
			return null;
		}
		byte[] raw = initSecretKey(sKey);
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] encrypted = cipher.doFinal(sSrc.getBytes());
		return byte2hex(encrypted).toLowerCase();
	}
	
	public static byte[] hex2byte(String strhex) {
		if (strhex == null) {
		return null;
		}
		int l = strhex.length();
		if (l % 2 == 1) {
		return null;
		}
		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; i++) {
		b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
		}
		return b;
	}
	
	public static String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
			hs = hs + "0" + stmp;
			} else {
			hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}
	
	/**
	 * 生成随机密钥
	 * @return
	 */
	public static String randomKey(){
		String keys = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int length = (int)(Math.random()*16+16);
		int i=0;
		String key = "";
		while(i<length){
			int j = (int)(Math.random()*61);
			if(j<=61){
				key+=keys.substring(j,j+1);
				i++;
			}
		}
		return key;
		
	}
	
	public static void main(String[] args) throws Exception{
		String encrypt = AESCoder.encrypt("ecologyxindaoa@weaver.com.cn","WEAVERECOLOGYDBENCODER");
		System.out.println(encrypt);
		System.out.println(AESCoder.decrypt(encrypt,"WEAVERECOLOGYDBENCODER"));
	}

}
