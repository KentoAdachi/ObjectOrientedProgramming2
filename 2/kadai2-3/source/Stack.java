
/**
 * スタック・クラス
 *  <PRE>
 *  後入れ先出しのデータ構造
 *  主な操作はつぎの２つ
 *  </PRE>
 *  <OL>
 *   <LI> void push(Object element)
 *   <LI> Object pop()
 *  </OL>
 *  @author 足立 賢人 BP16001
 *  @author Matsuura Saeko
 *  @version 1.0
 *
 */


public class Stack {

	/**
	 *  スタックそのものをObjectの配列で定義する。
	 *
	 *
	 */
	private Object[] stack;

	/**
	 *  スタックの大きさ
	 *
	 *
	 */
	private int size;

	/**
	 *  スタックに要素が入っている最上位の位置
	 *
	 */
	private int top;

	/**
	 *  スタックの大きさを指定してスタックを生成する。<BR>
	 *  はじめは空である。
	 *
	 */
	Stack(int size) {
		this.size = size;
		stack = new Object[size];
		top = -1;
	}

	/**
	 *  スタックに要素を入れる。
	 *  @param element 要素
	 *  @return なし
	 *  @exception none
	 *
	 */
	public void push(Object element) {

		if (isFull() == false) {
			stack[++top] = element;
		}
	}

	/**
	 *  スタックから最上位の位置にある要素を取り出す。
	 *  @return 最上位の要素要素
	 *  @exception none
	 *
	 * isEmpty()を参照する
	 */
	public Object pop() {
		return isEmpty()? null : stack[top--];
	}

	/**
	 *  スタックの最上位位置の要素：スタックの状態は変わらない。
	 *  @return 最上位の要素要素
	 *  @exception none
	 *
	 */
	public Object top() {
		return stack[top];
	}

	/**
	 *  スタックが空であるかを判定する。
	 *  @return 空であればtrue、空でなければfalse
	 *  @exception none
	 *
	 */
	boolean isEmpty() {

		return top == -1 ?true :false;
	}

	/**
	 *  スタックが満杯であるかを判定する。
	 *  @return 満杯であればtrue、満杯でなければfalse
	 *  @exception none
	 *
	 */
	boolean isFull() {

		return top == size-1? true : false;
	}

	/**
	 *  スタックの内容を標準出力に出力する。
	 *  @return なし
	 *  @exception none
	 *
	 *  呼ばれない
	 */
	void show() {
		for (int i = 0;i < size;i++) {
			System.out.println("stack["+i+"] = "+stack[i]);
		}
	}
	/**
	 *  スタックの文字列化。
	 *  @return スタックの内容をtopからbottomまで表示する
	 *  @exception none
	 *
	 */
	public String toString() {
		String ret = "";
		for (int i = 0;i <= top;i++) {
			ret +="stack"+"["+i+"] = "+stack[i]+"\n";
		}
		return ret;
	}

}
