import java.io.File;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Date;
import java.io.*;
class Main {

//さすがにでかいのでやることをまとめる
/*
現在,課題１のソースを課題３に対応した形式に書き換えている
疑問点は,捜査して初めてわかるディレクトリ数をどうして得ているのか
->f<dir>.listFiles().lengthとでもしていると予想<-解決
タイムスタンプの戻り値を適切な形式に変換する<-解決
ファイルへの書き出し処理を行う


*/

    public static void main(String[] args) {



        //get root dir
        File dir = new File("../resource");//あとで書き換える
        Queue<File> queue = new ArrayDeque<File>();
        queue.add(dir);

        try {
            //prepare writting
            String filename = "hello.txt";//あとで書き換える
            File log = new File(filename);
            FileWriter fw = new FileWriter(log);


            //loop from here
            //pop queue
            while((dir = queue.poll()) != null){
                //get current dir name
                // fw.write("Directory : "+dir.getName()+"\n");
                System.out.println("Directory : "+dir.getName());


                //get dir info

                File dirlist[] = dir.listFiles();

                System.out.println("             "+dirlist.length);
                for (File f :dirlist ) {
                    if (f.isDirectory()) {
                        // fw.write("            "+f.getName()+"はディレクトリ\n");
                        System.out.println("            "+f.getName()+"はディレクトリ");
                        //
                        System.out.println("                "+f.listFiles().length);

                        //push found dir
                        queue.add(f);
                    }else{
                        // fw.write("            "+f.getName()+"\n");

                        //ファイル名
                        System.out.println("            "+f.getName());
                        //絶対パス
                        System.out.println("                "+f.getAbsolutePath());
                        //サイズ
                        System.out.println("                "+f.length());
                        //タイムスタンプ
                        System.out.println("                "+new Date(f.lastModified()));
                    }
                }

            }

            fw.close();
        }catch (Exception e) {

        }


        //break if queue empty

        //done




    }

}
