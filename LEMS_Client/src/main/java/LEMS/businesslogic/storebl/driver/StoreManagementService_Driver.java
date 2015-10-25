package LEMS.businesslogic.storebl.driver;


import java.util.ArrayList;

import LEMS.businesslogicservice.storeblservice.StoreManagementService;

import LEMS.vo.ordervo.GoodsVO;


public class StoreManagementService_Driver {
	public void drive(StoreManagementService storeManagementService){
		ArrayList<GoodsVO> gvoInquire=storeManagementService.inquire("2015.10.25.8:00", "2015.10.25.16:00");
		System.out.println("已完成库存查看");
		ArrayList<GoodsVO> gvoCheck=storeManagementService.check();
		System.out.println("已完成库存盘点");
		storeManagementService.warning();
		System.out.println("已完成库存报警");
	}
	
	
	
	
	
	
	
	
	
}
