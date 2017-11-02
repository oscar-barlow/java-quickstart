package com.javaQuickstart.foreach;

import java.util.List;

public class FireAndForgetter {

  private static final RequestSender requestSender = new RequestSender();

  public FireAndForgetter() {
  }

  public void sendRequests(List<FireAndForgetRequest> requests) {
    requests.forEach(request -> requestSender.send(request));
  }

}
