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

@Mapper(componentModel = "spring", uses = ProductService.class)
public interface OrderMapper {

    Order orderRequestToOrder(OrderRequest orderRequest);

    OrderRequest orderToOrderRequest(Order order);

    List<OrderRowRequest> orderRowsToOrderRowRequests(List<OrderRow> orderRows);

    List<OrderRow> orderRowRequestsToOrderRows(List<OrderRowRequest> orderRowRequests);

    @Mapping(source = "productId", target = "product")
    OrderRow orderRowRequestToOrderRow(OrderRowRequest orderRowRequest);

    @Mapping(source = "product.id", target = "productId")
    OrderRowResponse orderRowToOrderRowResponse(OrderRow orderRow);

    Order orderResponseToOrder(OrderResponse orderResponse);

    OrderResponse orderToOrderResponse(Order order);

    List<OrderResponse> ordersToOrderResponses(List<Order> orders);

    List<OrderRowResponse> orderRowsToOrderRowResponses(List<OrderRow> orderRows);

    List<OrderRow> orderRowResponsesToOrderRows(List<OrderRowResponse> orderRowResponses);

}
