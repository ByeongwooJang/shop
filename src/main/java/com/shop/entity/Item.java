package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

//Item 클래스를 Entity로 선언, @Table 어노테이션을 통해 어떤 테이블과 매핑될지 지정
@Entity
@Table(name="item")

@Getter
@Setter
@ToString
public class Item {

    @Id //Entity로 선언한 클래스는 반드시 기본키를 가져야한다. -> @Id 어노테이션 사용
    @Column(name="item_id") //매핑 될 Cloumn 정보 설정
    @GeneratedValue(strategy= GenerationType.AUTO) // 기본키 생성 전략
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemNm;

    @Column(name="price", nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    private LocalDateTime regTime;

    private LocalDateTime updateTime;
}
