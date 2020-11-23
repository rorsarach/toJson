package utils.implement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import bean.Advice;
import bean.Examination;
import utils.ReadFile;

public class ReadFileAdvice implements ReadFile{

	@Override
	public List<Advice> getList(String filename) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Advice> list = new ArrayList<Advice>();
	    BufferedReader bf= new BufferedReader(new FileReader(filename));
		return list;
	}
}
