package com.ciq.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ciq.entity.Product;
import com.ciq.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.callbacks.Callback;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Operation(summary = "Create item with callback")
	@Callback(name = "onItemEvent", callbackUrlExpression = "{$request.body#/callbackUrl}", operation = {
			@Operation(summary = "Callback operation") })

	@ApiResponse(description = "Callback response", responseCode = "200")

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product newProduct = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
	}

	@ApiResponse(responseCode = "200", description = "Successful operation", headers = @Header(name = "X-Example-Header", description = "An example header", required = true))
	@GetMapping("/header-example" + "/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = productService.getProductById(id);
		return ResponseEntity.ok(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product updatedProduct = productService.updateProduct(id, productDetails);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
