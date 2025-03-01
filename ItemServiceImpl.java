package com.example.demo;

import com.example.demo.Item;
import com.example.demo.ItemRepository;
import com.example.demo.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public Item createItem(Item item) {
        // Add any business logic/validation here before saving
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Long id, Item itemDetails) {
        Optional<Item> itemOptional = itemRepository.findById(id);

        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setName(itemDetails.getName());
            item.setDescription(itemDetails.getDescription());
            return itemRepository.save(item);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}