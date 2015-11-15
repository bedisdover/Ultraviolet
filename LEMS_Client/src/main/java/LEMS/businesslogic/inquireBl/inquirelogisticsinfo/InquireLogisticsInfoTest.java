package LEMS.businesslogic.inquirebl.inquirelogisticsinfo;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class InquireLogisticsInfoTest {

	@Test
	public void testInquireLogisticsInfo() {
		LogisticsInfo lo=new LogisticsInfo("1234567890");
		ArrayList<String> t=lo.getLogisticsInfo();
		assertEquals("到达中转站",t.get(0));
	}

}
