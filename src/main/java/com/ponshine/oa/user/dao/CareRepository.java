package com.ponshine.oa.user.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ponshine.oa.user.entity.Card;

/**
 * Created by Brave on 16/10/12.
 */
public interface CareRepository extends JpaRepository<Card, Long> {

    Card findByCardNumber(String name);

}
