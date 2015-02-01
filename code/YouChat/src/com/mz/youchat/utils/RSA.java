package com.mz.youchat.utils;
/*
 * Copyright (C) 2010 The MobileSecurePay Project
 * All right reserved.
 * author: shiqun.shi@alipay.com
 */




import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import com.mz.youchat.YouChatApp;



/**
 * RSA?????????????
 * 
 */
public class RSA {

	private static final String ALGORITHM = "RSA";
	public static final String PUBLIC_KEY_NAME = "Public.key";
	public static final String PRIVATE_KEY_NAME = "Private.key";
	
	public static Map<String, String> genNewKeys()
	{
		Map<String, String> keys = new HashMap<String, String>();
		KeyPairGenerator keyPairGenerator;
		
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			
			keyPairGenerator.initialize(1024);
			
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			
			keys.put(RSA.PRIVATE_KEY_NAME, Base64.encode(privateKey.getEncoded()));
			keys.put(RSA.PUBLIC_KEY_NAME, Base64.encode(publicKey.getEncoded()));
			
			
			SharedPreferenceUtils.init(YouChatApp.getInstance().getApplicationContext());
			SharedPreferenceUtils.store(RSA.PRIVATE_KEY_NAME, keys.get(RSA.PRIVATE_KEY_NAME));
			SharedPreferenceUtils.store(RSA.PUBLIC_KEY_NAME, keys.get(RSA.PUBLIC_KEY_NAME));
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return keys;
	}
	
	public static String decrypt(String data)
	{
		byte[] descryptedData = null;
		try {
			Key keys = getPrivateKeyFromPKCS8(ALGORITHM,SharedPreferenceUtils.getString(PRIVATE_KEY_NAME));
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, keys);
			descryptedData = cipher.doFinal(Base64.decode(data));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return new String(descryptedData);
	}

	private static PrivateKey getPrivateKeyFromPKCS8(String algorithm,
			String bysKey) throws NoSuchAlgorithmException, Exception {
		PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
				Base64.decode(bysKey));
		KeyFactory keyf = KeyFactory.getInstance(algorithm);
		
		return keyf.generatePrivate(priPKCS8);
	}
	private static PublicKey getPublicKeyFromX509(String algorithm,
			String bysKey) throws NoSuchAlgorithmException, Exception {
		byte[] decodedKey = Base64.decode(bysKey);
		X509EncodedKeySpec x509 = new X509EncodedKeySpec(decodedKey);

		KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
		return keyFactory.generatePublic(x509);
	}

	public static String encrypt(String content) {
		try {
			PublicKey pubkey = getPublicKeyFromX509(ALGORITHM, SharedPreferenceUtils.getString(PUBLIC_KEY_NAME));

			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, pubkey);

			byte plaintext[] = content.getBytes("UTF-8");
			byte[] output = cipher.doFinal(plaintext);

			String s = new String(Base64.encode(output));

			return s;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	public static String sign(String content, String privateKey) {
		String charset = "utf-8";
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
					Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance("RSA");
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initSign(priKey);
			signature.update(content.getBytes(charset));

			byte[] signed = signature.sign();

			return Base64.encode(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean doCheck(String content, String sign, String publicKey) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			byte[] encodedKey = Base64.decode(publicKey);
			PublicKey pubKey = keyFactory
					.generatePublic(new X509EncodedKeySpec(encodedKey));

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);
			signature.update(content.getBytes("utf-8"));

			boolean bverify = signature.verify(Base64.decode(sign));
			return bverify;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> keys = genNewKeys();
		String privKey = keys.get(PRIVATE_KEY_NAME);
		String pubKey = keys.get(PUBLIC_KEY_NAME);
		String pvKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAI9rF4kKkuS7vp71j2lgvLa/I3Ztl+nZeGG6TVKqqf2EAWI+kGSAplo0Swz8IVIv3zKdZB6RNzt/s4OyUT7+2Lj5TuCEKo+SLf6p0GtYbhO4wzm62D7NWwyF/PUTte3IMLwyxyPSYj+mNn0iaxNr4vF6QRVnwsTA4+0XSguoa+xhAgMBAAECgYAEKhjp2su/JpB3byv15GA2ckBmXPJPUQhE1jMOlnQPL3kW0DhDItUxw1j2jI+vIkK55oYUuSTAbonY5iGj0aSbVz4AWkpGQlc6HvDEWpJ3b/vdpkOyscqqoVsPW2xfAVMVnA/y4LOMI5u9o4iFRj3oJX6O6q0J6vdosV+2kOvTQQJBANFcGf+dgVkz5UkvmqjSgTtjoKKnXkbrou0MsAex3OLak4nCyQ9OP0mEIvQR4BMmcSRlhjKuzGFWZtijOe+FaUkCQQCvXlCimaCAnPI1U47+D0MPSqlau9ioJvtIzbxOGpvEGNMVO+vTkUPfVgkGpGz0fcK8ih3oAGJguDbnj0kYOcJZAkAI/hrDxwEqUrdTiG7tN3WDlojs06GSDEcIRZY+Dl69g8P4k9xNAwBm6P0TXL0yNWGAvbeg768psythvMkdR665AkBaRIvxBm7thNvPwzEJaUW1a1L9F1AQTfBuqyfQdDXVnImalntvLYjoPtrqhlxnBQzmC5oVP41kB66LRt/zDlgRAkAw3ZhigUYv4tqsMTRHLi6fcV63z/04rKXq4L8enviH07JPOomqzhnh1dtHjSoOcTt5YIoIFeewgNcdcjRwMyMX";
		String pbKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCPaxeJCpLku76e9Y9pYLy2vyN2bZfp2Xhhuk1Sqqn9hAFiPpBkgKZaNEsM/CFSL98ynWQekTc7f7ODslE+/ti4+U7ghCqPki3+qdBrWG4TuMM5utg+zVsMhfz1E7XtyDC8Mscj0mI/pjZ9ImsTa+LxekEVZ8LEwOPtF0oLqGvsYQIDAQAB";
		
		
		String endata = encrypt("nast");
		//String deData = decrypt("RjJz+JcCc1jocnAwx9r6AKpJ6B8AFvKfIxWo3jOWdX2Vv+fV3GRX3p3zv8A0l6L6V/dePtfjQZFcl1nEq3PK2mvwgrC+IP/bntzbyPxpZ1Xk2xav7fzTJ+7PmE0o6Ip2/3tj3NxaNLvbNkXnoS2YUSPrJcDQr80Ui+95ZkFqW7k=", pvKey);
		System.out.println(privKey);
		System.out.println(pubKey);
	}
}
