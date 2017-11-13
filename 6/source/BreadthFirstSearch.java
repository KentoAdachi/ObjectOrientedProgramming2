import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * ���D��T��
 * 
 * @author bp16001
 * 
 */
public class BreadthFirstSearch {

	/**
	 * �w�蕶������܂ރt�@�C�����̒T�� �w��f�B���N�g���ȉ����ċA�I�ɑ�������
	 * 
	 * @param name
	 *            �w�蕶����
	 * @param entryPoint
	 *            �w��f�B���N�g��
	 * @return ��������܂ރt�@�C�����̃��X�g
	 */
	public static ArrayList<File> searchFile(String name, File entryPoint) {
		// �錾��
		File currentDir = entryPoint;
		// �t�@�C�����X�g
		ArrayList<File> fileList = new ArrayList<File>();
		// �f�B���N�g���L���[
		ArrayDeque<File> queue = new ArrayDeque<File>();

		// �G���g���|�C���g�̐ݒ�
		queue.add(entryPoint);

		// �J�����g�f�B���N�g���̐ݒ�
		while ((currentDir = queue.poll()) != null) {

			// �f�B���N�g���̎q�v�f�ɑ΂���
			for (File f : currentDir.listFiles()) {

				if (f.isDirectory()) {
					queue.add(f);

				} else {
					// �w�肵�����O���܂ނ�����
					if (f.getName().contains(name)) {
						fileList.add(f);

					} else {
					}
				}
			}

		}

		return fileList;

	}
}
