package utils.implement;

import java.util.List;

import bean.Examination;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ListToJsonExamination {
	public JSONArray tijianListToJson(List<Examination> list){
        JSONArray json = JSONArray.fromObject(list);  
        JSONArray jsonArray = new JSONArray();
        for(Examination examination : list){
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put("target",examination.getTarget());
        	jsonObject.put("uplist",examination.getUplist());
        	jsonObject.put("downlist",examination.getDownlist());
        	jsonArray.add(jsonObject);
        }
        return jsonArray;
	}
}
