package com.stashes.pvpbot.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import static net.minecraft.commands.Commands.literal;

/** TODO: port BotCommand: spawn|remove|list|attack|stop|settings|reload|stats ... Permission pvpbot.admin = op level 2. */
public final class PvpBotCommand {
    public static void register(CommandDispatcher<CommandSourceStack> d) {
        var root = d.register(literal("pvpbot").requires(s -> true));
        d.register(literal("bot").redirect(root));
    }
}
