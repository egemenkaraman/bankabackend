package com.example.stajbank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STAJBANKNEW")
public class bankaEntity {

    @Id
    @Column(name = "MUSTERIHESAPNO")
    private Long musteriHesapNo;

    @Column(name = "MUSTERINAME")
    private String musteriName;

    @Column(name = "MUSTERISURNAME")
    private String musteriSurname;

    @Column(name = "MUSTERIBAKIYE")
    private int musteriBakiye;

    @Column(name = "MUSTERIAGE")
    private int musteriAge;

    @Column(name = "MUSTERITCNO")
    private long musteriTcNo;

    // Varsayılan yapıcı (no-argument constructor) eklenmiş
    public bankaEntity() {
        // Varsayılan yapıcı
    }

    // Parametreli yapıcı
    public bankaEntity(Long musteriHesapNo, String musteriName, String musteriSurname, int musteriBakiye, int musteriAge, long musteriTcNo) {
        this.musteriHesapNo = musteriHesapNo;
        this.musteriName = musteriName;
        this.musteriSurname = musteriSurname;
        this.musteriBakiye = musteriBakiye;
        this.musteriAge = musteriAge;
        this.musteriTcNo = musteriTcNo;
    }

    // Getter ve Setter metodları
    public Long getMusteriHesapNo() {
        return musteriHesapNo;
    }

    public void setMusteriHesapNo(Long musteriHesapNo) {
        this.musteriHesapNo = musteriHesapNo;
    }

    public String getMusteriName() {
        return musteriName;
    }

    public void setMusteriName(String musteriName) {
        this.musteriName = musteriName;
    }

    public String getMusteriSurname() {
        return musteriSurname;
    }

    public void setMusteriSurname(String musteriSurname) {
        this.musteriSurname = musteriSurname;
    }

    public int getMusteriBakiye() {
        return musteriBakiye;
    }

    public void setMusteriBakiye(int musteriBakiye) {
        this.musteriBakiye = musteriBakiye;
    }

    public int getMusteriAge() {
        return musteriAge;
    }

    public void setMusteriAge(int musteriAge) {
        this.musteriAge = musteriAge;
    }

    public long getMusteriTcNo() {
        return musteriTcNo;
    }

    public void setMusteriTcNo(long musteriTcNo) {
        this.musteriTcNo = musteriTcNo;
    }
}