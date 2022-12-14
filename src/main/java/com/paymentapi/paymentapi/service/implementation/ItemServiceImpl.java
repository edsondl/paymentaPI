package .service.implementation;

import .model.Item;
import .repository.ItemRepository;
import com.paymentapi.paymentapi.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> saveAll(Iterable<Item> iterable) {
        return itemRepository.saveAll(iterable);
    }
}