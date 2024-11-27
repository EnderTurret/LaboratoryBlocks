package de.artemis.laboratoryblocks.common.data;

import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import de.artemis.laboratoryblocks.common.registration.ModItems;
import de.artemis.laboratoryblocks.common.registration.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class RecipesProvider extends RecipeProvider implements IConditionBuilder {
    public RecipesProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CONFIGURATION_TOOL.get(), 1).define('A', Items.IRON_INGOT).define('B', Items.ORANGE_WOOL).define('C', ModItems.IRON_SCREW.get()).define('D', Items.IRON_NUGGET).pattern("  C").pattern("DB ").pattern("AD ").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).unlockedBy("has_orange_wool", has(Items.ORANGE_WOOL)).unlockedBy("has_iron_screw", has(ModItems.IRON_SCREW.get())).unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STARCH.get(), 1).requires(Ingredient.of(ModTags.Item.STARCH_INGREDIENT), 4).unlockedBy("has_sugar", has(Items.SUGAR)).unlockedBy("has_sugar_cane", has(Items.SUGAR_CANE)).unlockedBy("has_beetroot", has(Items.BEETROOT)).unlockedBy("has_wheat", has(Items.WHEAT)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COMPRESSED_STARCH.get(), 1).define('A', ModItems.STARCH.get()).pattern("AA").pattern("AA").unlockedBy("has_starch", has(ModItems.STARCH.get())).save(consumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.COMPRESSED_STARCH.get()), RecipeCategory.MISC, ModItems.PLA_SHEETS.get().asItem(), 0.35F, 200).unlockedBy("has_compressed_starch", has(ModItems.COMPRESSED_STARCH.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_SCREW.get(), 16).define('A', Items.IRON_NUGGET).define('B', Items.IRON_INGOT).pattern("ABA").pattern(" A ").unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLEAR_LABORATORY_SCREEN.get(), 4).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', ModItems.IRON_SCREW.get()).define('C', ModItems.PLA_SHEETS.get()).pattern("BAB").pattern("ACA").pattern("BAB").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_iron_screw", has(ModItems.IRON_SCREW.get())).unlockedBy("has_pla_sheets", has(ModItems.PLA_SHEETS.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_PILLAR.get(), 2).define('A', ModBlocks.LABORATORY_BLOCK.get()).pattern("A").pattern("A").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_LABORATORY_PILLAR.get(), 8).define('A', ModBlocks.LABORATORY_PILLAR.get()).define('B', Items.GRAY_DYE).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_pillar", has(ModBlocks.LABORATORY_PILLAR.get())).unlockedBy("has_gray_dye", has(Items.GRAY_DYE)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLA_BLOCK.get(), 1).define('A', ModItems.PLA_SHEETS.get()).pattern("AA").pattern("AA").unlockedBy("has_pla_sheets", has(ModItems.PLA_SHEETS.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLA_TILES.get(), 8).define('A', ModBlocks.PLA_BLOCK.get()).pattern("AA").pattern("AA").unlockedBy("has_pla_block", has(ModBlocks.PLA_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLA_FLOORING.get(), 3).define('A', ModBlocks.PLA_BLOCK.get()).pattern("AA").unlockedBy("has_pla_block", has(ModBlocks.PLA_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TILED_PLA_FLOORING.get(), 3).define('A', ModBlocks.PLA_TILES.get()).pattern("AA").unlockedBy("has_pla_tiles", has(ModBlocks.PLA_TILES.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_BLOCK.get(), 8).define('A', Blocks.STONE).define('B', Items.QUARTZ).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_stone", has(Blocks.STONE)).unlockedBy("has_quartz", has(Items.QUARTZ)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCREWED_LABORATORY_BLOCK.get(), 2).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', ModItems.IRON_SCREW.get()).pattern("B B").pattern(" A ").pattern("B B").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_iron_screw", has(ModItems.IRON_SCREW.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_TILES.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).pattern("AA").pattern("AA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_LABORATORY_TILES.get(), 8).define('A', ModBlocks.LABORATORY_TILES.get()).define('B', Items.GRAY_DYE).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_tiles", has(ModBlocks.LABORATORY_TILES.get())).unlockedBy("has_gray_dye", has(Items.GRAY_DYE)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_LABORATORY_TILES.get(), 2).requires(ModBlocks.GRAY_LABORATORY_TILES.get()).requires(ModBlocks.LABORATORY_TILES.get()).unlockedBy("has_gray_laboratory_tiles", has(ModBlocks.GRAY_LABORATORY_TILES.get())).unlockedBy("has_laboratory_tiles", has(ModBlocks.LABORATORY_TILES.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_GLASS.get(), 8).define('A', Blocks.GLASS).define('B', ModBlocks.LABORATORY_BLOCK.get()).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_glass", has(Blocks.GLASS)).unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_VENT.get(), 1).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Items.IRON_NUGGET).pattern(" B ").pattern("BAB").pattern(" B ").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_VENT_CONNECTING.get(), 1).requires(ModBlocks.LABORATORY_VENT.get()).unlockedBy("has_laboratory_vent", has(ModBlocks.LABORATORY_VENT.get())).save(consumer);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.BLUE_WOOL).define('C', Blocks.BLACK_WOOL).pattern("AAA").pattern("BCB").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_wool", has(ItemTags.WOOL)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get()).unlockedBy("has_left-faced_blue_signaling_laboratory_block", has(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.RED_WOOL).define('C', Blocks.BLACK_WOOL).pattern("AAA").pattern("BCB").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_wool", has(ItemTags.WOOL)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get()).unlockedBy("has_left-faced_red_signaling_laboratory_block", has(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.GREEN_WOOL).define('C', Blocks.BLACK_WOOL).pattern("AAA").pattern("BCB").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_wool", has(ItemTags.WOOL)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get()).unlockedBy("has_left-faced_green_signaling_laboratory_block", has(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_FAN.get(), 1).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Items.IRON_NUGGET).define('C', ModItems.IRON_SCREW.get()).pattern("ABA").pattern("BCB").pattern("ABA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)).unlockedBy("has_iron_screw", has(ModItems.IRON_SCREW.get())).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_BOOKSHELF.get(), 1).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Items.BOOK).pattern("AAA").pattern("BBB").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_book", has(Items.BOOK)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_LABORATORY_BOOKSHELF.get(), 1).define('A', ModBlocks.LABORATORY_BLOCK.get()).pattern("AAA").pattern("   ").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_FAN_REDSTONE_CONTROLLED.get(), 1).requires(ModBlocks.LABORATORY_FAN.get()).requires(Items.REDSTONE).unlockedBy("has_laboratory_fan", has(ModBlocks.LABORATORY_FAN.get())).unlockedBy("has_redstone_particles", has(Items.REDSTONE)).save(consumer);

    }
}
