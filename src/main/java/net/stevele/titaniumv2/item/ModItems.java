package net.stevele.titaniumv2.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.stevele.titaniumv2.TitaniumV2;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

//Create stats for items

public class ModItems {
    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot", new Item(new Item.Settings()));
    public static final Item RAW_TITANIUM = registerItem("raw_titanium", new Item(new Item.Settings()));

    public static final Item TITANIUM_SWORD = registerItem("titanium_sword",
            new SwordItem(ModToolMaterials.TITANIUM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TITANIUM, 3, -2.4f))));
    public static final Item TITANIUM_PICKAXE = registerItem("titanium_pickaxe",
            new PickaxeItem(ModToolMaterials.TITANIUM, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TITANIUM, 1, -2.8f))));
    public static final Item TITANIUM_SHOVEL = registerItem("titanium_shovel",
            new ShovelItem(ModToolMaterials.TITANIUM, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TITANIUM, 3.5f, -3.0f))));
    public static final Item TITANIUM_AXE = registerItem("titanium_axe",
            new AxeItem(ModToolMaterials.TITANIUM, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TITANIUM, 6, -3.2f))));
    public static final Item TITANIUM_HOE = registerItem("titanium_hoe",
            new HoeItem(ModToolMaterials.TITANIUM, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TITANIUM, 0, -3f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TitaniumV2.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TitaniumV2.LOGGER.info("Registering Mod Items for " + TitaniumV2.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(TITANIUM_INGOT);
            fabricItemGroupEntries.add(RAW_TITANIUM);
        });

    }
}
