package com.ccc.hdfssys.service;


import com.ccc.hdfssys.common.hdfs.FileSystemFactory;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * @Author: cyb
 * @Date: 2019-05-03 12:15
 * @Version 1.0
 */
public class DirectoryHandleService {
    private FileSystem fileSystem = FileSystemFactory.getFileSystem();
    public void mkdir(String dirPath){
        try {
           fileSystem.mkdirs(new Path("/hdfsapi/test"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
