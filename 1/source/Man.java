/** 人クラス
 * <PRE>
 * 人が犬を飼う。
 * つぎの２つのメソッドをもつ。
 * </PRE>
 * <OL>
 * <LI> void keep(Dog d)
 * <LI> void train()
 * </OL>
 * @author Matsuura Saeko
 * @version 1.0
 */
class Man{
 String name;
 int age;
 Dog dog;
 Man(String n, int a){
 this.name = n;
 this.age = a;
 }
/**
 * 犬を飼う。
 * @param 犬
 * @exception none
*/
 void keep(Dog d){
 this.dog = d;
 System.out.println(name+"は"+this.dog.classification+"犬の"+this.dog.name+"を飼っています.");
}
/**
 * 犬の訓練をする。
 * @param none
 * @exception none
*/
 void train(){
 System.out.println("訓練を開始します。");
 this.dog.sit();
 this.dog.down();
 System.out.println("訓練が終わりました。");
 }
}
