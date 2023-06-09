package com.example.CardSpringBootApi.mapper;
import com.example.CardSpringBootApi.dto.UserDto;
import com.example.CardSpringBootApi.exceptions.IllegalUserParametersException;
import com.example.CardSpringBootApi.model.User;
import com.example.CardSpringBootApi.model.UserStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// Customised autogenerated Implementation from MapStruct ::::::::::::::::::::::
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setOib( user.getOib() );
        userDto.setName( user.getName() );
        userDto.setSurname( user.getSurname() );
        if ( user.getStatus() != null ) {
            userDto.setStatus( user.getStatus().name() );
        }

        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setOib( userDto.getOib() );
        user.setName( userDto.getName() );
        user.setSurname( userDto.getSurname() );
        if ( userDto.getStatus() != null ) {
            String statusUpperCased = userDto.getStatus().toUpperCase();
            List<String> allStatuses = Arrays.stream(UserStatus.values()).map(Enum::name).toList();
            if (allStatuses.contains(statusUpperCased)) {
                user.setStatus( Enum.valueOf( UserStatus.class, statusUpperCased ) );
            } else {
                throw new IllegalUserParametersException("Status can be %s".formatted(
                        String.join(", ", allStatuses)
                ));
            }
        }

        return user;
    }
}
