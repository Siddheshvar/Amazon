package com.example.Amazon.ServiceImpl;

import com.example.Amazon.Requests.OrderRequest;
import com.example.Amazon.Response.AddressResponse;
import com.example.Amazon.Response.BaseResponse;
import com.example.Amazon.Response.OrderResponse;
import com.example.Amazon.Response.SignUpResponse;
import com.example.Amazon.entity.Order;
import com.example.Amazon.repository.AddressRepository;
import com.example.Amazon.repository.OrderRepository;
import com.example.Amazon.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public BaseResponse saveOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderDate(orderRequest.getOrderDate());
        order.setTotalAmount(orderRequest.getTotalAmount());
        order.setShippingAddress(addressRepository.findByIsDeletedAndId(false,orderRequest.getShippingAddress()).get());
        order.setCreateOn(new Date());
        order.setIsDeleted(false);
        orderRepository.save(order);
        return new BaseResponse(200, "Order saved successfully", order);
    }

    @Override
    public BaseResponse<List<Order>> getAllOrder() {
        List<Order> orderList = orderRepository.findByIsDeleted(false);
        if (!orderList.isEmpty() && orderList.size()>0){
            List<OrderResponse> orderResponses = new ArrayList<>();
            for (Order orders : orderList){
                OrderResponse orderResponseList = new OrderResponse();
                orderResponseList.setId(orders.getId());
                orderResponseList.setOrderDate(orders.getOrderDate());
                orderResponseList.setTotalAmount(orders.getTotalAmount());

                AddressResponse addressResponse = new AddressResponse();
                addressResponse.setId(orders.getShippingAddress().getId());
                addressResponse.setFlatOrHouseNo(orders.getShippingAddress().getFlatOrHouseNo());
                addressResponse.setResidencyOrApartment(orders.getShippingAddress().getResidencyOrApartment());
                addressResponse.setAreaOrColony(orders.getShippingAddress().getAreaOrColony());
                addressResponse.setTownOrVillage(orders.getShippingAddress().getTownOrVillage());
                addressResponse.setCity(orders.getShippingAddress().getCity());
                addressResponse.setSubDistrict(orders.getShippingAddress().getSubDistrict());
                addressResponse.setDistrict(orders.getShippingAddress().getDistrict());
                addressResponse.setPinCode(orders.getShippingAddress().getPinCode());
                addressResponse.setState(orders.getShippingAddress().getState());
                addressResponse.setCountry(orders.getShippingAddress().getCountry());

                orderResponseList.setAddressResponse(addressResponse);
                orderResponses.add(orderResponseList);
            }
            return new BaseResponse(200, "Order retrieved successfully", orderResponses);
        }else{
            return new BaseResponse(404,    "No order found",null);
        }
    }

    @Override
    public BaseResponse getOrderById(Integer id) {
        Optional<Order> order = orderRepository.findByIsDeletedAndId(false,id);
        if (order.isPresent() && order!=null) {
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setId(order.get().getId());
            orderResponse.setOrderDate(order.get().getOrderDate());
            orderResponse.setTotalAmount(order.get().getTotalAmount());

            AddressResponse addressResponse = new AddressResponse();
            addressResponse.setId(order.get().getShippingAddress().getId());
            addressResponse.setFlatOrHouseNo(order.get().getShippingAddress().getFlatOrHouseNo());
            addressResponse.setResidencyOrApartment(order.get().getShippingAddress().getResidencyOrApartment());
            addressResponse.setAreaOrColony(order.get().getShippingAddress().getAreaOrColony());
            addressResponse.setTownOrVillage(order.get().getShippingAddress().getTownOrVillage());
            addressResponse.setCity(order.get().getShippingAddress().getCity());
            addressResponse.setSubDistrict(order.get().getShippingAddress().getSubDistrict());
            addressResponse.setDistrict(order.get().getShippingAddress().getDistrict());
            addressResponse.setPinCode(order.get().getShippingAddress().getPinCode());
            addressResponse.setState(order.get().getShippingAddress().getState());
            addressResponse.setCountry(order.get().getShippingAddress().getCountry());

            orderResponse.setAddressResponse(addressResponse);

            SignUpResponse signUpResponse = new SignUpResponse();
            signUpResponse.setId(order.get().getId());
            signUpResponse.setFullName(order.get().getSignUp().getFullName());
            signUpResponse.setPhoneNo(order.get().getSignUp().getPhoneNo());
            signUpResponse.setEmailId(order.get().getSignUp().getEmailId());

            orderResponse.setSignUpResponse(signUpResponse);
            return new BaseResponse(200,"Order retrieved ",orderResponse);
        }else{
            return new BaseResponse(200," Order not found",null);
        }
    }

    @Override
    public BaseResponse updateOrderById(Order order, Integer id) {
        Optional<Order> order1 = orderRepository.findByIsDeletedAndId(id);
        if (order1.isPresent() && order1!=null){
            order1.get().setOrderDate(order.getOrderDate());
            order1.get().setTotalAmount(order.getTotalAmount());
            order1.get().setShippingAddress(addressRepository.findByIsDeletedAndId(false,order.getShippingAddress().getId()).get());
            orderRepository.save(order1.get());
            return new BaseResponse(200, "Order updated successfully", order1.get());
        }else{
            return new BaseResponse(404,    "Order not found",null);
        }
    }

    @Override
    public BaseResponse deleteOrderById(Integer id) {
        Optional<Order> order = orderRepository.findByIsDeletedAndId(id);
        if (order.isPresent()) {
            orderRepository.deleteById(id);
            return new BaseResponse(200, "Order deleted successfully", order.get().getId());
        }else{
            return new BaseResponse(404,    "Order not found",null);
        }
    }

}
