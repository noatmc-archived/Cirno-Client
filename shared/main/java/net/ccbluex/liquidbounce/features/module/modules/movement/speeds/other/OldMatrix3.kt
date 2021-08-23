/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other

import net.ccbluex.liquidbounce.api.minecraft.potion.PotionType
import net.ccbluex.liquidbounce.event.MoveEvent
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode
import net.ccbluex.liquidbounce.utils.MovementUtils

class OldMatrix3 : SpeedMode("OldMatrix3") {
    override fun onUpdate() {
            mc.timer.timerSpeed = 1f
        if (mc.thePlayer!!.ticksExisted % 5 == 0) {
            mc.timer.timerSpeed = 5f
        }
        }
    override fun onMotion() {}
    override fun onMove(event: MoveEvent) {}
}