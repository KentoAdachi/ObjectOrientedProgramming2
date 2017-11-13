import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Test {
	public static void main(String[] args) throws IOException {


		ArrayList<File> list;
		list = BreadthFirstSearch.searchFile("java", new File("./"));


		for (File file : list) {
			System.out.println(file.getName());
			JavaReader reader = new JavaReader(file);

//			System.out.println(reader.readStatement());
//			System.out.println(reader.readStatement());

//			reader.classifyStatement(reader.readStatement());
//			reader.classifyStatement(reader.readStatement());
//			reader.classifyStatement(reader.readStatement());
//			reader.classifyStatement(reader.readStatement());
//			reader.classifyStatement(reader.readStatement());

			for (String string : reader.getClassNameList()) {
				System.out.println("Class : " +string);
			}
			for (String string : reader.getClassNameListImported()) {
				System.out.println("Import : " +string);
			}
			for (String string : reader.getPackageNameList()) {
				System.out.println("Package : " +string);
			}

			reader.close();
		}

	}
}
