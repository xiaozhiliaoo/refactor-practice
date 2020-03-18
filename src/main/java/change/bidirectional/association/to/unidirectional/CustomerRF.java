/**
 * 
 */
package change.bidirectional.association.to.unidirectional;

import junit.framework.Assert;

import java.util.HashSet;
import java.util.Set;

/**
 * @author meng.sun
 * 
 */
public class CustomerRF {
	
	private Set<OrderRF> _orders = new HashSet<OrderRF>();

	Set<OrderRF> friendOrders() {
		return _orders;
	}

//	void addOrder(OrderRF order) {
//		order.setCustomer(this);
//	}

	double getDiscount() {
		return 1;
	}

	double getPriceFor(OrderRF order) {
		Assert.assertTrue(_orders.contains(order));
		return order.getDisCountedPrice(this);
	}
}
