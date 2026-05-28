package contact;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.*;

import java.io.IOException;

public class hadoop_bzip {
    public static void main(String[] args) throws IOException {
        System.setProperty("HADOOP_USER_NAME", "root");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:8020");
        conf.set("io.compression.codecs", BZip2Codec.class.getName()); // 显式注册编解码器

        try (FileSystem fs = FileSystem.get(conf)) {
            CompressionCodecFactory factory = new CompressionCodecFactory(conf);
            BZip2Codec bzip2Codec = (BZip2Codec) factory.getCodecByClassName(BZip2Codec.class.getName());

            Path inputPath = new Path("/words.txt");
            Path outputPath = new Path("/data/words.txt.bz2");

            try (FSDataInputStream in = fs.open(inputPath);
                 CompressionOutputStream out = bzip2Codec.createOutputStream(fs.create(outputPath))) {
                IOUtils.copyBytes(in, out, conf);
                System.out.println("BZip2 压缩完成");
            }
        }
    }
}