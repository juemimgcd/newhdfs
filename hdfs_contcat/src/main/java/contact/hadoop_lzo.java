package contact;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.io.compress.Lz4Codec;
import org.apache.hadoop.io.compress.SnappyCodec;

import java.io.IOException;

public class hadoop_lzo {
    public static void main(String[] args) throws IOException {
        System.setProperty("HADOOP_USER_NAME", "root");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:8020");
        try (FileSystem fs = FileSystem.get(conf)) {
            Lz4Codec lc = new Lz4Codec();
                    lc.setConf(conf);

            try (FSDataInputStream fsin = fs.open(new Path("/words.txt"));
                 CompressionOutputStream out = lc.createOutputStream(fs.create(new Path("/data/words.lz4")));) {
                IOUtils.copyBytes(fsin, out, conf);
                System.out.println("the work of lz4 is over");
            }


        }
    }
}
