/**
*メインクラス
* @author あだっち
*/

class Main{

    public static void main(String[] args) {
        Man charly = new Man("charly brown",4);
        Dog snoopy = new Dog("snoopy","beagle",3);
        charly.keep(snoopy);
        charly.train();
    }
}
