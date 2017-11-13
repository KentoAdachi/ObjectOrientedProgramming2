import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Symple note for myself
 *
 * Java�t�@�C���̕��@�\���𖾂炩�ɂ���
 * �֐����Ƃɏ���������ꊇ�ŏ����������������ł�
 * matcher�g���Ă݂�̂����U�@�ł�
 * �����̋�؂�����s�łȂ��Z�~�R�����ɂ��������悢�̂ł�
 * lineNumberReader���g���Ă݂Ă�
 * �����Ǝv���Ă��񂾂��Ǔ������炵���A�N�Z�X���Ȃ�getter/setter����public�ł���K�v�����
 * Statement�N���X������Ď����Ŕ��f���Ă��炤�̖ʔ���?
 * @author bp16001
 *
 */
public class JavaReader {

	File file;
	FileReader fileReader;
	LineNumberReader lineNumberReader;
	ArrayList<String> classNameList;
	ArrayList<String> classNameListImported;
	ArrayList<String> packageNameList;

	JavaReader(File file) throws IOException {
		setFile(file);
		setFileReader(new FileReader(file));
		setLineNumberReader(new LineNumberReader(fileReader));
		setClassNameList(new ArrayList<String>());
		setClassNameListImported(new ArrayList<String>());
		setPackageNameList(new ArrayList<String>());
		analyze();
	}

	void analyze() throws IOException {
		String statement;
		while((statement = readStatement()) != null) {
			classifyStatement(statement);
		}

	}

	//set field
	void classifyStatement(String statement) {
		//�p�^�[����`
		//�r�����s�Ƃ�"class"���܂ޕ�����ɑΉ����邽�߂ɐ��K�\�����g�����������̂ł�
		//�܂��R�����g�A�E�g�����錾��z�肵�ĂȂ����ǃl
		String classNameReg = "class\\s+([a-zA-Z0-9]+)";
		String classNameImportedReg = "import\\s+([a-zA-Z0-9\\.]+)";
		String packageNameListReg = "package\\s+([a-zA-Z0-9]+)";

		matchPatternAddList(classNameReg, statement, getClassNameList());
		matchPatternAddList(classNameImportedReg, statement, getClassNameListImported());
		matchPatternAddList(packageNameListReg, statement, getPackageNameList());

	}

	void matchPatternAddList(String regex,String input,ArrayList<String> list ) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
//			System.out.println("Name : " + matcher.group(1));
			list.add(matcher.group(1));
		}
	}

	public void close() throws IOException {
		//����ɂ���fileReader��lineNumberReader�����ɕ��Ă���Ă�Ƃ�
		lineNumberReader.close();
		//		fileReader.close();
	}

	//�v���O����1��(�Z�~�R������؂�)��ǂݍ���
	//�z�肳���߂�l : "[�R�����g][�A�N�Z�X�C���q][class��package,import�錾��];"
	//����炪���s��󔒕����ŋ�؂��Ă���
	String readStatement() throws IOException {

		//		���̋󔒕����𖳎����ēǂݍ���
		//		�ǂݍ��񂾂��̂����߂�
		int c;
		StringBuilder stringBuilder = new StringBuilder();

		//�ŏ��̋󔒂␅���^�u,�R�����g������������(���K��)

		while ((c = lineNumberReader.read()) != -1) {
			//System.out.print((char)c);

			stringBuilder.append((char) c);

			if ((char) c == ';' || (char) c == '{' || (char) c == '}') {
				return stringBuilder.toString();
			}

		}

		return null;

	}

	/*---------------*
	 * getter/setter *
	 *---------------*/

	//�t�@�C���̐�΃p�X
	//getAbsolutePath()
	String getAbsolutePath() {
		return file.getAbsolutePath();
	}

	//�t�@�C����
	//getName()
	String getName() {
		return file.getName();
	}

	//����������������

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileReader getFileReader() {
		return fileReader;
	}

	public void setFileReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public LineNumberReader getLineNumberReader() {
		return lineNumberReader;
	}

	public void setLineNumberReader(LineNumberReader lineNumberReader) {
		this.lineNumberReader = lineNumberReader;
	}

	public ArrayList<String> getClassNameList() {
		return classNameList;
	}

	//�t�@�C���Ɋ܂܂��N���X��(�������邩������Ȃ�)
	//"class"�̏o������
	public void setClassNameList(ArrayList<String> classNameList) {
		this.classNameList = classNameList;
	}

	//�t�@�C���Ɋ܂܂��import�N���X��
	//"import"�̏o������
	public ArrayList<String> getClassNameListImported() {
		return classNameListImported;
	}

	public void setClassNameListImported(ArrayList<String> classNameListImported) {
		this.classNameListImported = classNameListImported;
	}

	//�t�@�C���Ɋ܂܂��p�b�P�[�W�錾
	//"package"�̏o������
	//�o���������܂ލs
	public ArrayList<String> getPackageNameList() {
		return packageNameList;
	}

	public void setPackageNameList(ArrayList<String> packageNameList) {
		this.packageNameList = packageNameList;
	}

	//�t�@�C���̍s��
	//"\n"�̏o����
	//readLine�̎��s��
	int getLineNumber() {
		return getLineNumberReader().getLineNumber();
	}


	//�������������܂�
}
