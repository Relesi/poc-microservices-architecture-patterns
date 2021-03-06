package com.relesi.architecture;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.relesi.architecture.domain.Address;
import com.relesi.architecture.domain.Category;
import com.relesi.architecture.domain.City;
import com.relesi.architecture.domain.Client;
import com.relesi.architecture.domain.PurchaseOrder;
import com.relesi.architecture.domain.Payment;
import com.relesi.architecture.domain.PaymentCard;
import com.relesi.architecture.domain.PaymentSlip;
import com.relesi.architecture.domain.Product;
import com.relesi.architecture.domain.PurchaseItem;
import com.relesi.architecture.domain.State;
import com.relesi.architecture.domain.enums.ClientType;
import com.relesi.architecture.domain.enums.PaymentState;
import com.relesi.architecture.repositories.AddressRepository;
import com.relesi.architecture.repositories.CategoryRepository;
import com.relesi.architecture.repositories.CityRepository;
import com.relesi.architecture.repositories.ClientRepository;
import com.relesi.architecture.repositories.PurchaseOrderRepository;
import com.relesi.architecture.repositories.PaymentRepository;
import com.relesi.architecture.repositories.ProductRepository;
import com.relesi.architecture.repositories.PurchaseItemRepository;
import com.relesi.architecture.repositories.StateRepository;

@SpringBootApplication
public class PocMicroservicesArchitectureApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private PurchaseItemRepository purchaseItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(PocMicroservicesArchitectureApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		Category cat3 = new Category(null, "Electronic");
		Category cat4 = new Category(null, "Gamer");
		Category cat5 = new Category(null, "Sony");
		Category cat6 = new Category(null, "Apple");
		Category cat7 = new Category(null, "Coffee Machine");



		Product p1 = new Product(null, "Computing", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));

		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		State sta1 = new State(null, "California");
		State sta2 = new State(null, "Texa");

		City c1 = new City(null, "Los Angeles", sta1);
		City c2 = new City(null, "Dallas", sta2);
		City c3 = new City(null, "Houston", sta2);

		sta1.getCities().addAll(Arrays.asList(c1));
		sta2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(sta1, sta2));
		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		Client cli1 = new Client(null, "Renato Lessa", "renato@gmail.com", "29484284086", ClientType.NATURALPERSON);
		cli1.getTelephones().addAll(Arrays.asList("23450987", "98761234"));

		Address a1 = new Address(null, "Street Dumas", "300", "Apt 201", "Englewood", "01220839", cli1, c1);
		Address a2 = new Address(null, "Street Broad Ave", "209", "Lounge 13", "New Jersey", "05880460", cli1, c2);

		cli1.getAddresses().addAll(Arrays.asList(a1, a2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1, a2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		PurchaseOrder ord1 = new PurchaseOrder(null, sdf.parse("13/08/2021 00:00"), cli1, a1);
		PurchaseOrder ord2 = new PurchaseOrder(null, sdf.parse("14/08/2021 00:00"), cli1, a2);

		Payment pay1 = new PaymentCard(null, PaymentState.SETTLED, ord1, 6);
		ord1.setPayment(pay1);

		Payment pay2 = new PaymentSlip(null, PaymentState.PENDING, ord2, sdf.parse("01/09/2021 00:00"), null);
		ord2.setPayment(pay2);

		cli1.getPurchaseOrder().addAll(Arrays.asList(ord1, ord2));

		purchaseOrderRepository.saveAll(Arrays.asList(ord1, ord2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));

		PurchaseItem purchIte1 = new PurchaseItem(ord1, p1, 0.00, 1, 2000.00);
		PurchaseItem purchIte2 = new PurchaseItem(ord1, p3, 0.00, 2, 80.00);
		PurchaseItem purchIte3 = new PurchaseItem(ord2, p2, 100.00, 1, 800.00);

		ord1.getItems().addAll(Arrays.asList(purchIte1, purchIte2));
		ord1.getItems().addAll(Arrays.asList(purchIte3));

		p1.getItems().addAll(Arrays.asList(purchIte1));
		p1.getItems().addAll(Arrays.asList(purchIte3));
		p1.getItems().addAll(Arrays.asList(purchIte2));

		purchaseItemRepository.saveAll(Arrays.asList(purchIte1, purchIte2, purchIte3));

	}

}
