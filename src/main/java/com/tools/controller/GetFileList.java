package com.tools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GetFileList {
    @Autowired
    private Environment env;
    @RequestMapping("/getlist")
    public String pageList(@RequestParam(value="pagenum",defaultValue = "0") int pagenum,@RequestParam(value="pageSize",defaultValue = "3") int pageSize, Model model){
        List<String> filenames = new ArrayList<>();
        List<String> pageNames=new ArrayList<>();
        filenames=getAllFile();
        int total=filenames.size();//总个数
        int totalpage=total%pageSize==0?(total/pageSize):(total/pageSize)+1;
        if(pagenum!=totalpage-1){
            pageNames= filenames.subList(pagenum*pageSize,(pagenum+1)*pageSize);
        }
       else{
            pageNames= filenames.subList(pagenum*pageSize,total-1);
        }

        model.addAttribute("pagenames",pageNames);
        model.addAttribute("pagenow",pagenum);
        model.addAttribute("lastpage",totalpage-1);
        System.out.println(totalpage);
        return "filelist1";
    }
    /**
     * 获取指定文件夹下所有文件，不含文件夹里的文件
     *
     * @param
     * @return
     */
    public List<String> getAllFile() {
        List<String> filenames = new ArrayList<>();
//        dirFilePath = env.getProperty("publish.path");
        String dirFilePath="d:\\publish";
        File folder = new File(dirFilePath);
//        if (StrUtil.isBlank(dirFilePath))
        if (!folder.exists()) {
            return null;
        }

//        filelist= getAllFile(folder);
        File[] childrenFiles = folder.listFiles();
        for (File childFile : childrenFiles) {
            // 如果是文件，直接添加到结果集合
            if (childFile.isFile()) {
                filenames.add(childFile.getName());
            }
        }
//        model.addAttribute("filenames",filenames);
//        System.out.println(filenames);
        return filenames;
//        return "filelist1";
    }
    public  void hello(){
        System.out.println("hello world");
    }
}
        /**
         * 获取指定文件夹下所有文件，不含文件夹里的文件
         *
         * @param dirFile 文件夹
         * @return
         */
//        public List<String> getAllFile(File dirFile){
            // 如果文件夹不存在或着不是文件夹，则返回 null
//        if (Objects.isNull(dirFile) || !dirFile.exists() || dirFile.isFile())
//            return null;
//            File[] childrenFiles = dirFile.listFiles();
//            if (Objects.isNull(childrenFiles) || childrenFiles.length == 0)
//                return null;
//
//            List<String> filenames = new ArrayList<>();
//            for (File childFile : childrenFiles) {
//                // 如果是文件，直接添加到结果集合
//                if (childFile.isFile()) {
//                    filenames.add(childFile.getName());
//                }
                //以下几行代码取消注释后可以将所有子文件夹里的文件也获取到列表里
//            else {
//                // 如果是文件夹，则将其内部文件添加进结果集合
//                List<File> cFiles = getAllFile(childFile);
//                if (Objects.isNull(cFiles) || cFiles.isEmpty()) continue;
//                files.addAll(cFiles);
//            }
//            }
//            return filenames;
//        }
//    }

//}
