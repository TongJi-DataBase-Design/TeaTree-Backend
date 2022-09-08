package cn.edu.tongji.teatreebackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "top_article")
public class TopArticleEntity {
    @Id
    @Column(name = "article_id", nullable = false)
    private Integer articleId;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
}
