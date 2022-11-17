package com.coolteam.igame.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Tools {
    public static String encryptPassword(String userName, String password) {
        return DigestUtils.md5Hex(userName + DigestUtils.md5Hex(password)).toLowerCase();
    }
}
