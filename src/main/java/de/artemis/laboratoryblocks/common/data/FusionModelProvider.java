package de.artemis.laboratoryblocks.common.data;

import java.util.function.Supplier;

import com.supermartijn642.fusion.api.model.DefaultModelTypes;
import com.supermartijn642.fusion.api.model.ModelInstance;
import com.supermartijn642.fusion.api.model.data.ConnectingModelDataBuilder;
import com.supermartijn642.fusion.api.predicate.DefaultConnectionPredicates;
import de.artemis.laboratoryblocks.LaboratoryBlocks;
import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

public class FusionModelProvider extends com.supermartijn642.fusion.api.provider.FusionModelProvider {
    public FusionModelProvider(PackOutput output) {
        super(LaboratoryBlocks.MOD_ID, output);
    }

    private void sameBlock(Supplier<? extends Block> block) {
        final Block b = block.get();
        final ResourceLocation id = BuiltInRegistries.BLOCK.getKey(b);
        var modelData = ConnectingModelDataBuilder.builder()
                .parent(ResourceLocation.fromNamespaceAndPath("minecraft", "block/cube_all"))
                .texture("all", ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/" + id.getPath() + "-fusion"))
                .connection(DefaultConnectionPredicates.isSameBlock())
                .build();
        addModel(id.withPath(p -> "block/" + p), ModelInstance.of(DefaultModelTypes.CONNECTING, modelData));
    }

    private void sameBlockAnd(Supplier<? extends Block> block, Supplier<? extends Block> block2) {
        final Block b = block.get();
        final ResourceLocation id = BuiltInRegistries.BLOCK.getKey(b);
        var modelData = ConnectingModelDataBuilder.builder()
                .parent(ResourceLocation.fromNamespaceAndPath("minecraft", "block/cube_all"))
                .texture("all", ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/" + id.getPath() + "-fusion"))
                .connection(DefaultConnectionPredicates.or(DefaultConnectionPredicates.isSameBlock(), DefaultConnectionPredicates.matchBlock(block2.get())))
                .build();
        addModel(id.withPath(p -> "block/" + p), ModelInstance.of(DefaultModelTypes.CONNECTING, modelData));
    }

    @Override
    protected void generate() {
        sameBlockAnd(ModBlocks.LABORATORY_BLOCK, ModBlocks.SCREWED_LABORATORY_BLOCK);
        sameBlock(ModBlocks.LABORATORY_VENT);
        sameBlock(ModBlocks.CLEAR_LABORATORY_SCREEN);
        sameBlock(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK);
        sameBlock(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK);
        sameBlock(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK);
        sameBlock(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK);
        sameBlock(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK);
        sameBlock(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK);
        sameBlockAnd(ModBlocks.SCREWED_LABORATORY_BLOCK, ModBlocks.LABORATORY_BLOCK);
        sameBlock(ModBlocks.LABORATORY_TILES);
        sameBlock(ModBlocks.GRAY_LABORATORY_TILES);
        sameBlock(ModBlocks.MIXED_LABORATORY_TILES);
        sameBlock(ModBlocks.LABORATORY_GLASS);

        var modelDataLaboratoryVentConnecting = ConnectingModelDataBuilder.builder()
                .parent(ResourceLocation.fromNamespaceAndPath("minecraft", "block/cube_all"))
                .texture("all", ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_vent_connecting-fusion"))
                .connection(DefaultConnectionPredicates.isSameBlock().or(DefaultConnectionPredicates.matchBlock(ModBlocks.LABORATORY_BLOCK.get())))
                .build();
        var modelInstanceLaboratoryVentConnecting = ModelInstance.of(DefaultModelTypes.CONNECTING, modelDataLaboratoryVentConnecting);
        this.addModel(ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_vent_connecting"), modelInstanceLaboratoryVentConnecting);



        var modelDataLaboratoryBookshelf = ConnectingModelDataBuilder.builder()
                .parent(ResourceLocation.fromNamespaceAndPath("minecraft", "block/cube_column"))
                .texture("side", ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_bookshelf-fusion"))
                .texture("end", ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_bookshelf_top-fusion"))
                .connection(DefaultConnectionPredicates.isSameBlock())
                .build();
        var modelInstanceLaboratoryBookshelf = ModelInstance.of(DefaultModelTypes.CONNECTING, modelDataLaboratoryBookshelf);
        this.addModel(ResourceLocation.fromNamespaceAndPath(LaboratoryBlocks.MOD_ID, "block/laboratory_bookshelf"), modelInstanceLaboratoryBookshelf);
    }
}
