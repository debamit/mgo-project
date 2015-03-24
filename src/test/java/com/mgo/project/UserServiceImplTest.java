package com.mgo.project;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.mgo.project.domain.User;
import com.mgo.project.repo.UserRepository;
import com.mgo.project.service.UserServiceImpl;
import static com.mgo.project.UserAssert.assertThatUser;


@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private static final String EMAIL = "email";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String CITY = "los angeles";
    private static final String STATE = "CA";
    private static final String PROFESSION = "sales";

    @Mock
    private UserRepository repository;

    private UserServiceImpl service;

    @Before
    public void setUp() {
        this.service = new UserServiceImpl(repository);
    }

    @Test
    public void create_ShouldSaveNewUser() {
        User newUser = new User(EMAIL, FIRSTNAME, LASTNAME, CITY, STATE, PROFESSION);

        when(repository.save(isA(User.class))).thenAnswer(invocation -> (User) invocation.getArguments()[0]);

        service.create(newUser);

        ArgumentCaptor<User> savedUserArgument = ArgumentCaptor.forClass(User.class);

        verify(repository, times(1)).save(savedUserArgument.capture());
        verifyNoMoreInteractions(repository);

        User savedUser = savedUserArgument.getValue();
        assertThatUser(savedUser).hasEmail(EMAIL)
        						 .hasFirstName(FIRSTNAME)
        						 .hasLastName(LASTNAME)
        						 .hasCity(CITY)
        						 .hasState(STATE)
        						 .hasProfession(PROFESSION);
                
    }

 
}
