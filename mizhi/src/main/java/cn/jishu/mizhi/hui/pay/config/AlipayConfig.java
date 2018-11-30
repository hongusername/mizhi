package cn.jishu.mizhi.hui.pay.config;

/**
 * 类名：AlipayConfig
 * 功能：基础配置类
 * 详细：设置帐户有关信息及返回路径
 * 修改日期：2018-11-27
 */
public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092100564029";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCGZoc/+/3EHzQRbfD4DAqlM7ZKsO0/RcwDfG/ZwzX3kH89IZ5YlnE5sXLrgUoGnv6yRUOe8Hzh6VgXb44IoPlEkafsXOYo439kah1gReCTWMmmuigkRqs7WRY9q/hhCpWg0zHn24dinK0KM+krm4ztDA+WaIVlCYd+KnDszt7L5HhDoupiRXYO4fRJux9SRP0WrWXMdIcnwTMphyxpYIVzx+teqhCRbgYFhvswu3vxFk4A8HbdKcHPjJYklTg156u+UeVpJ5oVB09rMncEFzn8d3VJhbX6qhIGDi8pKCP9UmYeJ85IchVVg72wZsXKXNaZK3bvN0GIPsMIvfDXPxD/AgMBAAECggEBAIKZtuvSLvIZcDtPnk0rRlzqN0W1T5WgeXMZxIbTTunWnA4HURu8dSIe8REwfYKZld4duGwGPRQ578Q2Psrbwd2DvK3OSEmLaAtnokwfGu+T48AEPWWi1lnBY/9h0OZbprK1B1XK2XBV10CG2Rnq+bKPecYqoxVfgS50h29WRuHRJCvgO3ilKHMQ0Lo95Vyncn12M5wXOu9DVIJiuStGxOYk2nznnuCg9zUiUSx/qPdCvXQkaiLE2nLNxPl+AH0VQKcQxSaYtJKYAmthE8LWD/yLT6kCh3+xsQyLbl6cWdLooBpcWGoTD7vB2rPXOXEdENwHIO99v2Y0ojtxUF5/TEECgYEAx2dwKU74bAyHHon7dLAOmvGsOiyWkKw6KFyUHQiqfGO0X+scYBWQXFF9ql76wZCLPBG8hinJl6Q2PCyoNqcqpMixU3T0b4omTWxPacJ3OpUpg+pMqe2y9xy+4XcNXTvrVpZTBrbszqt+Ij7xjLIZCTSfoZmKY328RMVo1yL1shkCgYEArIv5/x9LK2OdLeqGgYIlmZUn0iplSnij47iEAGI9JlsUZPdhQ03EUotly4rCTEUQkwpSQb59lco/wsLFfbXSBRfOaV8/vlz4TYHGczM15P2eEM5OepZoOH0LmPiiSrCbGPkoLBZKTj4GvSvDFyI9dYfTD6kBA+iAbuxHyZTWLtcCgYBNLEdIdXvHtYGF3DkpjAnbBbV2PlN3YnCPtmTMZ9IzmhLxHHk65p2cXR2ZlnDOATch5GtmMT4IJlGnMFFZ9ZCXfeTDO/xuPrVcOZLyh4TFc31BxKgvDAO7h7CIah8N+ma2eC9h5eH4in6immG55iOyYF93l4jrwHng09YjjTAx4QKBgGnRboAHsRHrBXojWloSdvy5fLJnTbdeRSRjBJE3rkjXkqpZDE06ZCw7UTKC5qXftUp4CfpH2L0ETBYlXPi7iRGWiAAXagBVA/KEpDACOAs3frjPzVFg7Im4JmSqFt23cWbfZsOi5+8UGw3oyLxnQ0nRAp+YBgdfj2R3g48cuD4BAoGALRf84rCZrCJ/oMozMU1bsk0tyh2DC6ku8Y3JUOBahb/KoW3hug6JsrwxbFxNs3faEG7oW59HGWbHs8Rr5LDrdypP/TyqRLgZcJQ74fGFwGk/Op3RvzUVr7j5zGsPAwoYzKavr6Gihum6nRifx6vP/DB/c8kw1RewXNM+sgtUTeY=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA8wRgququZy2Ogxu1mnAXBPRnSmDnGLjvw+7EE4pkU16vCOOEIicgCPrl3YcUfwg0GKvk2pzcow2yWckIAUwa5e/vihJvxTjrpx5kxszuBMfcdJd0lNhPAuLOr2eagGtTBrvokIrwEQvK9PLpahBV195OHEfRTpLkJ+hjvdIyHgK7yVnGzXILTPqVkA1LmzKUmTsLZ3MfMdNn2oQFHZRuCTBXKvelmWnewFQ43EFPaZmvMdLpnFY3NVbWPrji3qgGgMzDG3f9wp60JWwRKKrJyYpHxdYrdev6+q4M5JgoFg/44x8N5Q6EkNYJ1rOzlNTK1280ZuUW9HYa54KtAk5dQwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do\n";
}
