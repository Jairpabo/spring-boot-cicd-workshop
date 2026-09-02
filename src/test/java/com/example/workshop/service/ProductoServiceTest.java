package com.example.workshop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoServiceTest {

    private ProductoService productoService;

    @BeforeEach
    void setUp() {
        productoService = new ProductoService();
    }

    @Test
    @DisplayName("Debe calcular correctamente el precio con descuento")
    void debeCalcularPrecioConDescuento() {
        double resultado = productoService.aplicarDescuento(100.0, 10.0);
        assertEquals(999.0, resultado, 0.001);
    }

    @Test
    @DisplayName("Debe lanzar excepción si el porcentaje de descuento es negativo")
    void debeLanzarExcepcionConDescuentoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            productoService.aplicarDescuento(100.0, -5.0);
        });
    }

    @Test
    @DisplayName("Debe calcular correctamente el impuesto")
    void debeCalcularImpuesto() {
        double resultado = productoService.calcularImpuesto(100.0, 19.0);
        assertEquals(119.0, resultado, 0.001);
    }
}
