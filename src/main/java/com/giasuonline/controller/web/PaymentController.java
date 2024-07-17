package com.giasuonline.controller.web;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.giasuonline.config.PaypalPaymentIntent;
import com.giasuonline.config.PaypalPaymentMethod;
import com.giasuonline.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class PaymentController {
	public static final String URL_PAYPAL_SUCCESS = "pay/success";
	public static final String URL_PAYPAL_CANCEL = "pay/cancel";
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private PaypalService paypalService;

	@PostMapping("/pay")
	public String pay(HttpServletRequest request, @RequestParam("need_xu") BigDecimal need_xu) {
		String cancelUrl = com.giasuonline.util.Utils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
		String successUrl = com.giasuonline.util.Utils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
		try {
			Payment payment = paypalService.createPayment(need_xu, "USD", PaypalPaymentMethod.paypal,
					PaypalPaymentIntent.sale, "payment description", cancelUrl, successUrl);
			for (Links links : payment.getLinks()) {
				if (links.getRel().equals("approval_url")) {
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/";
	}

	@GetMapping(URL_PAYPAL_CANCEL)
	public String cancelPay() {
		return "cancel";
	}

	@GetMapping(URL_PAYPAL_SUCCESS)
	public ModelAndView successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if (payment.getState().equals("approved")) {
				return new ModelAndView("redirect:/trang-chu?paypal=success");
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return new ModelAndView("redirect:/trang-chu");
	}
}