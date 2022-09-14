/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import bean.Rest;
import bean.Student;
import bean.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;





/**
 *
 * @author dinh thang
 */
public class StudentDao {
    
    ObjectMapper mapper = new ObjectMapper();
    
    public StudentMap findAll(){
        JsonNode resp= Rest.get("/students");
//        JsonNode resp = giaodien.getFrames()
        return mapper.convertValue(resp,StudentMap.class);
    }
    
    public Student findBykey(String key){
        JsonNode resp = Rest.get("/students/"+ key);
        return mapper.convertValue(resp, Student.class);
    }
    public String create(Student data){
        JsonNode resp = Rest.post("/students",data);
        return resp.get("name").asText();
    }
    public Student update(String key ,Student data){
        JsonNode resp = Rest.put("/students/"+ key,data);
        return mapper.convertValue(resp, Student.class);
    }
    public void delete(String key){
        Rest.delete("/students/"+key);
    }
}
