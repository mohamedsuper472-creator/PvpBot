package com.stashes.pvpbot;

import java.io.InputStream;
import java.nio.file.*;

/** Copies bundled default data files to config/pvpbot on first run. */
public final class Defaults {
    private static final String[][] FILES = {
        {"/data/pvpbot/defaults/config.yml", "config.yml"},
        {"/data/pvpbot/defaults/messages.yml", "messages.yml"},
        {"/data/pvpbot/defaults/skin-pool.txt", "skin-pool.txt"},
        {"/assets/pvpbot/lang/en.yml", "lang/en.yml"},
        {"/assets/pvpbot/lang/it.yml", "lang/it.yml"},
    };
    public static void copyIfMissing(Path dir) {
        for (String[] f : FILES) {
            Path out = dir.resolve(f[1]);
            if (Files.exists(out)) continue;
            try (InputStream in = Defaults.class.getResourceAsStream(f[0])) {
                Files.createDirectories(out.getParent());
                Files.copy(in, out);
            } catch (Exception e) { PvpBotMod.LOG.error("copy " + f[1], e); }
        }
    }
}
