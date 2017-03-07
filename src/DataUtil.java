import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 数据转换
 * @author tanchong
 */
public class DataUtil {

	/**
	 * 将字符串转换成GBK格式
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getStringByGBK(String str) throws UnsupportedEncodingException{
		String data = new String(str.getBytes(),"GBK");
		return data;
	}
	
	/**
	 * 将字符串转换成utf-8格式
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getStringByUTF(String str) throws UnsupportedEncodingException{
		String data = new String(str.getBytes(),"UTF-8");
		return data;
	}
	
	/**
	 * 将发送的数据进行拼装，拼装为post和get方法都可以进行发送的形式
	 * @param map 传入一个map对象，对象的key为id，value为值
	 * @return
	 */
	public static String getDataBySendData(Map<String, String> map){
		String data = "";
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		while(it.hasNext()){
			Entry<String, String> entry = it.next();
			data += entry.getKey() + "=" +entry.getValue() + "&";
		}
		return data.substring(0, data.length()-1);
	}
}
