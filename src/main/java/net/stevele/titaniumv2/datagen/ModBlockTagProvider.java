package net.stevele.titaniumv2.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.stevele.titaniumv2.block.ModBlocks;
import net.stevele.titaniumv2.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.TITANIUM_BLOCK)
                .add(ModBlocks.RAW_TITANIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TITANIUM_BLOCK)
                .add(ModBlocks.RAW_TITANIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_TITANIUM_ORE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_TITANIUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}
