package com.slk.mallprojectvue;

import com.slk.mallprojectvue.utils.JWTutil;
import io.jsonwebtoken.Claims;

import java.util.HashMap;
import java.util.Map;

public class testJWT {


    public static void main(String[] args) {
        /*Map<String,Object> claims = new HashMap();
        claims.put("sex","男");
        claims.put("age",18);
        String jwtstr = JWTutil.creatJWT(claims,"slk",60*1000);*/
        String jwtstr = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzbGsiLCJzZXgiOiLnlLciLCJleHAiOjE2MDgxMDI2MTUsImlhdCI6MTYwODEwMjU1NSwiYWdlIjoxOH0.Hg69AgSvfhi4k2iPO4LkFELYFH2m3YRSFQ1XVB4iwhs";
        System.out.println("获取到的jwt：" + jwtstr);
        System.out.println("验证jwt：" + JWTutil.validateJWT(jwtstr));
        try {
            Claims info = JWTutil.parseJWT(jwtstr);
            System.out.println("信息：" + info.get("sex") + info.get("age") + info.getExpiration());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
