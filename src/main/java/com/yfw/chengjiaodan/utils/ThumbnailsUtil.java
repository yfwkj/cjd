package com.yfw.chengjiaodan.utils;

import net.coobird.thumbnailator.Thumbnails;

/**
 * @ClassName: ThumbnailsUtil
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/30 9:13
 * @Version: 1.0
 **/
public class ThumbnailsUtil {

    /**
     * @return void
     * @Author Chenyz
     * @Description 按原比例缩略图工具
     * @Date 9:14 2020/6/30
     * @Param [source 图片源地址,scale 缩放大小,quality 生成图片的质量0.1f 至 1.0f 之间取值,outFile 输出文件的路径和名字]
     **/
    public static void setThumbnails (String sourceFile, double scale, float quality, String outFilePath)  throws Exception {
        Thumbnails.of(sourceFile).scale(scale).outputQuality(quality).toFile(outFilePath);
    }
}
