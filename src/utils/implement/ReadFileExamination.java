package utils.implement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import bean.Advice;
import bean.Examination;
import utils.ReadFile;

public class ReadFileExamination implements ReadFile{

	@Override
	public List<Examination> getList(String filename) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Examination> list = new ArrayList<Examination>();
	    BufferedReader bf= new BufferedReader(new FileReader(filename));
		return list;
	}

}
