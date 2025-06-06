package net.stevele.titaniumv2.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.stevele.titaniumv2.TitaniumV2;
import net.stevele.titaniumv2.block.ModBlocks;

//Group items together in a custom Creative mode tab

public class ModItemGroups {
    public static final ItemGroup TITANIUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TitaniumV2.MOD_ID, "titanium_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.TITANIUM_INGOT))
                    .displayName(Text.translatable("itemgroup.titanium-v2.titanium_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TITANIUM_INGOT);
                        entries.add(ModItems.RAW_TITANIUM);

                        entries.add(ModItems.TITANIUM_SWORD);
                        entries.add(ModItems.TITANIUM_PICKAXE);
                        entries.add(ModItems.TITANIUM_SHOVEL);
                        entries.add(ModItems.TITANIUM_AXE);
                        entries.add(ModItems.TITANIUM_HOE);
                    }).build());

    public static final ItemGroup TITANIUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TitaniumV2.MOD_ID, "titanium_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.TITANIUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.titanium-v2.titanium_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.TITANIUM_BLOCK);
                        entries.add(ModBlocks.RAW_TITANIUM_BLOCK);
                        entries.add(ModBlocks.DEEPSLATE_TITANIUM_ORE);
                    }).build());


    public static void registerItemGroups() {
        TitaniumV2.LOGGER.info("Registering Item Groups for " + TitaniumV2.MOD_ID);
    }
}
