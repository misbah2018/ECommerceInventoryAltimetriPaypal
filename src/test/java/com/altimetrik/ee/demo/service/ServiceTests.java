package com.altimetrik.ee.demo.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTests {

	@MockBean
	ComponentDetailsRepository componentDetailsRepository;

	@Autowired
	ComponentDetailsService componentDetailsService;

	private final String applicationName = "Fridge";

	@Test
	public void getAllUnitTest(){
		PairedComponentDetailsBean pairedComponentDetailsBean = new getAll();
		Mockito.when(componentDetailsRepository.findAll(applicationName)).thenReturn(pairedComponentDetailsBean);
		assertThat(componentDetailsService.findAll(applicationName))).isEqualTo(pairedComponentDetailsBean);

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
