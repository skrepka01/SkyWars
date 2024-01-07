package ry.skywars.model;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Commands {

    private long id; // id Арены ,которой принадлежит команда
    private int quantity; // количество игроков в команде
    private String name; // название Комнады
    private Material material; // Предмет,который визуализирует команду

    public Commands(){}

    public Commands(long id,int quantity, String name, Material material){
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.material = material;

    }

    public Commands(int quantity, String name, Material material) {
        this.quantity = quantity;
        this.name = name;
        this.material = material;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
