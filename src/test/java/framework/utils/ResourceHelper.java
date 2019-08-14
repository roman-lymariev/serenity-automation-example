package framework.utils;

import java.io.InputStream;

public class ResourceHelper {
    public static String getAbsolutePathToResource(String relativePathInResourceFolder) {
        return Thread.currentThread().getContextClassLoader().getResource(relativePathInResourceFolder).getPath();
    }

    public static InputStream getResourceAsStream(String relativePathInResourceFolder) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(relativePathInResourceFolder);
    }
}
