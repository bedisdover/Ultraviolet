package LEMS.presentation;


/**
 * @author 苏琰梓
 *
 */
public class main {

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		LoginUi jPanelLogin = new LoginUi(mainFrame);
		mainFrame.setContentPane(jPanelLogin);
	}
}
//所有用户的账号、密码、身份
//bc0211000000	123456	苏琰梓	 营业厅业务员
//bc0211000001	123456	张三	营业厅业务员
//c0210000000	123456	米拉娜	快递员
//fc00000	123456	戴泽	财务人员
//gm00000	123456	克林克兹	总经理
//m00000	123456	宋益明	管理员
//sm02100000000	123456	米波	仓库管理人员
//tc0210000000	123456	周梦佳	中转中心业务员