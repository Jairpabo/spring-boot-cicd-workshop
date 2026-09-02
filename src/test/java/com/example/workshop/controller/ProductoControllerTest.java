package com.example.workshop.controller;

import com.example.workshop.service.ProductoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.HashMap;
import java.util.Map;

@WebMvcTest(ProductoController.class)
class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductoService productoService;

    @Test
    @DisplayName("GET /api/productos/saludo - Debe retornar 200 OK y mensaje")
    void debeRetornarMensajeSaludo() throws Exception {
        when(productoService.obtenerMensaje()).thenReturn("Bienvenido a la API de Taller CI/CD");

        mockMvc.perform(get("/api/productos/saludo")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.mensaje").value("Bienvenido a la API de Taller CI/CD"));
    }

    @Test
    @DisplayName("GET /api/productos/descuento - Debe retornar 200 OK y cálculo")
    void debeCalcularDescuentoEnEndpoint() throws Exception {
        when(productoService.aplicarDescuento(100.0, 10.0)).thenReturn(90.0);

        mockMvc.perform(get("/api/productos/descuento")
                .param("precio", "100.0")
                .param("porcentaje", "10.0")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.precioFinal").value(90.0));
    }
     @GetMapping("/estado")
 public ResponseEntity<Map<String, String>> estadoServicio() {
     Map<String, String> status = new HashMap<>();
     status.put("estado", "ACTIVO");
     status.put("version", "1.0.0");
     return ResponseEntity.ok(status);
 }
}
