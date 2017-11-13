import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CodeProfiler {

	public static void main(String[] args) throws IOException {
		String filePath = inputString("ファイルパスを入力 : ");
		String fileName = inputString("ファイル名を入力 : ");
		exportCsv(filePath, fileName);
	}

	static void exportCsv(String filePath, String fileName) throws IOException {
		String pathName = filePath + fileName;
		File exportFile = new File(pathName);
		FileWriter writer = new FileWriter(exportFile);

		ArrayList<File> fileList;
		fileList = BreadthFirstSearch.searchFile("java", new File(filePath));
		for (File file : fileList) {
			JavaReader reader = new JavaReader(file);
			for (String className : reader.classNameList) {
				writer.write(reader.getAbsolutePath() + "," + reader.getName()
						+ "," + reader.getLineNumber() + ",Class," + className
						+ "\n");
			}
			for (String classNameImported : reader.classNameListImported) {
				writer.write(reader.getAbsolutePath() + "," + reader.getName()
						+ "," + reader.getLineNumber() + ",Import,"
						+ classNameImported + "\n");
			}
			for (String packageName : reader.packageNameList) {
				writer.write(reader.getAbsolutePath() + "," + reader.getName()
						+ "," + reader.getLineNumber() + ",Package,"
						+ packageName + "\n");
			}

		}

		writer.close();
	}

	static String inputString(String message) throws IOException {
		System.out.println(message);
		BufferedReader input = new BufferedReader(
				new InputStreamReader(System.in));
		return input.readLine();
	}
}
