package de.artemis.laboratoryblocks.common.data;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import de.artemis.laboratoryblocks.common.registration.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.neoforged.neoforge.client.model.generators.ItemModelProvider {
    public ItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, LaboratoryBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.STARCH.get());
        simpleItem(ModItems.COMPRESSED_STARCH.get());
        simpleItem(ModItems.PLA_SHEETS.get());
        simpleItem(ModItems.IRON_SCREW.get());
        simpleItem(ModItems.CONFIGURATION_TOOL.get());

        simpleBlock(ModBlocks.PLA_BLOCK.get());
        simpleBlock(ModBlocks.PLA_TILES.get());
        simpleBlock(ModBlocks.LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.LABORATORY_TILES.get());
        simpleBlock(ModBlocks.GRAY_LABORATORY_TILES.get());
        simpleBlock(ModBlocks.MIXED_LABORATORY_TILES.get());
        simpleBlock(ModBlocks.LABORATORY_GLASS.get());
        simpleBlock(ModBlocks.LABORATORY_FAN.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.LABORATORY_FAN_REDSTONE_CONTROLLED.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_fan_redstone_controlled"));
        simpleBlock(ModBlocks.SCREWED_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.LABORATORY_VENT.get());
        cubeAll(BuiltInRegistries.BLOCK.getKey(ModBlocks.LABORATORY_VENT_CONNECTING.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_vent"));
        simpleBlock(ModBlocks.CLEAR_LABORATORY_SCREEN.get());

        simpleBlock(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get());

        simpleBlock(ModBlocks.LABORATORY_PILLAR.get());
        simpleBlock(ModBlocks.GRAY_LABORATORY_PILLAR.get());
        simpleBlock(ModBlocks.LABORATORY_BOOKSHELF.get());

        carpet(BuiltInRegistries.BLOCK.getKey(ModBlocks.PLA_FLOORING.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/pla_block"));
        carpet(BuiltInRegistries.BLOCK.getKey(ModBlocks.TILED_PLA_FLOORING.get()).toString(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/pla_tiles"));
    }

    private void simpleItem(Item item) {
        withExistingParent(DataProvider.getRegistryName(item), "item/generated").texture("layer0", ResourceLocation.fromNamespaceAndPath(this.modid, "item/" +
                DataProvider.getRawRegistryName(item)));
    }

    private void simpleBlock(Block block) {
        withExistingParent(DataProvider.getRegistryName(block), ResourceLocation.fromNamespaceAndPath(this.modid, "block/" + DataProvider.getRawRegistryName(block)));
    }
}
