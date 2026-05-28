package contact;

import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.Iterator;

public class hdfs_file {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\idea_project\\newhdfs\\hdfs_contcat\\src\\file.txt");
        //Writer fw =new FileWriter(f);
        if (f.exists()) {
            Reader fr = new FileReader(f);
            System.out.println("文件已存在，无法创建");
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } else {
            Writer fw= new FileWriter(f);
            f.createNewFile();
            fw.write("hello content");
            fw.close();
        }
    }
}


