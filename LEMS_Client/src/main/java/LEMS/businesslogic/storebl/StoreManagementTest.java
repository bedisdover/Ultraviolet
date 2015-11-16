
public class StoreManagementTest extends TestCase {
	public void test(){
		StoreManagement smt=new StoreManagement("20151025","20151026");
		assertEquals("1011001101",smt.inquire("20151025","20151026").get(1).getID());
		assertEquals("1111000011",smt.check().get(1).getID());
		smt.warning();
	}
}
