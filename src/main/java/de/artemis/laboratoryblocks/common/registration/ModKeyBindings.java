package de.artemis.laboratoryblocks.common.registration;

import com.mojang.blaze3d.platform.InputConstants;
import de.artemis.laboratoryblocks.LaboratoryBlocks;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.glfw.GLFW;

public class ModKeyBindings {

    public static final KeyMapping REMOVE_GLOWSTONE_CONFIGURATION_TOOL_ACTION = new KeyMapping("keybind." + LaboratoryBlocks.MOD_ID + ".remove_glowstone_configuration_tool_action", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_LEFT_CONTROL), "keybind." + LaboratoryBlocks.MOD_ID + ".category");
    public static final KeyMapping REMOVE_REDSTONE_CONFIGURATION_TOOL_ACTION = new KeyMapping("keybind." + LaboratoryBlocks.MOD_ID + ".remove_redstone_configuration_tool_action", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_LEFT_ALT), "keybind." + LaboratoryBlocks.MOD_ID + ".category");
    public static final KeyMapping SHOW_INFORMATION = new KeyMapping("keybind." + LaboratoryBlocks.MOD_ID + ".show_information", KeyConflictContext.UNIVERSAL, KeyModifier.NONE, InputConstants.Type.KEYSYM.getOrCreate(GLFW.GLFW_KEY_LEFT_CONTROL), "keybind." + LaboratoryBlocks.MOD_ID + ".category");

}
