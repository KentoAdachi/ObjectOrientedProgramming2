import java.io.File;
import java.util.Date;

/**
 * 幅優先探索によって指定ディレクトリ以下の階層構造をファイルに出力する
 * 出力形式はcsv
 * 出力先は指定ディレクトリ
 * @author BP16001 足立 賢人
 *
 */
public class BreadthFirstSearchCsv extends BreadthFirstSearchTxt {

	/**
	 * 幅優先探索によって指定ディレクトリ以下の階層構造をファイルに出力する
	 * 出力形式はcsv
	 * @param args コマンドライン引数
	 */
	public static void main(String[] args) {
		BreadthFirstSearchCsv s = new BreadthFirstSearchCsv();
		s.makeFile(s, args);
	}

	@Override
	public String getCurrentDirInfo(File f) {
		 return "D,"+f.getName()+","+f.listFiles().length+"\n";
	}

	@Override
	public String getChildDirInfo(File f) {
		 return "D,"+f.getName()+","+f.listFiles().length+"\n";
	}

	@Override
	public String getChildFileInfo(File f) {
		return "F,"+f.getName()+","+f.getAbsolutePath()+","+f.length()+","+new Date(f.lastModified())+"\n";
	}

}
