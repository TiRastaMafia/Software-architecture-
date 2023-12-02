package com.lesson9.RestExample.API;



import com.lesson9.RestExample.model.RequestBody;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Request {
    public String sendRequest(RequestBody requestBody) throws URISyntaxException, IOException, InterruptedException;

    public String sendRequest() throws URISyntaxException, IOException, InterruptedException;
}
