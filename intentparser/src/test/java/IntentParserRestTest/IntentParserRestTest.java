package IntentParserRestTest;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.internal.Iterables;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.amqp.utils.test.TestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.stackroute.swisit.assembler.HeteoasLinkAssembler;
import com.stackroute.swisit.controller.IntentParserRestController;
import com.stackroute.swisit.domain.CrawlerResult;
import com.stackroute.swisit.domain.IntentParserResult;
import com.stackroute.swisit.repository.RelationshipRepository;
import com.stackroute.swisit.service.IntentParseAlgo;
import com.stackroute.swisit.service.IntentParserService;
import com.stackroute.swisit.service.IntentParserServiceImpl;
import com.stackroute.swisit.subscriber.SubscriberImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = IntentParserRestController.class)
@WebMvcTest(controllers= IntentParserRestController.class)
public	class IntentParserRestTest{
      @Autowired
	  private  MockMvc mockMvc;

	    @MockBean
	    private IntentParseAlgo intentParseAlgo;
	    
	    @Autowired
	    private WebApplicationContext webApplicationContext;
	    
	    @MockBean
	    private RelationshipRepository relationshipRepository;
	    
	    @MockBean
	    private IntentParserService intentParserService;
	    
	    @MockBean
	    private IntentParserResult intentParserResult;

	    @MockBean
	    private CrawlerResult crawlerResult;
	    
	    @MockBean
	    private HeteoasLinkAssembler heteoasLinkAssembler; 
	    
	    @MockBean
	    private SubscriberImpl subscriberImpl;

	    @InjectMocks
	    private IntentParserRestController intentParserRestController;
	    
	     
	    @Before
	    public void setUp() {
	        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    
	    }

	    @Test
	    public void receiveMessage() throws Exception 
	    {

	        String expectedstring="{"+"\"message\":\"Data received successfully\""+"}";
	        mockMvc.perform(MockMvcRequestBuilders.post("/parse/fetch"))
	                .andExpect(status().isOk());
	    }
//	    

	    @SuppressWarnings("unchecked")
	    @Test
	    public void calculateConfidenceScore() throws Exception {
	        String expectedstring="{"+"\"message\":\"Data received successfully\""+"}";
	        mockMvc.perform(post("/parse"))
	                .andExpect(status().isOk());

}}