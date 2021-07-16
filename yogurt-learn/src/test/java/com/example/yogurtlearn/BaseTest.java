package com.example.yogurtlearn;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {YogurtLearnApplication.class})
public class BaseTest {
    @BeforeEach
    void setUp() {
        System.out.println("test start...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("test end...");
    }
}
