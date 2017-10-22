import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstSearchTxt implements BreadthFirstSearch{

	static final String OutOfBoundsMessage = "[usage] 変数1=出力先パス 変数2=出力ファイル名\n[example] java BreadthFirstSearchTxt(Csv) ../../ test.txt(or test.csv)";
	static final String IOMessage = "ファイルの処理が正常に終了しませんでした";
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		BreadthFirstSearchTxt s = new BreadthFirstSearchTxt();
		try {
		s.makeFile(s,args);
		}catch(ArrayIndexOutOfBoundsException e){
        	System.out.println(OutOfBoundsMessage);
		}
	}

	@Override
	public String getCurrentDirInfo(File f) {
		// TODO 自動生成されたメソッド・スタブ
		return "Directory : "+f.getName()+"\n";
	}

	@Override
	public String getChildDirInfo(File f) {
		// TODO 自動生成されたメソッド・スタブ
        return "            "+f.getName()+"はディレクトリ\n";
	}

	@Override
	public String getChildFileInfo(File f) {
		// TODO 自動生成されたメソッド・スタブ
		return "            "+f.getName()+"\n";
	}

	void makeFile(BreadthFirstSearch s,String[] args) {
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

                //get current dir info
                File dirlist[] = dir.listFiles();
                fw.write(getCurrentDirInfo(dir));

                //get dir info


                for (File f :dirlist ) {
                    if (f.isDirectory()) {
                        fw.write(getChildDirInfo(f));
                        //push dir found
                        queue.add(f);
                    }else{
                         fw.write(getChildFileInfo(f));
                    }
                }
            }
            fw.close();
            System.out.println("ファイルを出力しました");
        }catch (ArrayIndexOutOfBoundsException e) {
        	System.out.println(OutOfBoundsMessage);
        }catch(IOException e) {
        	System.out.println(IOMessage);
        }finally {
        	System.out.println("終了します");
        }
	}
}
