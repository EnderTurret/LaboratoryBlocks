package de.artemis.laboratoryblocks.common.data;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import de.artemis.laboratoryblocks.common.registration.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class TagsProvider {
    public static class BlockTagsProvider extends net.minecraft.data.tags.TagsProvider<Block> {
        private final PackOutput packOutput;

        protected BlockTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, ExistingFileHelper existingFileHelper) {
            super(packOutput, Registries.BLOCK, future, LaboratoryBlocks.MOD_ID, existingFileHelper);
            this.packOutput = packOutput;
        }

        @Override
        protected void addTags(@NotNull HolderLookup.Provider provider) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(getKey(ModBlocks.LABORATORY_VENT_CONNECTING.get()), getKey(ModBlocks.LABORATORY_FAN_REDSTONE_CONTROLLED.get()), getKey(ModBlocks.LABORATORY_BLOCK.get()), getKey(ModBlocks.LABORATORY_TILES.get()), getKey(ModBlocks.GRAY_LABORATORY_TILES.get()), getKey(ModBlocks.MIXED_LABORATORY_TILES.get()), getKey(ModBlocks.LABORATORY_VENT.get()), getKey(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get()), getKey(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get()), getKey(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get()), getKey(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get()), getKey(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get()), getKey(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get()), getKey(ModBlocks.LABORATORY_FAN.get()), getKey(ModBlocks.SCREWED_LABORATORY_BLOCK.get()), getKey(ModBlocks.CLEAR_LABORATORY_SCREEN.get()), getKey(ModBlocks.LABORATORY_PILLAR.get()), getKey(ModBlocks.GRAY_LABORATORY_PILLAR.get()), getKey(ModBlocks.LABORATORY_BOOKSHELF.get()), getKey(ModBlocks.CHISELED_LABORATORY_BOOKSHELF.get()));
            tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(getKey(ModBlocks.LABORATORY_BOOKSHELF.get()));
        }

        private ResourceKey<Block> getKey(Block block) {
            return BuiltInRegistries.BLOCK.getResourceKey(block).get();
        }

        @NotNull
        @Override
        protected Path getPath(ResourceLocation location) {
            return this.packOutput.getOutputFolder().resolve("data/" + location.getNamespace() + "/tags/block/" + location.getPath() + ".json");
        }

        @NotNull
        @Override
        public String getName() {
            return "Block tags";
        }
    }

    public static class ItemTagsProvider extends net.minecraft.data.tags.TagsProvider<Item> {
        private final PackOutput packOutput;

        protected ItemTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future, ExistingFileHelper existingFileHelper) {
            super(packOutput, Registries.ITEM, future, LaboratoryBlocks.MOD_ID, existingFileHelper);
            this.packOutput = packOutput;
        }

        @Override
        protected void addTags(@NotNull HolderLookup.Provider provider) {
            tag(ModTags.Item.STARCH_INGREDIENT).add(getKey(Items.SUGAR_CANE), getKey(Items.BEETROOT), getKey(Items.SUGAR), getKey(Items.WHEAT));
        }

        private ResourceKey<Item> getKey(Item item) {
            return BuiltInRegistries.ITEM.getResourceKey(item).get();
        }

        @NotNull
        @Override
        protected Path getPath(ResourceLocation location) {
            return this.packOutput.getOutputFolder().resolve("data/" + location.getNamespace() + "/tags/item/" + location.getPath() + ".json");
        }

        @NotNull
        @Override
        public String getName() {
            return "Item tags";
        }
    }
}
