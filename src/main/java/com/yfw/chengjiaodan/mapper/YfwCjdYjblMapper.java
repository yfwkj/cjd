package com.yfw.chengjiaodan.mapper;

import com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity;
import org.apache.ibatis.annotations.Insert;

public interface YfwCjdYjblMapper {

    /**
     * @Author Chenyz
     * @Description yfw_cjd_yjbl表添加一条记录
     * @Date 11:20 2020/7/2
     * @Param [yfwCjdYjblEntity]
     * @return java.lang.Integer
     **/
    @Insert("INSERT INTO yfw_cjd_yjbl SET cjd_no = #{cjdNo}, is_yeji = #{isYeji}, main_type = #{mainType}, yj_type = #{yjType}, dept_id = #{deptId},\n" +
            "\t\t\t     staff_id = #{staffId}, yj_rate = #{yjRate}, yj_amount = #{yjAmount}, fc_rate = #{fcRate}, get_amount = #{getAmount},\n" +
            "\t\t\t     yeji_amount = #{yejiAmount}, tex_rate = #{texRate}, tex_amount = #{texAmount}, is_salaryok = #{isSalaryok}, is_netsell = #{isNetsell},\n" +
            "\t\t\t     created_by = #{createdBy}, created_time = NOW(), del = #{del}")
    Integer insertYfwCjdYjbl(YfwCjdYjblEntity yfwCjdYjblEntity);
}
