package lits.java.people.cities.web;

import lits.java.people.cities.config.MockConfiguration;
import lits.java.people.cities.dtos.PersonDTO;
import net.minidev.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {MockConfiguration.class})
public class PeopleControllerTest {

    private static final String GET_PEOPLE_URL = "/api";

    @Autowired
    private MockMvc mockMvc;

    private PersonDTO getPersonDTO() {
        PersonDTO person = new PersonDTO();
        //person.setEmail("me@me.com");
        person.setFirstName("pavlo");
        person.setLastName("prot");
        person.setPhone("380380380380");

        return person;
    }

    public void savePersonMustSavePerson() {
        //JSONObject jsonObject = new JSONObject(getPersonDTO());

    }

    @Test
    public void getAllPeopleMustGetAListOfThem() throws Exception {
        mockMvc.perform(get(GET_PEOPLE_URL).accept("application/json")
                .contentType(MediaType.APPLICATION_JSON));
    }
}
