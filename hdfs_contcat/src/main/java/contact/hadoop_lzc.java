package contact;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.io.compress.CompressionCodecFactory;
import org.apache.hadoop.io.compress.CompressionOutputStream;
import com.hadoop.compression.lzo.LzopCodec;
import org.apache.hadoop.io.compress.Lz4Codec;

import java.io.IOException;

public class hadoop_lzc {
    public static void main(String[] args) throws IOException {
        System.setProperty("HADOOP_USER_NAME", "root");
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://master:8020");
        try (FileSystem fs = FileSystem.get(conf)) {
            //LzopCodec lc = new LzopCodec();
            //lc.setConf(conf);
            CompressionCodecFactory factory = new CompressionCodecFactory(conf);
            BZip2Codec bc = (BZip2Codec) factory.getCodecByClassName(BZip2Codec.class.getName());

            try (FSDataInputStream fsin = fs.open(new Path("/words.txt"));
                 CompressionOutputStream out = bc.createOutputStream(fs.create(new Path("/data/words.lzo")));) {
                IOUtils.copyBytes(fsin, out, conf);
                System.out.println("the work of lzo is over");
            }


        }
    }


    }



