package LEMS.po.inquirepo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author 章承尧
 * 物流信息持久化对象
 */
@SuppressWarnings("serial")
public class LogisticsInfoPO implements Serializable{
	long id;
	ArrayList<String> trace;
	
	public LogisticsInfoPO(long i,ArrayList<String> t){
		id=i;
		trace=t;
	}
	public long getId(){
		return id;
	}
	public ArrayList<String> getTrace(){
		return trace;
	}
}
