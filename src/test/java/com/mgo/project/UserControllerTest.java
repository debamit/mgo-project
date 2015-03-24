package com.mgo.project;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.mgo.project.controller.UserController;
import com.mgo.project.domain.User;
import com.mgo.project.service.AccountService;
import com.mgo.project.service.FileListService;
import com.mgo.project.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8")
    );

    private static final String EMAIL = "email";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String CITY = "city";
    private static final String STATE = "state";
    private static final String PROFESSION = "sales";

    @Mock
    private UserService userService;
    
    @Mock
    private AccountService accountService;
    
    @Mock
    private FileListService fileService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService))
                .build();
    }


    @Test
    public void findAll_OneUserEntryFound_ShouldReturnListThatContainsOneUserEntryAsJson() throws Exception {
        User found = new User(EMAIL, FIRSTNAME, LASTNAME, CITY, STATE, PROFESSION);
          

        when(userService.findAll()).thenReturn(Arrays.asList(found));

        mockMvc.perform(get("/api/user"))
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].email", is(EMAIL)))
                .andExpect(jsonPath("$[0].firstName", is(FIRSTNAME)))
                .andExpect(jsonPath("$[0].lastName", is(LASTNAME)))
                .andExpect(jsonPath("$[0].city", is(CITY)))
                .andExpect(jsonPath("$[0].state", is(STATE)))
                .andExpect(jsonPath("$[0].profession", is(PROFESSION)));
    }

}
