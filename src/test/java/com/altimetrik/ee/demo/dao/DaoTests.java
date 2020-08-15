package com.altimetrik.ee.demo.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class DaoTests {

	//Here we will mock db
	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	ComponentDetailsRepository repo;

	private final String applicationName = "Fridge";
	//We will do the test on H2 Db
	@Test
	public void getAllUnitTest(){
		PairedComponentDetailsBean pairedComponentDetailsBean = getAll();
		List list = pairedComponentDetailsBean.getPairedComponentDetails();
		//save both data in db

		ComponentDetailsEntity entity = new ComponentDetailsEntity();
		entity.setComponentName("Fridge");//check on this basis
		entity.setComponentIdentifier("Electronics");
		ComponentDetailsEntity entity1 = new ComponentDetailsEntity();
		entity1.setComponentName("Mattress");
		entity1.setComponentIdentifier("Household");
		ComponentDetailsEntity entity2= new ComponentDetailsEntity();
		entity2.setComponentName("Pen");
		entity2.setComponentIdentifier("Stationary");
		ComponentDetailsEntity saveInDb = testEntityManager.save(entity));
		ComponentDetailsEntity saveInDbNew = testEntityManager.save(entity1);
		ComponentDetailsEntity saveInDbNew = testEntityManager.save(entity2);

		//PairedComponentDetailsBean getFromDb = repo.findAll(applicationName);
		ComponentDetailsBean  componentDetailsBeanFromDb = repo.getByComponentName(applicationName);
		List<ComponentDetailsBean> notFoundEntitiesFromDb =  repo.getByComponentNameNotIn(applicationName);
		//found application
		ComponentDetailsBean beanOld = new ComponentDetailsBean(pairedComponentDetailsBean.getComponentName(),
				pairedComponentDetailsBean.getComponentIdentifier();
				);
		assertThat(componentDetailsBeanFromDb).isEqualTo(beanOld);
		assertThat(notFoundEntitiesFromDb).isEqualTo(pairedComponentDetailsBean.getPairedComponentDetails());

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
