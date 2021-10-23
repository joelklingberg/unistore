package com.unistore.order.dto;

import com.unistore.order.dto.request.OrderRequest;
import com.unistore.order.dto.request.OrderRowRequest;
import com.unistore.order.dto.response.OrderResponse;
import com.unistore.order.dto.response.OrderRowResponse;

import java.util.List;

import com.unistore.order.Order;
import com.unistore.order.OrderRow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    /* OrderRequest */

    // OrderRequest -> Order
    Order orderRequestToOrder(OrderRequest orderRequest);

    // Order -> OrderRequest
    OrderRequest orderToOrderRequest(Order order);

    // OrderRows -> OrderRowRequests
    List<OrderRowRequest> orderRowsToOrderRowRequests(List<OrderRow> orderRows);

    // OrderRowRequests -> OrderRows
    List<OrderRow> orderRowRequestsToOrderRows(List<OrderRowRequest> orderRowRequests);

    /* OrderResponse */

    // OrderResponse -> Order
    Order orderResponseToOrder(OrderResponse orderResponse);

    // Order -> OrderResponse
    OrderResponse orderToOrderResponse(Order order);

    List<OrderResponse> ordersToOrderResponses(List<Order> orders);

    // OrderRows -> OrderRowResponses
    @Mapping(source = "product.id", target = "productId")
    List<OrderRowResponse> orderRowsToOrderRowResponses(List<OrderRow> orderRows);

    // OrderRowResponses -> OrderRows
    @Mapping(source = "productId", target = "product.id")
    List<OrderRow> orderRowResponsesToOrderRows(List<OrderRowResponse> orderRowResponses);


}
