package de.artemis.laboratoryblocks.common.data;

import de.artemis.laboratoryblocks.LaboratoryBlocks;
import de.artemis.laboratoryblocks.common.registration.ModBlocks;
import de.artemis.laboratoryblocks.common.registration.ModItems;
import net.minecraft.data.PackOutput;

public class LanguageProvider extends net.neoforged.neoforge.common.data.LanguageProvider {
    public LanguageProvider(PackOutput packOutput, String locale) {
        super(packOutput, LaboratoryBlocks.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.laboratoryblocks", "Artemis' Laboratory Blocks");
        add("keybind.laboratoryblocks.category", "Artemis' Laboratory Blocks");

        add("tooltip.laboratoryblocks.configuration_tool_1", "Current mode: %s.");
        add("tooltip.laboratoryblocks.configuration_tool_2", "Crouch-Right-Click to cycle modes.");
        add("tooltip.laboratoryblocks.configuration_tool.state.remove_glowstone", "Remove Glowstone");
        add("tooltip.laboratoryblocks.configuration_tool.state.remove_redstone", "Remove Redstone");
        add("tooltip.laboratoryblocks.configuration_tool.state.reverse_redstone_control", "Reverse Redstone Control");

        add(ModItems.STARCH.get(), "Starch");
        add(ModItems.COMPRESSED_STARCH.get(), "Compressed Starch");
        add(ModItems.PLA_SHEETS.get(), "PLA Sheets");
        add(ModItems.IRON_SCREW.get(), "Iron Screw");
        add(ModItems.GLOWSTONE_PARTICLES.get(), "Glowstone Particles");
        add(ModItems.REDSTONE_PARTICLES.get(), "Redstone Particles");
        add(ModItems.CONFIGURATION_TOOL.get(), "Configuration Tool");

        add(ModBlocks.PLA_BLOCK.get(), "PLA Block");
        add(ModBlocks.PLA_TILES.get(), "PLA Tiles");
        add(ModBlocks.PLA_FLOORING.get(), "PLA Flooring");
        add(ModBlocks.TILED_PLA_FLOORING.get(), "Tiled PLA Flooring");
        add(ModBlocks.LABORATORY_BLOCK.get(), "Laboratory Block");
        add(ModBlocks.LABORATORY_TILES.get(), "Laboratory Tiles");
        add(ModBlocks.GRAY_LABORATORY_TILES.get(), "Gray Laboratory Tiles");
        add(ModBlocks.MIXED_LABORATORY_TILES.get(), "Mixed Laboratory Tiles");
        add(ModBlocks.LABORATORY_GLASS.get(), "Laboratory Glass");
        add(ModBlocks.LABORATORY_VENT.get(), "Laboratory Vent");
        add(ModBlocks.LABORATORY_VENT_CONNECTING.get(), "Laboratory Vent (Connecting)");
        add(ModBlocks.LEFT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get(), "Left-Faced Blue Signaling Laboratory Block");
        add(ModBlocks.RIGHT_FACED_BLUE_SIGNALING_LABORATORY_BLOCK.get(), "Right-Faced Blue Signaling Laboratory Block");
        add(ModBlocks.LEFT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get(), "Left-Faced Green Signaling Laboratory Block");
        add(ModBlocks.RIGHT_FACED_GREEN_SIGNALING_LABORATORY_BLOCK.get(), "Right-Faced Green Signaling Laboratory Block");
        add(ModBlocks.LEFT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get(), "Left-Faced Red Signaling Laboratory Block");
        add(ModBlocks.RIGHT_FACED_RED_SIGNALING_LABORATORY_BLOCK.get(), "Right-Faced Red Signaling Laboratory Block");
        add(ModBlocks.LABORATORY_FAN.get(), "Laboratory Fan");
        add(ModBlocks.SCREWED_LABORATORY_BLOCK.get(), "Screwed Laboratory Block");
        add(ModBlocks.CLEAR_LABORATORY_SCREEN.get(), "Clear Laboratory Screen");
        add(ModBlocks.LABORATORY_PILLAR.get(), "Laboratory Pillar");
        add(ModBlocks.GRAY_LABORATORY_PILLAR.get(), "Gray Laboratory Pillar");
        add(ModBlocks.LABORATORY_FAN_REDSTONE_CONTROLLED.get(), "Laboratory Fan (Redstone Controlled)");
        add(ModBlocks.LABORATORY_BOOKSHELF.get(), "Laboratory Bookshelf");
        add(ModBlocks.CHISELED_LABORATORY_BOOKSHELF.get(), "Chiseled Laboratory Bookshelf");
    }
}
