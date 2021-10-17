package com.unistore.order.dto;

import com.unistore.order.dto.request.OrderRequest;
import com.unistore.order.dto.request.OrderRowRequest;

import java.util.List;

import com.unistore.order.Order;
import com.unistore.order.OrderRow;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    // OrderRequest -> Order
    Order orderRequestToOrder(OrderRequest orderRequest);

    // Order -> OrderRequest
    OrderRequest orderToOrderRequest(Order order);

    // OrderRows -> OrderRowRequests
    List<OrderRowRequest> orderRowsToOrderRowRequests(List<OrderRow> orderRow);

    // OrderRowRequests -> OrderRows
    List<OrderRow> orderRowRequestsToOrderRows(List<OrderRowRequest> orderRowRequest);

}
