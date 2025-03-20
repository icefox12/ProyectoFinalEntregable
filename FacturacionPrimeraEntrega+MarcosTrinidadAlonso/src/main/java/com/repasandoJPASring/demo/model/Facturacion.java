package com.repasandoJPASring.demo.model;


import java.util.List;

public class Facturacion {
    private Cliente cliente;
    private List<Linea> lineas;

    // Getters y Setters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    public static class Cliente {
        private int clienteid;

        // Getters y Setters
        public int getClienteid() {
            return clienteid;
        }

        public void setClienteid(int clienteid) {
            this.clienteid = clienteid;
        }
    }

    public static class Linea {
        private int cantidad;
        private Producto producto;

        // Getters y Setters
        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }
    }

    public static class Producto {
        private int productoid;


        public int getProductoid() {
            return productoid;
        }

        public void setProductoid(int productoid) {
            this.productoid = productoid;
        }
    }
}