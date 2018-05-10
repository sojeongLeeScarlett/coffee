package kr.or.dgit.coffee_application.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.coffee_application.dao.PdIntroDao;
import kr.or.dgit.coffee_application.dao.ProductDao;
import kr.or.dgit.coffee_application.dto.PdIntro;
import kr.or.dgit.coffee_application.dto.Product;
import kr.or.dgit.coffee_application.service.PdIntroService;


public class ProductTest {
		private static ProductDao service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = ProductDao.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}
	//prdIntro 테스트
	@Test
	public void testAselcectByAll() throws SQLException {
		List<Product> listad = service.selectItemByAll();
		System.out.println(listad);
		assertNotNull(listad);
		for(Product ad : listad) {
			System.out.println(listad);
		}
	}
	
	
	@Test
	public void testBelectItemByNo() throws SQLException {
		Product product = new Product();
		product.setPdCode("A002");
		Product listad = service.selectItemByNo(product);
		System.out.println(listad);
		assertNotNull(listad);
	}
	
	//@Test
	public void testCInsertPrd() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		product.setPdName("테스트");
		
		service.insertItem(product);
		System.out.println(product);
		assertNotNull(product);
	}
	
	@Test
	public void testDUpdatePd() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		product.setPdName("얌얌");
		service.updateItem(product);
		System.out.println(product);
		assertNotNull(product);
	}
	
	@Test
	public void testEDeletePd() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		
		service.deleteItem(product);
		System.out.println(product);
		assertNotNull(product);
	}
	
	
	

}
