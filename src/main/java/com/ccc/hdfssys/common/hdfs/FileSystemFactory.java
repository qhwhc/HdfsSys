package com.ccc.hdfssys.common.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.net.URI;


/**
 * @Author: cyb
 * @Date: 2019-04-25 15:14
 * @Version 1.0
 */
public class FileSystemFactory {
    public static final String HDFS_PATH = "hdfs://106.12.127.134:9000";
    public static final String HDFS_USER = "root";

    private static FileSystem fileSystem = null;

    private FileSystemFactory(){}

    public static FileSystem getFileSystem(){
        try {
            if (fileSystem == null){
                synchronized (FileSystemFactory.class){
                    if(fileSystem == null){
                        Configuration configuration = new Configuration();
                        configuration.set("fs.hdfs.impl",
                                org.apache.hadoop.hdfs.DistributedFileSystem.class.getName()
                        );
                        configuration.set("fs.file.impl",
                                org.apache.hadoop.fs.LocalFileSystem.class.getName()
                        );
                        fileSystem = FileSystem.get(new URI(HDFS_PATH),configuration,HDFS_USER);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return fileSystem;
    }
}
