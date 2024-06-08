package de.artemis.laboratoryblocks.common.blocks;

import de.artemis.laboratoryblocks.common.blockentities.ChiseledLaboratoryBookShelfBlockEntity;
import de.artemis.laboratoryblocks.common.registration.ModItems;
import de.artemis.laboratoryblocks.common.registration.ModKeyBindings;
import de.artemis.laboratoryblocks.common.registration.ModParticles;
import de.artemis.laboratoryblocks.common.util.KeyBindingUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChiseledBookShelfBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public class ChiseledLaboratoryBookShelfBlock extends ChiseledBookShelfBlock {

    private final Supplier<ChiseledLaboratoryBookShelfBlock> block;

    public ChiseledLaboratoryBookShelfBlock(Supplier<ChiseledLaboratoryBookShelfBlock> block, Properties properties) {
        super(properties);
        this.block = block;
    }

    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {

        BlockEntity var8 = level.getBlockEntity(blockPos);
        if (var8 instanceof ChiseledLaboratoryBookShelfBlockEntity $$7) {
            Optional $$8 = getRelativeHitCoordinatesForBlockFace(blockHitResult, (Direction)blockState.getValue(HorizontalDirectionalBlock.FACING));
            if ($$8.isEmpty()) {
                return InteractionResult.PASS;
            } else {
                int $$9 = getHitSlot((Vec2)$$8.get());
                if ((Boolean)blockState.getValue((Property)SLOT_OCCUPIED_PROPERTIES.get($$9))) {
                    removeBook(level, blockPos, player, $$7, $$9);
                    return InteractionResult.sidedSuccess(level.isClientSide);
                } else {
                    ItemStack $$10 = player.getItemInHand(interactionHand);
                    if ($$10.is(ItemTags.BOOKSHELF_BOOKS)) {
                        addBook(level, blockPos, player, $$7, $$10, $$9);
                        return InteractionResult.sidedSuccess(level.isClientSide);
                    } else {
                        return InteractionResult.CONSUME;
                    }
                }
            }
        }

        //Laborator Begin

        ItemStack itemStackInHand = player.getItemInHand(interactionHand);

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
        }
        return InteractionResult.FAIL;
    }

    private static Optional<Vec2> getRelativeHitCoordinatesForBlockFace(BlockHitResult pHitResult, Direction pFace) {
        Direction $$2 = pHitResult.getDirection();
        if (pFace != $$2) {
            return Optional.empty();
        } else {
            BlockPos $$3 = pHitResult.getBlockPos().relative($$2);
            Vec3 $$4 = pHitResult.getLocation().subtract((double)$$3.getX(), (double)$$3.getY(), (double)$$3.getZ());
            double $$5 = $$4.x();
            double $$6 = $$4.y();
            double $$7 = $$4.z();
            Optional var10000;
            switch ($$2) {
                case NORTH:
                    var10000 = Optional.of(new Vec2((float)(1.0 - $$5), (float)$$6));
                    break;
                case SOUTH:
                    var10000 = Optional.of(new Vec2((float)$$5, (float)$$6));
                    break;
                case WEST:
                    var10000 = Optional.of(new Vec2((float)$$7, (float)$$6));
                    break;
                case EAST:
                    var10000 = Optional.of(new Vec2((float)(1.0 - $$7), (float)$$6));
                    break;
                case DOWN:
                case UP:
                    var10000 = Optional.empty();
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }

            return var10000;
        }
    }

    private static void addBook(Level pLevel, BlockPos pPos, Player pPlayer, ChiseledLaboratoryBookShelfBlockEntity pBlockEntity, ItemStack pBookStack, int pSlot) {
        if (!pLevel.isClientSide) {
            pPlayer.awardStat(Stats.ITEM_USED.get(pBookStack.getItem()));
            SoundEvent $$6 = pBookStack.is(Items.ENCHANTED_BOOK) ? SoundEvents.CHISELED_BOOKSHELF_INSERT_ENCHANTED : SoundEvents.CHISELED_BOOKSHELF_INSERT;
            pBlockEntity.setItem(pSlot, pBookStack.split(1));
            pLevel.playSound((Player)null, pPos, $$6, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (pPlayer.isCreative()) {
                pBookStack.grow(1);
            }

            pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
        }
    }

    private static void removeBook(Level pLevel, BlockPos pPos, Player pPlayer, ChiseledLaboratoryBookShelfBlockEntity pBlockEntity, int pSlot) {
        if (!pLevel.isClientSide) {
            ItemStack $$5 = pBlockEntity.removeItem(pSlot, 1);
            SoundEvent $$6 = $$5.is(Items.ENCHANTED_BOOK) ? SoundEvents.CHISELED_BOOKSHELF_PICKUP_ENCHANTED : SoundEvents.CHISELED_BOOKSHELF_PICKUP;
            pLevel.playSound((Player)null, pPos, $$6, SoundSource.BLOCKS, 1.0F, 1.0F);
            if (!pPlayer.getInventory().add($$5)) {
                pPlayer.drop($$5, false);
            }

            pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
        }
    }

    private static int getHitSlot(Vec2 pHitPos) {
        int $$1 = pHitPos.y >= 0.5F ? 0 : 1;
        int $$2 = getSection(pHitPos.x);
        return $$2 + $$1 * 3;
    }

    private static int getSection(float pX) {
        float $$1 = 0.0625F;
        float $$2 = 0.375F;
        if (pX < 0.375F) {
            return 0;
        } else {
            float $$3 = 0.6875F;
            return pX < 0.6875F ? 1 : 2;
        }
    }

    public @Nullable BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new ChiseledLaboratoryBookShelfBlockEntity(blockPos, blockState);
    }
}
