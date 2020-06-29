package com.yfw.chengjiaodan.mapper;

import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import org.apache.ibatis.annotations.Insert;


public interface YfwCjdAttachMapper {

    @Insert("INSERT INTO yfw_cjd_attach SET cjd_no=#{cjdNo},file_type=#{fileType},url=#{url},ico=#{ico},created_by=#{createdBy},thumbnail=#{thumbnail};")
    Integer insertYfwCjdAttach(YfwCjdAttachEntity yfwCjdAttachEntity);
}
