package net.stevele.titaniumv2.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.stevele.titaniumv2.block.ModBlocks;
import net.stevele.titaniumv2.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> TITANIUM_INGOT_SMELTABLES = List.of(ModItems.RAW_TITANIUM, ModBlocks.DEEPSLATE_TITANIUM_ORE);

        offerSmelting(recipeExporter, TITANIUM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT, 1, 600, "titanium_ingot");
        offerBlasting(recipeExporter, TITANIUM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT, 1, 300, "titanium_ingot");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TITANIUM_INGOT, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TITANIUM_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TITANIUM, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_TITANIUM_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TITANIUM_INGOT, 9)
                .input(ModBlocks.TITANIUM_BLOCK)
                .criterion(hasItem(ModBlocks.TITANIUM_BLOCK), conditionsFromItem(ModBlocks.TITANIUM_BLOCK))
                .offerTo(recipeExporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_TITANIUM, 9)
                .input(ModBlocks.RAW_TITANIUM_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_TITANIUM_BLOCK), conditionsFromItem(ModBlocks.RAW_TITANIUM_BLOCK))
                .offerTo(recipeExporter);

        //Crafting recipe for tools didn't worked and I can't find the solution despite looking everywhere
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.TITANIUM_SWORD)
                .pattern(" T ")
                .pattern(" T ")
                .pattern(" S ")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_PICKAXE)
                .pattern("TTT")
                .pattern(" S ")
                .pattern(" S ")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_SHOVEL)
                .pattern(" T ")
                .pattern(" S ")
                .pattern(" S ")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_AXE)
                .pattern("TT ")
                .pattern("TS ")
                .pattern(" S ")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.TITANIUM_HOE)
                .pattern("TT ")
                .pattern(" S ")
                .pattern(" S ")
                .input('T', ModItems.TITANIUM_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.TITANIUM_INGOT), conditionsFromItem(ModItems.TITANIUM_INGOT))
                .offerTo(recipeExporter);

    }
}
