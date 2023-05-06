package dev.rickyshd.simpleconfig;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * A better abstraction of default {@link org.bukkit.configuration.file.YamlConfiguration}
 * included with Bukkit-like plugins.
 * @since 1.0
 */
public interface Config extends Configuration, ConfigurationSection {
    /**
     * Creates a new configuration file reference.
     * @param plugin the {@link JavaPlugin} the config file belongs to.
     * @param filename the filename of the config file. It does not need to include the extension
     * @return a new configuration file reference.
     * @since 1.0
     */
    static @NotNull Config of(final JavaPlugin plugin, final String filename) {
        String _filename = filename;
        if (!_filename.endsWith(".yml")) _filename += ".yml";

        return new ConfigImpl(_filename, plugin);
    }

    /**
     * Reloads the configuration file from the disk.
     * @since 1.0
     */
    void reload();

    /**
     * Saves the configuration file to the disk.
     * @since 1.0
     */
    void save();

    /**
     * Saves the default configuration file included with the plugin to disk.
     * If it does not exist, then no file is created.
     * @return true on file created, false otherwise.
     * @since 1.0
     */
    boolean saveDefault();
}
