package com.example.workshop.service;

import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    public double aplicarDescuento(double precio, double porcentajeDescuento) {
        if (precio < 0 || porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("Valores de precio o descuento inválidos");
        }
        return precio - (precio * (porcentajeDescuento / 100.0));
    }

    public double calcularImpuesto(double precio, double porcentajeIva) {
        if (precio < 0 || porcentajeIva < 0) {
            throw new IllegalArgumentException("Valores inválidos para impuesto");
        }
        return precio + (precio * (porcentajeIva / 100.0));
    }

    public String obtenerMensaje() {
        return "Bienvenido a la API de Taller CI/CD";
    }
}
