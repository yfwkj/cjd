package com.mapper.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @ClassName: YfwCjdEntity
 * @Description: TODO
 * @Author: Chenyz
 * @Date: 2020/6/24 11:14
 * @Version: 1.0
 **/
@Entity
@Table(name = "yfw_cjd", schema = "yfwkj", catalog = "")
public class YfwCjdEntity {
    private int id;
    private String cjNo;
    private String cjStatus;
    private String jsStatus;
    private String yjdzStatus;
    private Timestamp cjDate;
    private String cjDept;
    private String seller;
    private String sellerMobi;
    private String cuserName;
    private String cuserMobi;
    private String cuserSourceDetail;
    private String cuserSource;
    private String fxName;
    private String fxMobi;
    private String qdName;
    private String qdMobi;
    private String jdName;
    private String jdMobi;
    private String cuserSzf;
    private String cuserSzfAddr;
    private String cuserCity;
    private String cjWays;
    private String fxCompany;
    private String lpCity;
    private String addDept;
    private String postAddr;
    private Timestamp qyDate;
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
    private Timestamp createdTime;
    private String updateBy;
    private Timestamp updateTime;
    private Integer del;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cj_no")
    public String getCjNo() {
        return cjNo;
    }

    public void setCjNo(String cjNo) {
        this.cjNo = cjNo;
    }

    @Basic
    @Column(name = "cj_status")
    public String getCjStatus() {
        return cjStatus;
    }

    public void setCjStatus(String cjStatus) {
        this.cjStatus = cjStatus;
    }

    @Basic
    @Column(name = "js_status")
    public String getJsStatus() {
        return jsStatus;
    }

    public void setJsStatus(String jsStatus) {
        this.jsStatus = jsStatus;
    }

    @Basic
    @Column(name = "yjdz_status")
    public String getYjdzStatus() {
        return yjdzStatus;
    }

    public void setYjdzStatus(String yjdzStatus) {
        this.yjdzStatus = yjdzStatus;
    }

    @Basic
    @Column(name = "cj_date")
    public Timestamp getCjDate() {
        return cjDate;
    }

    public void setCjDate(Timestamp cjDate) {
        this.cjDate = cjDate;
    }

    @Basic
    @Column(name = "cj_dept")
    public String getCjDept() {
        return cjDept;
    }

    public void setCjDept(String cjDept) {
        this.cjDept = cjDept;
    }

    @Basic
    @Column(name = "seller")
    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Basic
    @Column(name = "seller_mobi")
    public String getSellerMobi() {
        return sellerMobi;
    }

    public void setSellerMobi(String sellerMobi) {
        this.sellerMobi = sellerMobi;
    }

    @Basic
    @Column(name = "cuser_name")
    public String getCuserName() {
        return cuserName;
    }

    public void setCuserName(String cuserName) {
        this.cuserName = cuserName;
    }

    @Basic
    @Column(name = "cuser_mobi")
    public String getCuserMobi() {
        return cuserMobi;
    }

    public void setCuserMobi(String cuserMobi) {
        this.cuserMobi = cuserMobi;
    }

    @Basic
    @Column(name = "cuser_source_detail")
    public String getCuserSourceDetail() {
        return cuserSourceDetail;
    }

    public void setCuserSourceDetail(String cuserSourceDetail) {
        this.cuserSourceDetail = cuserSourceDetail;
    }

    @Basic
    @Column(name = "cuser_source")
    public String getCuserSource() {
        return cuserSource;
    }

    public void setCuserSource(String cuserSource) {
        this.cuserSource = cuserSource;
    }

    @Basic
    @Column(name = "fx_name")
    public String getFxName() {
        return fxName;
    }

    public void setFxName(String fxName) {
        this.fxName = fxName;
    }

    @Basic
    @Column(name = "fx_mobi")
    public String getFxMobi() {
        return fxMobi;
    }

    public void setFxMobi(String fxMobi) {
        this.fxMobi = fxMobi;
    }

    @Basic
    @Column(name = "qd_name")
    public String getQdName() {
        return qdName;
    }

    public void setQdName(String qdName) {
        this.qdName = qdName;
    }

    @Basic
    @Column(name = "qd_mobi")
    public String getQdMobi() {
        return qdMobi;
    }

    public void setQdMobi(String qdMobi) {
        this.qdMobi = qdMobi;
    }

    @Basic
    @Column(name = "jd_name")
    public String getJdName() {
        return jdName;
    }

    public void setJdName(String jdName) {
        this.jdName = jdName;
    }

    @Basic
    @Column(name = "jd_mobi")
    public String getJdMobi() {
        return jdMobi;
    }

    public void setJdMobi(String jdMobi) {
        this.jdMobi = jdMobi;
    }

