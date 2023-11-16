package de.cooltechno.tiertagger.events;

import de.cooltechno.tiertagger.TierTagger;
import de.cooltechno.tiertagger.mctiers.GetTier;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.awt.*;

public class listener_Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = (Player) event.getPlayer();
        String tier = new GetTier().getTier(player.getUniqueId());

        String displayTier;
        Color tierColor = null;

        switch (tier) {
            case "LT5":
                tierColor = Color.decode("#49485d");
                break;
            case "HT5":
                tierColor = Color.decode("#2d2d39");
                break;
            case "LT4":
                tierColor = Color.decode("#e839ff");
                break;
            case "HT4":
                tierColor = Color.decode("#DA1DFF");
                break;
            case "LT3":
                tierColor = Color.decode("#73abff");
                break;
            case "HT3":
                tierColor = Color.decode("#3988FF");
                break;
            case "LT2":
                tierColor = Color.decode("#FF883f");
                break;
            case "HT2":
                tierColor = Color.decode("#FCA801");
                break;
            case "LT1":
                tierColor = Color.decode("#FF4747");
                break;
            case "HT1":
                tierColor = Color.decode("#FF3939");
                break;
        }

        displayTier =  tier;

        if (!(tier == "User not found")) {
                TierTagger.plugin.setCustomName(player,displayTier);
        }else {
            TierTagger.plugin.setCustomName(player,ChatColor.GRAY + "?");
        }
    }



}
