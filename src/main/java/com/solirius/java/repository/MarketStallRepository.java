package com.solirius.java.repository;

import com.solirius.java.domain.MarketStall;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MarketStallRepository extends CrudRepository<MarketStall,UUID> {

}
