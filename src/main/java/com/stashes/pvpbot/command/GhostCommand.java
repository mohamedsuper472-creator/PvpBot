package com.stashes.pvpbot.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import static net.minecraft.commands.Commands.literal;

/** TODO: port GhostCommand: record|stoprecord|spawn|stare|remove|list|recordings. */
public final class GhostCommand {
    public static void register(CommandDispatcher<CommandSourceStack> d) {
        d.register(literal("ghost"));
    }
}
