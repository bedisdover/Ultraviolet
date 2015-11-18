package LEMS.vo.uservo;

import LEMS.po.informationpo.InstitutionPO;
import LEMS.po.userpo.UserRole;

/**
 * @author 苏琰梓
 * 用户信息值对象
 * 2015年10月26日
 */
public class UserVO {
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
    public UserVO(String id, String password, UserRole role, String name, InstitutionPO institution) {
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
