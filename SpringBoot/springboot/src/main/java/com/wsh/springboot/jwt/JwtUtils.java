package com.wsh.springboot.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.*;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;

public class JwtUtils {

    public static void main(String[] args) {
//        UserVo userVo = new UserVo();
//        userVo.setName("张三");
//        userVo.setId(10);
        Calendar instance = Calendar.getInstance();//获取当前时间戳
        instance.add(Calendar.SECOND, 60 * 10);//根据当前时间戳增加时间
        String token = JWT.create()
                .withClaim("userId", 456)//Token携带参数
                .withExpiresAt(instance.getTime())//设置Token过期时间--设置失效时间，到时间不能解密
                .sign(Algorithm.HMAC256("qi"));//加密Token
        System.out.printf(token);
    }

//   public static void main(String[] args) {
//        System.out.println(JwtUtils.getUser("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTcwOTI5NTQsInVzZXJJZCI6NDU2fQ.x8JE3XIGE0k2GCBLAGX8FOGJT82KPkaM4daOnDbeA6g"));
//    }
    public static Integer getUserId(String token) {
        if (checkToken(token)) {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("shancheng")).build();
            DecodedJWT verify = jwtVerifier.verify(token);//验证令牌
            return verify.getClaim("userId").asInt();
        }
//        if (checkToken(token)){
//            Claims claims = Jwts.parser().setSigningKey("RongShuYun").parseClaimsJws(token).getBody();
//            return Integer.valueOf(claims.getId());
//        }
        return null;
    }
    public static Integer getUser(String token) {
        if (checkToken(token)) {
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("qi")).build();
            DecodedJWT verify = jwtVerifier.verify(token);//验证令牌
            return verify.getClaim("userId").asInt();
        }
//        if (checkToken(token)){
//            Claims claims = Jwts.parser().setSigningKey("RongShuYun").parseClaimsJws(token).getBody();
//            return Integer.valueOf(claims.getId());
//        }
        return null;
    }

    public static String createToken(Integer userId) {
        Calendar instance = Calendar.getInstance();//获取当前时间戳
        instance.add(Calendar.SECOND, 60 * 1440);//根据当前时间戳增加时间
        String token = JWT.create()
                .withClaim("userId", userId)//Token携带参数
                .withExpiresAt(instance.getTime())//设置Token过期时间
                .sign(Algorithm.HMAC256("qi"));//加密Token
        return token;
//        JwtBuilder jwt = Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256, "RongShuYun") // JWT头部,加密算法为HS256,盐是 sunmone (自定义)
//                // 载荷部分 标准
//                .setId(String.valueOf(userId)) // jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
//                .setSubject("user") // sub: jwt所面向的用户
//                .setIssuer("Gm") // iss: jwt签发者
//                .setIssuedAt(new Date()) // iat: jwt的签发时间
//                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 600)));// exp: jwt的过期时间 一分钟
//        // 使用 compact 方法生成 Token
//        String token = jwt.compact();
//        // 输出 token
////        System.out.println(token);
//        return token;
    }
    public static String createToken(String userVo) {
        Calendar instance = Calendar.getInstance();//获取当前时间戳
        instance.add(Calendar.SECOND, 60 * 1440);//根据当前时间戳增加时间
        String token = JWT.create()
                .withClaim("userId", userVo)//Token携带参数
                .withExpiresAt(instance.getTime())//设置Token过期时间
                .sign(Algorithm.HMAC256("shancheng"));//加密Token
        return token;
//        JwtBuilder jwt = Jwts.builder()
//                .signWith(SignatureAlgorithm.HS256, "RongShuYun") // JWT头部,加密算法为HS256,盐是 sunmone (自定义)
//                // 载荷部分 标准
//                .setId(String.valueOf(userId)) // jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
//                .setSubject("user") // sub: jwt所面向的用户
//                .setIssuer("Gm") // iss: jwt签发者
//                .setIssuedAt(new Date()) // iat: jwt的签发时间
//                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 600)));// exp: jwt的过期时间 一分钟
//        // 使用 compact 方法生成 Token
//        String token = jwt.compact();
//        // 输出 token
////        System.out.println(token);
//        return token;
    }

    public static Boolean checkToken(String token) {
//        try {
//            Claims claims = Jwts.parser().setSigningKey("RongShuYun").parseClaimsJws(token).getBody();
//            System.out.println("jti :" + claims.getId()); // 唯一身份标识
//            System.out.println("sub :" + claims.getSubject()); // 用户名高
//            System.out.println("iss :" + claims.getIssuer()); // 签发者
//            System.out.println("iat :" + claims.getIssuedAt().toLocaleString()); // 签发时间
//            System.out.println("exp :" + claims.getExpiration().toLocaleString()); // 过期时间
//            if (new Date().after(claims.getExpiration())){
//                return false;
//            }
//            return true;
//        }catch (Exception e){
//            return false;
//        }
        // setSigningKey("RongShuYun") 把盐告知jwt , parseClaimsJws(token) 再把生成的token告知 就可以解密了

        // 输出解析后的token

        // 输出自定义部分载荷
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("qi")).build();
        try {
            DecodedJWT verify = jwtVerifier.verify(token);//验证令牌
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            return false;//签名异常
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            return false;//token过期
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            return false;//算法不一致
        } catch (InvalidClaimException e) {//失效的payload异常
            e.printStackTrace();
            return false;//payload失效
        } catch (JWTDecodeException e) {
            return false;//token无效
        } catch (Exception e) {
            e.printStackTrace();
            return false;//token无效
        }
    }


}
