import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * 幅優先探索
 * 
 * @author bp16001
 * 
 */
public class BreadthFirstSearch {

	/**
	 * 指定文字列を含むファイル名の探索 指定ディレクトリ以下を再帰的に走査する
	 * 
	 * @param name
	 *            指定文字列
	 * @param entryPoint
	 *            指定ディレクトリ
	 * @return 文字列を含むファイル名のリスト
	 */
	public static ArrayList<File> searchFile(String name, File entryPoint) {
		// 宣言部
		File currentDir = entryPoint;
		// ファイルリスト
		ArrayList<File> fileList = new ArrayList<File>();
		// ディレクトリキュー
		ArrayDeque<File> queue = new ArrayDeque<File>();

		// エントリポイントの設定
		queue.add(entryPoint);

		// カレントディレクトリの設定
		while ((currentDir = queue.poll()) != null) {

			// ディレクトリの子要素に対して
			for (File f : currentDir.listFiles()) {

				if (f.isDirectory()) {
					queue.add(f);

				} else {
					// 指定した名前を含むか判定
					if (f.getName().contains(name)) {
						fileList.add(f);

					} else {
					}
				}
			}

		}

		return fileList;

	}
}
