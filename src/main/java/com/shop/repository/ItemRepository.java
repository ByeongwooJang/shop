package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository 의 첫 번째에는 엔티티 타입 클래스를, 두 번째는 엔티티의 기본키 타입
//해당 클래스는 기본적인 CRUD 및 페이징 처리를 위한 메소드가 정이돼 있다,
public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item>,ItemRepositoryCustom {

    //Query Method 규칙 : find + 엔티티 이름 + By + 변수이름 = findItemByItemNm(엔티티 이름은 생략이 가능해서 아래와 같은 메소드명 사용)
    List<Item> findByItemNm(String itemNm);

    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

    List<Item> findByPriceLessThan(Integer price);

    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);

    @Query("select i from Item i where i.itemDetail like " +
            "%:itemDetail% order by i.price desc")
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
}