    @Basic
    @Column(name = "cuser_szf")
    public String getCuserSzf() {
        return cuserSzf;
    }

    public void setCuserSzf(String cuserSzf) {
        this.cuserSzf = cuserSzf;
    }

    @Basic
    @Column(name = "cuser_szf_addr")
    public String getCuserSzfAddr() {
        return cuserSzfAddr;
    }

    public void setCuserSzfAddr(String cuserSzfAddr) {
        this.cuserSzfAddr = cuserSzfAddr;
    }

    @Basic
    @Column(name = "cuser_city")
    public String getCuserCity() {
        return cuserCity;
    }

    public void setCuserCity(String cuserCity) {
        this.cuserCity = cuserCity;
    }

    @Basic
    @Column(name = "cj_ways")
    public String getCjWays() {
        return cjWays;
    }

    public void setCjWays(String cjWays) {
        this.cjWays = cjWays;
    }

    @Basic
    @Column(name = "fx_company")
    public String getFxCompany() {
        return fxCompany;
    }

    public void setFxCompany(String fxCompany) {
        this.fxCompany = fxCompany;
    }

    @Basic
    @Column(name = "lp_city")
    public String getLpCity() {
        return lpCity;
    }

    public void setLpCity(String lpCity) {
        this.lpCity = lpCity;
    }

    @Basic
    @Column(name = "add_dept")
    public String getAddDept() {
        return addDept;
    }

    public void setAddDept(String addDept) {
        this.addDept = addDept;
    }

    @Basic
    @Column(name = "post_addr")
    public String getPostAddr() {
        return postAddr;
    }

    public void setPostAddr(String postAddr) {
        this.postAddr = postAddr;
    }

    @Basic
    @Column(name = "qy_date")
    public Timestamp getQyDate() {
        return qyDate;
    }

    public void setQyDate(Timestamp qyDate) {
        this.qyDate = qyDate;
    }

    @Basic
    @Column(name = "lp_name")
    public String getLpName() {
        return lpName;
    }

    public void setLpName(String lpName) {
        this.lpName = lpName;
    }

    @Basic
    @Column(name = "lp_jzmj")
    public String getLpJzmj() {
        return lpJzmj;
    }

    public void setLpJzmj(String lpJzmj) {
        this.lpJzmj = lpJzmj;
    }

    @Basic
    @Column(name = "lp_tnmj")
    public String getLpTnmj() {
        return lpTnmj;
    }

    public void setLpTnmj(String lpTnmj) {
        this.lpTnmj = lpTnmj;
    }

    @Basic
    @Column(name = "contract_no")
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Basic
    @Column(name = "lp_dong")
    public String getLpDong() {
        return lpDong;
    }

    public void setLpDong(String lpDong) {
        this.lpDong = lpDong;
    }

    @Basic
    @Column(name = "lp_danyuan")
    public String getLpDanyuan() {
        return lpDanyuan;
    }

    public void setLpDanyuan(String lpDanyuan) {
        this.lpDanyuan = lpDanyuan;
    }

    @Basic
    @Column(name = "lp_fanghao")
    public String getLpFanghao() {
        return lpFanghao;
    }

    public void setLpFanghao(String lpFanghao) {
        this.lpFanghao = lpFanghao;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "price_discount")
    public String getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(String priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    @Basic
    @Column(name = "amount")
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "amount_discount")
    public String getAmountDiscount() {
        return amountDiscount;
    }

    public void setAmountDiscount(String amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    @Basic
    @Column(name = "payment")
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "cj_reward")
    public String getCjReward() {
        return cjReward;
    }

    public void setCjReward(String cjReward) {
        this.cjReward = cjReward;
    }

    @Basic
    @Column(name = "lp_huxing")
    public String getLpHuxing() {
        return lpHuxing;
    }

    public void setLpHuxing(String lpHuxing) {
        this.lpHuxing = lpHuxing;
    }

    @Basic
    @Column(name = "lp_chaoxiang")
    public String getLpChaoxiang() {
        return lpChaoxiang;
    }

    public void setLpChaoxiang(String lpChaoxiang) {
        this.lpChaoxiang = lpChaoxiang;
    }

    @Basic
    @Column(name = "bizhong")
    public String getBizhong() {
        return bizhong;
    }

    public void setBizhong(String bizhong) {
        this.bizhong = bizhong;
    }

    @Basic
    @Column(name = "guadan")
    public String getGuadan() {
        return guadan;
    }

    public void setGuadan(String guadan) {
        this.guadan = guadan;
    }

    @Basic
    @Column(name = "yongjingbl")
    public String getYongjingbl() {
        return yongjingbl;
    }

    public void setYongjingbl(String yongjingbl) {
        this.yongjingbl = yongjingbl;
    }

    @Basic
    @Column(name = "beizhu")
    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    @Basic
    @Column(name = "chengjiaogj")
    public String getChengjiaogj() {
        return chengjiaogj;
    }

