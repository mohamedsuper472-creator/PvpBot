# PvpBot -> Fabric 1.21.11 (skeleton)

Included: all data (config.yml, messages.yml, lang/*, skin-pool.txt), Fabric project, entrypoint, command stubs.
NOT ported: bot logic (~250 classes in `original-plugin-classes/`, compiled Paper plugin).

## Plan
1. Decompile `original-plugin-classes` (Vineflower/CFR) to read the logic (or get the real source from the GitHub in plugin.yml).
2. `nms/*` (FakePlayer, BotPlayer, NmsBridge, SilentConnection) -> server-side fake ServerPlayer (see Carpet's EntityPlayerMPFake). Mojang mappings = same names as Paper NMS.
3. `bot/*` -> mostly Bukkit API calls -> replace with Minecraft classes (ServerLevel, ItemStack, ...).
4. `gui/*` (inventory menus) -> ChestMenu/SimpleContainer. Events (BotListener) -> Fabric API events/mixins.
5. YAML: add snakeyaml (jar-in-jar) to read config.yml.
6. Check versions in gradle.properties at https://fabricmc.net/develop (loom/loader/api).
