import java.io.File;
public class FileTest{
    public static void main(String[] args){
        File dir = new File("../resource");
        /* 文字列として取得 */
        String[] dirlist = dir.list();
        /* File オブジェクトとして取得 */
        File[] dirFilelist = dir.listFiles();
        /* 取得した文字列データを画面出力 */
        for(int i =0; i < dirlist.length; i++){
            System.out.println(dirlist[i]);
        }
        System.out.println("-------------------");
        /* 取得した File オブジェクトデータを画面出力 */
        for(int i =0; i < dirFilelist.length; i++){
            System.out.println(dirFilelist[i].getName());
        }
    }
}
