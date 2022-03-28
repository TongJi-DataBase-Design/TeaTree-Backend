package cn.edu.tongji.teatreebackend.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * TODO:此处写TeaDistributionEntity类的描述
 *
 * @author 汪明杰
 * @date 2022/3/29 0:16
 */
@Entity
@Table(name = "TeaDistribution", schema = "OldTea", catalog = "")
public class TeaDistributionEntity {
    private int id;
    private String articleTitle;
    private String articleAbstract;
    private String articleCover;
    private String articleContent;
    private String articleSource;
    private Timestamp articleTime;
    private String teaType;
    private String teaDirection;
    private Integer clickNum;
    private Integer isTop;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "articleTitle")
    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    @Basic
    @Column(name = "articleAbstract")
    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    @Basic
    @Column(name = "articleCover")
    public String getArticleCover() {
        return articleCover;
    }

    public void setArticleCover(String articleCover) {
        this.articleCover = articleCover;
    }

    @Basic
    @Column(name = "articleContent")
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Basic
    @Column(name = "articleSource")
    public String getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    @Basic
    @Column(name = "articleTime")
    public Timestamp getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Timestamp articleTime) {
        this.articleTime = articleTime;
    }

    @Basic
    @Column(name = "teaType")
    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    @Basic
    @Column(name = "teaDirection")
    public String getTeaDirection() {
        return teaDirection;
    }

    public void setTeaDirection(String teaDirection) {
        this.teaDirection = teaDirection;
    }

    @Basic
    @Column(name = "clickNum")
    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    @Basic
    @Column(name = "isTop")
    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeaDistributionEntity that = (TeaDistributionEntity) o;
        return id == that.id && Objects.equals(articleTitle, that.articleTitle) && Objects.equals(articleAbstract, that.articleAbstract) && Objects.equals(articleCover, that.articleCover) && Objects.equals(articleContent, that.articleContent) && Objects.equals(articleSource, that.articleSource) && Objects.equals(articleTime, that.articleTime) && Objects.equals(teaType, that.teaType) && Objects.equals(teaDirection, that.teaDirection) && Objects.equals(clickNum, that.clickNum) && Objects.equals(isTop, that.isTop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleTitle, articleAbstract, articleCover, articleContent, articleSource, articleTime, teaType, teaDirection, clickNum, isTop);
    }
}