    public void setChengjiaogj(String chengjiaogj) {
        this.chengjiaogj = chengjiaogj;
    }

    @Basic
    @Column(name = "dianzijy")
    public String getDianzijy() {
        return dianzijy;
    }

    public void setDianzijy(String dianzijy) {
        this.dianzijy = dianzijy;
    }

    @Basic
    @Column(name = "custom_id")
    public Integer getCustomId() {
        return customId;
    }

    public void setCustomId(Integer customId) {
        this.customId = customId;
    }

    @Basic
    @Column(name = "cjd_zt")
    public Integer getCjdZt() {
        return cjdZt;
    }

    public void setCjdZt(Integer cjdZt) {
        this.cjdZt = cjdZt;
    }

    @Basic
    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "created_time")
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "update_by")
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "del")
    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YfwCjdEntity that = (YfwCjdEntity) o;
        return id == that.id &&
                Objects.equals(cjNo, that.cjNo) &&
                Objects.equals(cjStatus, that.cjStatus) &&
                Objects.equals(jsStatus, that.jsStatus) &&
                Objects.equals(yjdzStatus, that.yjdzStatus) &&
                Objects.equals(cjDate, that.cjDate) &&
                Objects.equals(cjDept, that.cjDept) &&
                Objects.equals(seller, that.seller) &&
                Objects.equals(sellerMobi, that.sellerMobi) &&
                Objects.equals(cuserName, that.cuserName) &&
                Objects.equals(cuserMobi, that.cuserMobi) &&
                Objects.equals(cuserSourceDetail, that.cuserSourceDetail) &&
                Objects.equals(cuserSource, that.cuserSource) &&
                Objects.equals(fxName, that.fxName) &&
                Objects.equals(fxMobi, that.fxMobi) &&
                Objects.equals(qdName, that.qdName) &&
                Objects.equals(qdMobi, that.qdMobi) &&
                Objects.equals(jdName, that.jdName) &&
                Objects.equals(jdMobi, that.jdMobi) &&
                Objects.equals(cuserSzf, that.cuserSzf) &&
                Objects.equals(cuserSzfAddr, that.cuserSzfAddr) &&
                Objects.equals(cuserCity, that.cuserCity) &&
                Objects.equals(cjWays, that.cjWays) &&
                Objects.equals(fxCompany, that.fxCompany) &&
                Objects.equals(lpCity, that.lpCity) &&
                Objects.equals(addDept, that.addDept) &&
                Objects.equals(postAddr, that.postAddr) &&
                Objects.equals(qyDate, that.qyDate) &&
                Objects.equals(lpName, that.lpName) &&
                Objects.equals(lpJzmj, that.lpJzmj) &&
                Objects.equals(lpTnmj, that.lpTnmj) &&
                Objects.equals(contractNo, that.contractNo) &&
                Objects.equals(lpDong, that.lpDong) &&
                Objects.equals(lpDanyuan, that.lpDanyuan) &&
                Objects.equals(lpFanghao, that.lpFanghao) &&
                Objects.equals(price, that.price) &&
                Objects.equals(priceDiscount, that.priceDiscount) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(amountDiscount, that.amountDiscount) &&
                Objects.equals(payment, that.payment) &&
                Objects.equals(cjReward, that.cjReward) &&
                Objects.equals(lpHuxing, that.lpHuxing) &&
                Objects.equals(lpChaoxiang, that.lpChaoxiang) &&
                Objects.equals(bizhong, that.bizhong) &&
                Objects.equals(guadan, that.guadan) &&
                Objects.equals(yongjingbl, that.yongjingbl) &&
                Objects.equals(beizhu, that.beizhu) &&
                Objects.equals(chengjiaogj, that.chengjiaogj) &&
                Objects.equals(dianzijy, that.dianzijy) &&
                Objects.equals(customId, that.customId) &&
                Objects.equals(cjdZt, that.cjdZt) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(del, that.del);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cjNo, cjStatus, jsStatus, yjdzStatus, cjDate, cjDept, seller, sellerMobi, cuserName, cuserMobi, cuserSourceDetail, cuserSource, fxName, fxMobi, qdName, qdMobi, jdName, jdMobi, cuserSzf, cuserSzfAddr, cuserCity, cjWays, fxCompany, lpCity, addDept, postAddr, qyDate, lpName, lpJzmj, lpTnmj, contractNo, lpDong, lpDanyuan, lpFanghao, price, priceDiscount, amount, amountDiscount, payment, cjReward, lpHuxing, lpChaoxiang, bizhong, guadan, yongjingbl, beizhu, chengjiaogj, dianzijy, customId, cjdZt, createdBy, createdTime, updateBy, updateTime, del);
    }
}
