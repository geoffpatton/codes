/**
 * Created by tua26762 on 6/16/2015.
 */
public class FileName {

    private String fullPath;
    private char pathSeparator,
            extensionSeparator;

    public FileName(String str, char sep, char ext) {

        fullPath = str;
        pathSeparator = sep;
        extensionSeparator = ext;

    }


    public String extension(){
        int period = fullPath.indexOf(extensionSeparator);
        return fullPath.substring(period + 1);
    }

    public String nameOfFile(){
        int slash = fullPath.lastIndexOf(pathSeparator);
        int period = fullPath.indexOf(extensionSeparator);
        return fullPath.substring(slash + 1, period);
    }

    public String pathFinder(){
        int firstSlash = fullPath.indexOf(pathSeparator);
        int lastSlash = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(firstSlash,lastSlash + 1);

    }




}
