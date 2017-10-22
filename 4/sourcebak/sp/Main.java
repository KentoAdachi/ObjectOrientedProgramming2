/*
オブジェクト指向プログラミングII
第3回課題
10/17(火)作成
BP16096 森勇輝
*/


import java.util.Queue;
import java.util.ArrayDeque;
import java.io.File;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException{
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("探索したいディレクトリ名を入力して下さい");
	String root = new String(in.readLine());
	File dir = new File(root);
	System.out.println("出力するファイル名を入力して下さい");
	String output = new String(in.readLine());
	File log = new File(output);
	Queue<File> queue = new ArrayDeque<File>();
	queue.add(dir);
	try {
	    FileWriter fw = new FileWriter(log);
	    while((dir = queue.poll()) != null){
		File dirlist[] = dir.listFiles();
		fw.write("Directory : "+dir.getName()+"\n");
		System.out.println("Directory : "+dir.getName());
		for (File f :dirlist ) {
		    if (f.isDirectory()) {
			fw.write("            "+f.getName()+" はディレクトリです。\n");
			System.out.println("            "+f.getName()+" はディレクトリです。");
			queue.add(f);
		    }else{
			fw.write("            "+f.getName()+"\n");
			System.out.println("            "+f.getName());
		    }
		}
	    }
	    fw.close();
	}catch (Exception e) {
	}
    }
}