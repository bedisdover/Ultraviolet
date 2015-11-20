package LEMS.businesslogic.storebl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * @author 周梦佳
 *库存查看 库存盘点 库存报警
 */
import java.util.ArrayList;
import java.util.Date;

import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.GoodsPO;
import LEMS.vo.storevo.GoodsVO;
import LEMS.vo.storevo.InboundOrderVO;
import LEMS.vo.storevo.OutboundOrderVO;

public class StoreManagement {
	String startTime;
	String endTime;

	public StoreManagement() {
	}

	public StoreManagement(String sTime, String eTime) {
		startTime = sTime;
		endTime = eTime;
	}

	public ArrayList<GoodsVO> inquire(String startTime,String endTime){
		int sTime=Integer.parseInt(startTime);
		int eTime=Integer.parseInt(endTime);
		ArrayList<InboundOrderVO> originalInboundOrderVO=new ArrayList<InboundOrderVO>();
		ArrayList<OutboundOrderVO> originalOutboundOrderVO=new ArrayList<OutboundOrderVO>();
		ArrayList<GoodsVO> result=new ArrayList<GoodsVO>();//查询结果
		StoreGenerateOrder generateOrder=new StoreGenerateOrder();
		originalInboundOrderVO=generateOrder.totalInboundOrder();		//ArrayList<InboundOrderVO>
		originalOutboundOrderVO=generateOrder.totalOutboundOrder();		//ArrayList<OutboundOrderVO>
		int inNum=0;
		int outNum=0;
		//统计时间段内出入库数量
		for(int i=0;i<originalInboundOrderVO.size();i++){
			int inDate=Integer.parseInt(originalInboundOrderVO.get(i).getInDate());
			if(sTime<=inDate && inDate<=eTime)
				inNum++;
		}
		for(int j=0;j<originalOutboundOrderVO.size();j++){
			int outDate=Integer.parseInt(originalOutboundOrderVO.get(j).getOutDate());
			if(sTime<=outDate && outDate<=eTime)
				outNum++;
		}

		//出库时间在结束时间之前均删除
		for(int i=0;i<originalInboundOrderVO.size();i++){
			int inDate=Integer.parseInt(originalInboundOrderVO.get(i).getInDate());
			for(int j=0;j<originalOutboundOrderVO.size();j++){
				if(originalInboundOrderVO.get(i).getId().equals(originalOutboundOrderVO.get(j).getId())){
					int outDate=Integer.parseInt(originalOutboundOrderVO.get(j).getOutDate());
					if(outDate<=eTime){
					originalInboundOrderVO.remove(i);
					i--;
					}
				}
			}
			
			if(inDate>eTime){
				originalInboundOrderVO.remove(i);
				i--;
			}
		}
		//InboundOrderVO对象的ArrayList转成GoodsVO对象
		for(int k=0;k<originalInboundOrderVO.size();k++){
			String id=originalInboundOrderVO.get(k).getId();
			Area area=originalInboundOrderVO.get(k).getArea();
			int row=originalInboundOrderVO.get(k).getRow();
			int stand=originalInboundOrderVO.get(k).getStand();
			int position=originalInboundOrderVO.get(k).getPosition();
			GoodsVO gvo=new GoodsVO(id,area,row,stand,position);
			result.add(gvo);
		}
	return result;
	}
	
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
		int standardNum = 0;
		ArrayList<GoodsVO> al = new ArrayList<GoodsVO>();
		al = check();
		int presentNum = al.size();
		if (presentNum >= standardNum)
			System.out.println("Warning!");
	}

}
