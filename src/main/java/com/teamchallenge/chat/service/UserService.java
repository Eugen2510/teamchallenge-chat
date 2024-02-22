package com.teamchallenge.chat.service;

import com.teamchallenge.chat.dto.UserDTO;
import com.teamchallenge.chat.entities.User;
import com.teamchallenge.chat.repository.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CookieService cookieService;
    private final static String USER_ID_COOKIE_NAME = "chatUserIdCookie";


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
       return userRepository.findById(id).orElseThrow();
    }

    private User saveUser(UserDTO userDTO, HttpServletResponse response){
        System.out.println("IN saveUser()");
        User user = userDTO.convertToUser();
        userRepository.save(user);
        long userId = user.getIdUser();
        System.out.println("userId = " + userId);
        Cookie userIdCookie = cookieService.createCookie(USER_ID_COOKIE_NAME, String.valueOf(user.getIdUser()));
        response.addCookie(userIdCookie);
        return user;
    }

    public UserDTO setUsername(HttpServletRequest request, UserDTO userDTO, HttpServletResponse response){
        long userId = getUserIdFromCookies(request);
        if (userId == -1){
            return saveUser(userDTO, response).convertToUserDTO();
        }

        return editUsername(userDTO, userId).convertToUserDTO();
    }

    private User editUsername(UserDTO userDTO, long userId){
        System.out.println("IN editUser()");
        User user = userRepository.findById(userId).orElseThrow();
        user.setUsername(userDTO.username());
        return userRepository.save(user);
    }

    private long getUserIdFromCookies(HttpServletRequest request){
        Optional<Cookie> userIdCookie = cookieService.extractCookiesFromRequest(request, USER_ID_COOKIE_NAME);
        return userIdCookie.map(cookie -> Long.parseLong(cookie.getValue())).orElse(-1L);
    }


}
