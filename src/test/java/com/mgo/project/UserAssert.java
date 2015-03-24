package com.mgo.project;

import org.assertj.core.api.AbstractAssert;
import static org.assertj.core.api.Assertions.assertThat;

import com.mgo.project.domain.User;




public class UserAssert extends AbstractAssert<UserAssert, User>{

    protected UserAssert(User actual) {
		super(actual, User.class);
	}

    static UserAssert assertThatUser(User actual) {
        return new UserAssert(actual);
    }

    UserAssert hasFirstName(String expectedFirstName) {
        isNotNull();

        String actualFirstName = actual.getFirstName();
        assertThat(actualFirstName)
                .overridingErrorMessage("Expected description to be <%s> but was <%s>",
                        expectedFirstName,
                        actualFirstName
                )
                .isEqualTo(expectedFirstName);

        return this;
    }
    
    UserAssert hasLastName(String expectedLastName) {
        isNotNull();

        String actualLastName = actual.getFirstName();
        assertThat(actualLastName)
                .overridingErrorMessage("Expected description to be <%s> but was <%s>",
                		expectedLastName,
                        actualLastName
                )
                .isEqualTo(expectedLastName);

        return this;
    }
    
    
    UserAssert hasEmail(String expectedEmail) {
        isNotNull();

        String actualEmail = actual.getEmail();
        assertThat(actualEmail)
                .overridingErrorMessage("Expected description to be <%s> but was <%s>",
                		expectedEmail,
                		actualEmail
                )
                .isEqualTo(expectedEmail);

        return this;
    }

    
    UserAssert hasCity(String expectedCity) {
        isNotNull();

        String actualCity = actual.getCity();
        assertThat(actualCity)
                .overridingErrorMessage("Expected description to be <%s> but was <%s>",
                		expectedCity,
                		actualCity
                )
                .isEqualTo(expectedCity);

        return this;
    }
    
    UserAssert hasState(String expectedState) {
        isNotNull();

        String actualState = actual.getState();
        assertThat(actualState)
                .overridingErrorMessage("Expected description to be <%s> but was <%s>",
                		expectedState,
                		actualState
                )
                .isEqualTo(expectedState);

        return this;
    }
    
    UserAssert hasProfession(String expectedProfession) {
        isNotNull();

        String actualProfession = actual.getProfession();
        assertThat(actualProfession)
                .overridingErrorMessage("Expected description to be <%s> but was <%s>",
                		expectedProfession,
                		actualProfession
                )
                .isEqualTo(expectedProfession);

        return this;
    }

}
