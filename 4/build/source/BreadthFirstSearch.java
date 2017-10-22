import java.io.File;

/**
 * 幅優先探索インターフェース
 * @author BP16001 足立 賢人
 *
 */
public interface BreadthFirstSearch {
	/**
	 * 現在位置のディレクトリ情報を返す
	 * @param f 現在位置
	 * @return ディレクトリ情報
	 */
	String getCurrentDirInfo(File f);
	/**
	 * 子ディレクトリの情報を返す
	 * @param f 子ディレクトリ
	 * @return ディレクトリ情報
	 */
	String getChildDirInfo(File f);
	/**
	 * 子ファイルの情報を返す
	 * @param f 子ファイル
	 * @return ディレクトリ情報
	 */
	String getChildFileInfo(File f);
}
