package ua.com.internet_shop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class EyesStoppers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    private String name;
    private String metaTitle;
    private String metaDescription;
    private String pathImg;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eyesStoppers")
    private List<Goods> goods;

    public EyesStoppers() {
    }

    public EyesStoppers(String name, String metaTitle, String metaDescription, String pathImg) {
        this.name = name;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.pathImg = pathImg;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "EyesStoppersDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", metaTitle='" + metaTitle + '\'' +
                ", metaDescription='" + metaDescription + '\'' +
                ", pathImg='" + pathImg + '\'' +
                '}';
    }
}
