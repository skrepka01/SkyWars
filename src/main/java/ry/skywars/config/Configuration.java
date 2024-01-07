package ry.skywars.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Configuration {

    private static File file;
    private static FileConfiguration configuration;

   public static void loadConfig(Plugin plugin){
       file = new File(plugin.getDataFolder(), "SkyWars.yml");
       if (!file.exists())
       {
           plugin.getDataFolder().mkdir();
           try {
               file.createNewFile();
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
           plugin.saveResource("SkyWars.yml",true);
       }
       configuration = YamlConfiguration.loadConfiguration(file);
   }

   public static FileConfiguration get()
   {
       return configuration;
   }
}
