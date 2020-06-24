package com.mapper;

import com.mapper.entity.YfwCjdEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface YfwCjdMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO yfw_cjd VALUES(NULL,#{cjNo},#{cjStatus},#{jsStatus},#{yjdzStatus},#{cjDate},#{cjDept},#{seller},#{sellerMobi},#{cuserName},#{cuserMobi},\n" +
            "#{cuserSourceDetail},#{cuserSource},#{fxName},#{fxMobi},#{qdName},#{qdMobi},#{jdName},#{jdMobi},#{cuserSzf},#{cuserSzfAddr},#{cuserCity},#{cjWays},#{fxCompany},#{lpCity},#{addDept},#{postAddr},#{qyDate},#{lpName},\n" +
            "#{lpJzmj},#{lpTnmj},#{contractNo},#{lpDong},#{lpDanyuan},#{lpFanghao},#{price},#{priceDiscount},#{amount},#{amountDiscount},#{payment},#{cjReward},#{lpHuxing},#{lpChaoxiang},#{bizhong},#{guadan},#{yongjingbl},#{beizhu},#{chengjiaogj},#{dianzijy},#{customId},#{cjdZt},#{createdBy},#{createdTime},#{updateBy},#{updateTime}, #{del})")
    Integer insertSubmit(YfwCjdEntity yfwCjdEntity);

    @Select("SELECT * FROM yfw_cjd WHERE id = #{id};")
    Map<String,Object> selectYfwCjdEntity(@Param("id") Integer id);
}
