package de.cooltechno.tiertagger;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.PlayerInfoData;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import com.comphenix.protocol.wrappers.WrappedGameProfile;
import de.cooltechno.tiertagger.events.listener_Join;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;


public final class TierTagger extends JavaPlugin {

    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

    public static TierTagger plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new listener_Join(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static TierTagger getPlugin() {
        return plugin;
    }


    public void setCustomName(Player player, String Tier) {
        Bukkit.dispatchCommand(console, "tab player " + player.getName() + " tagsuffix &l ["+Tier+"]");
    }


    }


