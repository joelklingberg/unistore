package com.unistore.order.dto;

import com.unistore.order.OrderRow;
import com.unistore.order.dto.request.OrderRowRequest;
import com.unistore.order.dto.response.OrderRowResponse;
import com.unistore.product.ProductService;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductService.class)
public interface OrderRowMapper {
    List<OrderRowRequest> orderRowsToOrderRowRequests(List<OrderRow> orderRows);

    List<OrderRow> orderRowRequestsToOrderRows(List<OrderRowRequest> orderRowRequests);

    @Mapping(source = "productId", target = "product")
    OrderRow orderRowRequestToOrderRow(OrderRowRequest orderRowRequest);

    @Mapping(source = "product.id", target = "productId")
    OrderRowResponse orderRowToOrderRowResponse(OrderRow orderRow);

    List<OrderRowResponse> orderRowsToOrderRowResponses(List<OrderRow> orderRows);

    List<OrderRow> orderRowResponsesToOrderRows(List<OrderRowResponse> orderRowResponses);
}
