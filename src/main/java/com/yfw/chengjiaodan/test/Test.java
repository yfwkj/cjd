package com.yfw.chengjiaodan.test;

import com.alibaba.fastjson.JSONObject;
import com.chtwm.component.util.JwtHelper;
import com.yfw.chengjiaodan.base.BaseApiService;
import com.yfw.chengjiaodan.service.YfwCjdAttachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/28 10:50
 * @Version: 1.0
 **/
@RestController
@Slf4j
public class Test extends BaseApiService<JSONObject> {

    @Autowired
    private YfwCjdAttachService yfwCjdAttachService;

    @PostMapping("/test")
    public void test(HttpServletRequest request) {
        String jwt = request.getHeader("User-Token");
        String retJson = JwtHelper.validateLogin(jwt);
        JSONObject jsonObject = JSONObject.parseObject(retJson);
        log.info(jsonObject.toString());
    }

    /**
     * @param path 图片路劲
     */
    public static void getData(String path) {
        try {
            //获取图像资源，转成BufferedImage对象
            BufferedImage bimg = ImageIO.read(new File(path));
            //创建一个二维数组，用来存放图像每一个像素位置的颜色值
            int[][] data = new int[bimg.getWidth()][bimg.getHeight()];
            //以高度为范围，逐列扫描图像，存进数组对应位置
            for (int i = 0; i < bimg.getWidth(); i++) {
                for (int j = 0; j < bimg.getHeight(); j++) {
                    data[i][j] = bimg.getRGB(i, j);//得到的是sRGB值，4字节
                }
            }
            compressImg(bimg.getWidth(), bimg.getHeight(), data, 6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片压缩...打印
     *
     * @param width  图片的宽
     * @param height 图片的高
     * @param data   图片转换后的二维int数组
     * @param x      将图片缩小几倍(偶数，2,4,6,12,24....)
     */
    public static void compressImg(int width, int height, int[][] data, int x) {
        //将数组旋转90°输出，实现逐行输出图像
        for (int i = 0; i < height; i += x) {
            for (int j = 0; j < width; j += x) {
                if (data[j][i] != -1) {//有颜色输出
                    System.out.print("*");
                } else {            //无颜色输出
                    System.out.print(" ");
                }
            }
            System.out.println();//每行结束换行
        }
    }
}
