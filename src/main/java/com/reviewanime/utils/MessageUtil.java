package com.reviewanime.utils;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request) {
		if (request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if (message.equals("insert_success")) {
				messageResponse = "Insert success";
				alert = "success";
			} else if (message.equals("update_success")) {
				messageResponse = "Update success";
				alert = "success";
			} else if (message.equals("delete_success")) {
				messageResponse = "Delete success";
				alert = "success";
			} else if (message.equals("error_system")) {
				messageResponse = "Error system";
				alert = "danger";
			} else if (message.equals("username_password_invalid")) {
				messageResponse = "Username or Password is invalid";
				alert = "danger";
			} else if (message.equals("not_login")) {
				messageResponse = "Not login";
				alert = "danger";
			} else if (message.equals("not_permission")) {
				messageResponse = "Not permission";
				alert = "danger";
			} else if (message.equals("password_not_match")) {
			    messageResponse = "Password and confirm password do not match";
			    alert = "danger";
			} else if (message.equals("register_success")) {
			    messageResponse = "Register success";
			    alert = "success";
			} else if (message.equals("register_failed")) {
			    messageResponse = "Register failed";
			    alert = "danger";
			}
			request.setAttribute("messageResponse", messageResponse);
			request.setAttribute("alert", alert);
		}
	}
}