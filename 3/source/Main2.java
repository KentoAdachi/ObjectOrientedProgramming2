import java.io.File;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Date;
import java.io.*;
class Main2 {

    //残りやること
    /*
    コード整形
    コメント
    */

    public static void main(String[] args) {



        //get root dir
        File dir = new File(args[0]);
        Queue<File> queue = new ArrayDeque<File>();
        queue.add(dir);

        try {
            //prepare writting

            String filename = args[0]+args[1];
            //args[0]のパス末尾に'/'をつける人とつけない人がいる
            if (args[0].charAt(args[0].length()-1) != '/') {
                filename = args[0]+"/"+args[1];
            }
            File log = new File(filename);
            FileWriter fw = new FileWriter(log);


            //loop from here
            //pop queue
            while((dir = queue.poll()) != null){

                File dirlist[] = dir.listFiles();
                //get current dir name

                // fw.write("Directory : "+dir.getName()+"\n");
                System.out.println("Directory : "+dir.getName());
                fw.write("D,"+dir.getName()+","+dirlist.length+"\n");

                //get dir info

                System.out.println("             "+dirlist.length);
                for (File f :dirlist ) {
                    if (f.isDirectory()) {
                        // fw.write("            "+f.getName()+"はディレクトリ\n");
                        System.out.println("            "+f.getName()+"はディレクトリ");

                        System.out.println("                "+f.listFiles().length);
                        fw.write("D,"+f.getName()+","+f.listFiles().length+"\n");

                        //push found dir
                        queue.add(f);
                    }else{
                        //  fw.write("            "+f.getName()+"\n");

                        //ファイル名
                        System.out.println("            "+f.getName());
                        //絶対パス
                        System.out.println("                "+f.getAbsolutePath());
                        //サイズ
                        System.out.println("                "+f.length());
                        //タイムスタンプ
                        System.out.println("                "+new Date(f.lastModified()));

                        fw.write("F,"+f.getName()+","+f.getAbsolutePath()+","+f.length()+","+new Date(f.lastModified())+"\n");
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
