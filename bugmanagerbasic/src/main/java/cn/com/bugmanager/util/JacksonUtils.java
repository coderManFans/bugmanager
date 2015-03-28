package cn.com.bugmanager.util;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

import java.util.List;
/**
 * Created by fcs on 2015/3/24.
 *
 * jackson序列化和反序列化的工具类
 */
public class JacksonUtils {
    public static JsonGenerator  jsonGenerator = null;
    public  static ObjectMapper  objectMapper = null;

    public static Object obj;


    public JacksonUtils(){}
    /**
     * 初始化jackson 对象，传入Object对象，进行json转化
     * @param object
     */
    public JacksonUtils(Object  object){
        objectMapper = new ObjectMapper();
        try{
            jsonGenerator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
        }catch (IOException e){
            e.printStackTrace();;
        }
    }

    public static void  entityToJson(Object  obj){
        try {
            jsonGenerator.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String  entityToJsonByObjectMapper(Object obj){
        String jsonStr = null;
        try {
             jsonStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }


    /**
     * java map集合对象转换为Jackson，序列化
     * @param objectMap
     * @return
     */
    public static String mapToJson(Map<String,Object> objectMap){
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(objectMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }


    /**
     * java list集合对象转换成json对象
     * @param list
     * @return
     */
    public static String listToJson(List<Object> list){
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }

    /**
     * json 转化java对象【json反序列化】
     * @param jsonStr
     * @param object
     * @return
     */
    public static Object jsonStrToEntity(String jsonStr,Object  object){
        Object obj = null;
        try {
            Object ojb = objectMapper.readValue(jsonStr,object.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }




    /**
     * 关闭jackson 流，进行垃圾回收
     */
    public static void destory(){
        try {
            if(jsonGenerator != null){
                jsonGenerator.flush();
            }
            if(!jsonGenerator.isClosed() ){
                jsonGenerator.close();;
            }
            jsonGenerator = null;
            objectMapper = null;
            obj = null;
            System.gc();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    
}
