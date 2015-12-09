package LEMS.businesslogic.storebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import LEMS.businesslogic.orderbl.AddOrder;
import LEMS.businesslogic.orderbl.Order;
import LEMS.businesslogic.utility.RMIConnect;
/**
 * @author 周梦佳
 *生成仓库出库入库单
 */
import LEMS.businesslogicservice.storeblservice.StoreGenerateOrderService;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.OrderFactory;
import LEMS.dataservice.factory.StoreFactory;
import LEMS.dataservice.orderdataservice.OrderDataService;
import LEMS.dataservice.storedataservice.GoodsDataService;
import LEMS.po.orderpo.OrderPO;
import LEMS.po.orderpo.TransportType;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.GoodsPO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;

public class StoreGenerateOrder implements StoreGenerateOrderService {

	ArrayList<InboundOrderVO> addInboundOrder = new ArrayList<InboundOrderVO>();
	ArrayList<OutboundOrderVO> addOutboundOrder = new ArrayList<OutboundOrderVO>();
	
	/**
	 * 数据->逻辑->界面
	 * 生成入库单
	 */
	public InboundOrderVO generateInboundOrderVO(String id) throws RemoteException{
	//	GoodsData goodsData;
		
		InboundOrderVO inboundOrderVO = new InboundOrderVO("", "", Destination.Beijing, Area.Airline, 1, 1, 1);
		try {
	//		goodsData = new GoodsData();
		
			GoodsPO goodsPO =getData().find(id);
			inboundOrderVO.setId(goodsPO.getId());
			inboundOrderVO.setInDate(goodsPO.getInDate());
			inboundOrderVO.setDestination(goodsPO.getDestination());
			inboundOrderVO.setArea(goodsPO.getArea());
			inboundOrderVO.setRow(goodsPO.getRow());
			inboundOrderVO.setStand(goodsPO.getStand());
			inboundOrderVO.setPosition(goodsPO.getPosition());

		} catch (RemoteException e) {
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
			AddOrder addOrder=new AddOrder();
			OrderPO orderpo=addOrder.findOrder(id);
			Double money=orderpo.getAmount();
			GoodsPO goodsPO = new GoodsPO(id, inDate, "", des, area, row, stand, pos, TransportType.YetToKnow, "", money);
			judge = getData().insert(goodsPO);
			if (judge == 0) {
				System.out.println("插入数据库失败！");
			} else {
				System.out.println("插入数据库成功！");
			}

		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
			return judge;
	}
	/**
	 * 数据->逻辑->界面
	 * 生成出库单
	 */
	public OutboundOrderVO generateOutboundOrderVO(String id) {
		OutboundOrderVO outboundOrderVO = new OutboundOrderVO("", "", Destination.Beijing, TransportType.Airplane, "");
		try {
			GoodsPO goodsPO = getData().find(id);
			outboundOrderVO.setId(goodsPO.getId());
			outboundOrderVO.setOutDate(goodsPO.getOutDate());
			outboundOrderVO.setDestination(goodsPO.getDestination());
			outboundOrderVO.setTransportType(goodsPO.getTransportType());
			outboundOrderVO.setTransferNum(goodsPO.getTransferNum());

		} catch (RemoteException e) {
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
			GoodsPO goodsPO =getData().find(id);
			goodsPO.setOutDate(outDate);
			goodsPO.setTransportType(transportType);
			goodsPO.setTransferNum(transferNum);
			judge=getData().update(goodsPO);
			if (judge == 0) {
				System.out.println("更新数据库失败！");
			} else {
				System.out.println("更新数据库成功！");
			}

		} catch (RemoteException e1) {
			e1.printStackTrace();
		}

	return judge;
		
	}
//输入id查询入库单
	public InboundOrderVO inquireInboundOrderPO(String id){
		InboundOrderVO inboundOrderVO = null;
		try {
			GoodsPO goodsPO =getData().find(id);
			String Id=goodsPO.getId();
			String inDate=goodsPO.getInDate();
			Destination des=goodsPO.getDestination();
			Area area=goodsPO.getArea();
			int row=goodsPO.getRow();
			int stand=goodsPO.getStand();
			int position=goodsPO.getPosition();
			inboundOrderVO =new InboundOrderVO(Id,inDate,des,area,row,stand,position);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return inboundOrderVO;
		
	}
	
	//输入id查询出库单
		public OutboundOrderVO inquireOutboundOrderPO(String id){
			OutboundOrderVO outboundOrderVO = null;
			try {
				GoodsPO goodsPO =getData().find(id);
				String Id=goodsPO.getId();
				String outDate=goodsPO.getOutDate();
				Destination des=goodsPO.getDestination();
				TransportType tt=goodsPO.getTransportType();
				String transferNum=goodsPO.getTransferNum();
				outboundOrderVO =new OutboundOrderVO(Id,outDate,des,tt,transferNum);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return outboundOrderVO;
			
		}
		//告诉数据库删除入库单
		public int deleteInboundOrderPO(String id){
			int judge=-1;
			try {
				judge=getData().delete(id);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return judge;
			
		}
		
		//删除出库单
		public int deleteOutboundOrderPO(String id){
			int judge=-1;
			try {
				GoodsPO goodsPO=getData().find(id);
				if(goodsPO.getInDate().equals("")){
					judge=getData().delete(id);
				}
				if(!goodsPO.getInDate().equals("")){
					goodsPO.setOutDate("");
					goodsPO.setTransferNum("");
					goodsPO.setTransportType(TransportType.YetToKnow);
					getData().update(goodsPO);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return judge;
			
		}
		//修改入库单
		public int updateInboundOrderPO(InboundOrderVO iovo){
			int judge=-1;
			try {
				String id=iovo.getId();
				GoodsPO goodspo=getData().find(id);
				String inDate=iovo.getInDate();
				Destination des=iovo.getDestination();
				Area area=iovo.getArea();
				int row=iovo.getRow();
				int stand=iovo.getStand();
				int position=iovo.getPosition();
				AddOrder addOrder=new AddOrder();
				OrderPO orderpo=addOrder.findOrder(id);
				Double money=orderpo.getAmount();
				GoodsPO goodsPO=new GoodsPO(id,inDate,goodspo.getOutDate(),des,area,row,stand,position,goodspo.getTransportType(),goodspo.getTransferNum(),money);
				judge=getData().update(goodsPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			return judge;
			
		}
		//修改出库单
		public int updateOutboundOrderPO(OutboundOrderVO oovo){

			int judge=-1;
			try {
				String id=oovo.getId();
				GoodsPO goodspo=getData().find(id);
				String outDate=oovo.getOutDate();
				Destination des=oovo.getDestination();
				TransportType tt=oovo.getTransportType();
				String tn=oovo.getTransferNum();
				AddOrder addOrder=new AddOrder();
				OrderPO orderpo=addOrder.findOrder(id);
				Double money=orderpo.getAmount();
				GoodsPO goodsPO=new GoodsPO(id,goodspo.getInDate(),outDate,des,goodspo.getArea(),goodspo.getRow(),goodspo.getStand(),goodspo.getPosition(),tt,tn,money);
				judge=getData().update(goodsPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			return judge;
		}
		
		private GoodsDataService getData() {
			GoodsDataService goodsDataService = null;
			
			try {
				//获得数据库的引用
				DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
				StoreFactory storeFactory = databaseFactory.getStoreFactory();
				goodsDataService =storeFactory.getGoodsData();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
			
			return goodsDataService;
		}
	
}
