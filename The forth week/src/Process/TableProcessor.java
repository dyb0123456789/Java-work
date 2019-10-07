package Process;
import java.io.File;
import java.util.List;



public class TableProcessor {

	public String process(String url)throws Exception{
		List<File> classFiles = Scanner.getClassFiles(url);
		StringBuilder sql = new StringBuilder();
		for(File file:classFiles) {
			Class<?>clazz = ClassFileLoader.LoadClass(file);
			TableInfo table = TableInfo.parse(clazz);
			if(table!=null)
				sql.append(table.toString());
		}
		return sql.toString();
		}
}