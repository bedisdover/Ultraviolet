package LEMS.businesslogic.storebl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * @author 周梦佳
 *库存查看 库存盘点 库存报警
 */
import java.util.ArrayList;
import java.util.Date;

import LEMS.businesslogic.utility.RMIConnect;
import LEMS.dataservice.factory.DatabaseFactory;
import LEMS.dataservice.factory.StoreFactory;
import LEMS.dataservice.storedataservice.GoodsDataService;
import LEMS.po.storepo.Area;
import LEMS.po.storepo.Destination;
import LEMS.po.storepo.GoodsPO;
import LEMS.po.storepo.TransportType;
import LEMS.vo.storevo.GoodsVO;

/**
 * 
 * @author 周梦佳
 *
 */
public class StoreManagement {
	String startTime;
	String endTime;

	public StoreManagement() {
	}

	public StoreManagement(String sTime, String eTime) {
		startTime = sTime;
		endTime = eTime;
	}

	// 库存查看 设定一个时间段，查看此时间段内的出/入库数量
	// 金额，存储位置，库存数量要有合计
	public ArrayList<GoodsVO> inquire(String startTime, String endTime) {
		ArrayList<GoodsPO> al = new ArrayList<GoodsPO>();
		ArrayList<GoodsVO> alInbound = new ArrayList<GoodsVO>();
		ArrayList<GoodsVO> alOutbound = new ArrayList<GoodsVO>();
		ArrayList<GoodsVO> alGoodsVO = new ArrayList<GoodsVO>();
		int totalInbound = 0;// 入库数量
		int totalOutbound = 0;// 出库数量
		int totalStock = 0;// 库存数量
		int airlineNum = 0;
		int trainlineNum = 0;
		int buslineNum = 0;
		int motolineNum = 0;
		double money = 0.0;

		try {
			al = getData().find(startTime, endTime);
			int number = al.size();
			for (int i = 0; i < number; i++) {
				GoodsPO gpo = al.get(i);
				String in = gpo.getInDate();
				String out = gpo.getOutDate();
				if (in.compareTo(startTime) >= 0 && in.compareTo(endTime) <= 0) {
					GoodsVO gvo = getGoodsVOInfo(gpo);
					alInbound.add(gvo);
				}
				if ((out.compareTo(startTime) >= 0) && (out.compareTo(endTime) <= 0)) {
					GoodsVO gvo = getGoodsVOInfo(gpo);
					alOutbound.add(gvo);
				}
				Area area = gpo.getArea();
				switch (area) {
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
			totalInbound = alInbound.size();
			totalOutbound = alOutbound.size();
			totalStock = al.size();

			// temp用来保存两者共有的数据
			ArrayList<GoodsVO> temp = new ArrayList<GoodsVO>(alInbound);
			temp.retainAll(alOutbound);
			alInbound.removeAll(temp);
			alGoodsVO.addAll(alInbound);
			alGoodsVO.addAll(alOutbound);
			int alGoodsVONum = alGoodsVO.size();
			for (int k = 0; k < alGoodsVONum; k++) {
				money = money + alGoodsVO.get(k).getMoney();
			}
			// 最后八个的id就是各种数量 我好流氓。。。hhhh
			GoodsVO gvo1 = new GoodsVO(totalInbound + "", Area.Airline, -1, -1, -1);
			GoodsVO gvo2 = new GoodsVO(totalOutbound + "", Area.Airline, -1, -1, -1);
			GoodsVO gvo3 = new GoodsVO(totalStock + "", Area.Airline, -1, -1, -1);
			GoodsVO gvo4 = new GoodsVO(money + "", Area.Airline, -1, -1, -1);
			GoodsVO gvo5 = new GoodsVO(airlineNum + "", Area.Airline, -1, -1, -1);
			GoodsVO gvo6 = new GoodsVO(trainlineNum + "", Area.Airline, -1, -1, -1);
			GoodsVO gvo7 = new GoodsVO(buslineNum + "", Area.Airline, -1, -1, -1);
			GoodsVO gvo8 = new GoodsVO(motolineNum + "", Area.Airline, -1, -1, -1);
			alGoodsVO.add(gvo1);
			alGoodsVO.add(gvo2);
			alGoodsVO.add(gvo3);
			alGoodsVO.add(gvo4);
			alGoodsVO.add(gvo5);
			alGoodsVO.add(gvo6);
			alGoodsVO.add(gvo7);
			alGoodsVO.add(gvo8);

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return alGoodsVO;
	}

	public GoodsVO getGoodsVOInfo(GoodsPO gpo) {
		String id = gpo.getId();
		String inDate = gpo.getInDate();
		String outDate = gpo.getOutDate();
		Destination des = gpo.getDestination();
		Area area = gpo.getArea();
		int row = gpo.getRow();
		int stand = gpo.getStand();
		int position = gpo.getPosition();
		TransportType tt = gpo.getTransportType();
		String tn = gpo.getTransferNum();
		Double money = gpo.getMoney();
		GoodsVO goodsVO = new GoodsVO(id, inDate, outDate, des, area, row, stand, position, tt, tn, money);
		return goodsVO;

	}

	// 库存盘点（盘点的是当天的库存快照，包括当天的各区快递的信息
	public ArrayList<GoodsVO> check(String time) {
		ArrayList<GoodsVO> alvo = new ArrayList<GoodsVO>();
		Date date = new Date(); // 获取当前系统时间
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String today = format.format(date).substring(0, 8);
		String start = today + "000000";
		String end = today + time;
		alvo = inquire(start, end);
		return alvo;
	}

	public void warning() {
		// int standardNum = 10000;
		// ArrayList<GoodsVO> al = new ArrayList<GoodsVO>();
		// al = check();
		// int presentNum = al.size();
		// if (presentNum >= standardNum)
		// System.out.println("Warning!");
	}

	private GoodsDataService getData() {
		GoodsDataService goodsDataService = null;

		try {
			// 获得数据库的引用
			DatabaseFactory databaseFactory = (DatabaseFactory) Naming.lookup(RMIConnect.RMI);
			StoreFactory storeFactory = databaseFactory.getStoreFactory();
			goodsDataService = storeFactory.getGoodsData();
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
