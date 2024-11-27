package de.artemis.laboratoryblocks.common.data;

import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import de.artemis.laboratoryblocks.common.registration.ModItems;
import de.artemis.laboratoryblocks.common.registration.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider {

    protected BlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PLA_BLOCK.get());
        dropSelf(ModBlocks.PLA_TILES.get());
        dropSelf(ModBlocks.PLA_FLOORING.get());
        dropSelf(ModBlocks.TILED_PLA_FLOORING.get());
        dropSelf(ModBlocks.LABORATORY_BLOCK.get());
        dropSelf(ModBlocks.LABORATORY_TILES.get());
        dropSelf(ModBlocks.GRAY_LABORATORY_TILES.get());
        dropSelf(ModBlocks.MIXED_LABORATORY_TILES.get());
        dropSelf(ModBlocks.LABORATORY_VENT.get());
        dropSelf(ModBlocks.LABORATORY_VENT_CONNECTING.get());
        dropSelf(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get());
        dropSelf(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get());
        dropSelf(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get());
        dropSelf(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get());
        dropSelf(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get());
        dropSelf(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get());
        dropSelf(ModBlocks.LABORATORY_FAN.get());
        dropSelf(ModBlocks.SCREWED_LABORATORY_BLOCK.get());
        dropSelf(ModBlocks.CLEAR_LABORATORY_SCREEN.get());
        dropSelf(ModBlocks.LABORATORY_PILLAR.get());
        dropSelf(ModBlocks.GRAY_LABORATORY_PILLAR.get());
        dropSelf(ModBlocks.LABORATORY_FAN_REDSTONE_CONTROLLED.get());

        dropWhenSilkTouch(ModBlocks.LABORATORY_GLASS.get());
        dropWhenSilkTouch(ModBlocks.LABORATORY_BOOKSHELF.get());
        add(ModBlocks.LABORATORY_BOOKSHELF.get(), (p_124233_) -> {
            return createSingleItemTableWithSilkTouch(p_124233_, Items.BOOK, ConstantValue.exactly(3.0F));
        });
    }

    @Override
    @NotNull
    protected Iterable<Block> getKnownBlocks() {
        return Registration.BLOCKS.getEntries()
                .stream()
                .filter(holder -> holder != ModBlocks.CHISELED_LABORATORY_BOOKSHELF)
                .map(DeferredHolder::value)
                .map(block -> (Block) block)
                .toList();
    }
}
