package utils;

import java.io.FileNotFoundException;
import java.util.List;

public interface ReadFile<E> {
	public List<E> getList(String filename) throws FileNotFoundException;
}
