package dev.rickyshd;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

final class ConfigImpl extends YamlConfiguration implements Config {
    private File configFile;
    private final String filename;
    private final JavaPlugin plugin;

    ConfigImpl(String file, JavaPlugin plugin) {
        this.plugin = plugin;
        this.filename = file;

        saveDefault();
        reload();
    }

    @Override
    public void reload() {
        if (configFile == null)
            configFile = new File(plugin.getDataFolder(), filename);

        try {
            load(configFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        try {
            Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(plugin.getResource(filename)), StandardCharsets.UTF_8);
            YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
            setDefaults(defConfig);

            defConfigStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        if (configFile == null)
            configFile = new File(plugin.getDataFolder(), filename);

        try {
            super.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean saveDefault() {
        if (configFile == null)
            configFile = new File(plugin.getDataFolder(), filename);
        if (!configFile.exists() && (plugin.getResource(filename) != null)) {
            plugin.saveResource(filename, false);
            return true;
        } else {
            return false;
        }
    }
}
