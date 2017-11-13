import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**メインクラス
 * ファイルの一覧データを生成し、ファイルに書き出すプログラム。
 * 動作は以下の通りである。
 * <ol>
 * 	<li>キーボードから「一覧を生成するディレクトリ名」と「出力ファイル名」を入力する。</li>
 * 	<li>一覧は指定したディレクトリ名をルートとする木構造を幅優先の順序で探索し、
 * 	Java のソースコードファイルのみファイル情報を抽出して、CSV 形式でファイルに出力する</li>
 * </ol>
 *
 * 課題番号 : 課題2
 * 日付 : 2017-11-14
 * @author BP16001 足立賢人
 * @version 1.0
 *
 *
 */
public class CodeProfiler {
	private static final String DEFAULT_FILE_NAME = "output.csv";
	private static final String DEFAULT_FILE_PATH = "./";

	/**メインメソッド
	 * パスとファイル名を指定してCSVファイルを出力する
	 * @param args コマンドライン引数
	 */

	public static void main(String[] args)  {
		String filePath;
		String fileName;
		try {
			filePath = inputString("ファイルパスを入力(default : " + DEFAULT_FILE_PATH + ") : ");
			fileName = inputString("ファイル名を入力(default : " + DEFAULT_FILE_NAME + ") : ");
			if (filePath.equals(""))
				filePath = DEFAULT_FILE_PATH;
			if (fileName.equals(""))
				fileName = DEFAULT_FILE_NAME;
			exportCsv(filePath, fileName);
		} catch (Exception e) {
			System.out.println("例外が発生しました\n"+e);
			return;
		}

		System.out.println(filePath + "に" + fileName + "を出力しました");
	}

	/**指定されたパス名に指定されたファイル名のCSVファイルを出力する。
	 *
	 * @param filePath 出力先パス名
	 * @param fileName 出力ファイル名
	 * @throws IOException 指定したファイルがほかのプログラムによってロックされている場合
	 */
	static void exportCsv(String filePath, String fileName) throws IOException {

		String pathName;
		if (filePath.endsWith("/")) {
			pathName = filePath + fileName;
		} else {
			pathName = filePath + "/" + fileName;
		}

		File exportFile = new File(pathName);
		FileWriter writer = new FileWriter(exportFile);

		ArrayList<File> fileList;
		fileList = BreadthFirstSearch.searchFile("java", new File(filePath));
		for (File file : fileList) {
			JavaReader reader = new JavaReader(file);
			for (String className : reader.classNameList) {
				writer.write(reader.getAbsolutePath() + "," + reader.getName()
						+ "," + reader.getLineNumber() + ",Class," + className
						+ "\n");
			}
			for (String classNameImported : reader.classNameListImported) {
				writer.write(reader.getAbsolutePath() + "," + reader.getName()
						+ "," + reader.getLineNumber() + ",Import,"
						+ classNameImported + "\n");
			}
			for (String packageName : reader.packageNameList) {
				writer.write(reader.getAbsolutePath() + "," + reader.getName()
						+ "," + reader.getLineNumber() + ",Package,"
						+ packageName + "\n");
			}

		}

		writer.close();
	}

	/**入力ストリームへの入力をサポートする。
	 * @param message 出力メッセージ
	 * @return 入力ストリームへの入力
	 * @throws IOException BufferedReader.readLine
	 */
	static String inputString(String message) throws IOException {
		System.out.println(message);
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		return input.readLine();
	}
}
