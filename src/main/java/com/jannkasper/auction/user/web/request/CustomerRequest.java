package com.jannkasper.auction.user.web.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CustomerRequest {
  private String email;
  private String pwd;
  private String role;
}
