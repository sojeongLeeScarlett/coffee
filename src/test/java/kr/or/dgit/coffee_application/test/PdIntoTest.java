package kr.or.dgit.coffee_application.test;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.coffee_application.dto.PdIntro;
import kr.or.dgit.coffee_application.dto.Product;
import kr.or.dgit.coffee_application.service.CoffeeService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PdIntoTest {
	private static CoffeeService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = CoffeeService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}
	//prdIntro 테스트
	@Test
	public void testAselcectSaleByAll() throws SQLException {
		List<PdIntro> listad = service.selectPriceByAll();
		System.out.println(listad);
		assertNotNull(listad);
		for(PdIntro ad : listad) {
			System.out.println(listad);
		}
	}
	
	@Test
	public void testGcallgetTotal() throws SQLException {
		List<PdIntro> listad = service.selectPriceByAllMargin();
		System.out.println(listad);
		assertNotNull(listad);
		for(PdIntro ad : listad) {
			System.out.println(ad);
		}
	}
	
	@Test
	public void testFcallSaleDetail() throws SQLException {
		List<PdIntro> listad = service.selectPriceByAllSelling();
		System.out.println(listad);
		assertNotNull(listad);
		for(PdIntro ad : listad) {
			System.out.println(listad);
		}
	}
	
	@Test
	public void testBelectSaleByNo() throws SQLException {
		Product product = new Product();
		product.setPdCode("A002");
		PdIntro intro = new PdIntro();
		intro.setPd(product);
		PdIntro listad = service.selectPriceByNo(intro);
		System.out.println(listad);
		assertNotNull(listad);
	}
	
	//@Test
	public void testCInsertPd() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		product.setPdName("테스트");
		PdIntro prd = new PdIntro();
		prd.setPd(product);
		prd.setPdUnitprice(160);
		prd.setPdUnitsales(560);
		prd.setPdPermargin(20);
		service.insertPrice(prd);
		System.out.println(prd);
		assertNotNull(prd);
	}
	
	//@Test
	public void testDUpdatePd() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		PdIntro prd = new PdIntro();
		prd.setPd(product);
		prd.setPdUnitprice(360);
		prd.setPdUnitsales(1360);
		prd.setPdPermargin(10);
		service.updatePrice(prd);
		System.out.println(prd);
		assertNotNull(prd);
	}
	
	//@Test
	public void testEDeletePd() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		PdIntro prd = new PdIntro();
		prd.setPd(product);
		service.deletePrice(prd);
		System.out.println(prd);
		assertNotNull(prd);
	}
	
	//@Test
	public void testFselcectByAll() throws SQLException {
		List<Product> listad = service.selectProductByAll();
		System.out.println(listad);
		assertNotNull(listad);
		for(Product ad : listad) {
			System.out.println(listad);
		}
	}
	
	
	//@Test
	public void testGelectItemByNo() throws SQLException {
		Product product = new Product();
		product.setPdCode("A002");
		Product listad = service.selectProductByNo(product);
		System.out.println(listad);
		assertNotNull(listad);
	}
	
	@Test
	public void testCInsertProduct() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		product.setPdName("테스트");
		
		service.insertProduct(product);
		System.out.println(product);
		assertNotNull(product);
	}
	
	@Test
	public void testDUpdateProduct() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		product.setPdName("얌얌");
		service.updateProduct(product);
		System.out.println(product);
		assertNotNull(product);
	}
	
	@Test
	public void testEDeleteProduct() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		
		service.deleteProduct(product);
		System.out.println(product);
		assertNotNull(product);
	}
	
	

	

}
