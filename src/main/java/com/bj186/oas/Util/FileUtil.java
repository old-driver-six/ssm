package com.bj186.oas.Util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 上传文件的工具类
 */
public class FileUtil {
    private static final String IMAGE_PREFIX = "/statis/imges";  //服务器储存上传图片地址的前缀
    private String path;         //存放的路径
    //判断文件是什么类型的
    private MultipartFile file;
    public FileUtil(MultipartFile file,HttpServletRequest request){
        this.file=file;
        path=request.getSession().getServletContext().getRealPath(IMAGE_PREFIX)+File.separator;
    }

    /**
     * 判断文件是什么类型的
     * @return
     */
    private String IsFile(){
        String oriName=null;
        if(!file.isEmpty()){
            oriName = file.getOriginalFilename();
            //获取出文件的后缀
            int index=oriName.lastIndexOf(".");
            oriName.substring(index);
        }
        return oriName;
    }

    /**
     * 如果是图片返回图片存储的位置
     * @return
     */

    /**
     * 文件上传的类
     * @return
     */
    public String uploadFile(){
        String paths=path+ UUIDUtil.getUUID()+IsFile();
        try {

            file.transferTo(new File(paths));
            return paths;
        } catch (IOException e) {
            e.printStackTrace();
            //如果文件夹不存在,则创建一个文件夹
            File file2=new File(path);
            file2.mkdirs();
            try {
                file.transferTo(new File(paths));
                return paths;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
}
