package cn.wq.hrm.controller;


import cn.wq.hrm.util.AjaxResult;
import cn.wq.hrm.util.FastDfsApiOpr;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/fastdfs")
public class FastDfsController {
    Logger logger = LoggerFactory.getLogger(FastDfsController.class);
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {

        try {
            //文件名 如1.png
            String fileName = file.getOriginalFilename();
            System.out.println("fileName:"+fileName);
            //文件后缀名 如png
            String extName = fileName.substring(fileName.lastIndexOf(".")+1);
            System.out.println("extName:"+extName);
            return FastDfsApiOpr.upload(file.getBytes(),extName);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("error...."+e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/delete")
    public AjaxResult delete(@RequestParam("path") String path) {
        ///group1/xxxx
        try {
            String pathTmp = path.substring(1); // goup1/xxxxx/yyyy
            //组名:goup1
            String groupName =  pathTmp.substring(0, pathTmp.indexOf("/")); //goup1
            //路径:如M00/00/01/wKgrA11vnTKAMZgeAAQjWmHSSu0609.jpg
            String remotePath = pathTmp.substring(pathTmp.indexOf("/")+1);// /xxxxx/yyyy
            FastDfsApiOpr.delete(groupName,remotePath);
            return AjaxResult.me();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("error...."+e.getMessage());
            return AjaxResult.me().setSuccess(false).setMessage(e.getMessage());
        }
    }

    @GetMapping("/download")
    public void download(@RequestParam("path")String path, HttpServletResponse response) {
        String pathTmp = path.substring(1); // goup1/xxxxx/yyyy
        String groupName =  pathTmp.substring(0, pathTmp.indexOf("/")); //goup1
        String remotePath = pathTmp.substring(pathTmp.indexOf("/")+1);// xxxxx/yyyy
        OutputStream os = null;
        InputStream is = null;
        try {
            byte[] datas = FastDfsApiOpr.download(groupName, remotePath);
            os = response.getOutputStream(); //直接给以流方式进行返回
            is = new ByteInputStream(datas,datas.length);
            IOUtils.copy(is,os);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("error...."+e.getMessage());
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
