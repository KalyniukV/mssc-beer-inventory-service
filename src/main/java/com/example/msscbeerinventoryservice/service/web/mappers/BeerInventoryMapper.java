package com.example.msscbeerinventoryservice.service.web.mappers;

import com.example.msscbeerinventoryservice.service.domain.BeerInventory;
import com.example.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

    BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto dto);

    BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
