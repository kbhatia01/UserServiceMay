package org.scaler.userservice.dtos;

import lombok.Data;
import org.scaler.userservice.models.Roles;
import org.scaler.userservice.models.User;

import java.util.List;

@Data
public class UserDto {
    private String name;
    private String email;
    private List<Roles> roles;

    public static UserDto from(User u){

        UserDto userDto = new UserDto();
        userDto.setEmail(u.getEmail());
        userDto.setName(u.getName());
        userDto.setRoles(u.getRoles());
        return userDto;
    }

}
