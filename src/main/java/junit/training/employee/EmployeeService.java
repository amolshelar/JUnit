package junit.training.employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeService {

	private static Map<Integer, String> employees = new HashMap<Integer, String>();

	static {
		employees.put(1, "Amol");
		employees.put(2, "Amit");
	}

	public String findNameById(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("Employee Id is required");
		}

		String name = employees.get(id);

		return name;
	}
}
