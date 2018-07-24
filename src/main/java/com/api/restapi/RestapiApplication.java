package com.api.restapi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.restapi.domain.Address;
import com.api.restapi.domain.CardPayment;
import com.api.restapi.domain.Category;
import com.api.restapi.domain.City;
import com.api.restapi.domain.Client;
import com.api.restapi.domain.Order;
import com.api.restapi.domain.Payment;
import com.api.restapi.domain.Product;
import com.api.restapi.domain.State;
import com.api.restapi.domain.TicketPayment;
import com.api.restapi.domain.enums.ClientType;
import com.api.restapi.domain.enums.PaymentState;
import com.api.restapi.repositories.AddressRepository;
import com.api.restapi.repositories.CategoryRepository;
import com.api.restapi.repositories.CityRepository;
import com.api.restapi.repositories.ClientRepository;
import com.api.restapi.repositories.OrderRepository;
import com.api.restapi.repositories.PaymentRepository;
import com.api.restapi.repositories.ProductRepository;
import com.api.restapi.repositories.StateRepository;

@SpringBootApplication
public class RestapiApplication implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoriaRepository;
	
	@Autowired
	private ProductRepository produtoRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Info");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
		
		State st1 = new State(null, "Minas");
		State st2 = new State(null, "Sampa");
		
		City c1 = new City(null, "Uberlandia", st1);
		City c2 = new City(null, "Sampa", st2);
		City c3 = new City(null, "Campinas", st2);
		
		st1.getCities().addAll(Arrays.asList(c1));
		st2.getCities().addAll(Arrays.asList(c2, c3));
		
		stateRepository.save(Arrays.asList(st1, st2));
		cityRepository.save(Arrays.asList(c1, c2, c3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "19876546752", ClientType.PESSOAFISICA);
		
		cli1.getPhones().addAll(Arrays.asList("86785764", "98756745"));
		
		Address a1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Address a2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getAdresses().addAll(Arrays.asList(a1, a2));
		
		clientRepository.save(Arrays.asList(cli1));
		addressRepository.save(Arrays.asList(a1, a2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Order ped1 = new Order(null, sdf.parse("30/09/2017 10:32"), cli1, a1);
		Order ped2 = new Order(null, sdf.parse("10/10/2017 19:35"), cli1, a2);
		
		Payment paym1 = new CardPayment(null, PaymentState.SETTLED, ped1, 6);
		ped1.setPayment(paym1);
		
		Payment paym2 = new TicketPayment(null, PaymentState.PENDING, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPayment(paym2);
		
		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));

		orderRepository.save(Arrays.asList(ped1, ped2));
		paymentRepository.save(Arrays.asList(paym1, paym2));
		
		
		
		
	}
	
}
