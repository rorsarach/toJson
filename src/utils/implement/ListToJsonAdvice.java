package utils.implement;

import java.util.List;

import bean.Advice;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import utils.ListToJson;

public class ListToJsonAdvice implements ListToJson{

	public JSONArray getJson(List<Advice> list) {
		// TODO Auto-generated method stub
        JSONArray json = JSONArray.fromObject(list);  
        JSONArray jsonArray = new JSONArray();
        for(Advice advice : list){
        	JSONObject jsonObject = new  JSONObject();
        	jsonObject.put("disease",advice.getDisease());
        	jsonObject.put("information",advice.getInformation());
        	jsonObject.put("clinic",advice.getClinic());
        	jsonObject.put("advice",advice.getAdvice());
        	jsonObject.put("alias",advice.getAlias());

        	jsonArray.add(jsonObject);
        }
        return jsonArray;
	}



}
