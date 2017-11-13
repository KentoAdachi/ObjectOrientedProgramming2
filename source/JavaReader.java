import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/** Javaファイルの文法解析を行うクラス
 * Javaファイルを読み取り,文(statement)の分類を行うための機能をサポートする。
 *
 * 課題番号 : 課題2
 * 日付 : 2017-11-14
 * @author BP16001 足立賢人
 * @version 1.0 コメントアウトした宣言に未対応
 */
public class JavaReader {

	File file;
	FileReader fileReader;
	LineNumberReader lineNumberReader;
	ArrayList<String> classNameList;
	ArrayList<String> classNameListImported;
	ArrayList<String> packageNameList;

	/** 読み込み元のFileを指定して、新規JavaReaderを作成する。
	 *
	 * @param file 読み込み元のファイル
	 * @throws IOException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、または何らかの理由で開くことができない場合。
	 */
	JavaReader(File file) throws IOException {
		setFile(file);
		setFileReader(new FileReader(file));
		setLineNumberReader(new LineNumberReader(fileReader));
		setClassNameList(new ArrayList<String>());
		setClassNameListImported(new ArrayList<String>());
		setPackageNameList(new ArrayList<String>());
		analyze();
	}

	/**ファイルを読み取り、その分類を行う。
	 * @throws IOException readStatement
	 */
	void analyze() throws IOException {
		String statement;
		while ((statement = readStatement()) != null) {
			classifyStatement(statement);
		}

	}

	//set field
	/**正規表現を使い文をクラス宣言、インポート宣言、パッケージ宣言、その他のいずれかに分類し、リストに追加する。
	 * @param statement 文
	 */
	void classifyStatement(String statement) {
		//パターン定義
		//途中改行とか"class"を含む文字列に対応するために正規表現が使いたかったのです
		//まあコメントアウトした宣言を想定してないけどネ
		String classNameReg = "class\\s+([a-zA-Z0-9]+)";
		String classNameImportedReg = "import\\s+([a-zA-Z0-9\\.]+)";
		String packageNameListReg = "package\\s+([a-zA-Z0-9]+)";

		matchPatternAddList(classNameReg, statement, getClassNameList());
		matchPatternAddList(classNameImportedReg, statement, getClassNameListImported());
		matchPatternAddList(packageNameListReg, statement, getPackageNameList());

	}


	/**パターンマッチングを行い、マッチングに成功した入力をリストに追加する
	 * @param regex 正規表現パターン
	 * @param input 入力
	 * @param list 入力先リスト
	 */
	void matchPatternAddList(String regex, String input, ArrayList<String> list) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			//			System.out.println("Name : " + matcher.group(1));
			list.add(matcher.group(1));
		}
	}

	/**javaReaderの終了処理を行う
	 * @throws IOException 正常に終了できなかった場合
	 */
	public void close() throws IOException {
		//fileReaderはlineNumberReaderが既に閉じてくれてるとか
		lineNumberReader.close();
		//		fileReader.close();
	}

	//プログラム1文(セミコロン区切り)を読み込む
	//想定される戻り値 : "[コメント][アクセス修飾子][classやpackage,import宣言部];"
	/**ファイルからプログラム1文を読み込む。
	 * 1文の終端はセミコロン(';')か中括弧('{','}')のいずれかで認識される。
	 * @return プログラム1文
	 * @throws IOException lineNumberReader.read
	 */
	String readStatement() throws IOException {

		//		頭の空白文字を無視して読み込む
		//		読み込んだものをためる
		int c;
		StringBuilder stringBuilder = new StringBuilder();

		//最初の空白や水平タブ,コメントも無視したい(正規化)

		while ((c = lineNumberReader.read()) != -1) {
			//System.out.print((char)c);

			stringBuilder.append((char) c);

			if ((char) c == ';' || (char) c == '{' || (char) c == '}') {
				return stringBuilder.toString();
			}

		}

		return null;

	}

	/*---------------*
	 * getter/setter *
	 *---------------*/

	//ファイルの絶対パス
	//getAbsolutePath()
	String getAbsolutePath() {
		return file.getAbsolutePath();
	}

	//ファイル名
	//getName()
	String getName() {
		return file.getName();
	}

	//自動生成ここから

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileReader getFileReader() {
		return fileReader;
	}

	public void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public LineNumberReader getLineNumberReader() {
		return lineNumberReader;
	}

	public void setLineNumberReader(LineNumberReader lineNumberReader) {
		this.lineNumberReader = lineNumberReader;
	}

	public ArrayList<String> getClassNameList() {
		return classNameList;
	}

	//ファイルに含まれるクラス名(複数あるかもしれない)
	//"class"の出現部分
	public void setClassNameList(ArrayList<String> classNameList) {
		this.classNameList = classNameList;
	}

	//ファイルに含まれるimportクラス名
	//"import"の出現部分
	public ArrayList<String> getClassNameListImported() {
		return classNameListImported;
	}

	public void setClassNameListImported(ArrayList<String> classNameListImported) {
		this.classNameListImported = classNameListImported;
	}

	//ファイルに含まれるパッケージ宣言
	//"package"の出現部分
	//出現部分を含む行
	public ArrayList<String> getPackageNameList() {
		return packageNameList;
	}

	public void setPackageNameList(ArrayList<String> packageNameList) {
		this.packageNameList = packageNameList;
	}

	//ファイルの行数
	//"\n"の出現回数
	//readLineの実行回数
	int getLineNumber() {
		return getLineNumberReader().getLineNumber();
	}

	//自動生成ここまで
}
