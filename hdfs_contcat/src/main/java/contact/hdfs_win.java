package contact;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class hdfs_win {
    public static void main(String[] args) throws Exception {
        System.setProperty("HADOOP_USER_NAME", "root");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS","hdfs://master:8020");
        conf.set("dfs.client.block.write.replace-datanode-on-failure.enable", "false");
        conf.set("dfs.client.block.write.replace-datanode-on-failure.policy", "NEVER");
        FileSystem fs = FileSystem.get(conf);
        Path p = new Path("/zjq.txt");
        FSDataOutputStream out = fs.append(p);
            for (int i = 0; i < 3; i++) {
                out.writeUTF("这是第" + i + "条数据gg\n");
                out.flush();
                Thread.sleep(2000);
            }
            fs.close();


            }
        }










