package com.teamchallenge.chat.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CookieService {
    public Cookie createCookie(String name, String value){
        return new Cookie(name, value);
    }

    public Cookie createCookie(String name, String value, String path){
        Cookie cookie = createCookie(name, value);
        cookie.setPath(path);
        return cookie;
    }

    public Cookie createCookie(String name, String value, String path, int maxAge){
        Cookie cookie = createCookie(name, value, path);
        cookie.setMaxAge(maxAge);
        return cookie;
    }

    public Optional<Cookie> extractCookiesFromRequest(HttpServletRequest request, String cookieName){
        Cookie [] cookies = request.getCookies();
        if(cookies == null) {
            return Optional.empty();
        }
        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findFirst();
    }
}

