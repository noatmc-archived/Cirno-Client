/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.spectre

import net.ccbluex.liquidbounce.event.MoveEvent
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode
import net.ccbluex.liquidbounce.utils.MovementUtils

class SpectreLowHop : SpeedMode("Cirno") {
    override fun onMotion() {
        if (!MovementUtils.isMoving || mc.thePlayer!!.movementInput.jump) return
        if (mc.thePlayer!!.onGround) {
            MovementUtils.strafe(2f)
            mc.thePlayer!!.motionY = 0.42
            mc.thePlayer!!.motionX *= 1.1
            mc.thePlayer!!.motionZ *= 1.1
            return
        }
        MovementUtils.strafe()
    }

    override fun onUpdate() {}
    override fun onMove(event: MoveEvent) {}
}