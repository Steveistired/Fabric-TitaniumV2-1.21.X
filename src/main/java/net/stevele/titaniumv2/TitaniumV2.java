package net.stevele.titaniumv2;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.stevele.titaniumv2.block.ModBlocks;
import net.stevele.titaniumv2.item.ModItemGroups;
import net.stevele.titaniumv2.item.ModItems;
//import net.stevele.titaniumv2.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TitaniumV2 implements ModInitializer {
	public static final String MOD_ID = "titanium-v2";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		//ModWorldGeneration.generateModWorldGen();

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH,5, factories -> {
			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD_BLOCK, 5),
					new ItemStack(ModItems.TITANIUM_INGOT,1), 3, 5, 0.04f));

			factories.add((entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND_BLOCK, 8),
					new ItemStack(ModItems.TITANIUM_INGOT,1), 3, 5, 0.04f));
		});

			TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER,5, factories -> {
				factories.add((entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD_BLOCK, 5),
						new ItemStack(ModItems.TITANIUM_INGOT,1), 3, 5, 0.04f));

				factories.add((entity, random) -> new TradeOffer(
						new TradedItem(Items.DIAMOND_BLOCK, 8),
						new ItemStack(ModItems.TITANIUM_INGOT,1), 3, 5, 0.04f));
		});



	}
}