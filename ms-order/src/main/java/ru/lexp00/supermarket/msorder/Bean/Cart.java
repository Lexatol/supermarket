package ru.lexp00.supermarket.msorder.Bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.lexp00.supermarket.msorder.entities.OrderItem;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@Component
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
    private List<OrderItem> items;
    private int totalPrice;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }


//    public List<Long> getProductIds() {
//        List<Long> ids = new ArrayList<>();
//        for (OrderItem item: items) {
//            ids.add(item.getProduct_id());
//        }
//        return ids;
//    }

}
