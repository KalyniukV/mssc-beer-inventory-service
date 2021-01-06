package com.example.msscbeerinventoryservice.service.services;

import com.example.model.events.NewInventoryEvent;
import com.example.msscbeerinventoryservice.service.config.JmsConfig;
import com.example.msscbeerinventoryservice.service.domain.BeerInventory;
import com.example.msscbeerinventoryservice.service.repositories.BeerInventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class NewInventoryListener {
    private final BeerInventoryRepository beerInventoryRepository;

    @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
    public void listen(NewInventoryEvent event) {
        log.debug("Got Inventory: " + event);

        beerInventoryRepository.save(
                BeerInventory.builder()
                        .beerId(event.getBeerDto().getId())
                        .upc(event.getBeerDto().getUpc())
                        .quantityOnHand(event.getBeerDto().getQuantityOnHand())
                        .build()
        );
    }


}
