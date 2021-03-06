package com.yfw.chengjiaodan.mapper;




import com.yfwkj.jsb.mapper.entity.YfwCjd;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface YfwCjdMapper {

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO yfw_cjd SET cj_no = #{cjNo},cj_status=#{cjStatus},js_status=#{jsStatus},\n" +
            "\t\t\tyjdz_status=#{yjdzStatus},cj_date=#{cjDate},cj_dept=#{cjDept},\n" +
            "\t\t\tseller=#{seller},seller_mobi=#{sellerMobi},cuser_name=#{cuserName},\n" +
            "\t\t\tcuser_mobi=#{cuserMobi},cuser_source_detail=#{cuserSourceDetail},\n" +
            "\t\t\tcuser_source=#{cuserSource},fx_name=#{fxName},fx_mobi=#{fxMobi},\n" +
            "\t\t\tqd_name=#{qdName},qd_mobi=#{qdMobi},jd_name=#{jdName},jd_mobi=#{jdMobi},\n" +
            "\t\t\tcuser_szf=#{cuserSzf},cuser_szf_addr=#{cuserSzfAddr},cuser_city=#{cuserCity},\n" +
            "\t\t\tcj_ways=#{cjWays},fx_company=#{fxCompany},lp_city=#{lpCity},add_dept=#{addDept},\n" +
            "\t\t\tpost_addr=#{postAddr},qy_date=#{qyDate},lp_name=#{lpName},lp_jzmj=#{lpJzmj},\n" +
            "\t\t\tlp_tnmj=#{lpTnmj},contract_no=#{contractNo},lp_dong=#{lpDong},lp_danyuan=#{lpDanyuan},\n" +
            "\t\t\tlp_fanghao=#{lpFanghao},price=#{price},price_discount=#{priceDiscount},amount=#{amount},\n" +
            "\t\t\tamount_discount=#{amountDiscount},payment=#{payment},cj_reward=#{cjReward},lp_huxing=#{lpHuxing},\n" +
            "\t\t\tlp_chaoxiang=#{lpChaoxiang},bizhong=#{bizhong},guadan=#{guadan},yongjingbl=#{yongjingbl},beizhu=#{beizhu},\n" +
            "\t\t\tchengjiaogj=#{chengjiaogj},dianzijy=#{dianzijy},custom_id=#{customId},cjd_zt=#{cjdZt},created_by=#{createdBy},\n" +
            "\t\t\tcreated_time=NOW(),update_by=#{updateBy},update_time=NOW(),del=0;")
    Integer insertSubmit(YfwCjd yfwCjd);

//    @Select("SELECT * FROM yfw_cjd WHERE id = #{id};")
//    Map<String,Object> selectYfwCjdEntity(@Param("id") Integer id);

    @Select("SELECT id, cj_no AS cjNo ,cj_status AS cjStatus , js_status AS jsStatus,\n" +
            "\t\t\tyjdz_status AS yjdzStatus , DATE_FORMAT(cj_date,'%Y-%m-%d') AS cjDate , cj_dept AS cjDept,\n" +
            "\t\t\tseller AS seller , seller_mobi AS sellerMobi , cuser_name AS cuserName,\n" +
            "\t\t\tcuser_mobi AS cuserMobi , cuser_source_detail AS cuserSourceDetail,\n" +
            "\t\t\tcuser_source AS cuserSource , fx_name AS fxName , fx_mobi AS fxMobi ,\n" +
            "\t\t\tqd_name AS qdName ,qd_mobi AS qdMobi ,jd_name AS jdName ,jd_mobi AS jdMobi,\n" +
            "\t\t\tcuser_szf AS cuserSzf , cuser_szf_addr AS cuserSzfAddr ,cuser_city AS cuserCity,\n" +
            "\t\t\tcj_ways AS cjWays , fx_company AS fxCompany , lp_city AS lpCity ,add_dept AS addDept ,\n" +
            "\t\t\tpost_addr AS postAddr , DATE_FORMAT(qy_date,'%Y-%m-%d') AS qyDate , lp_name AS lpName , lp_jzmj AS lpJzmj,\n" +
            "\t\t\tlp_tnmj AS lpTnmj ,contract_no AS contractNo ,lp_dong AS lpDong ,lp_danyuan AS lpDanyuan,\n" +
            "\t\t\tlp_fanghao AS lpFanghao , price AS price , price_discount AS priceDiscount , amount AS amount,\n" +
            "\t\t\tamount_discount AS amountDiscount , payment AS payment ,cj_reward AS cjReward ,lp_huxing AS lpHuxing,\n" +
            "\t\t\tlp_chaoxiang AS lpChaoxiang ,bizhong AS bizhong ,guadan AS guadan ,yongjingbl AS yongjingbl ,beizhu AS beizhu,\n" +
            "\t\t\tchengjiaogj AS chengjiaogj ,dianzijy AS dianzijy ,custom_id AS customId ,cjd_zt AS cjdZt ,created_by AS createdBy,\n" +
            "\t\t\tDATE_FORMAT(created_time,'%Y-%m-%d') AS createdTime ,update_by AS updateBy ,DATE_FORMAT(update_time,'%Y-%m-%d') AS updateTime ,del AS del FROM yfw_cjd WHERE id = #{id}")
    YfwCjd selectYfwCjdEntity(@Param("id") Integer id);

    /**
     * @Author Chenyz
     * @Description 模糊查询 倒排序 分页
     * @Date 9:02 2020/7/2
     * @Param [sort]
     * @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    @Select("SELECT * FROM yfw_cjd ORDER BY ${sort}")
    List<Map<String,Object>> selectYfwCjdList(@Param("sort") String sort);
}
