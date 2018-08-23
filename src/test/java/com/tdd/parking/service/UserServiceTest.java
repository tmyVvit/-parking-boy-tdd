package com.tdd.parking.service;

import com.tdd.parking.entity.User;
import com.tdd.parking.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {


    @MockBean
    private UserRepository userRepository;

    @Test
    public void should_return_true_when_call_addUser_given_user(){
        User user = new User( "tmy");
        UserService userService = new UserService(userRepository);
        when(userRepository.findById(anyLong())).thenReturn(null);

        String result = userService.addUser(user);

        assertNotNull(result);
    }

}
