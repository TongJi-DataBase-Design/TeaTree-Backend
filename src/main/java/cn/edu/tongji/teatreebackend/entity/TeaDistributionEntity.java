package cn.edu.tongji.teatreebackend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * TODO:此处写TeaDistributionEntity类的描述
 *
 * @author 汪明杰
 * @date 2022/3/29 19:37
 */
@Entity
@Table(name = "tea_distribution", schema = "OldTea", catalog = "")
public class TeaDistributionEntity {
    private int id;
    private String articleAbstract;
    private String articleContent;
    private String articleCover;
    private String articleSource;
    private Timestamp articleTime;
    private String articleTitle;
    private Integer clickNum;
    private Integer isTop;
    private String teaDirection;
    private String teaType;
    private String biologyTeaType;
    private int articleType;
    private String protectionArticleType;
    private String cultureArticleType;
    private String industryArticleType;
    private String activityArticleType;
    private Integer teaAge;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "article_abstract")
    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    @Basic
    @Column(name = "article_content")
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Basic
    @Column(name = "article_cover")
    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    @Basic
    @Column(name = "article_source")
    public String getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    @Basic
    @Column(name = "article_time")
    public Timestamp getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Timestamp articleTime) {
        this.articleTime = articleTime;
    }

    @Basic
    @Column(name = "article_title")
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "click_num")
    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    @Basic
    @Column(name = "is_top")
    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    @Basic
    @Column(name = "tea_direction")
    public String getTeaDirection() {
        return teaDirection;
    }

    public void setTeaDirection(String teaDirection) {
        this.teaDirection = teaDirection;
    }

    @Basic
    @Column(name = "tea_type")
    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeaDistributionEntity that = (TeaDistributionEntity) o;
        return id == that.id && Objects.equals(articleAbstract, that.articleAbstract) && Objects.equals(articleContent, that.articleContent) && Objects.equals(articleCover, that.articleCover) && Objects.equals(articleSource, that.articleSource) && Objects.equals(articleTime, that.articleTime) && Objects.equals(articleTitle, that.articleTitle) && Objects.equals(clickNum, that.clickNum) && Objects.equals(isTop, that.isTop) && Objects.equals(teaDirection, that.teaDirection) && Objects.equals(teaType, that.teaType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleAbstract, articleContent, articleCover, articleSource, articleTime, articleTitle, clickNum, isTop, teaDirection, teaType);
    }

    @Basic
    @Column(name = "biology_tea_type")
    public String getBiologyTeaType() {
        return biologyTeaType;
    }

    public void setBiologyTeaType(String biologyTeaType) {
        this.biologyTeaType = biologyTeaType;
    }

    @Basic
    @Column(name = "article_type")
    public int getArticleType() {
        return articleType;
    }

    public void setArticleType(int articleType) {
        this.articleType = articleType;
    }

    @Basic
    @Column(name = "protection_article_type")
    public String getProtectionArticleType() {
        return protectionArticleType;
    }

    public void setProtectionArticleType(String protectionArticleType) {
        this.protectionArticleType = protectionArticleType;
    }

    @Basic
    @Column(name = "culture_article_type")
    public String getCultureArticleType() {
        return cultureArticleType;
    }

    public void setCultureArticleType(String cultureArticleType) {
        this.cultureArticleType = cultureArticleType;
    }

    @Basic
    @Column(name = "industry_article_type")
    public String getIndustryArticleType() {
        return industryArticleType;
    }

    public void setIndustryArticleType(String industryArticleType) {
        this.industryArticleType = industryArticleType;
    }

    @Basic
    @Column(name = "activity_article_type")
    public String getActivityArticleType() {
        return activityArticleType;
    }

    public void setActivityArticleType(String activityArticleType) {
        this.activityArticleType = activityArticleType;
    }

    @Basic
    @Column(name = "tea_age")
    public Integer getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(Integer teaAge) {
        this.teaAge = teaAge;
    }
}
