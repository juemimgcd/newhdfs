package contact;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import org.apache.hadoop.io.compress.GzipCodec;

import java.io.IOException;

public class hadoop_zip {
    public static void main(String[] args) throws Exception {
        System.setProperty("HADOOP_USER_NAME", "root");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:8020");
        try (FileSystem fs = FileSystem.get(conf)) {
            GzipCodec gc = new GzipCodec();
            gc.setConf(conf);
            try (FSDataInputStream fsin = fs.open(new Path("/words.txt"));
                 CompressionOutputStream out = gc.createOutputStream(fs.create(new Path("/data/words.gz")));) {
                IOUtils.copyBytes(fsin, out, conf);
                out.finish();
                System.out.println("the work of gzip is over");
            }


        }
    }


}



