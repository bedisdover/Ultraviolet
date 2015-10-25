package LEMS.businesslogic.storebl.driver;

import LEMS.businesslogicservice.storeblservice.StoreGenerateOrderService;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.InboundOrderPO;
import LEMS.po.storepo.LoadFormat;
import LEMS.po.storepo.OutboundOrderPO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;



public class StoreGenerateOrderService_Driver {
	public void drive(StoreGenerateOrderService storeGenerateOrderService){
		InboundOrderVO iov=storeGenerateOrderService.generateInboundOrder(new InboundOrderPO());
		System.out.println("快递单号："+iov.getId());
		iov.setInDate("2015.10.25");
		System.out.println("入库日期："+iov.getInDate());
		System.out.println("目的地："+iov.getDestination());
		iov.setArea(Area.航运区);
		iov.setRow(1);
		iov.setStand(1);
		iov.setPosition(1);
		System.out.println("区号："+iov.getArea());
		System.out.println("排号："+iov.getRow());
		System.out.println("架号："+iov.getStand());
		System.out.println("位号："+iov.getPosition());
		System.out.println("入库单：none");
		
		OutboundOrderVO oov=storeGenerateOrderService.generateOutboundOrder(new OutboundOrderPO());
		System.out.println("快递单号："+oov.getId());
		oov.setOutDate("2015.10.26");
		System.out.println("出库日期："+oov.getOutDate());
		System.out.println("目的地："+oov.getDestination());
		oov.setLoadFormat(LoadFormat.飞机);
		System.out.println("装运形式:"+oov.getLoadFormat());
		oov.setTransferNum(0000001);
		System.out.println("中转单编号/汽运编号："+oov.getTransferNum());
		System.out.println("出库单：none");
		
		}
	}