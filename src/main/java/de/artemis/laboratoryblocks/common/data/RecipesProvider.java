package de.artemis.laboratoryblocks.common.data;

import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import de.artemis.laboratoryblocks.common.registration.ModItems;
import de.artemis.laboratoryblocks.common.registration.ModTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RecipesProvider extends RecipeProvider implements IConditionBuilder {
    public RecipesProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STARCH.get(), 8).requires(Ingredient.of(ModTags.Item.STARCH_INGREDIENT), 4).unlockedBy("has_sugar", has(Items.SUGAR)).unlockedBy("has_sugar_cane", has(Items.SUGAR_CANE)).unlockedBy("has_beetroot", has(Items.BEETROOT)).unlockedBy("has_wheat", has(Items.WHEAT)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COMPRESSED_STARCH.get(), 1).define('A', ModItems.STARCH.get()).pattern("AA").pattern("AA").unlockedBy("has_starch", has(ModItems.STARCH.get())).save(consumer);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.COMPRESSED_STARCH.get()), RecipeCategory.MISC, ModItems.PLA_SHEETS.get().asItem(), 0.35F, 200).unlockedBy("has_compressed_starch", has(ModItems.COMPRESSED_STARCH.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_SCREW.get(), 16).define('A', Items.IRON_NUGGET).define('B', Items.IRON_INGOT).pattern("ABA").pattern(" A ").unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)).unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLEAR_LABORATORY_SCREEN.get(), 4).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', ModItems.IRON_SCREW.get()).define('C', ModItems.PLA_SHEETS.get()).pattern("BAB").pattern("ACA").pattern("BAB").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_iron_screw", has(ModItems.IRON_SCREW.get())).unlockedBy("has_pla_sheets", has(ModItems.PLA_SHEETS.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_CLEAR_LABORATORY_SCREEN.get(), 1).requires(ModBlocks.CLEAR_LABORATORY_SCREEN.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_clear_laboratory_screen", has(ModBlocks.CLEAR_LABORATORY_SCREEN.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_PILLAR.get(), 2).define('A', ModBlocks.LABORATORY_BLOCK.get()).pattern("A").pattern("A").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_LABORATORY_PILLAR.get(), 1).requires(ModBlocks.LABORATORY_PILLAR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_laboratory_pillar", has(ModBlocks.LABORATORY_PILLAR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_LABORATORY_PILLAR.get(), 8).define('A', ModBlocks.LABORATORY_PILLAR.get()).define('B', Items.GRAY_DYE).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_pillar", has(ModBlocks.LABORATORY_PILLAR.get())).unlockedBy("has_gray_dye", has(Items.GRAY_DYE)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_GRAY_LABORATORY_PILLAR.get(), 1).requires(ModBlocks.GRAY_LABORATORY_PILLAR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_gray_laboratory_pillar", has(ModBlocks.GRAY_LABORATORY_PILLAR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLA_BLOCK.get(), 1).define('A', ModItems.PLA_SHEETS.get()).pattern("AA").pattern("AA").unlockedBy("has_pla_sheets", has(ModItems.PLA_SHEETS.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_PLA_BLOCK.get(), 1).requires(ModBlocks.PLA_BLOCK.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_pla_block", has(ModBlocks.PLA_BLOCK.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLA_TILES.get(), 8).define('A', ModBlocks.PLA_BLOCK.get()).pattern("AA").pattern("AA").unlockedBy("has_pla_block", has(ModBlocks.PLA_BLOCK.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_PLA_TILES.get(), 1).requires(ModBlocks.PLA_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_pla_tiles", has(ModBlocks.PLA_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLA_FLOORING.get(), 3).define('A', ModBlocks.PLA_BLOCK.get()).pattern("AA").unlockedBy("has_pla_block", has(ModBlocks.PLA_BLOCK.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_PLA_FLOORING.get(), 1).requires(ModBlocks.PLA_FLOORING.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_pla_flooring", has(ModBlocks.PLA_FLOORING.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TILED_PLA_FLOORING.get(), 3).define('A', ModBlocks.PLA_TILES.get()).pattern("AA").unlockedBy("has_pla_tiles", has(ModBlocks.PLA_TILES.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_TILED_PLA_FLOORING.get(), 1).requires(ModBlocks.TILED_PLA_FLOORING.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_tiled_pla_flooring", has(ModBlocks.TILED_PLA_FLOORING.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_BLOCK.get(), 8).define('A', Blocks.STONE).define('B', Items.QUARTZ).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_stone", has(Blocks.STONE)).unlockedBy("has_quartz", has(Items.QUARTZ)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.LABORATORY_BLOCK.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCREWED_LABORATORY_BLOCK.get(), 2).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', ModItems.IRON_SCREW.get()).pattern("B B").pattern(" A ").pattern("B B").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_iron_screw", has(ModItems.IRON_SCREW.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_SCREWED_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.SCREWED_LABORATORY_BLOCK.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_screwed_laboratory_block", has(ModBlocks.SCREWED_LABORATORY_BLOCK.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_TILES.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).pattern("AA").pattern("AA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_LABORATORY_TILES.get(), 1).requires(ModBlocks.LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_laboratory_tiles", has(ModBlocks.LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_LABORATORY_TILES.get(), 8).define('A', ModBlocks.LABORATORY_TILES.get()).define('B', Items.GRAY_DYE).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_tiles", has(ModBlocks.LABORATORY_TILES.get())).unlockedBy("has_gray_dye", has(Items.GRAY_DYE)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_GRAY_LABORATORY_TILES.get(), 1).requires(ModBlocks.GRAY_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_gray_laboratory_tiles", has(ModBlocks.GRAY_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_LABORATORY_TILES.get(), 2).requires(ModBlocks.GRAY_LABORATORY_TILES.get()).requires(ModBlocks.LABORATORY_TILES.get()).unlockedBy("has_gray_laboratory_tiles", has(ModBlocks.GRAY_LABORATORY_TILES.get())).unlockedBy("has_laboratory_tiles", has(ModBlocks.LABORATORY_TILES.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_MIXED_LABORATORY_TILES.get(), 1).requires(ModBlocks.MIXED_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_mixed_laboratory_tiles", has(ModBlocks.MIXED_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.OAK_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_oak_planks", has(Blocks.OAK_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_OAK_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.OAK_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_oak_laboratory_floor", has(ModBlocks.OAK_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.SPRUCE_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_spruce_planks", has(Blocks.SPRUCE_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_SPRUCE_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.SPRUCE_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_spruce_laboratory_floor", has(ModBlocks.SPRUCE_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.BIRCH_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_birch_planks", has(Blocks.BIRCH_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_BIRCH_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.BIRCH_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_birch_laboratory_floor", has(ModBlocks.BIRCH_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.DARK_OAK_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_dark_oak_planks", has(Blocks.DARK_OAK_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_DARK_OAK_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.DARK_OAK_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_dark_oak_laboratory_floor", has(ModBlocks.DARK_OAK_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.ACACIA_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_acacia_planks", has(Blocks.ACACIA_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_ACACIA_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.ACACIA_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_acacia_laboratory_floor", has(ModBlocks.ACACIA_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.JUNGLE_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_jungle_planks", has(Blocks.JUNGLE_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_JUNGLE_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.JUNGLE_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_jungle_laboratory_floor", has(ModBlocks.JUNGLE_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.MANGROVE_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_mangrove_planks", has(Blocks.MANGROVE_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_MANGROVE_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.MANGROVE_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_mangrove_laboratory_floor", has(ModBlocks.MANGROVE_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.CRIMSON_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_crimson_planks", has(Blocks.CRIMSON_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_CRIMSON_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.CRIMSON_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_crimson_laboratory_floor", has(ModBlocks.CRIMSON_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.WARPED_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_warped_planks", has(Blocks.WARPED_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_WARPED_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.WARPED_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_warped_laboratory_floor", has(ModBlocks.WARPED_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.CHERRY_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_cherry_planks", has(Blocks.CHERRY_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_CHERRY_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.CHERRY_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_cherry_laboratory_floor", has(ModBlocks.CHERRY_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_LABORATORY_FLOOR.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.BAMBOO_PLANKS).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_bamboo_planks", has(Blocks.BAMBOO_PLANKS)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_BAMBOO_LABORATORY_FLOOR.get(), 1).requires(ModBlocks.BAMBOO_LABORATORY_FLOOR.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_bamboo_laboratory_floor", has(ModBlocks.BAMBOO_LABORATORY_FLOOR.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_LABORATORY_TILES.get(), 8).define('A', ModBlocks.OAK_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_oak_laboratory_floor", has(ModBlocks.OAK_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_OAK_LABORATORY_TILES.get(), 1).requires(ModBlocks.OAK_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_oak_laboratory_tiles", has(ModBlocks.OAK_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_LABORATORY_TILES.get(), 8).define('A', ModBlocks.SPRUCE_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_spruce_laboratory_floor", has(ModBlocks.SPRUCE_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_SPRUCE_LABORATORY_TILES.get(), 1).requires(ModBlocks.SPRUCE_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_spruce_laboratory_tiles", has(ModBlocks.SPRUCE_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_LABORATORY_TILES.get(), 8).define('A', ModBlocks.BIRCH_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_birch_laboratory_floor", has(ModBlocks.BIRCH_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_BIRCH_LABORATORY_TILES.get(), 1).requires(ModBlocks.BIRCH_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_birch_laboratory_tiles", has(ModBlocks.BIRCH_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_LABORATORY_TILES.get(), 8).define('A', ModBlocks.DARK_OAK_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_oak_laboratory_floor", has(ModBlocks.DARK_OAK_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_DARK_OAK_LABORATORY_TILES.get(), 1).requires(ModBlocks.DARK_OAK_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_dark_oak_laboratory_tiles", has(ModBlocks.DARK_OAK_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_LABORATORY_TILES.get(), 8).define('A', ModBlocks.ACACIA_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_acacia_laboratory_floor", has(ModBlocks.ACACIA_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_ACACIA_LABORATORY_TILES.get(), 1).requires(ModBlocks.ACACIA_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_acacia_laboratory_tiles", has(ModBlocks.ACACIA_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_LABORATORY_TILES.get(), 8).define('A', ModBlocks.JUNGLE_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_jungle_laboratory_floor", has(ModBlocks.JUNGLE_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_JUNGLE_LABORATORY_TILES.get(), 1).requires(ModBlocks.JUNGLE_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_jungle_laboratory_tiles", has(ModBlocks.JUNGLE_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_LABORATORY_TILES.get(), 8).define('A', ModBlocks.MANGROVE_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_mangrove_laboratory_floor", has(ModBlocks.MANGROVE_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_MANGROVE_LABORATORY_TILES.get(), 1).requires(ModBlocks.MANGROVE_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_mangrove_laboratory_tiles", has(ModBlocks.MANGROVE_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_LABORATORY_TILES.get(), 8).define('A', ModBlocks.CRIMSON_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_crimson_laboratory_floor", has(ModBlocks.CRIMSON_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_CRIMSON_LABORATORY_TILES.get(), 1).requires(ModBlocks.CRIMSON_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_crimson_laboratory_tiles", has(ModBlocks.CRIMSON_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_LABORATORY_TILES.get(), 8).define('A', ModBlocks.WARPED_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_warped_laboratory_floor", has(ModBlocks.WARPED_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_WARPED_LABORATORY_TILES.get(), 1).requires(ModBlocks.WARPED_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_warped_laboratory_tiles", has(ModBlocks.WARPED_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_LABORATORY_TILES.get(), 8).define('A', ModBlocks.CHERRY_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_cherry_laboratory_floor", has(ModBlocks.CHERRY_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_CHERRY_LABORATORY_TILES.get(), 1).requires(ModBlocks.CHERRY_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_cherry_laboratory_tiles", has(ModBlocks.CHERRY_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_LABORATORY_TILES.get(), 8).define('A', ModBlocks.BAMBOO_LABORATORY_FLOOR.get()).pattern("AA").pattern("AA").unlockedBy("has_bamboo_laboratory_floor", has(ModBlocks.BAMBOO_LABORATORY_FLOOR.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_BAMBOO_LABORATORY_TILES.get(), 1).requires(ModBlocks.BAMBOO_LABORATORY_TILES.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_bamboo_laboratory_tiles", has(ModBlocks.BAMBOO_LABORATORY_TILES.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_GLASS.get(), 8).define('A', Blocks.GLASS).define('B', ModBlocks.LABORATORY_BLOCK.get()).pattern("AAA").pattern("ABA").pattern("AAA").unlockedBy("has_glass", has(Blocks.GLASS)).unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_LABORATORY_GLASS.get(), 1).requires(ModBlocks.LABORATORY_GLASS.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_laboratory_glass", has(ModBlocks.LABORATORY_GLASS.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_VENT.get(), 1).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Items.IRON_NUGGET).pattern(" B ").pattern("BAB").pattern(" B ").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_LABORATORY_VENT.get(), 1).requires(ModBlocks.LABORATORY_VENT.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_laboratory_vent", has(ModBlocks.LABORATORY_VENT.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.BLUE_WOOL).define('C', Blocks.BLACK_WOOL).pattern("AAA").pattern("BCB").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_wool", has(ItemTags.WOOL)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_right-faced_blue_signaling_laboratory_block", has(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get()).unlockedBy("has_left-faced_blue_signaling_laboratory_block", has(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_left-faced_blue_signaling_laboratory_block", has(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.RED_WOOL).define('C', Blocks.BLACK_WOOL).pattern("AAA").pattern("BCB").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_wool", has(ItemTags.WOOL)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_right-faced_red_signaling_laboratory_block", has(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get()).unlockedBy("has_left-faced_red_signaling_laboratory_block", has(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_left-faced_red_signaling_laboratory_block", has(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get(), 8).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Blocks.GREEN_WOOL).define('C', Blocks.BLACK_WOOL).pattern("AAA").pattern("BCB").pattern("AAA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_wool", has(ItemTags.WOOL)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_right-faced_green_signaling_laboratory_block", has(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get()).unlockedBy("has_left-faced_green_signaling_laboratory_block", has(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get(), 1).requires(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_left-faced_green_signaling_laboratory_block", has(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LABORATORY_FAN.get(), 1).define('A', ModBlocks.LABORATORY_BLOCK.get()).define('B', Items.IRON_NUGGET).define('C', ModItems.IRON_SCREW.get()).pattern("ABA").pattern("BCB").pattern("ABA").unlockedBy("has_laboratory_block", has(ModBlocks.LABORATORY_BLOCK.get())).unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)).unlockedBy("has_iron_screw", has(ModItems.IRON_SCREW.get())).save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENLIGHTED_LABORATORY_FAN.get(), 1).requires(ModBlocks.LABORATORY_FAN.get()).requires(Items.GLOWSTONE_DUST).unlockedBy("has_laboratory_fan", has(ModBlocks.LABORATORY_FAN.get())).unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST)).save(consumer);

    }
}
