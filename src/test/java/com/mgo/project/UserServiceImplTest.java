package com.mgo.project;

import static com.javaadvent.bootrest.todo.TodoAssert.assertThatTodo;
import static com.javaadvent.bootrest.todo.TodoDTOAssert.assertThatTodoDTO;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import com.mgo.project.domain.User;
import com.mgo.project.repo.UserRepository;
import com.mgo.project.service.UserServiceImpl;



public class UserServiceImplTest {

    private static final String ID = "description";
    private static final String EMAIL = "id";
    private static final String FIRSTNAME = "title";
    private static final String LASTNAME = "description";
    private static final String CITY = "id";
    private static final String STATE = "title";
    private static final String PROFESSION = "description";

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
        assertThatUser(savedUser).hasEmail(EMAIL).hasFirstName(FIRSTNAME);
                
    }

    @Test
    public void create_ShouldReturnTheInformationOfCreatedTodoEntry() {
        TodoDTO newTodo = new TodoDTOBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .build();

        when(repository.save(isA(Todo.class))).thenAnswer(invocation -> {
            Todo persisted = (Todo) invocation.getArguments()[0];
            ReflectionTestUtils.setField(persisted, "id", ID);
            return persisted;
        });

        TodoDTO returned = service.create(newTodo);

        assertThatTodoDTO(returned)
                .hasId(ID)
                .hasTitle(TITLE)
                .hasDescription(DESCRIPTION);
    }

    @Test(expected = TodoNotFoundException.class)
    public void delete_TodoEntryNotFound_ShouldThrowException() {
        when(repository.findOne(ID)).thenReturn(Optional.empty());

        service.findById(ID);
    }
}
