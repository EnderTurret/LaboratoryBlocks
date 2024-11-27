package de.artemis.laboratoryblocks.common.blocks;

import de.artemis.laboratoryblocks.common.blockentities.ChiseledLaboratoryBookShelfBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ChiseledLaboratoryBookShelfBlock extends ChiseledBookShelfBlock {

    public ChiseledLaboratoryBookShelfBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if (newState.getBlock() instanceof ChiseledLaboratoryBookShelfBlock) return;
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new ChiseledLaboratoryBookShelfBlockEntity(blockPos, blockState);
    }
}
