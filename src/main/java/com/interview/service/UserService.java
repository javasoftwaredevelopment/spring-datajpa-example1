package com.interview.service;

import com.interview.dto.UserDto;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> findUserById(Long id);

}
