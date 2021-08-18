package com.enigma.bookStore.dto;

import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

public class RequestTransactions {

    @NotNull
    private RequestBook[] buys;

    public RequestBook[] getBuys() {
        return buys;
    }

    public void setBuys(RequestBook[] buys) {
        this.buys = buys;
    }
}
