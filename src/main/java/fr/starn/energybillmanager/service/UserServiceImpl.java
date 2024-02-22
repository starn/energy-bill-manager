package fr.starn.energybillmanager.service;

import fr.starn.energybillmanager.dto.UserDto;
import fr.starn.energybillmanager.entity.Client;
import fr.starn.energybillmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto save(UserDto user) throws Exception {
        List<UserDto> users = getAll();
        return userToUserDto(userRepository.save(userDtoToUser(user)));
    }

    @Override
    public UserDto update(UserDto user) {
        return userToUserDto(userRepository.save(userDtoToUser(user)));
    }

    @Override
    public void delete(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {
        return ((List<Client>)userRepository.findAll()).stream().map(u -> userToUserDto(u)).collect(Collectors.toList());
    }

    @Override
    public UserDto get(long id) {
        return  userToUserDto(userRepository.findById(id).get());
    }

    private UserDto userToUserDto(Client client) {
        UserDto userDto = new UserDto(client.getId());
        return userDto;
    }

    private Client userDtoToUser(UserDto userDto){
        Client client = new Client();
        client.setId(userDto.id());
        return client;
    }
}
