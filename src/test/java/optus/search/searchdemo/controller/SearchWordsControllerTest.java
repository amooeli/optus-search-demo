package optus.search.searchdemo.controller;

import optus.search.searchdemo.SearchdemoApplication;
import optus.search.searchdemo.service.TextCounter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ali.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SearchdemoApplication.class)
@SpringBootTest
public class SearchWordsControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    private SearchWordsController searchWordsController;
    @Mock
    private TextCounter service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(searchWordsController).build();
    }

    @Test
    public void testCountWords() throws Exception {

        mockMvc.perform(post("/counter-api/search").
                contentType(MediaType.APPLICATION_JSON_VALUE).
                header("Authorization", "Basic b3B0dXM6Y2FuZGlkYXRlcw==").
                content("{\"searchText\": [\"Duis\", \"Sed\", \"Donec\", \"Augue\", \"Pellentesque\", \"123\"]}").
                accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
                andDo(print());
    }

    @Test
    public void testTopWords() throws Exception {

        mockMvc.perform(get("/counter-api/top/{topCount}", 10).
                contentType(MediaType.APPLICATION_JSON_VALUE).
                header("Authorization", "Basic b3B0dXM6Y2FuZGlkYXRlcw==")).
                andExpect(status().isOk()).
                andDo(print());
    }
}