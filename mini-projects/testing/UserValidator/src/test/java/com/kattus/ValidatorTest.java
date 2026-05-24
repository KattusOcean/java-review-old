package com.kattus;

import com.kattus.Rules.AgeRule;
import com.kattus.Rules.EmailRule;
import com.kattus.Rules.UsernameRule;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.time.Duration;

// import static skips the "Assertion.assertEquals" or "Assumptions.assumeFalse" to "assertEquals" or "assumeFalse"
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class ValidatorTest {

    Validator validator;

    // Runs itself at the very finish of the tests
    @AfterAll
    public static void finishAll() {
        System.out.println("All tests are finished!");
    }

    // Runs itself before every individual test
    @BeforeEach
    public void startTest() {
        validator = new Validator();
    }

    // Runs itself after every individual test
    @AfterEach
    public void finishTest() {
        System.out.println("Test completed!");
    }

    // Indicates to JUnit that this is a nested class
    @Nested
    class EmptyUser {
        User user = new User("", "", 0);

        // Runs itself and pass if the method does not throw any exception
        @Test
//        @Disabled("(optional message) I know it is failing everywhere, fix later") // Skips the tested method depending on the tag selected
        @DisabledOnOs(OS.LINUX)
        public void validNotEmptyUser() {
            validator.addRule(new EmailRule());
            validator.addRule(new AgeRule());
            validator.addRule(new UsernameRule());

            // Does not stop the next tests even if the first ones fails
            assertAll(
                    () -> assertNotEquals("", user.getUsername()), // Expected -> Fail
                    () -> assertEquals("Juancho", user.getUsername()), // Expected -> Fail
                    () -> assertNotEquals("", user.getEmail()), // Expected -> Fail
                    () -> assertTrue(user.getAge() >= 21, "User must be over twenty-one"), // Expected -> Fail
                    () -> assertTrue(false), // Expected -> Fail
                    () -> assertDoesNotThrow(() -> validator.validate(user)), // Expected -> Fail
                    () -> assertThrows(ValidatorException.class, () -> validator.validate(user)) // Expected -> True
            );
        }

        @Test
        @DisplayName("Username is blank") // Changes the displayed name of the method
        public void usernameMissing() {
            User user = new User("", "alex@gmail.com", 19);
            validator.addRule(new UsernameRule());

            assertThrows(
                    ValidatorException.class, () -> validator.validate(user)
            );
        }

        @Test
        // @Enable... runs the tests depending on the enabled tag selected (i.e. run on windows)
        @EnabledOnOs(OS.WINDOWS)
        public void emailMissing() {
            User user = new User("Alex", "", 19);
            validator.addRule(new EmailRule());

            assertThrows(
                    ValidatorException.class, () -> validator.validate(user)
            );
        }
    }

    // Indicates to JUnit that this is a nested class
    @Nested
    class NotEmptyUser {
        User user = new User("Alex", "alex@gmail.com", 19);

        // Runs itself and pass if the method does not throw any exception
        @Test
        public void validNotEmptyUser() {

            // Another way to "disable" or "enable" test methods
            assumeTrue(2 + 2 == 4); // Will continue the test
            assumeFalse(2 + 2 == 4); // Will skip the test
            assumingThat(2 + 2 == 5, () -> {
                assertEquals(2 + 2, 4);
            }); // Will skip the test

            validator.addRule(new EmailRule());
            validator.addRule(new AgeRule());
            validator.addRule(new UsernameRule());

            // Does not stop the next tests even if the first ones fails
            assertAll(
                    () -> assertNotEquals("", user.getUsername()), // Expected -> Success
                    () -> assertEquals("Juancho", user.getUsername()), // Expected -> Fail
                    () -> assertNotEquals("", user.getEmail()), // Expected -> Success
                    () -> assertTrue(user.getAge() >= 21, "User must be over twenty-one"), // Expected -> Success
                    () -> assertTrue(false), // Expected -> Fail
                    () -> assertDoesNotThrow(() -> validator.validate(user)), // Expected -> Success
                    () -> assertThrows(ValidatorException.class, () -> validator.validate(user)) // Expected -> Fail
            );
        }

        @Test
        @DisplayName("Age lower than zero") // Changes the displayed name of the method
        public void ageNegative() {
            User user = new User("Alex", "alex@gmail.com", -34);
            validator.addRule(new AgeRule());

            assertThrows(
                    ValidatorException.class, () -> validator.validate(user)
            );
        }

        @Test
        public void ageLowerThanEighteen() {
            User user = new User("Alex", "alex@gmail.com", 13);
            validator.addRule(new AgeRule());

            assertThrows(
                    ValidatorException.class, () -> validator.validate(user)
            );
        }

        @Test
        public void emailWithoutCorrectFormat() {
            User user = new User("Alex", "alexgmail.com", 19);
            validator.addRule(new EmailRule());

            assertThrows(
                    ValidatorException.class, () -> validator.validate(user)
            );
        }
    }


    /* === NON RELATED TESTS === */
    @Test
    public void testTimeout() {
        // Tests the time of performance of the method
        assertAll(
                () -> assertTimeout(Duration.ofMillis(200), () -> Thread.sleep(500), "Will fail, time exceeded"), // Expected -> Fail
                () -> assertTimeout(Duration.ofMillis(500), () -> Thread.sleep(200), "Will not fail, enough time") // Expected -> Success
        );
    }

    @Test
    public void testArrays() {
        int[] arr1 = new int[] {1, 4, 9, 16, 25};
        int[] arr2 = new int[] {1, 4, 9, 16, 25};
        int[] arr3 = new int[] {1, 4, 10, 16, 25};
        assertEquals(arr1, arr2, "1. They are equal "); // Will fail because they are two different instances (references does not match)
        assertArrayEquals(arr1, arr2, "2. They are the same"); // Will succeed
        assertArrayEquals(arr1, arr3, "3. They are not the same"); // Will fail
    }
}