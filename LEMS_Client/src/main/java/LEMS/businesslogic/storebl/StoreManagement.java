package LEMS.businesslogic.storebl;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * @author 周梦佳
 *库存查看 库存盘点 库存报警
 */
import java.util.ArrayList;
import java.util.Date;

import LEMS.po.orderpo.TransportType;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.GoodsPO;
import LEMS.vo.storevo.GoodsVO;

public class StoreManagement {
	String startTime;
	String endTime;

	public StoreManagement() {
	}

	public StoreManagement(String sTime, String eTime) {
		startTime = sTime;
		endTime = eTime;
	}

	//库存查看 设定一个时间段，查看此时间段内的出/入库数量
	//金额，存储位置，库存数量要有合计
	public ArrayList<GoodsVO> inquire(String startTime,String endTime){
		GoodsData goodsData;
		ArrayList<GoodsPO> al=new ArrayList<GoodsPO>();
		ArrayList<GoodsVO> alInbound=new ArrayList<GoodsVO>();
		ArrayList<GoodsVO> alOutbound=new ArrayList<GoodsVO>();
		ArrayList<GoodsVO> alGoodsVO=new ArrayList<GoodsVO>();
		int totalInbound=0;//入库数量
		int totalOutbound=0;//出库数量
		int totalStock=0;//库存数量
		int airlineNum=0;
		int trainlineNum=0;
		int buslineNum=0;
		int motolineNum=0;
		double money=0.0;
		
		
		try {
			goodsData = new GoodsData();
			al=goodsData.find(startTime, endTime);
			int number=al.size();
			for(int i=0;i<number;i++){
				GoodsPO gpo=al.get(i);
				String in=gpo.getInDate();
				String out=gpo.getOutDate();
				if(in.compareTo(startTime)>=0 && in.compareTo(endTime)<=0){
					//totalInbound++;
					GoodsVO gvo=getGoodsVOInfo(gpo);
					alInbound.add(gvo);
					
				}
				if((out.compareTo(startTime)>=0 )&& (out.compareTo(endTime)<=0)){
					//totalOutbound++;
					GoodsVO gvo=getGoodsVOInfo(gpo);
					alOutbound.add(gvo);
				}
				Area area=gpo.getArea();
				switch(area){
					case Airline:
						airlineNum++;
						break;
					case Trainline:
						trainlineNum++;
						break;
					case Busline:
						buslineNum++;
						break;
					case Motoline:
						motolineNum++;
						break;
				}
			
				
			}
			totalInbound=alInbound.size();
			totalOutbound=alOutbound.size();
			totalStock=al.size();
			
			
			//temp用来保存两者共有的数据
			ArrayList<GoodsVO> temp = new ArrayList<GoodsVO>(alInbound);
			temp.retainAll(alOutbound);
			alInbound.removeAll(temp);
			alGoodsVO.addAll(alInbound);
			alGoodsVO.addAll(alOutbound);
			int alGoodsVONum=alGoodsVO.size();
			for(int k=0;k<alGoodsVONum;k++){
				money=money+alGoodsVO.get(k).getMoney();
			}
			//最后两个的id就是出入库数量 我好流氓。。。hhhh
			GoodsVO gvo1=new GoodsVO(totalInbound+"", Area.Airline, -1, -1, -1);
			GoodsVO gvo2=new GoodsVO(totalOutbound+"", Area.Airline, -1, -1, -1);
			GoodsVO gvo3=new GoodsVO(totalInbound+"", Area.Airline, -1, -1, -1);
			GoodsVO gvo4=new GoodsVO(totalOutbound+"", Area.Airline, -1, -1, -1);
			GoodsVO gvo5=new GoodsVO(totalInbound+"", Area.Airline, -1, -1, -1);
			GoodsVO gvo6=new GoodsVO(totalOutbound+"", Area.Airline, -1, -1, -1);
			GoodsVO gvo7=new GoodsVO(totalInbound+"", Area.Airline, -1, -1, -1);
			GoodsVO gvo8=new GoodsVO(totalOutbound+"", Area.Airline, -1, -1, -1);
			alGoodsVO.add(gvo1);
			alGoodsVO.add(gvo2);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return alGoodsVO;
	}
	
	public ArrayList<Double> inquireNum(String startTime,String endTime){
		ArrayList<Double> alNum=new ArrayList<Double>();
		ArrayList<GoodsVO> al=new ArrayList<GoodsVO>();
		Double money=0.0;
		double airlineNum=0;
		double trainlineNum=0;
		double buslineNum=0;
		double motolineNum=0;
		
		al=inquire(startTime, endTime);
		int length=al.size();
		al.remove(length-1);
		al.remove(length-2);
		int number=al.size();
		for(int i=0;i<number;i++){
			GoodsVO gvo=al.get(i);
			Area area=gvo.getArea();
			switch(area){
				case Airline:
					airlineNum++;
					break;
				case Trainline:
					trainlineNum++;
					break;
				case Busline:
					buslineNum++;
					break;
				case Motoline:
					motolineNum++;
					break;
			}
			
		}
		
		
		
		alNum.add(money);
		alNum.add(airlineNum);
		alNum.add(trainlineNum);
		alNum.add(buslineNum);
		alNum.add(motolineNum);
		
		return alNum;
	}
	
	



		
//		
//		int sTime=Integer.parseInt(startTime);
//		int eTime=Integer.parseInt(endTime);
//		ArrayList<InboundOrderVO> originalInboundOrderVO=new ArrayList<InboundOrderVO>();
//		ArrayList<OutboundOrderVO> originalOutboundOrderVO=new ArrayList<OutboundOrderVO>();
//		ArrayList<GoodsVO> result=new ArrayList<GoodsVO>();//查询结果
//		StoreGenerateOrder generateOrder=new StoreGenerateOrder();
//		originalInboundOrderVO=generateOrder.totalInboundOrder();		//ArrayList<InboundOrderVO>
//		originalOutboundOrderVO=generateOrder.totalOutboundOrder();		//ArrayList<OutboundOrderVO>
//		int inNum=0;
//		int outNum=0;
//		//统计时间段内出入库数量
//		for(int i=0;i<originalInboundOrderVO.size();i++){
//			int inDate=Integer.parseInt(originalInboundOrderVO.get(i).getInDate());
//			if(sTime<=inDate && inDate<=eTime)
//				inNum++;
//		}
//		for(int j=0;j<originalOutboundOrderVO.size();j++){
//			int outDate=Integer.parseInt(originalOutboundOrderVO.get(j).getOutDate());
//			if(sTime<=outDate && outDate<=eTime)
//				outNum++;
//		}
//
//		//出库时间在结束时间之前均删除
//		for(int i=0;i<originalInboundOrderVO.size();i++){
//			int inDate=Integer.parseInt(originalInboundOrderVO.get(i).getInDate());
//			for(int j=0;j<originalOutboundOrderVO.size();j++){
//				if(originalInboundOrderVO.get(i).getId().equals(originalOutboundOrderVO.get(j).getId())){
//					int outDate=Integer.parseInt(originalOutboundOrderVO.get(j).getOutDate());
//					if(outDate<=eTime){
//					originalInboundOrderVO.remove(i);
//					i--;
//					}
//				}
//			}
//			
//			if(inDate>eTime){
//				originalInboundOrderVO.remove(i);
//				i--;
//			}
//		}
//		//InboundOrderVO对象的ArrayList转成GoodsVO对象
//		for(int k=0;k<originalInboundOrderVO.size();k++){
//			String id=originalInboundOrderVO.get(k).getId();
//			Area area=originalInboundOrderVO.get(k).getArea();
//			int row=originalInboundOrderVO.get(k).getRow();
//			int stand=originalInboundOrderVO.get(k).getStand();
//			int position=originalInboundOrderVO.get(k).getPosition();
//			GoodsVO gvo=new GoodsVO(id,area,row,stand,position);
//			result.add(gvo);
//		}
//	return result;
//	}
//	
	public GoodsVO getGoodsVOInfo(GoodsPO gpo){
		String id=gpo.getId();
		String inDate=gpo.getInDate();
		String outDate=gpo.getOutDate();
		Destination des=gpo.getDestination();
		Area area=gpo.getArea();
		int row=gpo.getRow();
		int stand=gpo.getStand();
		int position=gpo.getPosition();
		TransportType tt=gpo.getTransportType();
		String tn=gpo.getTransferNum();
		Double money=gpo.getMoney();
		GoodsVO goodsVO=new GoodsVO(id,inDate,outDate,des,area,row,stand,position,tt,tn,money);
		return goodsVO;
		
		
	}
	
	//库存盘点（盘点的是当天的库存快照，包括当天的各区快递的信息
	public ArrayList<GoodsVO> check() {
		ArrayList<GoodsVO> alvo = new ArrayList<GoodsVO>();
		Date date=new Date();		//获取当前系统时间
		DateFormat format=new SimpleDateFormat("yyyyMMddHH:mm:ss");
		String nowTime=format.format(date);
		String todayStartTime=nowTime.substring(0, 8)+"00:00:00";
		alvo=inquire(todayStartTime,nowTime);
		return alvo;
	}

	public void warning() {
		int standardNum = 10000;
		ArrayList<GoodsVO> al = new ArrayList<GoodsVO>();
		al = check();
		int presentNum = al.size();
		if (presentNum >= standardNum)
			System.out.println("Warning!");
	}

}
