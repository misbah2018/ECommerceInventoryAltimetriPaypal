//package com.altimetrik.ee.demo.tests;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class IntegrationTests {
//
//	//This integration test will run on H2 database
//
//	@LocalServerPort
//	private int port;
//	//Here we will do E2E testing
//	@Autowired
//	private TestRestTemplate testRestTemplate;
//	private HttpHeaders headers  = new HttpHeaders();
//
//	final static String URI = "/service";
//	final static String GETALL_URI = URI+"/";
//
//
//	@Test
//	public void getAllUnitTest() throws JsonProcessingException{
//		List<PairedComponentDetailsBean> list = getAll();
//		PairedComponentDetailsBean pairedComponentDetailsBean = new PairedComponentDetailsBean();
//		pairedComponentDetailsBean.setPairedComponentDetails(list);
//		String inputInJson = UtilUser.mapTOJson(pairedComponentDetailsBean);
//		PairedComponentDetailsBean user1 = list.get(0);
//		HttpEntity<PairedComponentDetailsBean> httpEntity = new HttpEntity<PairedComponentDetailsBean>(user1,headers);
//
//
//		//get all user
//		responseEntity = testRestTemplate
//				.exchange(formFullURLWithPort(GETALL_URI), HttpMethod.GET,httpEntity, String.class);
//		String responseInJson  = responseEntity.getBody();
//		System.out.println(responseInJson+" "+inputInJson);
//		assertThat(inputInJson).isEqualTo(responseInJson);
//		assertEquals(HttpStatus.OK.value(), responseEntity.getStatusCodeValue());
//	}
//
//	//to get list of PairedComponentDetailsBean
//	private PairedComponentDetailsBean getAll(){
//		ComponentDetailsBean bean = new ComponentDetailsBean();
//		bean.setComponentName("Fridge");//check on this basis
//		bean.setComponentIdentifier("Electronics");
//		ComponentDetailsBean bean1 = new ComponentDetailsBean();
//		bean1.setComponentName("Mattress");
//		bean1.setComponentIdentifier("Household");
//		ComponentDetailsBean bean2 = new ComponentDetailsBean();
//		bean1.setComponentName("Pen");
//		bean1.setComponentIdentifier("Stationary");
//		List<ComponentDetailsBean> list = new ArrayList<>();
//		list.add(bean1);
//		list.add(bean2);
//		PairedComponentDetailsBean pairedComponentDetailsBean = new
//				PairedComponentDetailsBean( bean,
//				list);
//		return pairedComponentDetailsBean;
//	}
//
//
//
//
//}
