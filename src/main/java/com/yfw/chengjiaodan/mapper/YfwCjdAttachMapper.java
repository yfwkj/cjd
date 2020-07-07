package com.yfw.chengjiaodan.mapper;



import com.yfw.chengjiaodan.mapper.entity.StaffVoEntity;
import com.yfwkj.jsb.mapper.entity.YfwCjdAttach;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface YfwCjdAttachMapper {

    /**
     * @Author Chenyz
     * @Description 新增记录
     * @Date 14:41 2020/7/3
     * @Param [yfwCjdAttachEntity]
     * @return java.lang.Integer
     **/
    @Insert("INSERT INTO yfw_cjd_attach SET cjd_no=#{cjdNo},file_type=#{fileType},url=#{url},ico=#{ico},created_by=#{createdBy},created_time = NOW(),thumbnail=#{thumbnail},del = 0;")
    Integer insertYfwCjdAttach(YfwCjdAttach yfwCjdAttach);

    /**
     * @Author Chenyz
     * @Description 分页 模糊查询 排序
     * @Date 14:41 2020/7/3
     * @Param [sort, search]
     * @return java.util.List<com.yfwkj.jsb.mapper.entity.YfwCjdAttachEntity>
     **/
    @Select("SELECT * FROM yfw_cjd_attach where 1 = 1 ${search} ORDER BY ${sort}")
    List<YfwCjdAttach> selectYfwCjdAttachPagehelper(@Param("sort") String sort, @Param("search") String search);

    /**
     * @Author Chenyz
     * @Description 获取 id 联合查询 返回 created_by
     * @Date 14:40 2020/7/3
     * @Param [id]
     * @return com.yfwkj.jsb.mapper.entity.StaffVoEntity
     **/
    @Select("select   p.position_name,d.dept_name, s.* from yfw_userstaff u ,yfw_staff s ,yfw_position p ,yfw_dept d\n" +
            "where    s.id=u.staff_id and p.id=s.position_id and d.id=s.deptid and u.user_id = #{id}")
    StaffVoEntity selectStaff(@Param("id") String id);

    /**
     * @Author Chenyz
     * @Description 修改 del 字段状态 0 表示正常 1 表示删除
     * @Date 14:42 2020/7/3
     * @Param [id]
     * @return java.lang.Integer
     **/
    @Update("UPDATE yfw_cjd_attach SET del = 1 WHERE id = #{id}")
    Integer updateCjdAttachById(@Param("id") String id);
}
