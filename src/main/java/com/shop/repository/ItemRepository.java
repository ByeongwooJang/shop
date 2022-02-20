package com.shop.repository;

import com.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository 의 첫 번째에는 엔티티 타입 클래스를, 두 번째는 엔티티의 기본키 타입
public interface ItemRepository extends JpaRepository<Item, Long> {

}
