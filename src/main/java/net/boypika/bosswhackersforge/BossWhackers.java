package net.boypika.bosswhackersforge;

import net.boypika.bosswhackersforge.sword.DragonWhacker;
import net.boypika.bosswhackersforge.sword.WardenWhacker;
import net.boypika.bosswhackersforge.sword.WitherWhacker;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(BossWhackers.MODID)
public class BossWhackers {
    public static final String MODID = "boss_whackers";
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<SwordItem> WITHER = ITEMS.register("wither_whacker", () -> new WitherWhacker(Tiers.DIAMOND, -3, -3.5f, new Item.Properties()));
    public static final RegistryObject<SwordItem> DRAGON = ITEMS.register("dragon_whacker", () -> new DragonWhacker(Tiers.NETHERITE, -4, -3.5f, new Item.Properties()));
    public static final RegistryObject<SwordItem> WARDEN = ITEMS.register("warden_whacker", () -> new WardenWhacker(Tiers.NETHERITE, -4, -3.5f, new Item.Properties()));

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> HEARTS = CREATIVE_MODE_TABS.register("hearts",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(WITHER.get()))
                    .title(Component.translatable("creativetab.whackers"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(WITHER.get());
                        pOutput.accept(DRAGON.get());
                        pOutput.accept(WARDEN.get());
                    })
                    .build());

    public BossWhackers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
