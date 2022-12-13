package com.tools.publish;

import com.tools.controller.GetFileList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EwellToolsPublishApplicationTests {
    @Autowired
    private GetFileList getFileList;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testPagelist(){
        Model model=null;
//        getFileList.pageList(1,model);
    }
}
