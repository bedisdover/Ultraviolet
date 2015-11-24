package LEMS.vo.ordervo;

/**
 * @author 宋益明
 *
 * 货物信息值对象
 */
public class GoodsVO {
	/**
	 * 货物名称
	 */
	private String name;
	/**
	 * 货物尺寸
	 */
	private String size;
	/**
	 * 货物数量
	 */
	private int quantity;
	/**
	 * 货物质量
	 */
	private double weight;
	/**
	 * 货物体积
	 */
	private double volumn;
	
	//TODO 可能不需要的构造函数
//	public GoodsVO(String name, String size, int quantity, double weight, double volumn) {
//		this.name = name;
//		this.size = size;
//		this.quantity = quantity;
//		this.weight = weight;
//		this.volumn = volumn;
//	}

	public String getName() {
		return name;
	}

	public String getSize() {
		return size;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getWeight() {
		return weight;
	}

	public double getVolumn() {
		return volumn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}
}
