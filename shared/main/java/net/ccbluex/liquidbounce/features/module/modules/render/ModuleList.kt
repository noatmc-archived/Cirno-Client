/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.module.modules.render
import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.event.EventTarget
import net.ccbluex.liquidbounce.event.Render3DEvent
import net.ccbluex.liquidbounce.features.module.Module
import net.ccbluex.liquidbounce.features.module.ModuleCategory
import net.ccbluex.liquidbounce.features.module.ModuleInfo
import net.ccbluex.liquidbounce.value.IntegerValue
import net.ccbluex.liquidbounce.value.FloatValue
import net.ccbluex.liquidbounce.utils.render.RenderUtils
import net.ccbluex.liquidbounce.features.module.ModuleManager
import net.ccbluex.liquidbounce.features.module.modules.combat.KillAura
import net.ccbluex.liquidbounce.features.module.modules.movement.Fly
import net.ccbluex.liquidbounce.features.module.modules.movement.Speed
import net.ccbluex.liquidbounce.features.module.modules.world.Scaffold

@ModuleInfo(name = "ModuleList", description = "Shows A List of modules", category = ModuleCategory.RENDER)
class ModuleList : Module() {
    private val XV = FloatValue("X", 1f, 0f, 5000f)
    private val XY = FloatValue("Y", 1f, 0f, 5000f)
    private val XZ = IntegerValue("Z", 1, 0, 5000)
    @EventTarget
    fun onRender3D(event: Render3DEvent) {
        RenderUtils.renderNameTag("Test: False", XV.get().toDouble(), XY.get().toDouble() + 45, XZ.get().toDouble())
        if (!LiquidBounce.moduleManager[KillAura::class.java].state) {
            RenderUtils.renderNameTag("KillAura: False", XV.get().toDouble(), XY.get().toDouble(), XZ.get().toDouble())
        }
        if (LiquidBounce.moduleManager[KillAura::class.java].state) {
            RenderUtils.renderNameTag("KillAura: True", XV.get().toDouble(), XY.get().toDouble(), XZ.get().toDouble())
        }
        if (!LiquidBounce.moduleManager[Fly::class.java].state) {
            RenderUtils.renderNameTag("Fly: False", XV.get().toDouble(), XY.get().toDouble() - 45, XZ.get().toDouble())
        }
        if (LiquidBounce.moduleManager[Fly::class.java].state) {
            RenderUtils.renderNameTag("Fly: True", XV.get().toDouble(), XY.get().toDouble() - 45, XZ.get().toDouble())
        }
        if (!LiquidBounce.moduleManager[Speed::class.java].state) {
            RenderUtils.renderNameTag("Speed: False", XV.get().toDouble(), XY.get().toDouble() - 90, XZ.get().toDouble())
        }
        if (LiquidBounce.moduleManager[Speed::class.java].state) {
            RenderUtils.renderNameTag("Speed: True", XV.get().toDouble(), XY.get().toDouble() - 90, XZ.get().toDouble())
        }
        if (!LiquidBounce.moduleManager[Scaffold::class.java].state) {
            RenderUtils.renderNameTag("Scaffold: False", XV.get().toDouble(), XY.get().toDouble() - 135, XZ.get().toDouble())
        }
        if (LiquidBounce.moduleManager[Scaffold::class.java].state) {
            RenderUtils.renderNameTag("Scaffold: True", XV.get().toDouble(), XY.get().toDouble() - 135, XZ.get().toDouble())
        }
    }
}
