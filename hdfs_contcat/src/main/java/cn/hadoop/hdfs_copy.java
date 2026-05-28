package cn.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class hdfs_copy {
    public static void main(String[] args) throws Exception {
        Path p = new Path("/cnm/");
        System.setProperty("HADOOP_USER_NAME","root");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://master:8020");
        FileSystem fs =FileSystem.get(conf);
        FileInputStream fin  = new FileInputStream("D:\\flows.txt");
        FSDataOutputStream fos =fs.append(p);
        IOUtils.copyBytes(fin,fos,1024);
        fos.close();
        fin.close();
        fs.close();
       //fs.copyFromLocalFile(new Path("D:\\flows.txt"),p);
    }
}
