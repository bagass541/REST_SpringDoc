package com.bagas.REST_SpringDoc;

import java.util.stream.Collectors;

import org.aspectj.weaver.ast.Or;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class OrderController {

	private final OrderRepository orderRepository;
	private final OrderModelAssembler assembler;
	
	@GetMapping("/orders")
	CollectionModel<EntityModel<Order>> all()
	{
		List<EntityModel<Order>> orders = orderRepository.findAll().stream()
				.map(assembler::toModel)
				.collect(Collectors.toList());
		
		return CollectionModel.of(orders, 
				linkTo(methodOn(OrderController.class).all()).withSelfRel());
	}
	
	@GetMapping("/orders/{id}")
	EntityModel<Order> one(@PathVariable Long id)
	{
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new OrderNotFoundExceoption(id));
		
		return assembler.toModel(order);
	}
	
	@PostMapping("/orders")
	ResponseEntity<EntityModel<Order>> newOrder(@RequestBody Order order)
	{
		
		order.setStatus(Status.IN_PROGRESS);
		Order newOrder = orderRepository.save(order);
		
		return ResponseEntity
				.created(linkTo(methodOn(OrderController.class).one(newOrder.getId())).toUri())
				.body(assembler.toModel(newOrder));
	}
	
}

