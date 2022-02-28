package com.shop.entity;

import com.shop.constant.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class OrderItem extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    /*FetchType.Lazy 하는 이유는 ManyToOne으로 연결된 엔티티에서
    실제로 데이터를 조회를 하지 않더라도 해당 Entity를 불러와서 성능이슈가 발생하므로 Lazy전략을 사용해
    실제로 사용될 때만 데이터를 불러오도록 설정
    왠만하면 LAZY로 설정
    * */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;


//    private LocalDateTime regTime;
//    private LocalDateTime updateTime;
}
