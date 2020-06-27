package com.mapper.entity;

import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.*;


/**
 * @ClassName: YfwCjdEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/24 11:14
 * @Version: 1.0
 **/
@Valid
@Data
public class YfwCjdEntity {
    private int id;
    private String cjNo;
    private String cjStatus;
    private String jsStatus;
    private String yjdzStatus;

    @NotBlank(message = "成交时间日期不能为空")
    @Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "成交时间日期格式不正确:YYYY-MM-DD")
    private String cjDate;

    private String cjDept;
    private String seller;

    @NotBlank(message = "销售员手机号码不能为空")
    @Size(min = 11, max = 11, message = "销售员手机号码长度不正确")
    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "销售员手机号格式错误")
    private String sellerMobi;

    private String cuserName;

    @NotBlank(message = "客户手机号码不能为空")
    @Size(min = 11, max = 11, message = "客户手机号码长度不正确")
    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "客户手机号格式错误")
    private String cuserMobi;

    private String cuserSourceDetail;
    private String cuserSource;
    private String fxName;

    @NotBlank(message = "分销员手机号码不能为空")
    @Size(min = 11, max = 11, message = "分销员手机号码长度不正确")
    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "分销员手机号格式错误")
    private String fxMobi;

    private String qdName;

    @NotBlank(message = "渠道信息手机号码不能为空")
    @Size(min = 11, max = 11, message = "渠道信息手机号码长度不正确")
    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "渠道信息手机号格式错误")
    private String qdMobi;

    private String jdName;

    @NotBlank(message = "接待手机号码不能为空")
    @Size(min = 11, max = 11, message = "接待手机号码长度不正确")
    @Pattern(regexp = "^(((13[0-9])|(14[579])|(15([0-3]|[5-9]))|(16[6])|(17[0135678])|(18[0-9])|(19[89]))\\d{8})$", message = "接待手机号格式错误")
    private String jdMobi;

    private String cuserSzf;
    private String cuserSzfAddr;
    private String cuserCity;
    private String cjWays;
    private String fxCompany;
    private String lpCity;
    private String addDept;
    private String postAddr;

    @NotBlank(message = "签约日期不能为空")
    @Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "签约时间日期格式不正确:YYYY-MM-DD")
    private String qyDate;

    private String lpName;
    private String lpJzmj;
    private String lpTnmj;
    private String contractNo;
    private String lpDong;
    private String lpDanyuan;
    private String lpFanghao;
    private String price;
    private String priceDiscount;
    private String amount;
    private String amountDiscount;
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
    private Integer customId;
    private Integer cjdZt;
    private String createdBy;

    @NotBlank(message = "创建时间日期不能为空")
    @Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "创建时间日期格式不正确:YYYY-MM-DD")
    private String createdTime;

    private String updateBy;

    @NotBlank(message = "更新时间日期不能为空")
    @Pattern(regexp = "^(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)$", message = "更新时间日期格式不正确:YYYY-MM-DD")
    private String updateTime;

    @NotNull(message = "del不能为null")
    @DecimalMin(value = "0",message = "必须大于0的数字")
    private Integer del;


}
