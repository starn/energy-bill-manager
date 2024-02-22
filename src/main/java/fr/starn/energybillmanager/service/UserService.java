package fr.starn.energybillmanager.service;

import fr.starn.energybillmanager.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto user) throws Exception;
    public UserDto update(UserDto user);
    void delete(long id);

    List<UserDto> getAll();

    UserDto get(long id);
}
