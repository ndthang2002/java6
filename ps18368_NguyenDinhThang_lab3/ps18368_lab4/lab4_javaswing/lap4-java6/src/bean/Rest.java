/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;
import javafx.scene.paint.Color;
/**
 *
 * @author dinh thang
 */

public class Rest {
    
    
      private static ObjectMapper mapper = new ObjectMapper();
    //lấy dữ liệu từ firebase
    private static JsonNode request(String method,String path,Object data){
        try {
            String uri ="https://poly-java-6-13436-default-rtdb.firebaseio.com"+path+".json";
            URL url =new URL(uri);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Accept", "application/json");  
            conn.setRequestMethod(method);
            if (method.equalsIgnoreCase("POST")|| method.equalsIgnoreCase("PUT")) {
                conn.setDoOutput(true);
                mapper.writeValue(conn.getOutputStream(),data);
            }
            int responseCode = conn.getResponseCode();
            if(responseCode==200){
                return mapper.readTree(conn.getInputStream());
            }
            conn.disconnect();
            return null;
        }catch (Exception e) {
            throw  new RuntimeException(e);            
        }
    }

    //thêm sữ liệu 
    public static JsonNode post(String path ,Object data){
        return request("POST",path,data);
    }
    public static JsonNode put(String path, Object data){
        return request("PUT",path,data);
    }
    public static void delete(String path){
        request("DELETE", path, null);
    }
    public static JsonNode get(String path){
        return request("GET", path, null);      
                
    }
    
}
