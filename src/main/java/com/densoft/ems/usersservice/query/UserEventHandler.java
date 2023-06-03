package com.densoft.ems.usersservice.query;

import com.densoft.ems.common.model.PaymentDetails;
import com.densoft.ems.common.model.User;
import com.densoft.ems.common.query.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserEventHandler {
    @QueryHandler
    public User findUserPaymentDetails(FetchUserPaymentDetailsQuery fetchUserPaymentDetailQuery) {
        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("John Doe")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder()
                .firstName("Sergey")
                .lastName("Kargopolov")
                .userId(fetchUserPaymentDetailQuery.getUserId())
                .paymentDetails(paymentDetails)
                .build();
    }
}
