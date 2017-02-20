package ua.com.internet_shop.entity;

import javax.persistence.*;

@Entity
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pahtImg;
    private boolean mainImg;

    @ManyToOne(fetch = FetchType.LAZY)
    private Goods goods;

    public Images() {
    }

    public Images(String pahtImg, boolean mainImg) {
        this.pahtImg = pahtImg;
        this.mainImg = mainImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPahtImg() {
        return pahtImg;
    }

    public void setPahtImg(String pahtImg) {
        this.pahtImg = pahtImg;
    }

    public boolean isMainImg() {
        return mainImg;
    }

    public void setMainImg(boolean mainImg) {
        this.mainImg = mainImg;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Images{" +
                "id=" + id +
                ", pahtImg='" + pahtImg + '\'' +
                ", mainImg=" + mainImg +
                '}';
    }
}
