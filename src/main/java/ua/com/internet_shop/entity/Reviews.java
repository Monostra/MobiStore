package ua.com.internet_shop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String comment;
    private String goodReview;
    private String badReview;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    private Goods goods;

    @ManyToMany
    @JoinTable(name = "userReviews", joinColumns = @JoinColumn(name = "reviewsId"), inverseJoinColumns = @JoinColumn(name = "userId"))
    private List<User> users;

    public Reviews() {
    }

    public Reviews(String comment, String goodReview, String badReview, LocalDate date) {
        this.comment = comment;
        this.goodReview = goodReview;
        this.badReview = badReview;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGoodReview() {
        return goodReview;
    }

    public void setGoodReview(String goodReview) {
        this.goodReview = goodReview;
    }

    public String getBadReview() {
        return badReview;
    }

    public void setBadReview(String badReview) {
        this.badReview = badReview;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", goodReview='" + goodReview + '\'' +
                ", badReview='" + badReview + '\'' +
                ", date=" + date +
                '}';
    }
}
