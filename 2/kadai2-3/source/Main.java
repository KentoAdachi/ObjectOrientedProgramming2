
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
 *  @author 足立 賢人 BP16001
 *  @author Matsuura Saeko
 *  @version 1.0
 *
 */
public class Main {

	public static void main(String[] args) {

		for (String str :args ) {
			System.out.println(reverse(str));
		}


	}



	/**
	 *   語を反転するメソッド
	 *
	 *  @param word 語
	 *  @return 語と反転語の組
	 */
	static String reverse(String word) {
		//stackの生成
		int l = word.length();
		Stack stack = new Stack(l);
		//wordを一文字単位でpush
		for (int i = 0;i < l;i++ ) {
			stack.push(word.charAt(i));
		}

		//stackをpopして新たな文字列に追加
		String rev ="";
		for (int i = 0;i < l;i++ ) {
			rev += stack.pop();
		}


		//二つの組をreturn
		return word+"<==>"+rev;
	}

}
