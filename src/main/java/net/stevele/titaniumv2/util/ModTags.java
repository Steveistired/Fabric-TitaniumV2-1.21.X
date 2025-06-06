package net.stevele.titaniumv2.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.stevele.titaniumv2.TitaniumV2;

//Generate tags for modded items

public class ModTags {
        public static class Blocks {
            public static final TagKey<Block> NEEDS_TITANIUM_TOOL = createTag("needs_titanium_tool");
            public static final TagKey<Block> INCORRECT_FOR_TITANIUM_TOOL = createTag("incorrect_for_titanium_tool");

            private static TagKey<Block> createTag(String name) {
                return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TitaniumV2.MOD_ID, name));
            }
        }

        public static class Items {
            public static final TagKey<Item> TITANIUM_ITEMS = createTag("titanium_items");

            private static TagKey<Item> createTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, Identifier.of(TitaniumV2.MOD_ID, name));

            }
        }
}
