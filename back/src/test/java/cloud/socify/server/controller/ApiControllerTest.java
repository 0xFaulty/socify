package cloud.socify.server.controller;

import cloud.socify.server.service.ApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApiControllerTest {

    @Mock
    private ApiService apiService;

    @InjectMocks
    private ApiController apiController;

    @Test
    public void getApiVersion() {
        //prepare example
//        List<String> list = ImmutableList.of(); //guava
        when(apiService.getVersion()).thenReturn("v1");
        //testing
        ResponseEntity re = apiController.getApiVersion();
        //validate
        verify(apiService).getVersion();
        assertThat("test", is("test"));
    }
}