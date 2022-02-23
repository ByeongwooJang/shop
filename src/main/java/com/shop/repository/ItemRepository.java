package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

//JpaRepository 의 첫 번째에는 엔티티 타입 클래스를, 두 번째는 엔티티의 기본키 타입
//해당 클래스는 기본적인 CRUD 및 페이징 처리를 위한 메소드가 정이돼 있다,
public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {

    //Query Method 규칙 : find + 엔티티 이름 + By + 변수이름 = findItemByItemNm(엔티티 이름은 생략이 가능해서 아래와 같은 메소드명 사용)
    List<Item> findByItemNm(String itemNm);
    List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);
    List<Item> findByPriceLessThan(Integer price);
    List<Item> findByPriceLessThanOrderByPriceDesc(Integer price);//OrderBy + 속성명 + Desc(Asc)

    //:itemDetail 대신 ?1 이라는 표현을 사용해 첫 번째 파라미터를 전달하겠다는 표현을 사용할 수 있지만 명시적인 방법인 @Param 어노테이션을 사용하는것을 추천
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc")
    //@Query(value = "select * from Item i where i.item_detail like %:itemDetail% order by i.price desc", nativeQuery = true)
    List<Item> findByItemDetail(@Param("itemDetail") String itemDetail);
}
