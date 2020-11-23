package utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteFile {
	public void writefile(String str,String filename) throws IOException {
		  Path path = Paths.get(filename);
		  // 使用newBufferedWriter创建文件并写文件
		  // 这里使用了try-with-resources方法来关闭流，不用手动关闭
		  try (BufferedWriter writer =
		          Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
		  }
		  //追加写模式
		  try (BufferedWriter writer =
		        Files.newBufferedWriter(path,
		            StandardCharsets.UTF_8,
		            StandardOpenOption.APPEND)){
		    writer.write(str);
		  }
		}
}
