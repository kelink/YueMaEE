package com.gdufs.gd.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.catalina.User;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.junit.Before;

public class JacksonUtil {

	public JacksonUtil() {
		super();
	}

	private JsonGenerator jsonGenerator = null;
	private ObjectMapper objectMapper = null;

	/**
	 * 創建objectMapper，實例化objectMapper
	 */
	public void init() {
		objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					System.out, JsonEncoding.UTF8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 銷毀jsonGenerator
	 */
	public void destory() {
		try {
			if (jsonGenerator != null) {
				jsonGenerator.flush();
			}
			if (!jsonGenerator.isClosed()) {
				jsonGenerator.close();
			}
			jsonGenerator = null;
			objectMapper = null;
			System.gc();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将java对象转换成json字符串
	 */
	public static String writeEntity2JSON(Object obj) {
		String jsonStr = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonStr = objectMapper.writeValueAsString(obj);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonStr;
	}

	/**
	 * 将json字符串转换成JavaBean对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readJson2Entity(String jsonStr, Class<T> clazz) {
		ObjectMapper objectMapper = new ObjectMapper();
		Object object = null;
		try {
			object = objectMapper.readValue(jsonStr, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) object;

	}

	/**
	 * json 字符串轉化為對應的類型 获取泛型的Collection Type
	 * 
	 * @param jsonStr
	 *            json字符串
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类型
	 */
	public static <T> T readJson(String jsonStr, Class<?> collectionClass,
			Class<?>... elementClasses) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JavaType javaType = mapper.getTypeFactory().constructParametricType(
				collectionClass, elementClasses);
		return mapper.readValue(jsonStr, javaType);

	}

	// public static void main(String[] args) {
	//
	// HashMap<String, ArrayList<String>> temp = new HashMap<String,
	// ArrayList<String>>();
	// ArrayList<String> arrayList = new ArrayList<String>();
	// arrayList.add("1");
	// arrayList.add("2");
	// arrayList.add("3");
	//
	// ArrayList<String> arrayList1 = new ArrayList<String>();
	// arrayList1.add("1");
	// arrayList1.add("2");
	//
	// temp.put("first", arrayList);
	// temp.put("second", arrayList1);
	// System.out.println(writeEntity2JSON(1));
	// System.out.println(writeEntity2JSON(new Date()));
	// System.out.println(writeEntity2JSON(arrayList1));
	//
	// // String jsonString =
	// // "{\"second\":[\"1\",\"2\"],\"first\":[\"1\",\"2\",\"3\"]}";
	// String jsonString = "[\"1\",\"2\"]";
	// try {
	// List<?> aList = readJson(jsonString, List.class, String.class);
	// System.out.println(aList.toString());
	//
	// System.out.println((arrayList1));
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	// /**
	// * <b>function:</b>json字符串转换成list<map>
	// *
	// * @author hoojo
	// * @createDate 2010-11-23 下午06:12:01
	// */
	// @Test
	// public static <T> T readJson2List(String jsonStr, Class<T> clazz) {
	// ObjectMapper objectMapper = new ObjectMapper();
	// try {
	// List<LinkedHashMap<String, Object>> list = objectMapper.readValue(
	// jsonStr, List.class);
	// for (int i = 0; i < list.size(); i++) {
	// Map<String, Object> map = list.get(i);
	// Set<String> set = map.keySet();
	// for (Iterator<String> it = set.iterator(); it.hasNext();) {
	// String key = it.next();
	// System.out.println(key + ":" + map.get(key));
	// }
	// }
	// } catch (JsonParseException e) {
	// e.printStackTrace();
	// } catch (JsonMappingException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * <b>function:</b>json字符串转换成Array
	// *
	// * @author hoojo
	// * @createDate 2010-11-23 下午06:14:01
	// */
	// @Test
	// public void readJson2Array() {
	// String json =
	// "[{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"
	// +
	// "{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}]";
	// try {
	// AccountBean[] arr = objectMapper.readValue(json,
	// AccountBean[].class);
	// System.out.println(arr.length);
	// for (int i = 0; i < arr.length; i++) {
	// System.out.println(arr[i]);
	// }
	//
	// } catch (JsonParseException e) {
	// e.printStackTrace();
	// } catch (JsonMappingException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// @Test
	// public void readJson2Map() {
	// String json =
	// "{\"success\":true,\"A\":{\"address\": \"address2\",\"name\":\"haha2\",\"id\":2,\"email\":\"email2\"},"
	// +
	// "\"B\":{\"address\":\"address\",\"name\":\"haha\",\"id\":1,\"email\":\"email\"}}";
	// try {
	// Map<String, Map<String, Object>> maps = objectMapper.readValue(
	// json, Map.class);
	// System.out.println(maps.size());
	// Set<String> key = maps.keySet();
	// Iterator<String> iter = key.iterator();
	// while (iter.hasNext()) {
	// String field = iter.next();
	// System.out.println(field + ":" + maps.get(field));
	// }
	// } catch (JsonParseException e) {
	// e.printStackTrace();
	// } catch (JsonMappingException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

}
