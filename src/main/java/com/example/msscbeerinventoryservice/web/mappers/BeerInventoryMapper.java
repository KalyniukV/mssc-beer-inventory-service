package com.example.msscbeerinventoryservice.web.mappers;

import com.example.msscbeerinventoryservice.domain.BeerInventory;
import com.example.msscbeerinventoryservice.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto dto);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
