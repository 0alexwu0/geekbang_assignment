package com.alex.demo.mapping;

import com.alex.demo.dto.UserDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserDto findUserByUserId(@Param("user_id") String userId);

    int updateUser(UserDto dto);
}
