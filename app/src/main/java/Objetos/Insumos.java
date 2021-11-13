package Objetos;

public class Insumos {

    private int id;
    private int stock;
    private String[] insumos = {"Baraja poker", "Sobres de cartas Pokémon", "Sobres de cartas yu gi oh", "Juego de mesa"};
    private int[] precios = {1000, 500, 800, 2000};

    public Insumos(){

    }

    public Insumos(int id, int stock, String[] insumos, int[] precios) {
        this.id = id;
        this.stock = stock;
        this.insumos = insumos;
        this.precios = precios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String[] getInsumos() {
        return insumos;
    }

    public void setInsumos(String[] insumos) {
        this.insumos = insumos;
    }

    public int[] getPrecios() {
        return precios;
    }

    public void setPrecios(int[] precios) {
        this.precios = precios;
    }


    public int agregarAdicional(int precio, int adicional){
        return precio + adicional;
    }
}
