package com.example.workshop.controller;

import com.example.workshop.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/saludo")
    public ResponseEntity<Map<String, String>> saludo() {
        Map<String, String> response = new HashMap<>();
        response.put("mensaje", productoService.obtenerMensaje());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/descuento")
    public ResponseEntity<Map<String, Object>> calcularDescuento(
            @RequestParam double precio,
            @RequestParam double porcentaje) {
        double resultado = productoService.aplicarDescuento(precio, porcentaje);
        Map<String, Object> response = new HashMap<>();
        response.put("precioOriginal", precio);
        response.put("descuento", porcentaje);
        response.put("precioFinal", resultado);
        return ResponseEntity.ok(response);
    }
}
