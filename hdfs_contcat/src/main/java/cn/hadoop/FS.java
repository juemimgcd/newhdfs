package cn.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

public class FS {
    public static void main(String[] args) throws Exception {
        Path p = new Path("/cnm/words.txt");
        System.setProperty("HADOOP_USER_NAME","root");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://master:8020");
        FileSystem fs =FileSystem.get(conf);

        //普通写入数据FSDataOutputStream
        FSDataOutputStream fsOut = fs.create(p);

            fsOut.writeUTF("dajlakhjfdehq");
            fsOut.close();
            fs.close();


        FSDataInputStream fsIn = fs.open(p);
        System.out.println(fsIn.readUTF());



    }
}
