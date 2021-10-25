package com.unistore.order.dto;

import com.unistore.order.dto.request.OrderRequest;
import com.unistore.order.dto.request.OrderRowRequest;
import com.unistore.order.dto.response.OrderResponse;
import com.unistore.order.dto.response.OrderRowResponse;
import java.util.List;
import com.unistore.order.Order;
import com.unistore.order.OrderRow;
import com.unistore.product.ProductService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = OrderRowMapper.class)
public interface OrderMapper {

    Order orderRequestToOrder(OrderRequest orderRequest);

    OrderRequest orderToOrderRequest(Order order);

    Order orderResponseToOrder(OrderResponse orderResponse);

    OrderResponse orderToOrderResponse(Order order);

    List<OrderResponse> ordersToOrderResponses(List<Order> orders);

}
