package cn.itcast.yycg.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * 药品信息导入处理接口
 * @author 
 *
 */
public class TestYpxxImportServiceImpl implements HxlsOptRowsInterface {

	/**
	 * 返回结果，成功返回1，失败返回0
	 */
	@Override
	public String saveOptRows(int sheetIndex, int curRow, List<String> rowlist)
			throws Exception {

		//解析rowlist

		//获取流水号
		String bm = rowlist.get(0);
		
		//获取通用名
		String mc = rowlist.get(1);
		
		//获取中标价格
		String zbjg = rowlist.get(2);
		
		//构造一个po对象
		TestYpxx ypxx = new TestYpxx(bm, mc, Float.parseFloat(zbjg));
		//插入数据库。。。。
		System.out.println("导入数据。。。。。"+ypxx);
		
		return "1";
		
		
	}
	
	public static void main(String[] args) {
		HxlsRead xls2csv;
		try {
			xls2csv = new HxlsRead("d:/ypxx_20140609145243.xls",0,new TestYpxxImportServiceImpl());
			xls2csv.process();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
