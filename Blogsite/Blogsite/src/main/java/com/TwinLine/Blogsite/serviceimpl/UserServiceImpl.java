package com.TwinLine.Blogsite.serviceimpl;

import com.TwinLine.Blogsite.Repo.UserRepo;
import com.TwinLine.Blogsite.Service.UserService;
import com.TwinLine.Blogsite.entity.User;
import com.TwinLine.Blogsite.exception.ResourceNotFoundException;
import com.TwinLine.Blogsite.payload.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userdto) {
        User user = this.modelMapper.map(userdto, User.class);
        user.setPassword(passwordEncoder.encode(userdto.getPassword()));
        User addedUser = this.userRepo.save(user);
        return this.modelMapper.map(addedUser, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDtos, Integer userId) {
        User cat = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
        cat.setName(userDtos.getName());
        cat.setEmail(userDtos.getEmail());
        cat.setPassword(userDtos.getPassword());
        cat.setAge(userDtos.getAge());
        cat.setGender(userDtos.getGender());
        User updatedUser = this.userRepo.save(cat);
        return this.modelMapper.map(updatedUser,UserDto.class);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User cat = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
        return this.modelMapper.map(cat,UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos = users.stream().map((cat) -> this.modelMapper.map(cat,UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User cat = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
        this.userRepo.delete(cat);
    }
}
