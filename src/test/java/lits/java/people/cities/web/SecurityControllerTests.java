package lits.java.people.cities.web;

import lits.java.people.cities.config.MockConfiguration;
import net.minidev.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {MockConfiguration.class})
public class SecurityControllerTest {

    private static final String controllerUrl = "/api";

    @Autowired
    private MockMvc mockMvc;

    public void shouldSuccessUserSignUp() {

    }

