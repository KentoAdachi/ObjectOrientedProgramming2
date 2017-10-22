import java.io.File;
import java.util.Date;

public class BreadthFirstSearchCsv extends BreadthFirstSearchTxt {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		BreadthFirstSearchCsv s = new BreadthFirstSearchCsv();
		s.makeFile(s, args);
	}

	@Override
	public String getCurrentDirInfo(File f) {
		// TODO 自動生成されたメソッド・スタブ
		 return "D,"+f.getName()+","+f.listFiles().length+"\n";
	}

	@Override
	public String getChildDirInfo(File f) {
		// TODO 自動生成されたメソッド・スタブ
		 return "D,"+f.getName()+","+f.listFiles().length+"\n";
	}

	@Override
	public String getChildFileInfo(File f) {
		// TODO 自動生成されたメソッド・スタブ
		return "F,"+f.getName()+","+f.getAbsolutePath()+","+f.length()+","+new Date(f.lastModified())+"\n";
	}

}
