package LEMS.po.userpo;

import java.io.Serializable;

import LEMS.po.informationpo.InstitutionPO;

/**
 * @author 宋益明
 * 
 * 用户持久化对象
 */
@SuppressWarnings("serial")
public class UserPO implements Serializable {
    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户类型
     */
    private UserRole role;
    private InstitutionPO institution;
    public UserPO(String id, String password, UserRole role, String name,InstitutionPO institution) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.institution=institution;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
    public InstitutionPO getInstitution(){
    	return institution;
    }
}

