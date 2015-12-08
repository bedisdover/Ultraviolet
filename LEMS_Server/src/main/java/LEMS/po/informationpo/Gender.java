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
    
    public static Gender transfer(String gender){
    	Gender g=null;
    	if(gender.equals("MAN")){
    		g=Gender.MAN;
    	}
    	else{
    		g=Gender.WOMEN;
    	}
    	return g;
    }
}