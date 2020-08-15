package com.altimetrik.ee.demo.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ServiceController.class)
public class ControllerTests {

	@MockBean
	ComponentDetailsService componentDetailsService;

	@Autowired
	MockMvc mockMvc;

	private final static String applicationName = "Fridge";
	final static String URI = "/service";
	final static String GETALL_URI = URI+"/";
	@Test
	public void testgetAll() throws Exception{
		PairedComponentDetailsBean pairedComponentDetailsBean =  getAll();
		//we have mocked the userservice.getAll() method
		Mockito.when(componentDetailsService.findAll(applicationName)).thenReturn(pairedComponentDetailsBean);
		String inputInJson = UtilUser.mapTOJson(pairedComponentDetailsBean);

		//we build a request with url,content ,ttoe etc
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get(GETALL_URI)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);
		//to perform the result
		MvcResult mvcResult = mockMvc
				.perform(requestBuilder)
				.andReturn();

		MockHttpServletResponse httpServletResponse =  mvcResult.getResponse();
		String outputInJson = httpServletResponse.getContentAsString();
		assertThat(inputInJson).isEqualTo(outputInJson);
		assertEquals(HttpStatus.OK.value(), httpServletResponse.getStatus());

	}

	//to get list of PairedComponentDetailsBean
	private PairedComponentDetailsBean getAll(){
		ComponentDetailsBean bean = new ComponentDetailsBean();
		bean.setComponentName("Fridge");//check on this basis
		bean.setComponentIdentifier("Electronics");
		ComponentDetailsBean bean1 = new ComponentDetailsBean();
		bean1.setComponentName("Mattress");
		bean1.setComponentIdentifier("Household");
		ComponentDetailsBean bean2 = new ComponentDetailsBean();
		bean1.setComponentName("Pen");
		bean1.setComponentIdentifier("Stationary");
		List<ComponentDetailsBean> list = new ArrayList<>();
		list.add(bean1);
		list.add(bean2);

		PairedComponentDetailsBean pairedComponentDetailsBean = new
				PairedComponentDetailsBean( bean,
		list);
		return pairedComponentDetailsBean;
	}
}
