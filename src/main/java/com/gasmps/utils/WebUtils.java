package com.gasmps.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public final class WebUtils {
	
	public static String getIp(HttpServletRequest request) {

		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = Constant.ClientInfo.DEFAULT_IP;
		}
		return ip;
	}

	public static String getHost(HttpServletRequest request) throws SocketException {
		String hostName = request.getServerName();
		if (hostName == null || hostName.length() == 0 || "unknown".equalsIgnoreCase(hostName)) {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface nic = interfaces.nextElement();
				Enumeration<InetAddress> addresses = nic.getInetAddresses();
				while (hostName == null && addresses.hasMoreElements()) {
					InetAddress address = addresses.nextElement();
					if (!address.isLoopbackAddress()) {
						hostName = address.getHostName();
					}
				}
			}
		}
		if (hostName == null || hostName.length() == 0 || "unknown".equalsIgnoreCase(hostName)) {
			hostName = Constant.ClientInfo.DEFAULT_HOST;
		}
		return hostName;
	}

	public static String getCountry(HttpServletRequest request) {
		String country = request.getLocale().getCountry();
		if (country == null || country.length() == 0 || "unknown".equalsIgnoreCase(country)) {
			country = Constant.ClientInfo.DEFAULT_COUNTRY;
		}
		return country;
	}

	public static String getDevice(HttpServletRequest request) {
		String machine = null;
		if (request.getHeader("User-Agent") != null
				&& request.getHeader("User-Agent").toLowerCase().indexOf(Constant.ClientInfo.MOBILE_DEVICE) != -1) {
			machine = Constant.ClientInfo.MOBILE_DEVICE;
		} else {
			machine = Constant.ClientInfo.DESKTOP_DEVICE;
		}
		return machine;
	}
	
	

}
