package LEMS.po.informationpo;

public enum Gender{
    MAN, WOMEN;
    
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