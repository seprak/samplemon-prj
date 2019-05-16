package com.airhacks.ping.boundary;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.metrics.annotation.Metered;

import com.kodnito.microprofilerestapimongodb.dao.TodoDAO;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

	@Inject
	private TodoDAO todoDAO;

	@Metered(description = "PINGmeter")
	@GET
	public String ping() {
		String hostName = null;
		InetAddress localHost = null;
		
		try {
			localHost = InetAddress.getLocalHost();
			hostName = localHost.getHostName();
		} catch (UnknownHostException e) {
			
		}
		return "Enjoy Java EE 8! host=" + hostName + ", IP=" + localHost;
	}

}
