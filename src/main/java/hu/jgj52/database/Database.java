package hu.jgj52.database;

import org.bukkit.plugin.java.JavaPlugin;

public final class Database extends JavaPlugin {

    public static PostgreSQL postgres;
    public static Redis redis;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveConfig();
        try {
            postgres = new PostgreSQL(
                    getConfig().getString("postgresql.host"),
                    getConfig().getInt("postgresql.port"),
                    getConfig().getString("postgresql.database"),
                    getConfig().getString("postgresql.user"),
                    getConfig().getString("postgresql.password")
            );
            getLogger().info("§aPostgreSQL successfully connected!");
        } catch (Exception e) {
            getLogger().warning("§ePostgreSQL failed to connect!");
        }
        try {
            redis = new Redis(
                    getConfig().getString("redis.host"),
                    getConfig().getInt("redis.port"),
                    getConfig().getString("redis.password")
            );
            getLogger().info("§aRedis successfully connected!");
        } catch (Exception e) {
            getLogger().warning("§eRedis failed to connect!");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
