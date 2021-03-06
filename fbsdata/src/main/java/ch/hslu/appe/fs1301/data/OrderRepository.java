package ch.hslu.appe.fs1301.data;

import java.util.ArrayList;
import java.util.List;

import ch.hslu.appe.fs1301.data.shared.iAPPEEntityManager;
import ch.hslu.appe.fs1301.data.shared.iOrderRepository;
import ch.hslu.appe.fs1301.data.shared.entity.Bestellung;

import com.google.inject.Inject;

public class OrderRepository extends BaseRepository<Bestellung> implements iOrderRepository {

	@Inject
	public OrderRepository(iAPPEEntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Bestellung> getOrdersById(int... ids) throws IllegalArgumentException {
		if (ids.length == 0)
			throw new IllegalArgumentException("ids");
		
		List<Bestellung> orders = new ArrayList<Bestellung>();
		for (int i = 0; i < ids.length; i++) {
			Bestellung order = getById(ids[i]);
			if (order != null)
				orders.add(order);
		}
		return orders;
	}

}
