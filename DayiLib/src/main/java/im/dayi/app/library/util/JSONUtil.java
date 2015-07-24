package im.dayi.app.library.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @description JSON工具类
 * @author wragony
 * @email: wxl@wisezone.org
 * @createDate: 2013-1-6
 * @version 1.0.0
 * @copyright Copyright(c) 2013 jifenzhong.com. All Rights Reserved
 */
public class JSONUtil {

	/***
	 * 将JSON对象数组序列化为JSON文本
	 * 
	 * @param jsonArray
	 * @return
	 */
	public static String toJSONString(JSONArray jsonArray) throws Exception {
		try {
			return jsonArray.toString();
		}
		catch (Exception e) {
            throw new Exception("JSON Exception.");
		}
	}

	/***
	 * 将JSON对象序列化为JSON文本
	 * 
	 * @param jsonObject
	 * @return
	 */
	public static String toJSONString(JSONObject jsonObject) throws Exception {
		try {
			return jsonObject.toString();
		}
		catch (Exception e) {
			throw new Exception("JSON Exception.");
		}
	}

	/***
	 * 将对象转换为JSON对象数组
	 * 
	 * @param text
	 * @return
	 */
	public static JSONArray toJSONArray(String text) throws Exception {
		try {
			return JSONArray.parseArray(text);
		} catch (Exception e) {
            throw new Exception("JSON Exception.");
		}
	}

	/***
	 * 将对象转换为JSON对象
	 * 
	 * @param text
	 * @return
	 */
	public static JSONObject toJSONObject(String text) throws Exception {
		try {
			JSONObject obj = JSONObject.parseObject(text);
			return (obj == null) ? new JSONObject() : obj;
		} catch (Exception e) {
            throw new Exception("JSON Exception.");
		}
	}

	/**
	 * 判断一个JSON数组是否为空
	 */
	public static boolean isEmpty(JSONArray array) {
		return (array == null) || (array.size() == 0);
	}

}
