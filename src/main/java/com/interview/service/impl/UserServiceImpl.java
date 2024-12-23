package com.interview.service.impl;

import com.interview.dto.AddressDto;
import com.interview.dto.UserDto;
import com.interview.entity.Address;
import com.interview.entity.User;
import com.interview.repository.UserRepository;
import com.interview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;


    @Override
    public Optional<UserDto> findUserById(Long id) {
        return userRepo.findById(id).map(this::toUserDto);
    }

    private UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUserAddresses().stream().map(this::toAddressDto).collect(Collectors.toList()));
    }

    private AddressDto toAddressDto(Address address) {
        return new AddressDto(
                address.getId(),
                address.getActive(),
                address.getAddress(),
                address.getAddressType().ordinal());
    }

}
