package com.jannkasper.auction.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

  @GetMapping("/myAccount")
  public String getAccountDetails(String input) {
    return "Here are the account details from the DB";
  }

  @GetMapping("/myBalance")
  public String getBalanceDetails(String input) {
    return "Here are the balance details from the DB";
  }

  @GetMapping("/myCards")
  public String getCardDetails(String input) {
    return "Here are the card details from the DB";
  }

  @GetMapping("/myLoans")
  public String getLoanDetails(String input) {
    return "Here are the loan details from the DB";
  }

  @GetMapping("/contact")
  public String saveContactInquiryDetails(String input) {
    return "Inquiry details are saved to the DB";
  }

  @GetMapping("/notices")
  public String getNotices(String input) {
    return "Here are the notices details from the DB";
  }

}
