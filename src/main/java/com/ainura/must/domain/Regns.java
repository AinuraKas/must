package com.ainura.must.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
@NoArgsConstructor//ломбок аннотация: конструктор без аргуметов
@Table(name = "REGNS")
public class Regns {

    @Id
    private Integer regnsid;

    @Column
    private String regns;

}
