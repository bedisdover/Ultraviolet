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
	
	public GoodsVO(String name, String size, int quantity, double weight, double volumn) {
		this.name = name;
		this.size = size;
		this.quantity = quantity;
		this.weight = weight;
		this.volumn = volumn;
	}

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
}
