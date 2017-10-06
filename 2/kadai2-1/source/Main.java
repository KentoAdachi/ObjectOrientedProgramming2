/**
 * メイン・クラス
 *  <PRE>
 *  問題1の解決手順を定義するmainメソッドをもつ
 *  解決手順はつぎのとおりである。
 *  </PRE>
 *  <OL>
 *   <LI> 語をコマンドライン引数として入力する
 *   <LI> 入力された語の数だけ「語を反転し、その結果を画面に表示する」を繰り返す
 *  </OL>
 *  @author Matsuura Saeko
 *  @version 1.0
 *
 */
public class Main {

	public static void main(String[] args) {

        //やること
        //Stackのインスタンスstackを作る
        Stack stack = new Stack();
        //文字列"A"をstackにpushする
		stack.push(1);
        //文字列"B"をstackにpushする
		stack.push("B");
        //stackから要素をpopし、画面に表示する
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	/**
	 *   語を反転するメソッド
	 *
	 *  @param word 語
	 *  @return 語と反転語の組
	 *
	 */
	static String reverse(String word) {
		return null;

	}

}
