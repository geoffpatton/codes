/**
 * Created by tua26762 on 6/16/2015.
 */
public class FilenameDemo {

    public static void main(String[] args) {
        final String FPATH = "/home/user/index.jsp";

        FileName website = new FileName(FPATH, '/', '.');

        //print the following

        System.out.println(website.extension());

        System.out.println(website.nameOfFile());

        System.out.println(website.pathFinder());


        //path
    }

}
