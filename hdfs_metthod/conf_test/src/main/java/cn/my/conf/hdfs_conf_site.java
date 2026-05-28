package cn.my.conf;
import com.google.common.annotations.VisibleForTesting;
import org.apache.hadoop.conf.Configuration;
import org.junit.Test;

public class hdfs_conf_site {
    //1）创建Configuration的对象，读取并打印属性fs.defaultFS的值，
    // configuration.get(“fs.defaultFs”);
    //2）项目的src下创建core-site.xml文件，设置fs.defaultFS新值
    //获取属性fs.defaultFS的值并打印输出
    //3）程序中设置“fs.defaultFs”的值，并输出值
    //4）读取属性dfs.replication、dfs.blocksize的值，读取并输出值
    //5）Eclipse项目的src下创建hdfs-site.xml文件，设置dfs.replication、dfs.blocksize的值，读取并输出值。
    //idea的项目在module的resources目录下创建文件hdfs-site.xml,设置dfs.replication、dfs.blocksize的值，读取并输出值。
    //6）使用addResourece方法后，再读取并输出值
    @Test
    public void cf_site(){
        Configuration conf = new Configuration();
        //System.out.println(conf.get("fs.defaultFS"));
        //conf.get("fs.defaultFS");
        //System.out.println("设置core—site.xml后输出结果为："+conf.get("fs.defaultFS"));
        //conf.set("defaultFS","hdfs://nowhere:12345");
        //System.out.println("设置“fs.defaultFs”的值后输出结果为："+conf.get("defaultFS"));
        conf.addResource("hdfs-site.xml");
        System.out.println(conf.get("dfs.replication"));
        System.out.println(conf.get("dfs.blocksize"));


    }


}
