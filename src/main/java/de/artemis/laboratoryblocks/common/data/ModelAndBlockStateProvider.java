package de.artemis.laboratoryblocks.common.data;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModelAndBlockStateProvider extends BlockStateProvider {
    public ModelAndBlockStateProvider(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, LaboratoryBlocks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.LABORATORY_TILES.get());
        simpleBlock(ModBlocks.GRAY_LABORATORY_TILES.get());
        simpleBlock(ModBlocks.MIXED_LABORATORY_TILES.get());

        simpleBlock(ModBlocks.LABORATORY_FAN.get());
        simpleBlock(ModBlocks.SCREWED_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.LABORATORY_VENT.get());
        simpleBlock(ModBlocks.LABORATORY_VENT_CONNECTING.get());
        simpleBlock(ModBlocks.CLEAR_LABORATORY_SCREEN.get());
        simpleBlock(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get());
        simpleBlock(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get());

        simpleBlockWithRenderType(ModBlocks.LABORATORY_GLASS.get(), "cutout");

        simpleBlock(ModBlocks.PLA_BLOCK.get());
        simpleBlock(ModBlocks.PLA_TILES.get());

        pillarBlock(ModBlocks.LABORATORY_PILLAR.get(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_pillar"), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_pillar_top"));
        pillarBlock(ModBlocks.GRAY_LABORATORY_PILLAR.get(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/gray_laboratory_pillar"), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/gray_laboratory_pillar_top"));
        pillarBlock(ModBlocks.LABORATORY_BOOKSHELF.get(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_bookshelf"), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_bookshelf_top"));

        carpetBlock(ModBlocks.PLA_FLOORING.get(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/pla_block"));
        carpetBlock(ModBlocks.TILED_PLA_FLOORING.get(), ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/pla_tiles"));
    }

    public void block(Block block, ResourceLocation texture) {
        simpleBlock(block, models().withExistingParent(BuiltInRegistries.BLOCK.getKey(block).toString(), ResourceLocation.withDefaultNamespace("block/cube_all"))
                .texture("all", texture));
    }

    public void simpleBlockWithRenderType(Block block, String renderType) {
        simpleBlock(block, cubeAllWithRenderType(block, renderType));
    }

    public ModelFile cubeAllWithRenderType(Block block, String renderType) {
        return models().cubeAll(BuiltInRegistries.BLOCK.getKey(block).toString(), blockTexture(block)).renderType(renderType);
    }

    public void blockWithRenderType(Block block, ResourceLocation texture, String renderType) {
        simpleBlock(block, models().withExistingParent(BuiltInRegistries.BLOCK.getKey(block).toString(), ResourceLocation.withDefaultNamespace("block/cube_all"))
                .texture("all", texture).renderType(renderType));
    }

    public void pillarBlock(Block block, ResourceLocation texture_side, ResourceLocation texture_top) {
        ModelFile block_model = models().withExistingParent(DataProvider.getRegistryName(block.asItem()), "block/cube_column").texture("side", texture_side).texture("end", texture_top);
        getVariantBuilder(block).partialState().setModels(ConfiguredModel.builder().modelFile(block_model).build());
    }

    public void carpetBlock(Block block, ResourceLocation texture) {
        ModelFile block_model = models().withExistingParent(DataProvider.getRegistryName(block.asItem()), "block/carpet").texture("wool", texture);
        getVariantBuilder(block).partialState().setModels(ConfiguredModel.builder().modelFile(block_model).build());
    }
}
