package com.mz.youchat.comm;

public class PartnerConfig {

	// 合作商户ID。用签约支付宝账号登录ms.alipay.com后，在账户信息页面获取。
	public static final String PARTNER = "2088011314451567";
	// 商户收款的支付宝账号
	public static final String SELLER = "2088011314451567";
	// 商户（RSA）私钥
	public static final String RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK4WAl7ZbcjjcCv0I5nHTNB2T0i15H5Y9CNHn/nKgzS7+/DtvGkVD0YKqqBFBz86PaHLTG5m97upOj1k2Wu/PWe8xY/nDNP+cELy6h6etUEsOzBBLpenszAPfoyJnDPv/q8XrXjKf+gLf2yO6IyGREmtCfPdFszYt+Zy2CTQFKK5AgMBAAECgYACB4eni2lYOi6IlKQFmukuVPK/qj8rqeXOs3sN8mptJvPc7yiPIQu4iU9L5wIanpcxV6lgcBrbOTHQnWhbdTNGCWNyh1pEtB1MwV8dGIx3Qrjn9NZT/FXEUHtJATYjwcj8fhUH+AEv+dOVuUMs1Ko/cHQVCP6xkODfRTN37evkAQJBAN7S8bXMrGR9H26CEGHFC4+cP5b92BhQt80W1YWy2Cuucb6t8QUbbcJmFE4lMopg904i9rdT5udwlydsbIklzhkCQQDIAWOe46d5HGWjRw+xBbfk8SRaWK6Vf70zy72M6QixTMu7q75ge0UA3oWKLeARpErDlhI7TBetciZj+BLz5M2hAkEAx2C22PZP1wbCZi5JHEKlKpYjrCZtAqzPGdrxqdUyajuIGZcoj2pQlt6iEp5kD7/d6XONkNKpTLPI/ISexUUnmQJARx2vVYTvPLIrNaaD3tcAr2hLG9DiqwfTt8IfMSZ/T8PVwXJs7BOI0qlM5HgxbzRy3R7Udr80wBiRrAQ+gPh/YQJBALaxS7GuPU6rKGMlZCs4SsWzPo+EBRwVqrtZAjl37zyL1cqZAEjZN2LQF7EHAOTYNoOdB9siwevJJd2sml1VkVI=";
	// 支付宝（RSA）公钥 用签约支付宝账号登录ms.alipay.com后，在密钥管理页面获取。
	public static final String RSA_ALIPAY_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLdct6zkRbpev6mAieCO497N8CqA3+kFQGJDWD1goRXnRNlxaqS52e8mjumMI6u3Mtkk4js3eBMh7PYpsF2FOlsZkLlBZgzCuNG3LN/wTE+TML8vL4WxTfww6iFFvMJMejDj33wKD54xZfeRiTpN1HsJKymd/O+b+ECXyM35gpJwIDAQAB";
	
	// 支付宝安全支付服务apk的名称，必须与assets目录下的apk名称一致
	public static final String ALIPAY_PLUGIN_NAME = "alipay_plugin_20120428msp.apk";
	
}
