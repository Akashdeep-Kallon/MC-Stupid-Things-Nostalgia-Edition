package AkaH.stupidThings.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;

public class ModConfig {
    public static final ForgeConfigSpec.BooleanValue ENABLE_CHAOS;
    public static final ForgeConfigSpec COMMON_CONFIG;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();
        b.push("general");
        ENABLE_CHAOS = b.comment("Enable chaotic item effects.").define("enableChaos", true);
        b.pop();
        COMMON_CONFIG = b.build();
    }

    public static void register(ModLoadingContext context) {
        context.registerConfig(Type.COMMON, COMMON_CONFIG);
    }
}
