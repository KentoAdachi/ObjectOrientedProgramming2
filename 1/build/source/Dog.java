/**
 * 犬クラス
 *
*/
class Dog{
 String name;
 String classification;
 int age;
 String position;
/**
 * 名前、犬種、年齢を与えて犬オブジェクトを生成する。
 * 姿勢の初期値は「立っている」である。
 * @param 名前 犬種 年齢
 * @exception none
*/
 Dog (String n, String c, int a){
 this.name = n;
 this.classification = c;
 this.age = a;
 this.position = "立っている";
 }
/**
 * 姿勢の値を「座っている」に変更するメソッドである。
 * @param none
 * @exception none
*/
 void sit(){
 System.out.println(this.name + ", Sit!");
 this.position = "座っている";
 System.out.println(this.name + "は" + this.position);
 }
/**
 * 姿勢の値を「伏せている」に変更するメソッドである。
 * @param none
 * @exception none
*/
 void down(){
 System.out.println(this.name + ", Down!");
 this.position = "伏せている";
 System.out.println(this.name + "は" + this.position);
 }
}
