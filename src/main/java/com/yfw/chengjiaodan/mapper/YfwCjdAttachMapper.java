package com.yfw.chengjiaodan.mapper;

import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


public interface YfwCjdAttachMapper {

    @Insert("INSERT INTO yfw_cjd_attach SET cjd_no=#{cjdNo},file_type=#{fileType},url=#{url},ico=#{ico},created_by=#{createdBy},thumbnail=#{thumbnail};")
    Integer insertYfwCjdAttach(YfwCjdAttachEntity yfwCjdAttachEntity);

    @Select("SELECT * FROM yfw_cjd_attach where 1 = 1 ${search} ORDER BY ${sort}")
    List<YfwCjdAttachEntity> selectYfwCjdAttachPagehelper(@Param("sort") String sort, @Param("search") String search);

}
