import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class HttpHostConnection {

	/**
	 * 采用POST进行发送数据，然后接收到的字符串返回
	 * @param url 发送的URL地址
	 * @param postData 发送的数据，采用map进行封装
	 * @param encoding 接收的数据，采用什么类型进行接收，如"GBK" or "UTF-8"
	 * @return
	 */
	public String sendPostData(String url, Map<String, String> map,String encoding)throws Exception {
		String data = null;
		URL dataUrl = new URL(url);
		HttpURLConnection con = (HttpURLConnection) dataUrl
				.openConnection();
		//设置连接的头部信息
		con.setRequestProperty("Host","yi.baidu.com");
		con.setRequestProperty("User-Agent",
		"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0");
		con.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
		con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		con.setRequestProperty("Accept-Encoding", "gzip, deflate");
		con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
		con.setRequestProperty("Referer", "http://yi.baidu.com/pc/hospital/listpage?zt=self&zt_ext=&pvid=1464339216636110&provId=32&cityId=0&regionId=0&key=&filterFlag=1&searchFlag=0&qq-pf-to=pcqq.c2c");
		con.setRequestProperty("Cookie", "tssid=pcNewHospitalPage%3A2; BDUSS=G9pa3dBNU4wNldjb1daSTRyZVNLNzM4N3hSdGJWVklRdG1GbGNXVX42Y25KZDFXQVFBQUFBJCQAAAAAAAAAAAEAAADjwksLa3lka29uZzkyODhTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACeYtVYnmLVWN; BAIDUID=57C9E1EDC462E762D82A4FED844AF7EC:FG=1; BIDUPSID=2B457C73BD34E5810B432E2A213A0943; PSTM=1461589933; H_PS_PSSID=18881_18285_1459_18201_19557_17946_19568_15397_12302_18243; Hm_lvt_2129ef9891a442299befc9c664fc73e3=1464358986; Hm_lpvt_2129ef9891a442299befc9c664fc73e3=1464395377");
		con.setRequestProperty("Connection", "keep-alive");
		//得到发送的数据
		String post = DataUtil.getDataBySendData(map);
		// 进行发送数据
		sendConnectinData(con, post);
		// 进行接收数据
		data = getConnectionData(con, encoding);

		con.disconnect();
		return data;
	}

	/**
	 * 采用GET进行发送数据，然后接收到的字符串返回
	 * @param url 发送的URL地址
	 * @param postData 发送的数据，采用map进行封装，这里使用get发送，是明文发送
	 * @param encoding 接收的数据，采用什么类型进行接收，如"GBK" or "UTF-8"
	 * @return
	 */
	public String sendGetData(String url, Map<String, String> map, String encoding) {
		String data = null;
		try {
			// 对URL进行拼装
			url += "?" + DataUtil.getDataBySendData(map);
			//创建连接
			URL dataUrl = new URL(url);
			HttpURLConnection con = (HttpURLConnection) dataUrl
					.openConnection();
			//创建头部信息
			con.setRequestProperty("Host","yi.baidu.com");
			con.setRequestProperty("User-Agent",
			"Mozilla/5.0 (Windows NT 10.0; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0");
			con.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
			con.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
			con.setRequestProperty("Accept-Encoding", "gzip, deflate");
			con.setRequestProperty("X-Requested-With", "XMLHttpRequest");
			con.setRequestProperty("Referer", "http://yi.baidu.com/pc/hospital/listpage?zt=self&zt_ext=&pvid=1464339216636110&provId=32&cityId=0&regionId=0&key=&filterFlag=1&searchFlag=0&qq-pf-to=pcqq.c2c");
			con.setRequestProperty("Cookie", "tssid=pcNewHospitalPage%3A2; BDUSS=G9pa3dBNU4wNldjb1daSTRyZVNLNzM4N3hSdGJWVklRdG1GbGNXVX42Y25KZDFXQVFBQUFBJCQAAAAAAAAAAAEAAADjwksLa3lka29uZzkyODhTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACeYtVYnmLVWN; BAIDUID=57C9E1EDC462E762D82A4FED844AF7EC:FG=1; BIDUPSID=2B457C73BD34E5810B432E2A213A0943; PSTM=1461589933; H_PS_PSSID=18881_18285_1459_18201_19557_17946_19568_15397_12302_18243; Hm_lvt_2129ef9891a442299befc9c664fc73e3=1464358986; Hm_lpvt_2129ef9891a442299befc9c664fc73e3=1464395377");
			con.setRequestProperty("Connection", "keep-alive");
			// 直接进行接收数据
			data = getConnectionData(con, encoding);
			
			con.disconnect();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}

	/**
	 * 获取某一连接的数据，不需要进行发送数据
	 * 
	 * @param url
	 *            需要返回的url地址
	 * @return
	 */
	public String getHostData(String url,String encoding) {
		String data = null;
		try {
			URL dataUrl = new URL(url);
			HttpURLConnection con = (HttpURLConnection) dataUrl
					.openConnection();
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "Keep-Alive");
			con.setRequestProperty("user-agent",
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 进行接收数据
			data = getConnectionData(con, encoding);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return data;
	}

	/**
	 * 进行发送数据，根据获取到的连接对象进行发送数据
	 * @param con 连接对象
	 * @param postData 发送的数据
	 * @throws Exception
	 */
	protected void sendConnectinData(HttpURLConnection con, String postData)
			throws Exception {
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setDoInput(true);
		// 进行发送数据
		OutputStream os = con.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		dos.write(postData.getBytes());
		dos.flush();
		// 发送完成关闭连接
		dos.close();

	}

	/**
	 * 根据连接获取到连接中的数据
	 * @param con 连接对象
	 * @param encoding 接收的形式，采用什么类型进行接收数据
	 * @return 成功得到的数据
	 * @throws Exception
	 */
	protected String getConnectionData(HttpURLConnection con,String encoding) throws Exception {
		String str = "";
		// 直接进行获取数据
		InputStreamReader isr = new InputStreamReader(con.getInputStream(),encoding);
		BufferedReader br = new BufferedReader(isr);
		String temp = null;
		while ((temp = br.readLine()) != null) {
			if(temp.equals("")){
				str += "\r\n";
			}else{
				str += temp;
			}
		}
		con.disconnect();
		return str;
	}
}
