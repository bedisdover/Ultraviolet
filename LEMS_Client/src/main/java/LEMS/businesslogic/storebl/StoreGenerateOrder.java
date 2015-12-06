package LEMS.businesslogic.storebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * @author 周梦佳
 *生成仓库出库入库单
 */
import LEMS.businesslogicservice.storeblservice.StoreGenerateOrderService;
import LEMS.po.orderpo.TransportType;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.GoodsPO;
import LEMS.po.storepo.InboundOrderPO;
import LEMS.po.storepo.OutboundOrderPO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;
import LEMS.businesslogic.storebl.GoodsData;

public class StoreGenerateOrder implements StoreGenerateOrderService {

	ArrayList<InboundOrderVO> addInboundOrder = new ArrayList<InboundOrderVO>();
	ArrayList<OutboundOrderVO> addOutboundOrder = new ArrayList<OutboundOrderVO>();

	/**
	 * 数据->逻辑->界面
	 * 生成入库单
	 */
	public InboundOrderVO generateInboundOrderVO(String id) {
		GoodsData goodsData;
		InboundOrderVO inboundOrderVO = new InboundOrderVO("", "", Destination.Beijing, Area.Airline, 1, 1, 1);
		try {
			goodsData = new GoodsData();
			GoodsPO goodsPO = goodsData.find(id);
			inboundOrderVO.setId(goodsPO.getId());
			inboundOrderVO.setInDate(goodsPO.getInDate());
			inboundOrderVO.setDestination(goodsPO.getDestination());
			inboundOrderVO.setArea(goodsPO.getArea());
			inboundOrderVO.setRow(goodsPO.getRow());
			inboundOrderVO.setStand(goodsPO.getStand());
			inboundOrderVO.setPosition(goodsPO.getPosition());

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addInboundOrder.add(inboundOrderVO);
		return inboundOrderVO;

	}

	
	/**
	 * 界面->逻辑->数据
	 * 更新数据库
	 * 
	 */
	public int generateInboundOrderPO(InboundOrderVO inboundOrderVO) {
		int judge=0;
		try {
			String id = inboundOrderVO.getId();
			String inDate = inboundOrderVO.getInDate();
			Destination des = inboundOrderVO.getDestination();
			Area area = inboundOrderVO.getArea();
			int row = inboundOrderVO.getRow();
			int stand = inboundOrderVO.getStand();
			int pos = inboundOrderVO.getPosition();
			GoodsPO goodsPO = new GoodsPO(id, inDate, "", des, area, row, stand, pos, TransportType.YetToKnow, "");
			GoodsData goodsData = new GoodsData();
			judge = goodsData.insert(goodsPO);
			if (judge == 0) {
				System.out.println("插入数据库失败！");
			} else {
				System.out.println("插入数据库成功！");
			}

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			return judge;
	}
	/**
	 * 数据->逻辑->界面
	 * 生成出库单
	 */
	public OutboundOrderVO generateOutboundOrderVO(String id) {
		GoodsData goodsData;
		OutboundOrderVO outboundOrderVO = new OutboundOrderVO("", "", Destination.Beijing, TransportType.Airplane, "");
		try {
			goodsData = new GoodsData();
			GoodsPO goodsPO = goodsData.find(id);
			outboundOrderVO.setId(goodsPO.getId());
			outboundOrderVO.setOutDate(goodsPO.getOutDate());
			outboundOrderVO.setDestination(goodsPO.getDestination());
			outboundOrderVO.setTransportType(goodsPO.getTransportType());
			outboundOrderVO.setTransferNum(goodsPO.getTransferNum());

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// addOutboundOrder.add(outboundOrderVO);
		return outboundOrderVO;

	}
	/**
	 * 界面->逻辑->数据
	 * 更新数据库
	 */
	public int  generateOutboundOrderPO(OutboundOrderVO outboundOrderVO){
			int judge=0;
		try {
			String id = outboundOrderVO.getId();
			String outDate = outboundOrderVO.getOutDate();
			Destination des = outboundOrderVO.getDestination();
			TransportType transportType = outboundOrderVO.getTransportType();
			String transferNum= outboundOrderVO.getTransferNum();
			GoodsData goodsData = new GoodsData();
			GoodsPO goodsPO =goodsData.find(id);
			goodsPO.setOutDate(outDate);
			goodsPO.setTransportType(transportType);
			goodsPO.setTransferNum(transferNum);
			judge=goodsData.update(goodsPO);
			if (judge == 0) {
				System.out.println("更新数据库失败！");
			} else {
				System.out.println("更新数据库成功！");
			}

		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	return judge;
		
	}
//输入id查询入库单
	public InboundOrderVO inquireInboundOrder(String id){
		GoodsData goodsData;
		InboundOrderVO inboundOrderVO = null;
		try {
			goodsData = new GoodsData();
			GoodsPO goodsPO =goodsData.find(id);
			String Id=goodsPO.getId();
			String inDate=goodsPO.getInDate();
			Destination des=goodsPO.getDestination();
			Area area=goodsPO.getArea();
			int row=goodsPO.getRow();
			int stand=goodsPO.getStand();
			int position=goodsPO.getPosition();
			inboundOrderVO =new InboundOrderVO(Id,inDate,des,area,row,stand,position);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return inboundOrderVO;
		
	}
	
	//输入id查询出库单
		public OutboundOrderVO inquireOutboundOrder(String id){
			GoodsData goodsData;
			OutboundOrderVO outboundOrderVO = null;
			try {
				goodsData = new GoodsData();
				GoodsPO goodsPO =goodsData.find(id);
				String Id=goodsPO.getId();
				String outDate=goodsPO.getOutDate();
				Destination des=goodsPO.getDestination();
				TransportType tt=goodsPO.getTransportType();
				String transferNum=goodsPO.getTransferNum();
				outboundOrderVO =new OutboundOrderVO(Id,outDate,des,tt,transferNum);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return outboundOrderVO;
			
		}
		
	
	public ArrayList<InboundOrderVO> totalInboundOrder() {
		return addInboundOrder;

	}

	public ArrayList<OutboundOrderVO> totalOutboundOrder() {
		return addOutboundOrder;

	}
}
