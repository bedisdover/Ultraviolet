package LEMS.po.informationpo;

public enum Gender{
    MAN, WOMEN;
    
    public static Gender exchange(String s){
    	if(s.equals("男")){
    		return MAN;
    	}
    	else{
    		return WOMEN;
    	}
    }
}