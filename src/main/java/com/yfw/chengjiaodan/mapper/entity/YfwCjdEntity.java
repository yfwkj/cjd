package com.yfw.chengjiaodan.mapper.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;

import javax.validation.Valid;
import javax.validation.constraints.*;


/**
 * @ClassName: YfwCjdEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/24 11:14
 * @Version: 1.0
 **/
@Data
public class YfwCjdEntity {
    private int id;

    private String cjNo;
    private String cjStatus;
    private String jsStatus;
    private String yjdzStatus;

    //成交时间必填
    @NotBlank(message = "成交时间日期不能为空")
    @Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "成交时间日期格式不正确:YYYY-MM-DD")
    private String cjDate;

    //成交部门必填
    @NotBlank(message = "成交部门不能为空")
    private String cjDept;

    //销售员必填
    @NotBlank(message = "销售员姓名不能为空")
    private String seller;

    //销售员电话必填
    @NotBlank(message = "销售员手机号码不能为空")
//    @Size(min = 11, max = 11, message = "销售员手机号码长度不正确")
//    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "销售员手机号格式错误")
    private String sellerMobi;

    //客户名字必填
    @NotBlank(message = "客户姓名不能为空")
    private String cuserName;

    //客户电话必填
    @NotBlank(message = "客户手机号码不能为空")
//    @Size(min = 11, max = 11, message = "客户手机号码长度不正确")
//    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "客户手机号格式错误")
//    @Pattern(regexp = "^(1[7358]\\d{9}\\s*,\\s*)*(1[7358]\\d{9})$",message = "手机格式不正确，多个手机用英文逗号隔开")
    private String cuserMobi;

    //来源明细必填
    @NotBlank(message = "来源明细不能为空")
    private String cuserSourceDetail;

    //客户来源必填
    @NotBlank(message = "客户来源不能为空")
    private String cuserSource;
    private String fxName;

//    @NotBlank(message = "分销员手机号码不能为空")
//    @Size(min = 11, max = 11, message = "分销员手机号码长度不正确")
//    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "分销员手机号格式错误")
    private String fxMobi;

    private String qdName;

    @Size(min = 11, max = 11, message = "渠道信息手机号码长度不正确")
    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "渠道信息手机号格式错误")
    private String qdMobi;

    //接待必填
    @NotBlank(message = "接待姓名不能为空")
    private String jdName;

    //接待电话必填
    @NotBlank(message = "接待手机号码不能为空")
    //@Size(min = 11, max = 11, message = "接待手机号码长度不正确")
    //@Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "接待手机号格式错误")
    private String jdMobi;

    private String cuserSzf;
    private String cuserSzfAddr;

    //省份城市必填
    @NotBlank(message = "省份城市不能为空")
    private String cuserCity;

    private String cjWays;
    private String fxCompany;

    //楼盘城市必填
    @NotBlank(message = "楼盘城市不能为空")
    private String lpCity;

    private String addDept;
    private String postAddr;

    //@NotBlank(message = "签约日期不能为空")
    //@Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "签约时间日期格式不正确:YYYY-MM-DD")
    private String qyDate;

    private String lpName;
    private String lpJzmj;
    private String lpTnmj;
    private String contractNo;
    private String lpDong;
    private String lpDanyuan;

    //房号必填
    @NotBlank(message = "房号不能为空")
    private String lpFanghao;

    private String price;
    private String priceDiscount;
    private String amount;

    //折后总价必填
    @NotBlank(message = "折后总价不能为空")
    private String amountDiscount;

    //付款方式必填
    @NotBlank(message = "付款方式不能为空")
    private String payment;

    private String cjReward;
    private String lpHuxing;
    private String lpChaoxiang;
    private String bizhong;
    private String guadan;
    private String yongjingbl;
    private String beizhu;
    private String chengjiaogj;
    private String dianzijy;

    @Pattern(regexp = "^[0-9]*$",message = "customId必须为整数")
    @Size(min = 0, max = 11, message = "customId的值超过最大值范围")
    private String customId;

    @Pattern(regexp = "^[0-9]*$",message = "cjdZt必须为整数")
    @Size(min = 0, max = 11, message = "cjdZt的值超过最大值范围")
    private String cjdZt;

    private String createdBy;

//    @NotBlank(message = "创建时间日期不能为空")
//    @Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "创建时间日期格式不正确:YYYY-MM-DD")
    private String createdTime;

    private String updateBy;

//    @NotBlank(message = "更新时间日期不能为空")
//    @Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "更新时间日期格式不正确:YYYY-MM-DD")
    private String updateTime;


    @Pattern(regexp = "^[0-9]*$",message = "del必须为整数")
    @Size(min = 0, max = 11, message = "del的值超过最大值范围")
    private String del;

}
