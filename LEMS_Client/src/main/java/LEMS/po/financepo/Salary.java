package LEMS.po.financepo;

public class Salary {
	public static double getDefaultSalary(String role) {
		switch (role) {
		case "管理员":
			return 8500;
		case "总经理":
			return 20000;
		case "仓库管理人员":
			return 6500;
		case "快递员":
			return 3500;
		case "营业厅业务员":
			return 5500;
		case "中转中心业务员":
			return 6500;
		case "财务人员":
			return 8500;
		default:
			return 3500;
		}
	}
}
