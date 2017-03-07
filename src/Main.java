import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Main {
	public static void main(String[] args) throws Exception{
		test();
	}
	
	public static void test() throws Exception{
		HttpHostConnection testHHC = new HttpHostConnection();
		Map<String, String> GetMap = new HashMap<String, String>();
		GetMap.put("cityId", "0");
		GetMap.put("provId", "8");
		GetMap.put("regionId", "0");
		GetMap.put("pageSize", "100");//每页显示多多少项
		GetMap.put("sortType", "3");
		GetMap.put("isInsurance", "0");
		GetMap.put("hospitalType", "0");
		GetMap.put("hospitalLvl", "12");//0是全部医院，12是三甲医院，其他数字未知，通过火狐（谷歌应该也行）-开发工具-网络，获取http请求详细内容。
		GetMap.put("serviceType", "0");
		GetMap.put("isRecommend", "0");
		GetMap.put("page", "1");//当前页
		GetMap.put("zt", "self");
		GetMap.put("pvid", "1464395382585749");
		GetMap.put("seed", "seed_1464395377739");
		
		String jsonString = testHHC.sendGetData(
				"http://yi.baidu.com/pc/hospital/list?cityId=0&provId=32&regionId=0&pageSize=10&sortType=1&isInsurance=0&hospitalType=0&hospitalLvl=0&serviceType=0&isRecommend=0&page=1&zt=self&pvid=1464395382585749&seed=seed_1464395377739"
				, GetMap,"utf-8");
		System.out.println(jsonString);
		HospitalInfo testobj = new Gson().fromJson(jsonString, HospitalInfo.class);
		File desFile = new File("../url/hn_hospital_url.txt");
		PrintWriter pWriter = new PrintWriter(desFile);
		//System.out.println(testobj.data.hospitalList.get(0).name);
		for (int i = 0;i < testobj.data.hospitalList.size();i ++){
			System.out.println(testobj.data.hospitalList.get(i).name);
			System.out.println(testobj.data.hospitalList.get(i).link);
			pWriter.println(testobj.data.hospitalList.get(i).link);
		}
		pWriter.close();
	}


}
