package com.mapper;

import com.mapper.entity.YfwConfigEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface YfwConfigMapper {

    /**
     * @Author Chenyz
     * @Description 查询最后一条id 获取cj_no(成交单号)字段
     * @Date 11:03 2020/6/28
     * @Param []
     * @return java.lang.String
     **/
    @Select("SELECT VALUE FROM yfw_config WHERE NAME = 'CJNO'")
    String selectYfwConfigValue();

    /**
     * @Author Chenyz
     * @Description 更新 yfw_config 表 value 记录
     * @Date 15:07 2020/6/28
     * @Param [value]
     * @return java.lang.Integer
     **/
    @Update("UPDATE yfw_config SET VALUE = #{value} WHERE NAME = 'CJNO'")
    Integer updateYfwConfigValue(@Param("value") String value);

}
