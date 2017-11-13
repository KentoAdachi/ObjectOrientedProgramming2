import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CodeProfiler {

	public static void main(String[] args) throws IOException {
		exportCsv("./testdata/", "test.csv");
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
						+ "," + reader.getLineNumber() + ",Class," + className + "\n");
			}
			for (String classNameImported : reader.classNameListImported) {
				writer.write(reader.getAbsolutePath() + "," + reader.getName()
						+ "," + reader.getLineNumber() + ",Import," + classNameImported + "\n");
			}
			for (String packageName : reader.packageNameList) {
				writer.write(reader.getAbsolutePath() + "," + reader.getName()
						+ "," + reader.getLineNumber() + ",Package," + packageName + "\n");
			}

		}

		writer.close();
	}
}
