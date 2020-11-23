import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bean.Advice;
import net.sf.json.JSONArray;

import utils.WriteFile;
import utils.implement.GetListAdvice;
import utils.implement.ListToJsonAdvice;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "F:\\Others\\tishi.xlsx";
		List<Advice> list = new ArrayList<Advice>();
		GetListAdvice getlistAdvice = new GetListAdvice();
		list = getlistAdvice.getList(filename);
        JSONArray jsonArray = new JSONArray();
        ListToJsonAdvice listToJsonAdvice = new ListToJsonAdvice();
		jsonArray = listToJsonAdvice.getJson(list);
//        System.out.println(jsonArray.toString());
		WriteFile writefile = new WriteFile();
		writefile.writefile(jsonArray.toString(), "F:\\Others\\advice.txt");
	}

}
