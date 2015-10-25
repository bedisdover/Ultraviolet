package LEMS.po.informationpo;

public enum Gender{
    //赋值必须都赋值或都不赋值，不能一部分赋值一部分不赋值；如果不赋值则不能写构造器，赋值编译也出错
    MAN("MAN"), WOMEN("WOMEN");
    
    private final String value;

    //构造函数只能在内部使用
    Gender(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
}