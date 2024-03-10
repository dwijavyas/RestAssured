package eCommerce;

import java.util.List;

public class SetCreateOrderRequest {
	
	private List<SetSubCreateOrderRequest> orders;

	public List<SetSubCreateOrderRequest> getOrders() {
		return orders;
	}

	public void setOrders(List<SetSubCreateOrderRequest> orders) {
		this.orders = orders;
	}

}
