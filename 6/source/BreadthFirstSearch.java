import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * ディレクトリの幅優先探索をサポートするユーティリティクラス。
 *
 * 課題番号 : 課題2
 * 日付 : 2017-11-14
 * @author BP16001 足立賢人
 * @version 1.0
 */
public class BreadthFirstSearch {

	/**
	 * 指定文字列を含むファイル名の探索 指定ディレクトリ以下を幅優先探索アルゴリズムに従い再帰的に走査する
	 *
	 * @param name
	 *            指定文字列
	 * @param entryPoint
	 *            指定ディレクトリ
	 * @return 指定文字列を含むファイル名のリスト
	 */
	public static ArrayList<File> searchFile(String name, File entryPoint) {

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
					// 指定した名前で終わるか判定
					if (f.getName().endsWith(name)) {
						fileList.add(f);

					} else {
					}
				}
			}

		}

		return fileList;

	}
}
