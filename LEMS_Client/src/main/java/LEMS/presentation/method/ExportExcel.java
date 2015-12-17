package LEMS.presentation.method;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;  
/**
 * 导出excel表格，像这样
 * ArrayList<Object> al=new ArrayList<Object>();
GoodsVO gvo=new GoodsVO("1", "1", "1", Destination.Beijing, Area.Airline, 1, 1, 1, TransportType.Airplane, "1",1);
al.add(gvo);
ExportExcel excel=new ExportExcel();
String[] title={"快递单号","入库日期","出库日期","目的地","存储区域","架号","排号","位号","装运形式","单号","运费"};
excel.exportExcel("f:/text.xls","库存盘点", title, al);
 * 
 *
 */

public class ExportExcel { 
	/**filename 文件名
	 * head EXCEL标题
	 * listTitle EXCEL文件第一行列标题集合 
	 * listContent EXCEL文件正文数据集合 
	 */
	public  final static String exportExcel(String fileName,String head,String[] Title, List<Object> listContent) {  
		  String result="系统提示：Excel文件导出成功！";    
		  // 以下开始输出到EXCEL  
		  try {      
		   FileOutputStream fos ;
		   fos =new FileOutputStream(fileName);
		  /**
		   * 创建工作簿
		   */
		   WritableWorkbook workbook = Workbook.createWorkbook(fos);  
		  /**
		   * 创建工作表
		   */
		   WritableSheet sheet = workbook.createSheet("Sheet1", 0);  
		   sheet.getSettings().setDefaultColumnWidth(20); 
		  /**
		   * 设置纵横打印（默认为纵打）、打印纸
		   */
		   jxl.SheetSettings sheetset = sheet.getSettings();  
		   sheetset.setProtected(false);  
		  /**
		   * 设置单元格字体
		   */
		   WritableFont NormalFont = new WritableFont(WritableFont.ARIAL, 11);  
		   WritableFont BoldFont = new WritableFont(WritableFont.ARIAL, 13,WritableFont.BOLD); 
		   WritableFont TitleFont = new WritableFont(WritableFont.ARIAL, 15,WritableFont.BOLD); 
		  /**
		   * 以下设置三种单元格样式，灵活备用
		   */
		   

		   // 用于标题居中  
		   WritableCellFormat wcf_title_center = new WritableCellFormat(TitleFont);  
		   wcf_title_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条  
		   wcf_title_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐  
		   wcf_title_center.setAlignment(Alignment.CENTRE); // 文字水平对齐  
		   wcf_title_center.setWrap(false); // 文字是否换行
		   
		   // 用于标题居中  
		   WritableCellFormat wcf_center = new WritableCellFormat(BoldFont);  
		   wcf_center.setBorder(Border.ALL, BorderLineStyle.THIN); // 线条  
		   wcf_center.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐  
		   wcf_center.setAlignment(Alignment.CENTRE); // 文字水平对齐  
		   wcf_center.setWrap(false); // 文字是否换行  
		
		     
		   // 用于正文居左  
		   WritableCellFormat wcf_left = new WritableCellFormat(NormalFont);  
		   wcf_left.setBorder(Border.NONE, BorderLineStyle.THIN); // 线条  
		   wcf_left.setVerticalAlignment(VerticalAlignment.CENTRE); // 文字垂直对齐  
		   wcf_left.setAlignment(Alignment.CENTRE); // 文字水平对齐  
		   wcf_left.setWrap(false); // 文字是否换行     
		   /**
		    * 以下是EXCEL开头大标题
		    */
		 //  sheet.mergeCells(0, 0, colWidth, 0);  
		   sheet.addCell(new Label(Title.length/2,0 , head, wcf_title_center));  
		   /**
		    * 以下是EXCEL第一行列标题
		    */
		   for (int i = 0; i < Title.length; i++) {  
		    sheet.addCell(new Label(i, 1,Title[i],wcf_center));  
		   }     
		   /**
		    * 以下是EXCEL正文数据
		    */
		   Field[] fields=null;  
		   int i=2;  
		   for(Object obj:listContent){  
		       fields=obj.getClass().getDeclaredFields();  
		       int j=0;  
		       for(Field v:fields){  
		           v.setAccessible(true);  
		           Object va=v.get(obj);  
		           if(va==null){  
		               va="";  
		           }  
		           sheet.addCell(new Label(j, i,va.toString(),wcf_left));  
		           j++;  
		       }  
		       i++;  
		   }  
		   /**
		    * 将以上缓存中的内容写到EXCEL文件中
		    */
		   workbook.write(); 
		   /**
		    * 关闭文件
		    */
		   workbook.close();     
		  
		  } catch (Exception e) {  
		   result="系统提示：Excel文件导出失败，原因："+ e.toString();  
		   System.out.println(result);   
		   e.printStackTrace();  
		  }  
		  return result;  
		 }  
}  