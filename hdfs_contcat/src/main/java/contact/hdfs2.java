package contact;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.Path;
public class hdfs2 {



        public static void main(String[] args) throws Exception {
            System.setProperty("HADOOP_USER_NAME", "root");
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "hdfs://master:8020");
            conf.set("dfs.client.block.write.replace-datanode-on-failure.enable", "false");
            conf.set("dfs.client.block.write.replace-datanode-on-failure.policy", "NEVER");

            try (FileSystem fs = FileSystem.get(conf)) {
                Path p = new Path("/zjq.txt");

                // 使用追加模式打开文件流
                try (FSDataOutputStream out = fs.append(p)) {
                    for (int i = 0; i < 3; i++) {
                        String content = "这是第" + i + "条数据uu\n"; // 注意末尾的换行符
                        byte[] bytes = content.getBytes("UTF-8");

                        out.write(bytes);    // 直接写入字节数组
                        out.flush();        // 关键：强制刷新缓冲区到HDFS

                        System.out.println("已写入: " + content.trim());

                        Thread.sleep(2000);  // 暂停2秒（修正sleep方法调用）
                    }
                } // 自动关闭out
            } // 自动关闭fs
        }
    }


