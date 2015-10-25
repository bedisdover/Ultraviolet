package LEMS.po.userpo;

import java.io.Serializable;

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
    private int id;
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

    public UserPO(int id, String name, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getId() {
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
}

