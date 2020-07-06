package com.yfw.chengjiaodan.mapper;

import com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity;
import com.yfw.chengjiaodan.mapper.entity.YfwCjdYjblEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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
            "\t\t\t     created_by = #{createdBy}, created_time = NOW(), del = 0")
    Integer insertYfwCjdYjbl(YfwCjdYjblEntity yfwCjdYjblEntity);

    /**
     * @Author Chenyz
     * @Description //TODO
     * @Date 16:30 2020/7/2
     * @Param [sort, search]
     * @return java.util.List<com.yfw.chengjiaodan.mapper.entity.YfwCjdAttachEntity>
     **/
    @Select("SELECT * FROM yfw_cjd_yjbl where 1 = 1 ${search} ORDER BY ${sort}")
    List<YfwCjdYjblEntity> selectYfwCjdYjblPagehelper(@Param("sort") String sort, @Param("search") String search);

    /**
     * @Author Chenyz
     * @Description 修改  yfw_cjd_yjbl del 字段 0 表示正常 1 表示删除
     * @Date 15:36 2020/7/3
     * @Param [id]
     * @return java.lang.Integer
     **/
    @Update("UPDATE yfw_cjd_yjbl SET del = 1 WHERE id = #{id}")
    Integer updateCjdYjblById(@Param("id") String id);
}
