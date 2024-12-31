package com.ryazanova.MyApplicationH2.service;
import com.ryazanova.MyApplicationH2.dto.UserDto;
import com.ryazanova.MyApplicationH2.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
    List<UserDto> findAllUsers();
}
