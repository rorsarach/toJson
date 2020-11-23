package utils;

import java.io.IOException;
import java.util.List;


public interface GetList<E> {
	public List<E> getList(String filename) throws IOException;
}
