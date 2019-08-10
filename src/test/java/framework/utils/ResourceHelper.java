package framework.utils;

import java.io.InputStream;

public class ResourceHelper {
    public static String getAbsolutePathToResource(Class callingClass, String relativePathInResourceFolder) {
        return callingClass.getClassLoader().getResource(relativePathInResourceFolder).getPath();
    }

    public static InputStream getResourceAsStream(Class callingClass, String relativePathInResourceFolder) {
        return callingClass.getClassLoader().getResourceAsStream(relativePathInResourceFolder);
    }
}
