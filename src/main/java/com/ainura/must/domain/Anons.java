package com.ainura.must.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
@Table(name = "ANONS")
public class Anons {
    @Id
    private Integer anonsid;

    @Column
    private Integer funusid;

    @Column
    private Integer subthemeid;
    @Column
    private String text;
    @Column
    private String imgfile ;
    @Column
    private Date anonsdst;
    @Column(nullable = true)
    private Date anonsdend;

    //@ManyToOne
    //@JoinColumn(name = "regnsid")
    @Column
    private Integer regnsid;


    @Column
    private Date dcreate;

    public Anons(Integer id, String text) {
        this.anonsid=id;
        this.text=text;
    }
    public Anons(Integer id, String text, Integer regnsid) {
        this.anonsid=id;
        this.text=text;
        this.regnsid=regnsid;
    }


}
