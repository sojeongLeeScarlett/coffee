package kr.or.dgit.coffee_application.test;

public class PdIntoTest {
		/*private static PdIntroDao service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service = PdIntroDao.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
	}
	//prdIntro 테스트
	@Test
	public void testAselcectByAll() throws SQLException {
		List<PdIntro> listad = service.selectItemByAll();
		System.out.println(listad);
		assertNotNull(listad);
		for(PdIntro ad : listad) {
			System.out.println(listad);
		}
	}
	
	@Test
	public void testBselectItemByAllMargin() throws SQLException {
		List<PdIntro> listad = service.selectItemByAllMargin();
		System.out.println(listad);
		assertNotNull(listad);
		for(PdIntro ad : listad) {
			System.out.println(ad);
		}
	}
	
	@Test
	public void testBselectcallSaleDetail() throws SQLException {
		List<PdIntro> listad = service.selectItemByAllSelling();
		System.out.println(listad);
		assertNotNull(listad);
		for(PdIntro ad : listad) {
			System.out.println(listad);
		}
	}
	
	@Test
	public void testBelectItemByNo() throws SQLException {
		Product product = new Product();
		product.setPdCode("A002");
		PdIntro intro = new PdIntro();
		intro.setPd(product);
		PdIntro listad = service.selectItemByNo(intro);
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
		service.insertItem(prd);
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
		service.updateItem(prd);
		System.out.println(prd);
		assertNotNull(prd);
	}
	
	@Test
	public void testEDeletePd() throws SQLException{
		Product product = new Product();
		product.setPdCode("EE112");
		PdIntro prd = new PdIntro();
		prd.setPd(product);
		service.deleteItem(prd);
		System.out.println(prd);
		assertNotNull(prd);
	}
	
	*/
	

}
