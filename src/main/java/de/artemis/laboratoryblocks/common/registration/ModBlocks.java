package de.artemis.laboratoryblocks.common.registration;

import de.artemis.laboratoryblocks.common.blocks.*;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModBlocks {

    private static <T extends Block> Supplier<T> register(String name, Supplier<T> block) {
        Supplier<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties()));

        return toReturn;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
        return false;
    }

    private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    public static void register() {
    }

    public static final Supplier<LaboratoryBlock> LABORATORY_PILLAR = register("laboratory_pillar",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> GRAY_LABORATORY_PILLAR = register("gray_laboratory_pillar",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> CLEAR_LABORATORY_SCREEN = register("clear_laboratory_screen",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(1.25F, 1.5F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> LABORATORY_FAN = register("laboratory_fan",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<RedstoneControlledLaboratoryBlock> LABORATORY_FAN_REDSTONE_CONTROLLED = register("laboratory_fan_redstone_controlled",
            () -> new RedstoneControlledLaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK = register("left-faced_blue_signaling_laboratory_block",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK = register("right-faced_blue_signaling_laboratory_block",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK = register("left-faced_red_signaling_laboratory_block",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK = register("right-faced_red_signaling_laboratory_block",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK = register("left-faced_green_signaling_laboratory_block",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK = register("right-faced_green_signaling_laboratory_block",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> LABORATORY_BOOKSHELF = register("laboratory_bookshelf",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(1.5F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<ChiseledLaboratoryBookShelfBlock> CHISELED_LABORATORY_BOOKSHELF = register("chiseled_laboratory_bookshelf",
            () -> new ChiseledLaboratoryBookShelfBlock(BlockBehaviour.Properties.of().strength(1.5F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> LABORATORY_VENT = register("laboratory_vent",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> LABORATORY_VENT_CONNECTING = register("laboratory_vent_connecting",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> PLA_BLOCK = register("pla_block",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(0.5F, 0.5F).sound(SoundType.BONE_BLOCK)));

    public static final Supplier<LaboratoryBlock> PLA_TILES = register("pla_tiles",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(0.5F, 0.5F).sound(SoundType.BONE_BLOCK)));

    public static final Supplier<LaboratoryCarpetBlock> PLA_FLOORING = register("pla_flooring",
            () -> new LaboratoryCarpetBlock(BlockBehaviour.Properties.of().ignitedByLava().strength(0.1F).sound(SoundType.BONE_BLOCK)));

    public static final Supplier<LaboratoryCarpetBlock> TILED_PLA_FLOORING = register("tiled_pla_flooring",
            () -> new LaboratoryCarpetBlock(BlockBehaviour.Properties.of().ignitedByLava().strength(0.1F).sound(SoundType.BONE_BLOCK)));

    public static final Supplier<LaboratoryBlock> LABORATORY_BLOCK = register("laboratory_block",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> SCREWED_LABORATORY_BLOCK = register("screwed_laboratory_block",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> LABORATORY_TILES = register("laboratory_tiles",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> GRAY_LABORATORY_TILES = register("gray_laboratory_tiles",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));

    public static final Supplier<LaboratoryBlock> MIXED_LABORATORY_TILES = register("mixed_laboratory_tiles",
            () -> new LaboratoryBlock(BlockBehaviour.Properties.of().strength(2.5F, 3.0F).sound(ModSoundType.LABORATORY_BLOCK)));


    public static final Supplier<LaboratoryGlassBlock> LABORATORY_GLASS = register("laboratory_glass",
            () -> new LaboratoryGlassBlock(BlockBehaviour.Properties.of().strength(0.3F).sound(SoundType.GLASS).noOcclusion().isValidSpawn(ModBlocks::never).isRedstoneConductor(ModBlocks::never).isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never)));

}
