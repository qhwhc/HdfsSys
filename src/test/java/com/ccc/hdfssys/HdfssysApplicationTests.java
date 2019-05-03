package com.ccc.hdfssys;

import com.ccc.hdfssys.common.hdfs.FileSystemFactory;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HdfssysApplicationTests {
    private FileSystem fileSystem = FileSystemFactory.getFileSystem();
    @Test
    public void contextLoads() {
        System.out.println("123");
    }

    @Test
    public void mkdir(){
        try {
            fileSystem.mkdirs(new Path("/hdfsapi/test"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
