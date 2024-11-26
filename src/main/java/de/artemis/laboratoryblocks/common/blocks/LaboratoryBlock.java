package de.artemis.laboratoryblocks.common.blocks;

import de.artemis.laboratoryblocks.common.registration.ModItems;
import de.artemis.laboratoryblocks.common.registration.ModKeyBindings;
import de.artemis.laboratoryblocks.common.registration.ModParticles;
import de.artemis.laboratoryblocks.common.registration.ModSoundEvents;
import de.artemis.laboratoryblocks.common.util.KeyBindingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class LaboratoryBlock extends Block implements BaseLaboratoryBlock {
    private final Supplier<LaboratoryBlock> block;

    public LaboratoryBlock(Supplier<LaboratoryBlock> block, Properties properties) {
        super(properties);
        this.block = block;
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack itemStackInHand, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return tryApplyGlowstone(itemStackInHand, blockState, level, blockPos, player, hand, block);
    }
}
