package contact;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;

public class hdfsContact {
    public static void main(String[] args) throws IOException {
        //Configuration conf = null;
        //FileSystem fs = null;
        System.setProperty("HADOOP_USER_NAME", "root");
        Configuration conf = new Configuration(true);
        conf.set("dfs.replication", "2");
        conf.set("dfs.blocksize", "256M");
        conf.set("fs.defaultFS", "hdfs://master:8020");
        FileSystem fs = FileSystem.get(conf);
        fs.copyFromLocalFile(new Path("D:/s2177/zjq.txt"),new Path("/"));
        fs.close();
    }
}
