import java.io.File;

public interface BreadthFirstSearch {
	String getCurrentDirInfo(File f);
	String getChildDirInfo(File f);
	String getChildFileInfo(File f);
}
