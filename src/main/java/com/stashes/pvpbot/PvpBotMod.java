package com.stashes.pvpbot;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

/** Fabric entrypoint. Port of PvpBotPlugin (Paper). See PORTING.md. */
public class PvpBotMod implements ModInitializer {
    public static final String ID = "pvpbot";
    public static final Logger LOG = LoggerFactory.getLogger(ID);
    public static Path configDir;

    @Override
    public void onInitialize() {
        configDir = FabricLoader.getInstance().getConfigDir().resolve(ID);
        Defaults.copyIfMissing(configDir); // config.yml, messages.yml, skin-pool.txt, lang/*
        CommandRegistrationCallback.EVENT.register((dispatcher, registry, env) -> {
            com.stashes.pvpbot.command.PvpBotCommand.register(dispatcher); // /pvpbot, /bot
            com.stashes.pvpbot.command.GhostCommand.register(dispatcher);  // /ghost
        });
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            // TODO: BotManager.tick(server)  (was BotTicker in the plugin)
        });
        LOG.info("PvpBot loaded (skeleton)");
    }
}
