package de.artemis.laboratoryblocks.common.blocks;

import de.artemis.laboratoryblocks.common.blockentities.ChiseledLaboratoryBookShelfBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class ChiseledLaboratoryBookShelfBlock extends ChiseledBookShelfBlock {

    private final Supplier<ChiseledLaboratoryBookShelfBlock> block;

    public ChiseledLaboratoryBookShelfBlock(Supplier<ChiseledLaboratoryBookShelfBlock> block, Properties properties) {
        super(properties);
        this.block = block;
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(ItemStack itemStackInHand, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        //Vanilla Begin

        ItemInteractionResult result = super.useItemOn(itemStackInHand, blockState, level, blockPos, player, hand, hitResult);
        if (result != ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION)
        	return result;

        //Vanilla End

        /*ItemStack itemStackInHand = player.getItemInHand(interactionHand);
        if (itemStackInHand.is(ModItems.GLOWSTONE_PARTICLES.get()) || itemStackInHand.is(ModItems.CONFIGURATION_TOOL.get())) {

            // Applying Glowstone
            if (itemStackInHand.is(ModItems.GLOWSTONE_PARTICLES.get()) && !blockState.getBlock().builtInRegistryHolder().unwrapKey().get().toString().contains("enlighted")) {
                if (!player.isCreative()) {
                    itemStackInHand.shrink(1);
                }

                level.setBlock(blockPos, block.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, blockState.getValue(HorizontalDirectionalBlock.FACING)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED)), 3);
                level.playSound(player, blockPos, SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.BLOCKS, 1.0F, 1.0F);

                for (float i = 0; i <= 1; i += 0.2F) {
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX() + i, blockPos.getY(), blockPos.getZ(), 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX() + i, blockPos.getY() + 1, blockPos.getZ(), 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX(), blockPos.getY() + i, blockPos.getZ(), 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX() + 1, blockPos.getY() + i, blockPos.getZ(), 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX() + i, blockPos.getY(), blockPos.getZ() + 1, 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX() + i, blockPos.getY() + 1, blockPos.getZ() + 1, 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX(), blockPos.getY() + i, blockPos.getZ() + 1, 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX() + 1, blockPos.getY() + i, blockPos.getZ() + 1, 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX(), blockPos.getY(), blockPos.getZ() + i, 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX() + 1, blockPos.getY(), blockPos.getZ() + i, 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX(), blockPos.getY() + 1, blockPos.getZ() + i, 0, 0, 0);
                    level.addParticle(ModParticles.APPLYING_GLOWSTONE_PARTICLE.get(), blockPos.getX() + 1, blockPos.getY() + 1, blockPos.getZ() + i, 0, 0, 0);
                }

                return InteractionResult.SUCCESS;
            }

            // Removing Glowstone
            else if (itemStackInHand.is(ModItems.CONFIGURATION_TOOL.get()) && blockState.getBlock().builtInRegistryHolder().unwrapKey().get().toString().contains("enlighted") && KeyBindingUtil.isKeyPressed(ModKeyBindings.REMOVE_GLOWSTONE_CONFIGURATION_TOOL_ACTION)) {
                if (!player.isCreative()) {
                    if (!player.getInventory().add(new ItemStack(ModItems.GLOWSTONE_PARTICLES.get()))) {
                        ItemEntity itemEntity = new ItemEntity(level, blockPos.getX() + 0.5F, blockPos.getY() + 1.0F, blockPos.getZ() + 0.5F, new ItemStack(ModItems.GLOWSTONE_PARTICLES.get()));
                        itemEntity.setDefaultPickUpDelay();
                        level.addFreshEntity(itemEntity);
                    }

                    itemStackInHand.hurt(1, RandomSource.create(), null);
                }
                level.setBlock(blockPos, block.get().defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, blockState.getValue(HorizontalDirectionalBlock.FACING)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_0_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_1_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_2_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_3_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_4_OCCUPIED)).setValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED, blockState.getValue(BlockStateProperties.CHISELED_BOOKSHELF_SLOT_5_OCCUPIED)), 3);
                level.playSound(player, blockPos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.playSound(player, blockPos, ModSoundEvents.CONFIGURATION_TOOL_USE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);

                for (float i = 0; i <= 1; i += 0.2F) {
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX() + i, blockPos.getY(), blockPos.getZ(), 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX() + i, blockPos.getY() + 1, blockPos.getZ(), 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX(), blockPos.getY() + i, blockPos.getZ(), 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX() + 1, blockPos.getY() + i, blockPos.getZ(), 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX() + i, blockPos.getY(), blockPos.getZ() + 1, 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX() + i, blockPos.getY() + 1, blockPos.getZ() + 1, 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX(), blockPos.getY() + i, blockPos.getZ() + 1, 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX() + 1, blockPos.getY() + i, blockPos.getZ() + 1, 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX(), blockPos.getY(), blockPos.getZ() + i, 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX() + 1, blockPos.getY(), blockPos.getZ() + i, 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX(), blockPos.getY() + 1, blockPos.getZ() + i, 0, 0, 0);
                    level.addParticle(ModParticles.REMOVING_MODIFIER_PARTICLE.get(), blockPos.getX() + 1, blockPos.getY() + 1, blockPos.getZ() + i, 0, 0, 0);
                }

                return InteractionResult.SUCCESS;
            }
        }*/
        return result;
    }

    private static void addBook(Level level, BlockPos blockPos, Player player, ChiseledLaboratoryBookShelfBlockEntity blockEntity, ItemStack books, int slot) {
        if (!level.isClientSide) {
            player.awardStat(Stats.ITEM_USED.get(books.getItem()));
            SoundEvent soundEvent = books.is(Items.ENCHANTED_BOOK) ? SoundEvents.CHISELED_BOOKSHELF_INSERT_ENCHANTED : SoundEvents.CHISELED_BOOKSHELF_INSERT;
            blockEntity.setItem(slot, books.split(1));
            level.playSound((Player) null, blockPos, soundEvent, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (player.isCreative()) {
                books.grow(1);
            }

            level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockPos);
        }
    }

    private static void removeBook(Level pLevel, BlockPos pPos, Player pPlayer, ChiseledLaboratoryBookShelfBlockEntity pBlockEntity, int pSlot) {
        if (!pLevel.isClientSide) {
            ItemStack $$5 = pBlockEntity.removeItem(pSlot, 1);
            SoundEvent $$6 = $$5.is(Items.ENCHANTED_BOOK) ? SoundEvents.CHISELED_BOOKSHELF_PICKUP_ENCHANTED : SoundEvents.CHISELED_BOOKSHELF_PICKUP;
            pLevel.playSound((Player) null, pPos, $$6, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (!pPlayer.getInventory().add($$5)) {
                pPlayer.drop($$5, false);
            }

            pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
        }
    }

    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new ChiseledLaboratoryBookShelfBlockEntity(blockPos, blockState);
    }

    @Override
    public void onRemove(BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, BlockState newBlockState, boolean movedByPiston) {
        if (!blockState.is(newBlockState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof ChiseledLaboratoryBookShelfBlockEntity) {
                ChiseledLaboratoryBookShelfBlockEntity bookShelfBlockEntity = (ChiseledLaboratoryBookShelfBlockEntity) blockEntity;
                if (!bookShelfBlockEntity.isEmpty()) {
                    for (int i = 0; i < 6; ++i) {
                        ItemStack books = bookShelfBlockEntity.getItem(i);
                        if (!books.isEmpty()) {
                            Containers.dropItemStack(level, (double) blockPos.getX(), (double) blockPos.getY(), (double) blockPos.getZ(), books);
                        }
                    }

                    bookShelfBlockEntity.clearContent();
                    level.updateNeighbourForOutputSignal(blockPos, this);
                }
            }

            super.onRemove(blockState, level, blockPos, newBlockState, movedByPiston);
        }
    }

    @Override
    public int getAnalogOutputSignal(@NotNull BlockState blockState, Level level, @NotNull BlockPos blockPos) {
        if (level.isClientSide()) {
            return 0;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof ChiseledLaboratoryBookShelfBlockEntity) {
                ChiseledLaboratoryBookShelfBlockEntity bookShelfBlockEntity = (ChiseledLaboratoryBookShelfBlockEntity) blockEntity;
                return bookShelfBlockEntity.getLastInteractedSlot() + 1;
            } else {
                return 0;
            }
        }
    }
}
